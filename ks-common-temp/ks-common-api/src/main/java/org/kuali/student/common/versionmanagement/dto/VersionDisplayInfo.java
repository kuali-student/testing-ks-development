/*
 * Copyright 2010 The Kuali Foundation Licensed under the Educational Community
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.osedu.org/licenses/ECL-2.0 Unless required by applicable law or
 * agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kuali.student.common.versionmanagement.dto;

import org.kuali.student.common.versionmanagement.infc.VersionDisplay;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionDisplayInfo", propOrder = {"versionIndId", "objectTypeURI", "sequenceNumber", "currentVersionEnd", "currentVersionStart", "versionComment", "versionedFromId" /*TODO KSCM-gwt-compile , "_futureElements" */})
public class VersionDisplayInfo implements VersionDisplay, Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String versionIndId;

    @XmlElement
    private String objectTypeURI;

    @XmlElement
    private Long sequenceNumber;

    @XmlElement
    private Date currentVersionStart;

    @XmlElement
    private Date currentVersionEnd;

    @XmlElement
    private String versionComment;

    @XmlElement
    private String versionedFromId;

    //TODO KSCM-gwt-compile
    //@XmlAnyElement
    //private List<Element> _futureElements;

    public VersionDisplayInfo() {

    }

    public VersionDisplayInfo(VersionDisplay versionDisplay) {
        super();

        if (null != versionDisplay) {
            this.versionIndId = versionDisplay.getVersionIndId();
            this.sequenceNumber = versionDisplay.getSequenceNumber();
            this.currentVersionStart = (null != versionDisplay.getCurrentVersionStart()) ? new Date(versionDisplay.getCurrentVersionStart().getTime()) : null;
            this.currentVersionEnd = (null != versionDisplay.getCurrentVersionEnd()) ? new Date(versionDisplay.getCurrentVersionEnd().getTime()) : null;
            this.versionComment = versionDisplay.getVersionComment();
            this.versionedFromId = versionDisplay.getVersionedFromId();
        }
    }

    @Override
    public String getVersionedFromId() {
        return versionedFromId;
    }

    public void setVersionedFromId(String versionedFromId) {
        this.versionedFromId = versionedFromId;
    }

    @Override
    public String getObjectTypeURI() {
        return objectTypeURI;
    }

    public void setObjectTypeURI(String objectTypeURI) {
        this.objectTypeURI = objectTypeURI;
    }

    @Override
    public String getVersionIndId() {
        return versionIndId;
    }

    public void setVersionIndId(String versionIndId) {
        this.versionIndId = versionIndId;
    }

    @Override
    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public Date getCurrentVersionStart() {
        return currentVersionStart;
    }

    public void setCurrentVersionStart(Date currentVersionStart) {
        this.currentVersionStart = currentVersionStart;
    }

    @Override
    public Date getCurrentVersionEnd() {
        return currentVersionEnd;
    }

    public void setCurrentVersionEnd(Date currentVersionEnd) {
        this.currentVersionEnd = currentVersionEnd;
    }

    @Override
    public String getVersionComment() {
        return versionComment;
    }

    public void setVersionComment(String versionComment) {
        this.versionComment = versionComment;
    }

    public String getId() {
        //TODO KSCM   return id;
        return "";
    }
}
