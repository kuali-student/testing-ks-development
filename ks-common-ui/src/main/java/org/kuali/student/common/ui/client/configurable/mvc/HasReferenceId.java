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
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.common.ui.client.configurable.mvc;

/**
 * This allows getting/setting of a reference id and reference key on any widget
 * implementing this interface. 
 * 
 * @author Kuali Student Team
 *
 */
public interface HasReferenceId {

    public void setReferenceId(String id);
    
    public String getReferenceId();
    
    public void setReferenceKey(String key);
    
    public String getReferenceKey();
}
