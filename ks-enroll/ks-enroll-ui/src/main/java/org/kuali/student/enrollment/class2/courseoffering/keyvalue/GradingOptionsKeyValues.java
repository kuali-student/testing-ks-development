/**
 * Copyright 2012 The Kuali Foundation Licensed under the
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
 * Created by vgadiyak on 6/2/12
 */
package org.kuali.student.enrollment.class2.courseoffering.keyvalue;

import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.kuali.rice.krad.web.form.MaintenanceForm;
import org.kuali.student.enrollment.class2.courseoffering.dto.CourseOfferingEditWrapper;
import org.kuali.student.lum.course.dto.CourseInfo;
import org.kuali.student.lum.course.service.CourseService;
import org.kuali.student.lum.course.service.CourseServiceConstants;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.mock.utilities.TestHelper;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.util.constants.CourseOfferingServiceConstants;
import org.kuali.student.r2.common.util.constants.LrcServiceConstants;
import org.kuali.student.r2.lum.lrc.dto.ResultValueInfo;
import org.kuali.student.r2.lum.lrc.dto.ResultValuesGroupInfo;
import org.kuali.student.r2.lum.lrc.infc.ResultValuesGroup;
import org.kuali.student.r2.lum.lrc.service.LRCService;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.*;

/**
 * This class //TODO ...
 *
 * @author Kuali Student Team
 */
public class GradingOptionsKeyValues extends UifKeyValuesFinderBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private CourseService courseService;
    private LRCService lrcService;

    @Override
    public List<KeyValue> getKeyValues(ViewModel model) {

        List<ResultValuesGroupInfo> gradingOptions = new ArrayList<ResultValuesGroupInfo>();
        List<String> crsGradingOptions = new ArrayList<String>();
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        ContextInfo context = TestHelper.getContext1();

        MaintenanceForm form1 = (MaintenanceForm)model;
        CourseOfferingEditWrapper form = (CourseOfferingEditWrapper)form1.getDocument().getDocumentDataObject();

        String courseId = form.getCoInfo().getCourseId();

        if (courseId != null) {
            try {
                CourseInfo courseInfo = (CourseInfo) getCourseService().getCourse(courseId);
                crsGradingOptions = courseInfo.getGradingOptions();

                Set<String> studentRegOpts  = new HashSet<String>(Arrays.asList(CourseOfferingServiceConstants.ALL_STUDENT_REGISTRATION_OPTION_TYPE_KEYS));
                for(String crsGradingOption: crsGradingOptions) {
                    if (!studentRegOpts.contains(crsGradingOption)) {
                        gradingOptions.add(getLrcService().getResultValuesGroup(crsGradingOption, context));  // gradingOption = LrcServiceConstants.RESULT_GROUP_KEY_GRADE_LETTER || LrcServiceConstants.RESULT_GROUP_KEY_GRADE_PASSFAIL
                    }
                }
            } catch (DoesNotExistException e) {
                throw new RuntimeException("No subject areas found! There should be some in the database", e);
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            } catch (MissingParameterException e) {
                throw new RuntimeException(e);
            } catch (OperationFailedException e) {
                throw new RuntimeException(e);
            } catch (PermissionDeniedException e) {
                throw new RuntimeException(e);
            } catch (org.kuali.student.common.exceptions.DoesNotExistException e) {
                throw new RuntimeException("No subject areas found! There should be some in the database", e);
            } catch (org.kuali.student.common.exceptions.InvalidParameterException e) {
                throw new RuntimeException(e);
            } catch (org.kuali.student.common.exceptions.MissingParameterException e) {
                throw new RuntimeException(e);
            } catch (org.kuali.student.common.exceptions.OperationFailedException e) {
                throw new RuntimeException(e);
            } catch (org.kuali.student.common.exceptions.PermissionDeniedException e) {
                throw new RuntimeException(e);
            }
        }

        for (ResultValuesGroupInfo gradingOption: gradingOptions) {
            keyValues.add(new ConcreteKeyValue(gradingOption.getKey(), gradingOption.getName()));
        }

        return keyValues;
    }

    protected CourseService getCourseService() {
        if(courseService == null) {
            courseService = (CourseService) GlobalResourceLoader.getService(new QName(CourseServiceConstants.COURSE_NAMESPACE, "CourseService"));
        }
        return this.courseService;
    }

    protected LRCService getLrcService() {
        if(lrcService == null) {
            lrcService = (LRCService) GlobalResourceLoader.getService(new QName("http://student.kuali.org/wsdl/lrc", "LrcService"));
        }
        return this.lrcService;
    }
}