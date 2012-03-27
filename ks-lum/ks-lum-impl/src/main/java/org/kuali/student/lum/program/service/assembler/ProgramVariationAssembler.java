/*
 * Copyright 2007 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific  language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.lum.program.service.assembler;

import java.util.List;

import org.apache.log4j.Logger;
import org.kuali.student.r1.common.assembly.BOAssembler;
import org.kuali.student.r1.common.assembly.BaseDTOAssemblyNode;
import org.kuali.student.r1.common.assembly.BaseDTOAssemblyNode.NodeOperation;
import org.kuali.student.r2.common.assembler.AssemblyException;
import org.kuali.student.r1.common.dto.AmountInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r1.lum.course.dto.LoDisplayInfo;
import org.kuali.student.r1.lum.lu.dto.CluInfo;
import org.kuali.student.r2.lum.clu.service.CluService;
import org.kuali.student.r1.lum.program.dto.ProgramVariationInfo;
import org.kuali.student.r1.lum.program.dto.assembly.*;
import org.kuali.student.lum.service.assembler.CluAssemblerUtils;

import org.kuali.student.conversion.util.R1R2ConverterUtil;
/**
 * @author KS
 *
 */
public class ProgramVariationAssembler implements BOAssembler<ProgramVariationInfo, CluInfo> {
    final static Logger LOG = Logger.getLogger(ProgramVariationAssembler.class);

    private CluService luService;
    private CluAssemblerUtils cluAssemblerUtils;
    private ProgramAssemblerUtils programAssemblerUtils;



    @Override
    public ProgramVariationInfo assemble(CluInfo baseDTO, ProgramVariationInfo businessDTO, boolean shallowBuild, ContextInfo contextInfo) throws AssemblyException {

        ProgramVariationInfo pvInfo = (null != businessDTO) ? businessDTO : new ProgramVariationInfo();

        // Copy all the data from the clu to the programvariation
        programAssemblerUtils.assembleBasics(baseDTO, (ProgramCommonAssembly) pvInfo, contextInfo);
        programAssemblerUtils.assembleIdentifiers(baseDTO, (ProgramIdentifierAssembly) pvInfo);
        programAssemblerUtils.assembleBasicAdminOrgs(baseDTO, (ProgramBasicOrgAssembly) pvInfo);
        programAssemblerUtils.assembleFullOrgs(baseDTO, (ProgramFullOrgAssembly) pvInfo);
        programAssemblerUtils.assembleAtps(baseDTO, (ProgramAtpAssembly) pvInfo);
        programAssemblerUtils.assembleLuCodes(baseDTO, (ProgramCodeAssembly) pvInfo);
        try {
			programAssemblerUtils.assemblePublications(baseDTO, (ProgramPublicationAssembly) pvInfo, contextInfo);
		} catch (PermissionDeniedException e) {
			// // TODO KSCM-421 could not add this to BoAssembler interface, since it is r2 exception and not a R1
			e.printStackTrace();
		}
        
        if (!shallowBuild) {
        	programAssemblerUtils.assembleRequirements(baseDTO, (ProgramRequirementAssembly) pvInfo, contextInfo);
        	pvInfo.setResultOptions(programAssemblerUtils.assembleResultOptions(baseDTO.getId(), contextInfo));
        	/* TODO KSCM-429  pvInfo.setLearningObjectives(cluAssemblerUtils.assembleLos(baseDTO.getId(), shallowBuild,contextInfo)); */
        }
        
        pvInfo.setIntensity((null != baseDTO.getIntensity()) ? baseDTO.getIntensity().getUnitType() : null);
        pvInfo.setStdDuration(baseDTO.getStdDuration());
        pvInfo.setCampusLocations(baseDTO.getCampusLocations());
        pvInfo.setEffectiveDate(baseDTO.getEffectiveDate());
        pvInfo.setDescr(baseDTO.getDescr());
        pvInfo.setVersionInfo(baseDTO.getVersionInfo());

        return pvInfo;
    }


