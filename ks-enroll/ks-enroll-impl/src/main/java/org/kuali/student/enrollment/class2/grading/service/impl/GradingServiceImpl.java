package org.kuali.student.enrollment.class2.grading.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam;

import org.kuali.student.enrollment.class2.acal.service.assembler.GradeRosterAssembler;
import org.kuali.student.enrollment.courseoffering.dto.CourseOfferingInfo;
import org.kuali.student.enrollment.courseoffering.infc.CourseOffering;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingService;
import org.kuali.student.enrollment.grading.dto.GradeRosterEntryInfo;
import org.kuali.student.enrollment.grading.dto.GradeRosterInfo;
import org.kuali.student.enrollment.grading.dto.GradeValuesGroupInfo;
import org.kuali.student.enrollment.grading.service.GradingService;
import org.kuali.student.enrollment.lpr.dto.LprRosterEntryInfo;
import org.kuali.student.enrollment.lpr.dto.LprRosterInfo;
import org.kuali.student.enrollment.lpr.dto.LuiPersonRelationInfo;
import org.kuali.student.enrollment.lpr.service.LuiPersonRelationService;
import org.kuali.student.r2.common.datadictionary.dto.DictionaryEntryInfo;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.dto.TypeInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.exceptions.AlreadyExistsException;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.exceptions.VersionMismatchException;

public class GradingServiceImpl implements GradingService {
    private LuiPersonRelationService lprService;
    private GradeRosterAssembler gradeRosterAssembler;
    private CourseOfferingService courseOfferingService;

    public LuiPersonRelationService getLprService() {
        return lprService;
    }

    public void setLprService(LuiPersonRelationService lprService) {
        this.lprService = lprService;
    }

    public CourseOfferingService getCourseOfferingService() {
        return courseOfferingService;
    }

    public void setCourseOfferingService(CourseOfferingService courseOfferingService) {
        this.courseOfferingService = courseOfferingService;
    }

    public GradeRosterAssembler getGradeRosterAssembler() {
        return gradeRosterAssembler;
    }

    public void setGradeRosterAssembler(GradeRosterAssembler gradeRosterAssembler) {
        this.gradeRosterAssembler = gradeRosterAssembler;
    }

