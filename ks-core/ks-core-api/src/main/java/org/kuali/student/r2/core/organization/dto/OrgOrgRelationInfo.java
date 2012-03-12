/*
 * Copyright 2010 The Kuali Foundation 
 *
 * Licensed under the Educational Community License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kuali.student.r2.core.organization.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.kuali.student.r2.core.organization.infc.OrgOrgRelation;
import org.kuali.student.r2.common.dto.RelationshipInfo;
//import org.w3c.dom.Element;

/**
 * Detailed information about a single organization to organization
 * relationship.
 *
 * @author tom
 */ 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrgOrgRelationInfo", propOrder = {
                "id", "typeKey", "stateKey",
                "orgId", "relatedOrgId",
                "effectiveDate", "expirationDate",
                "meta", "attributes"})//, "_futureElements" }) TODO KSCM Non-GWT translatable code })

public class OrgOrgRelationInfo 
    extends RelationshipInfo
    implements OrgOrgRelation, Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String orgId;

    @XmlElement
    private String relatedOrgId;

//    TODO KSCM-372: Non-GWT translatable code
//    @XmlAnyElement
//    private List<Element> _futureElements;


    /**
     * Constructs a new OrgOrgRelationInfo.
     */
    public OrgOrgRelationInfo() {
    }

    /**
     * Constructs a new OrgOrgRelationInfo from an OrgOrgRelation.
     *
     * @param orgOrgRelation the OrgOrgRelation to copy
     */
    public OrgOrgRelationInfo(OrgOrgRelation orgOrgRelation) {
        super(orgOrgRelation);

        if (orgOrgRelation != null) {
            this.orgId = orgOrgRelation.getOrgId();
            this.relatedOrgId = orgOrgRelation.getRelatedOrgId();
        }
    }

    @Override
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String getRelatedOrgId() {
        return relatedOrgId;
    }

    public void setRelatedOrgId(String relatedOrgId) {
        this.relatedOrgId = relatedOrgId;
    }
}
