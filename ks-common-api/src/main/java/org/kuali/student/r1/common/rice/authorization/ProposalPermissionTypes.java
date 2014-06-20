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

package org.kuali.student.r1.common.rice.authorization;

/**
 * Enum to be used for Permission types (KRAD). Permission Type is analagous to a permission template.
 * 
 * When using permission types, permission checks will be performed using template names. 
 *
 */
public enum ProposalPermissionTypes {
	INITIATE("Initiate","KR-SYS","Initiate Document"),
	OPEN("View","KS-SYS","Open Document"),
	EDIT("Edit","KS-SYS","Edit Document"),
    BLANKET_APPROVE("Blanket Approve","KS-SYS","Blanket Approve"),
	ADD_COMMENT("Add a Comment","KS-SYS","Add a Comment"),
    EDIT_COMMENT("Edit Comment","KS-SYS","Edit a Comment"),
    DELETE_COMMENT("Delete Comment","KS-SYS","Delete a Comment");

	private String label = "";
	private String permissionNamespace = "";
	private String permissionTemplateName = "";

	private ProposalPermissionTypes(String label, String permissionNamespace, String permissionTemplateName) {
        this.label = label;
        this.permissionNamespace = permissionNamespace;
        this.permissionTemplateName = permissionTemplateName;
    }

	public String getLabel() {
    	return label;
    }

	public void setLabel(String label) {
    	this.label = label;
    }

	public String getPermissionNamespace() {
    	return permissionNamespace;
    }

	public void setPermissionNamespace(String permissionNamespace) {
    	this.permissionNamespace = permissionNamespace;
    }

	public String getPermissionTemplateName() {
    	return permissionTemplateName;
    }

	public void setPermissionTemplateName(String permissionTemplateName) {
    	this.permissionTemplateName = permissionTemplateName;
    }

	public String getCode() {
		return permissionNamespace + "~" + permissionTemplateName;
	}

	public static ProposalPermissionTypes getByCode(String code) {
		for (ProposalPermissionTypes type : ProposalPermissionTypes.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		return null;
	}

	@Override
    public String toString() {
        return label;
    }
}