    /**
     * This method returns the TypeInfo for a given grade roster type key.
     * 
     * @param gradeRosterTypeKey
     *            Key of the type
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return Information about the Type
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *             gradeRosterTypeKey not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *             invalid gradeRosterTypeKey
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *             missing gradeRosterTypeKey
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *             unable to complete request
     */
    @Override
    public TypeInfo getGradeRosterType(@WebParam(name = "gradeRosterTypeKey") String gradeRosterTypeKey,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException {
        return null; // TODO implement method.
    }

    /**
     * Retrieve information about a grade roster
     * 
     * @param gradeRosterId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public GradeRosterInfo getGradeRoster(@WebParam(name = "gradeRosterId") String gradeRosterId,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * Retrieve information about grade rosters by grader and term
     * 
     * @param graderId
     * @param termKey
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public List<GradeRosterInfo> getGradeRostersByGraderAndTerm(@WebParam(name = "graderId") String graderId,
            @WebParam(name = "termKey") String termKey, @WebParam(name = "context") ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * Retrieves rosters of final grades for a course offering
     * 
     * @param courseOfferingId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public List<GradeRosterInfo> getFinalGradeRostersForCourseOffering(
            @WebParam(name = "courseOfferingId") String courseOfferingId,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        List<GradeRosterInfo> gradeRosterInfos = new ArrayList<GradeRosterInfo>();

        List<LprRosterInfo> lprRosters = lprService.getLprRostersByLuiAndRosterType(courseOfferingId, "kuali.lpr.type.roster.grade.final", context);
        for (LprRosterInfo lprRoster : lprRosters) {
            GradeRosterInfo gradeRosterInfo = assembleGradeRoster(lprRoster, context);
            gradeRosterInfos.add(gradeRosterInfo);
        }

        return gradeRosterInfos;
    }

    /**
     * Retrieves rosters of final grade by actvity offerings
     * 
     * @param activityOfferingId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public List<GradeRosterInfo> getFinalGradeRostersForActivityOffering(
            @WebParam(name = "activityOfferingId") String activityOfferingId,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * Retrieves all rosters for an activity offering
     * 
     * @param activityOfferingId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public List<GradeRosterInfo> getGradeRostersForActivityOffering(
            @WebParam(name = "activityOfferingId") String activityOfferingId,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * Build an interim roster of given type. Roster type should be used to
     * figure out which students from the activity offerings will be in the
     * roster
     * 
     * @param activityOfferingIdList
     * @param rosterTypeKey
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.AlreadyExistsException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public GradeRosterInfo buildInterimGradeRosterByType(
            @WebParam(name = "activityOfferingIdList") String courseOfferingId,
            @WebParam(name = "activityOfferingIdList") List<String> activityOfferingIdList,
            @WebParam(name = "rosterTypeKey") String rosterTypeKey, @WebParam(name = "context") ContextInfo context)
            throws AlreadyExistsException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * Update interim grade roster information
     * 
     * @param gradeRoster
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *             One or more values invalid for this operation
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     * @throws org.kuali.student.r2.common.exceptions.VersionMismatchException
     */
    @Override
    public GradeRosterInfo updateInterimGradeRoster(@WebParam(name = "gradeRoster") GradeRosterInfo gradeRoster,
            @WebParam(name = "context") ContextInfo context) throws DataValidationErrorException,
            DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException,
            PermissionDeniedException, VersionMismatchException {
        return null; // TODO implement method.
    }

    /**
     * Delete an interim grade roster
     * 
     * @param gradeRosterId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public StatusInfo deleteInterimGradeRoster(@WebParam(name = "gradeRosterId") String gradeRosterId,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * Update state of final grade roster. Only state can be changed for the
     * final grade roster. Final grade submission is tracked through state
     * change on the roster.
     * 
     * @param gradeRosterId
     * @param stateKey
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *             One or more values invalid for this operation
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     * @throws org.kuali.student.r2.common.exceptions.VersionMismatchException
     */
    @Override
    public GradeRosterInfo updateFinalGradeRosterState(@WebParam(name = "gradeRosterId") String gradeRosterId,
            @WebParam(name = "newStateKey") String stateKey, @WebParam(name = "context") ContextInfo context)
            throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, VersionMismatchException {
        return null; // TODO implement method.
    }

    /**
     * Validate a grade roster information
     * 
     * @param gradeRoster
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     */
    @Override
    public List<ValidationResultInfo> validateGradeRoster(@WebParam(name = "gradeRoster") GradeRosterInfo gradeRoster,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException {
        return null; // TODO implement method.
    }

    /**
     * Retrieve information about a grade roster entry
     * 
     * @param gradeRosterEntryId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public GradeRosterEntryInfo getGradeRosterEntry(@WebParam(name = "gradeRosterEntryId") String gradeRosterEntryId,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * Retrieve a list of grade roster entries based on their ids. The method
     * should fail if there is an error in retrieving any id from the list.
     * 
     * @param gradeRosterEntryIdList
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public List<GradeRosterEntryInfo> getGradeRosterEntriesByIdList(
            @WebParam(name = "gradeRosterEntryIdList") List<String> gradeRosterEntryIdList,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * Retrieve grade roster entries by roster
     * 
     * @param gradeRosterId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public List<GradeRosterEntryInfo> getGradeRosterEntriesByRosterId(
            @WebParam(name = "gradeRosterId") String gradeRosterId, @WebParam(name = "context") ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * This method ...
     * 
     * @param studentId
     * @param rosterId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public List<String> getValidGradeGroupIdsForStudentByRoster(@WebParam(name = "studentId") String studentId,
            @WebParam(name = "rosterId") String rosterId, @WebParam(name = "context") ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * This method ...
     * 
     * @param studentId
     * @param courseOfferingId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public GradeRosterEntryInfo getFinalGradeForStudentInCourseOffering(@WebParam(name = "studentId") String studentId,
            @WebParam(name = "courseOfferingId") String courseOfferingId,
            @WebParam(name = "context") ContextInfo context) throws DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * This method ...
     * 
     * @param gradeRosterEntry
     * @param gradeRosterId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.AlreadyExistsException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public GradeRosterEntryInfo addEntrytoInterimRoster(
            @WebParam(name = "gradeRosterEntry") GradeRosterEntryInfo gradeRosterEntry,
            @WebParam(name = "gradeRosterId") String gradeRosterId, @WebParam(name = "context") ContextInfo context)
            throws AlreadyExistsException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * This method ...
     * 
     * @param gradeRosterEntryId
     * @param gradeRosterId
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     */
    @Override
    public StatusInfo removeEntryFromInterimRoster(@WebParam(name = "gradeRosterEntryId") String gradeRosterEntryId,
            @WebParam(name = "gradeRosterId") String gradeRosterId, @WebParam(name = "context") ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * This method ...
     * 
     * @param gradeRosterEntryId
     * @param assignedGradeKey
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *             One or more values invalid for this operation
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     * @throws org.kuali.student.r2.common.exceptions.VersionMismatchException
     */
    @Override
    public boolean updateGrade(@WebParam(name = "gradeRosterEntryId") String gradeRosterEntryId,
            @WebParam(name = "assignedGrade") String assignedGradeKey, @WebParam(name = "context") ContextInfo context)
            throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, VersionMismatchException {
        return false; // TODO implement method.
    }

    /**
     * This method ...
     * 
     * @param gradeRosterEntryId
     * @param assignedGradeKey
     * @param context
     *            Context information containing the principalId and locale
     *            information about the caller of service operation
     * @return
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *             One or more values invalid for this operation
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             authorization failure
     * @throws org.kuali.student.r2.common.exceptions.VersionMismatchException
     */
    @Override
    public boolean updateCredit(@WebParam(name = "gradeRosterEntryId") String gradeRosterEntryId,
            @WebParam(name = "creditsEarned") String assignedGradeKey, @WebParam(name = "context") ContextInfo context)
            throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, VersionMismatchException {
        return false; // TODO implement method.
    }

    /**
     * Get the list of entry keys in this dictionary
     * <p/>
     * The list of keys is stored in the ref object URI strcture E.g
     * http://student.kuali.org/wsdl/luService/CluInfo will be the objectTypeURI
     * for the CluInfo structure The refObjectURI has three parts:
     * <ol>
     * <li>http://student.kuali.org/wsdl -- which is fixed
     * <li>luService -- which should match the namespace of the service in which
     * the object is defined
     * <li>CluInfo -- which should match the java class's simple name
     * </ol>
     * 
     * @param context
     *            information about the user and locale
     * @return a list of all the known data dictionary entry keys in the ref
     *         object URI structure.
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *             if could not complete the operation
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *             if entryKey is null
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             if user does not have permission to call this method
     */
    @Override
    public List<String> getDataDictionaryEntryKeys(@WebParam(name = "context") ContextInfo context)
            throws OperationFailedException, MissingParameterException, PermissionDeniedException {
        return null; // TODO implement method.
    }

    /**
     * Get the data dictionary entry for the specified entry key
     * 
     * @param entryKey
     *            that identifies the dictionary entry, this is done by
     *            specifying a refObjectURI
     * @param context
     *            information about the user and locale
     * @return the data dictionary entry key
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *             if could not complete the operation
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *             if entryKey is null
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *             if entryKey does not exist in the dictionary
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *             if user does not have permission to call this method
     */
    @Override
    public DictionaryEntryInfo getDataDictionaryEntry(@WebParam(name = "entryKey") String entryKey,
            @WebParam(name = "context") ContextInfo context) throws OperationFailedException,
            MissingParameterException, PermissionDeniedException, DoesNotExistException {
        return null; // TODO implement method.
    }

    @Override
    public List<GradeValuesGroupInfo> getGradeGroupsByIdList(List<String> gradeGroupIdList, ContextInfo context)
            throws DoesNotExistException, InvalidParameterException, MissingParameterException,
            OperationFailedException, PermissionDeniedException {
        // TODO sambit - THIS METHOD NEEDS JAVADOCS
        return null;
    }

    @Override
    public boolean updateNumberGrade(String gradeRosterEntryId, String numberGradeValue, ContextInfo context)
            throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
            MissingParameterException, OperationFailedException, PermissionDeniedException, VersionMismatchException {
        // TODO sambit - THIS METHOD NEEDS JAVADOCS
        return false;
    }

    private GradeRosterInfo assembleGradeRoster(LprRosterInfo lprRosterInfo, ContextInfo context) throws InvalidParameterException, MissingParameterException, DoesNotExistException, PermissionDeniedException, OperationFailedException {
        Map<String, LprRosterEntryInfo> lprIdToRosterEntriesMap = new HashMap<String, LprRosterEntryInfo>();
        List<String> graderIds = new ArrayList<String>();
        List<String> lprRosterEntryIds = new ArrayList<String>();

        List<LprRosterEntryInfo> lprRosterEntries = lprService.getEntriesForLprRoster(lprRosterInfo.getId(), context);
        for (LprRosterEntryInfo lprRosterEntry : lprRosterEntries) {
            String lprId = lprRosterEntry.getLprId();
            lprIdToRosterEntriesMap.put(lprId, lprRosterEntry);
        }

        List<String> lprIds = new ArrayList<String>(lprIdToRosterEntriesMap.keySet());
        List<LuiPersonRelationInfo> lprInfos = lprService.getLprsByIdList(lprIds, context);
        for (LuiPersonRelationInfo lprInfo : lprInfos) {
            String lprInfoType = lprInfo.getTypeKey();
            if ("kuali.lpr.type.instructor.main".equals(lprInfoType)) {
                graderIds.add(lprInfo.getPersonId());
            } else if ("kuali.lpr.type.registrant".equals(lprInfoType)) {
                LprRosterEntryInfo lprRosterEntryInfo = lprIdToRosterEntriesMap.get(lprInfo.getId());
                lprRosterEntryIds.add(lprRosterEntryInfo.getId());
            }
        }

        List<CourseOfferingInfo> courseOfferings = courseOfferingService.getCourseOfferingsByIdList(lprRosterInfo.getAssociatedLuiIds(), context);
        String courseOfferingId = courseOfferings.get(0).getCourseId();

        GradeRosterInfo gradeRosterInfo = gradeRosterAssembler.assemble(lprRosterInfo, lprRosterEntryIds, graderIds, courseOfferingId, context);
        return gradeRosterInfo;
    }

}
