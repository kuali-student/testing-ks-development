/**
 * Copyright 2010 The Kuali Foundation Licensed under the
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
 */

package org.kuali.student.r1.common.validation.dto;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.kuali.student.r2.common.infc.ValidationResult.ErrorLevel;

@XmlAccessorType(XmlAccessType.FIELD)
public class ValidationResultInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum ErrorLevel {
		OK(0), WARN(1), ERROR(2);

		int level;

		private ErrorLevel(int level) {
			this.level = level;
		}

		public int getLevel() {
			return level;
		}

		public static ErrorLevel min(ErrorLevel e1, ErrorLevel e2) {
			return e1.ordinal() < e2.ordinal() ? e1 : e2;
		}

		public static ErrorLevel max(ErrorLevel e1, ErrorLevel e2) {
			return e1.ordinal() > e2.ordinal() ? e1 : e2;
		}
		
        public static ErrorLevel fromInt(int level) {
            switch (level) {
                case 0:
                    return OK;
                case 1:
                    return WARN;
                case 2:
                    return ERROR;
                default:
                    throw new IllegalArgumentException(level + "");
            }
        }
        
        public static org.kuali.student.r2.common.infc.ValidationResult.ErrorLevel fromR1Int(int level) {
            switch (level) {
                case 0:
                    return org.kuali.student.r2.common.infc.ValidationResult.ErrorLevel.OK;
                case 1:
                    return org.kuali.student.r2.common.infc.ValidationResult.ErrorLevel.WARN;
                case 2:
                    return org.kuali.student.r2.common.infc.ValidationResult.ErrorLevel.ERROR;
                default:
                    throw new IllegalArgumentException(level + "");
            }
        }
        // This method was added to maintain some of the R1 packages which are old and 
        // should be replaced, but still need to compile
		@Deprecated
		public static ErrorLevel convertR2toR1(org.kuali.student.r2.common.infc.ValidationResult.ErrorLevel errorLevelR2){	    
		    return ErrorLevel.fromInt(errorLevelR2.getLevel());
		}
		
		public static org.kuali.student.r2.common.infc.ValidationResult.ErrorLevel convertR1toR2(ErrorLevel errorLevelR1){	    
		    return ErrorLevel.fromR1Int(errorLevelR1.getLevel());
		}
	}

	private transient Object invalidData = null;

	@XmlElement
	protected String element;

	@XmlElement
	protected ErrorLevel level = ErrorLevel.OK;

	@XmlElement
	protected String message;

	public ValidationResultInfo() {
		super();
		this.level = ErrorLevel.OK;
	}

	public ValidationResultInfo(String element) {
		super();
		this.level = ErrorLevel.OK;
		this.element = element;
	}

	public ValidationResultInfo(String element, Object invalidData) {
		this(element);
		this.invalidData = invalidData;
	}

	/**
	 * @return the level
	 */
	public ErrorLevel getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(ErrorLevel level) {
		this.level = level;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	/**
	 * Returns the ValidationResult's error level
	 * 
	 * @return
	 */
	public ErrorLevel getErrorLevel() {
		return level;
	}

	/**
	 * Convenience method. Adds a message with an error level of WARN
	 * 
	 * @param message
	 *            the message to add
	 */
	public void setWarning(String message) {
		this.level = ErrorLevel.WARN;
		this.message = message;
	}

	/**
	 * Convenience method. Adds a message with an error level of ERROR
	 * 
	 * @param message
	 *            the message to add
	 */
	public void setError(String message) {
		this.level = ErrorLevel.ERROR;
		this.message = message;
	}

	/**
	 * Convenience method. Returns true if getErrorLevel() == ErrorLevel.OK
	 * 
	 * @return true if getErrorLevel() == ErrorLevel.OK
	 */
	public boolean isOk() {
		return getErrorLevel() == ErrorLevel.OK;
	}

	/**
	 * Convenience method. Returns true if getErrorLevel() == ErrorLevel.WARN
	 * 
	 * @return true if getErrorLevel() == ErrorLevel.WARN
	 */
	public boolean isWarn() {
		return getErrorLevel() == ErrorLevel.WARN;
	}

	/**
	 * Convenience method. Returns true if getErrorLevel() == ErrorLevel.ERROR
	 * 
	 * @return true if getErrorLevel() == ErrorLevel.ERROR
	 */
	public boolean isError() {
		return getErrorLevel() == ErrorLevel.ERROR;
	}

	public String toString() {
		return "[" + level + "] Path: [" + element + "] - " + message
				+ " data=[" + invalidData + "]";
	}

	/**
	 * Checks if there are any validation errors exceeding the threshold and ignoring the list of fieldPaths passed in
	 * @param validationResults
	 * @param threshold
	 * @param ignoreFields
	 * @return
	 */
	public static boolean hasValidationErrors(List<ValidationResultInfo> validationResults, ErrorLevel threshold, List<String> ignoreFields){
		 if (validationResults != null) {
            for (ValidationResultInfo validationResult : validationResults) {
            	//Ignore any fields that are in the list
            	if(ignoreFields!=null && !ignoreFields.contains(validationResult.getElement())){
            		//Return true if any of the validation results exceed your threshold
            		if (validationResult.getLevel() == ErrorLevel.ERROR) {
	                    return true;
	                }
	                if (ErrorLevel.WARN.equals(threshold) && validationResult.getLevel() == ErrorLevel.WARN) {
	                    return true;
	                }
            	}
            }
        }
		return false;
	}
	
	
	public static org.kuali.student.r2.common.infc.ValidationResult.ErrorLevel convertR1toR2Level(
			ErrorLevel levelR1) {

		org.kuali.student.r2.common.infc.ValidationResult.ErrorLevel r2Level = null;
		r2Level = r2Level.fromInt(levelR1.getLevel());

		return r2Level;

	}

	public static List<org.kuali.student.r2.common.dto.ValidationResultInfo> convertValidationResultInfoToR2(List<ValidationResultInfo> validationResults) {
		// TODO KSCM-322
	    
	    org.kuali.student.r2.common.dto.ValidationResultInfo r2ValidationResultInfo =  new org.kuali.student.r2.common.dto.ValidationResultInfo(); 
	    
	    List<org.kuali.student.r2.common.dto.ValidationResultInfo> r2ValidationResultInfoList = (List<org.kuali.student.r2.common.dto.ValidationResultInfo>) new org.kuali.student.r2.common.dto.ValidationResultInfo(); 
	    
	    for (ValidationResultInfo validationResultInfo : validationResults) 
	    {
	        r2ValidationResultInfo.setElement(validationResultInfo.getElement()); 
	        r2ValidationResultInfo.setMessage(validationResultInfo.getMessage());
	        r2ValidationResultInfo.setLevel(convertR1toR2Level(validationResultInfo.getLevel()));
	        r2ValidationResultInfo.setInvalidData(validationResultInfo.getInvalidData());
	        
	        r2ValidationResultInfoList.add(r2ValidationResultInfo); 
	    }
	    
	    return r2ValidationResultInfoList;
	
	}

	public Object getInvalidData() {
        return invalidData;
    }
	
}