    @Override
    public BaseDTOAssemblyNode<ProgramVariationInfo, CluInfo> disassemble(ProgramVariationInfo businessDTO, NodeOperation operation, ContextInfo contextInfo) throws AssemblyException {
    	BaseDTOAssemblyNode<ProgramVariationInfo, CluInfo> result = new BaseDTOAssemblyNode<ProgramVariationInfo, CluInfo>(this);
    	
    	if (businessDTO == null) {
			// FIXME Unsure now if this is an exception or just return null or
			// empty assemblyNode
		    LOG.error("Variation to disassemble is null!");
			throw new AssemblyException("Variation can not be null");
		}

		CluInfo clu;
		try {
			clu = (NodeOperation.UPDATE == operation) ? R1R2ConverterUtil.convert(luService.getClu(businessDTO.getId(), contextInfo),new CluInfo()) : new CluInfo();
        } catch (Exception e) {
			throw new AssemblyException("Error getting existing learning unit during variation update", e);
        } 
        
        boolean stateChanged = NodeOperation.UPDATE == operation && businessDTO.getState() != null && !businessDTO.getState().equals(clu.getState());
        
        clu.setState(businessDTO.getState());
        programAssemblerUtils.disassembleBasics(clu, (ProgramCommonAssembly) businessDTO);
        if (businessDTO.getId() == null)
            businessDTO.setId(clu.getId());
        programAssemblerUtils.disassembleIdentifiers(clu, (ProgramIdentifierAssembly) businessDTO, operation);
        programAssemblerUtils.disassembleAdminOrgs(clu, (ProgramBasicOrgAssembly) businessDTO, operation);
        programAssemblerUtils.disassembleAtps(clu, (ProgramAtpAssembly) businessDTO, operation);
        programAssemblerUtils.disassembleLuCodes(clu, (ProgramCodeAssembly) businessDTO, operation);
        programAssemblerUtils.disassemblePublications(clu, (ProgramPublicationAssembly) businessDTO, operation, result, contextInfo);

        if(businessDTO.getProgramRequirements() != null && !businessDTO.getProgramRequirements().isEmpty()) {
        	programAssemblerUtils.disassembleRequirements(clu, (ProgramRequirementAssembly) businessDTO, operation, result, stateChanged, contextInfo);
        }
        
        if (businessDTO.getResultOptions() != null) {
            disassembleResultOptions(businessDTO, operation, result, contextInfo);
        }

        if (businessDTO.getLearningObjectives() != null) {
            disassembleLearningObjectives(businessDTO, operation, result,contextInfo);
        }
 
		AmountInfo intensity = new AmountInfo();
		intensity.setUnitType(businessDTO.getIntensity());
		clu.setIntensity(intensity);
		clu.setStdDuration(businessDTO.getStdDuration());
        clu.setCampusLocations(businessDTO.getCampusLocations());
        clu.setEffectiveDate(businessDTO.getEffectiveDate());
        clu.setDescr(businessDTO.getDescr());
        clu.setVersionInfo(businessDTO.getVersionInfo());
        
		// Add the Clu to the result
		result.setNodeData(clu);
		result.setOperation(operation);
		result.setBusinessDTORef(businessDTO);
		return result;
    	
    }

    private void disassembleLearningObjectives(ProgramVariationInfo variation, NodeOperation operation, BaseDTOAssemblyNode<ProgramVariationInfo, CluInfo> result,ContextInfo contextInfo) throws AssemblyException {
    	/* TODO KSCM-429 try {
            List<BaseDTOAssemblyNode<?, ?>> loResults = cluAssemblerUtils.disassembleLos(variation.getId(), variation.getState(), (List<LoDisplayInfo>) variation.getLearningObjectives(), operation,contextInfo);
            if (loResults != null) {
                result.getChildNodes().addAll(loResults);
            }
        } catch (DoesNotExistException e) {
        } catch (Exception e) {
            throw new AssemblyException("Error while disassembling los", e);
        } */
    }

    private void disassembleResultOptions(ProgramVariationInfo variation, NodeOperation operation, BaseDTOAssemblyNode<ProgramVariationInfo, CluInfo> result, ContextInfo contextInfo) throws AssemblyException {
        BaseDTOAssemblyNode<?, ?> resultOptions = cluAssemblerUtils.disassembleCluResults(variation.getId(), variation.getState(), variation.getResultOptions(), operation, ProgramAssemblerConstants.DEGREE_RESULTS, "Result options", "Result option", contextInfo);
        if (resultOptions != null) {
            result.getChildNodes().add(resultOptions);           
        }
    }
    
    // Spring setter
    public void setLuService(CluService luService) {
        this.luService = luService;
    }
    
    public void setCluAssemblerUtils(CluAssemblerUtils cluAssemblerUtils) {
        this.cluAssemblerUtils = cluAssemblerUtils;
    }

    public void setProgramAssemblerUtils(ProgramAssemblerUtils programAssemblerUtils) {
        this.programAssemblerUtils = programAssemblerUtils;
    }


}
