/*
 * Copyright 2012 The Kuali Foundation Licensed under the
 *  Educational Community License, Version 2.0 (the "License"); you may
 *  not use this file except in compliance with the License. You may
 *  obtain a copy of the License at
 *
 *   http://www.osedu.org/licenses/ECL-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an "AS IS"
 *  BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 *  or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */

package org.kuali.student.r2.core.appointment.service;

import org.kuali.student.r2.core.appointment.constants.AppointmentServiceConstants;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @Version 1.0
 * @Author Sri komandur@uw.edu
 */
@WebService(name = "AppointmentService", serviceName = "AppointmentService", portName = "AppointmentService", targetNamespace = AppointmentServiceConstants.NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface AppointmentService {

}
