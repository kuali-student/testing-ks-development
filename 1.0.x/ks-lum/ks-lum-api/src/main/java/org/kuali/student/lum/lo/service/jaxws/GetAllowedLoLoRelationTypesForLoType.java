
package org.kuali.student.lum.lo.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Feb 19 15:17:58 PST 2010
 * Generated source version: 2.2
 */

@XmlRootElement(name = "getAllowedLoLoRelationTypesForLoType", namespace = "http://student.kuali.org/wsdl/lo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllowedLoLoRelationTypesForLoType", namespace = "http://student.kuali.org/wsdl/lo", propOrder = {"loTypeKey","relatedLoTypeKey"})

public class GetAllowedLoLoRelationTypesForLoType {

    @XmlElement(name = "loTypeKey")
    private java.lang.String loTypeKey;
    @XmlElement(name = "relatedLoTypeKey")
    private java.lang.String relatedLoTypeKey;

    public java.lang.String getLoTypeKey() {
        return this.loTypeKey;
    }

    public void setLoTypeKey(java.lang.String newLoTypeKey)  {
        this.loTypeKey = newLoTypeKey;
    }

    public java.lang.String getRelatedLoTypeKey() {
        return this.relatedLoTypeKey;
    }

    public void setRelatedLoTypeKey(java.lang.String newRelatedLoTypeKey)  {
        this.relatedLoTypeKey = newRelatedLoTypeKey;
    }

}

