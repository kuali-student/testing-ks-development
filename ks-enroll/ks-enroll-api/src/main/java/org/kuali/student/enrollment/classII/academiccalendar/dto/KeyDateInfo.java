/*
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
package org.kuali.student.enrollment.classII.academiccalendar.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.kuali.student.r2.common.dto.KeyEntityInfo;
import org.kuali.student.r2.common.infc.ModelBuilder;

import org.kuali.student.enrollment.classII.academiccalendar.infc.KeyDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyDateInfo", propOrder = {"key", "typeKey", "stateKey", "name", "descr", "isAllDay", "isDateRange", "startDate", "endDate", "metaInfo", "attributes", "_futureElements"})
public class KeyDateInfo extends KeyEntityInfo implements KeyDate, Serializable {

    private static final long serialVersionUID = 1L;
    @XmlElement
    private final Boolean isAllDay;
    @XmlElement
    private final Boolean isDateRange;
    @XmlElement
    private final Date startDate;
    @XmlElement
    private final Date endDate;
    @XmlAnyElement
    private final List<Element> _futureElements;

    protected KeyDateInfo() {
        isAllDay = false;
        isDateRange = false;
        startDate = null;
        endDate = null;
        _futureElements = null;
    }

    /**
     * Constructs a new KeyDateInfo from another KeyDate.
     *
     * @param keyDate the KeyDate to copy
     */
    public KeyDateInfo(KeyDate keyDate) {
        super(keyDate);
        this.isAllDay = keyDate.getIsAllDay();
        this.isDateRange = keyDate.getIsDateRange();
        this.startDate = null != keyDate.getStartDate() ? new Date(keyDate.getStartDate().getTime()) : null;
        this.endDate = null != keyDate.getEndDate() ? new Date(keyDate.getEndDate().getTime()) : null;
        _futureElements = null;
    }

    @Override
    public Boolean getIsAllDay() {
        return isAllDay;
    }

    @Override
    public Boolean getIsDateRange() {
        return isDateRange;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    /**
     * The builder class for this KeyDateInfo.
     */
    public static class Builder extends KeyEntityInfo.Builder implements ModelBuilder<KeyDateInfo>, KeyDate {

        private Boolean isAllDay;
        private Boolean isDateRange;
        private Date startDate;
        private Date endDate;

        /**
         * Constructs a new builder.
         */
        public Builder() {
        }

        /**
         *  Constructs a new builder initialized from another
         *  KeyDate.
         */
        public Builder(KeyDate keyDate) {
            super(keyDate);
            this.isAllDay = keyDate.getIsAllDay();
            this.isDateRange = keyDate.getIsDateRange();
            this.startDate = null != keyDate.getStartDate() ? new Date(keyDate.getStartDate().getTime()) : null;
            this.endDate = null != keyDate.getEndDate() ? new Date(keyDate.getEndDate().getTime()) : null;
        }

        @Override
        public KeyDateInfo build() {
            return new KeyDateInfo(this);
        }

        @Override
        public Boolean getIsAllDay() {
            return isAllDay;
        }

        public void setIsAllDay(Boolean isAllDay) {
            this.isAllDay = isAllDay;
        }

        @Override
        public Boolean getIsDateRange() {
            return isDateRange;
        }

        public void setIsDateRange(Boolean isDateRange) {
            this.isDateRange = isDateRange;
        }

        @Override
        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = new Date(startDate.getTime());
        }

        @Override
        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = new Date(endDate.getTime());
        }
    }
}
