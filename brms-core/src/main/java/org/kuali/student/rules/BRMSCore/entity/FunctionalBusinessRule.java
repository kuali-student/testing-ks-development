/*
 * Copyright 2007 The Kuali Foundation Licensed under the Educational Community License, Version 1.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.opensource.org/licenses/ecl1.php Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package org.kuali.student.rules.BRMSCore.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.kuali.student.poc.common.util.UUIDHelper;

/**
 * Contains meta data about a functional business rule. Since a functional business rule is composed of one or more Rule
 * Elements, this class is associated with one or more RuleElement instances. The class also contains BusinessRuleEvaluation
 * and RuleMetaData instances.
 * 
 * @author Kuali Student Team (zdenek.kuali@gmail.com)
 */
@Entity
@Table(name = "FunctionalBusinessRule_T")
@NamedQueries({@NamedQuery(name = "FunctionalBusinessRule.findByRuleID", query = "SELECT c FROM FunctionalBusinessRule c WHERE c.ruleIdentifier = :ruleID")})
public class FunctionalBusinessRule {

    @Id
    private String id;

    private String name;
    private String description;
    private String successMessage;
    private String failureMessage;
    @Column(unique = true, nullable = false)
    private String ruleIdentifier;
    private String compiledRuleID;
    @Embedded
    private RuleMetaData ruleMetaData;
    @Embedded
    private BusinessRuleEvaluation businessRuleEvaluation;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "functionalBusinessRule")
    private Collection<RuleElement> ruleElements;

    /**
     * Sets up an empty instance.
     */
    public FunctionalBusinessRule() {
        id = null;
        name = null;
        description = null;
        successMessage = null;
        failureMessage = null;
        ruleIdentifier = null;
        compiledRuleID = null;
        ruleMetaData = null;
        businessRuleEvaluation = null;
    }

    /**
     * Sets up a RuleProposition instance.
     * 
     * @param id
     * @param name
     * @param description
     * @param ruleIdentified
     * @param ruleMetaData
     */
    public FunctionalBusinessRule(String name, String description, String successMessage, String failureMessage, String ruleIdentified, String compileRuleID, RuleMetaData ruleMetaData, BusinessRuleEvaluation businessRuleEvaluation) {
        this.name = name;
        this.description = description;
        this.successMessage = successMessage;
        this.failureMessage = failureMessage;
        this.ruleIdentifier = ruleIdentified;
        this.compiledRuleID = compileRuleID;
        this.ruleMetaData = ruleMetaData;
        this.businessRuleEvaluation = businessRuleEvaluation;
    }

    /**
     * Adds a new RuleElement to the list of rule elements that the functional business rule is composed of
     * 
     * @param ruleElement
     *            a new Rule Element to add to this business rule object
     */
    public void addRuleElement(RuleElement ruleElement) {
        if (ruleElements == null) {
            ruleElements = new ArrayList<RuleElement>();
        }
        ruleElements.add(ruleElement);
    }

    /**
     * AutoGenerate the Id
     */
    @PrePersist
    public void prePersist() {
        this.id = UUIDHelper.genStringUUID();
    }

    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public final void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the ruleMetaData
     */
    public final RuleMetaData getRuleMetaData() {
        return ruleMetaData;
    }

    /**
     * @param ruleMetaData
     *            the ruleMetaData to set
     */
    public final void setRuleMetaData(RuleMetaData ruleMetaData) {
        this.ruleMetaData = ruleMetaData;
    }

    /**
     * @return the businessRuleEvaluation
     */
    public final BusinessRuleEvaluation getBusinessRuleEvaluation() {
        return businessRuleEvaluation;
    }

    /**
     * @param businessRuleEvaluation
     *            the businessRuleEvaluation to set
     */
    public final void setBusinessRuleEvaluation(BusinessRuleEvaluation businessRuleEvaluation) {
        this.businessRuleEvaluation = businessRuleEvaluation;
    }

    /**
     * @return the ruleElements
     */
    public final Collection<RuleElement> getRuleElements() {
        return ruleElements;
    }

    /**
     * @param ruleElements
     *            the ruleElements to set
     */
    public final void setRuleElements(Collection<RuleElement> ruleElements) {
        this.ruleElements = ruleElements;
    }

    /**
     * @return the successMessage
     */
    public final String getSuccessMessage() {
        return successMessage;
    }

    /**
     * @param successMessage
     *            the successMessage to set
     */
    public final void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    /**
     * @return the failureMessage
     */
    public final String getFailureMessage() {
        return failureMessage;
    }

    /**
     * @param failureMessage
     *            the failureMessage to set
     */
    public final void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    /**
     * @return the ruleIdentifier
     */
    public final String getRuleIdentifier() {
        return ruleIdentifier;
    }

    /**
     * @param ruleIdentifier
     *            the ruleIdentifier to set
     */
    public final void setRuleIdentifier(String ruleIdentifier) {
        this.ruleIdentifier = ruleIdentifier;
    }

    /**
     * @return the compiledRuleID
     */
    public String getCompiledRuleID() {
        return compiledRuleID;
    }

    /**
     * @param compiledRuleID
     *            the compiledRuleID to set
     */
    public void setCompiledRuleID(String compiledRuleID) {
        this.compiledRuleID = compiledRuleID;
    }

}
