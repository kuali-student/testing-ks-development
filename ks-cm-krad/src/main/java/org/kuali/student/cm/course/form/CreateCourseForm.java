/**
 * Copyright 2014 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * Created by chongzhu on 2/6/14
 */
package org.kuali.student.cm.course.form;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.web.form.MaintenanceDocumentForm;
import org.kuali.student.r2.core.proposal.dto.ProposalInfo;
import org.kuali.student.r2.lum.clu.CLUConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Form for create course.
 */
public class CreateCourseForm extends MaintenanceDocumentForm {

    private String createCourseInitialAction;

    private boolean useReviewProcess = false;

    private boolean isCurriculumSpecialist = false;

    private int selectedTabIndex = 0;

    public CreateCourseForm(){
        Map<String,String> permDetails = new HashMap<String, String>();
        permDetails.put(KewApiConstants.DOCUMENT_TYPE_NAME_DETAIL, CLUConstants.PROPOSAL_TYPE_COURSE_CREATE_ADMIN);
        isCurriculumSpecialist = KimApiServiceLocator.getPermissionService().hasPermissionByTemplate(GlobalVariables.getUserSession().getPrincipalId(), KRADConstants.KUALI_RICE_SYSTEM_NAMESPACE, KewApiConstants.INITIATE_PERMISSION, permDetails);
    }

    public String getCreateCourseInitialAction() {
        return createCourseInitialAction;
    }

    public void setCreateCourseInitialAction(String createCourseInitialAction) {
        this.createCourseInitialAction = createCourseInitialAction;
    }

    public boolean isUseReviewProcess() {
        return useReviewProcess;
    }

    public void setUseReviewProcess(boolean useCMreviewProcess) {
        this.useReviewProcess = useCMreviewProcess;
    }

    public int getSelectedTabIndex() {
        return selectedTabIndex;
    }

    public void setSelectedTabIndex(int selectedTabIndex) {
        this.selectedTabIndex = selectedTabIndex;
    }

    public boolean isCurriculumSpecialist() {
        return isCurriculumSpecialist;
    }

    public String getHeaderText() {
        String headerSuffixText;

        if (isCurriculumSpecialist() && !isUseReviewProcess()){
            headerSuffixText = " (Admin Proposal)";
        } else {
            headerSuffixText = " (Proposal)";
        }
        ProposalInfo proposalInfo = ((CourseInfoWrapper) getDocument().getNewMaintainableObject().getDataObject()).getProposalInfo();

        if (proposalInfo != null && StringUtils.isNotBlank(proposalInfo.getName())){
            return proposalInfo.getName() + headerSuffixText;
        } else {
            return "New Course" + headerSuffixText;
        }
    }
}
