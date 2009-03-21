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
package org.kuali.student.rules.internal.common.statement.propositions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kuali.student.rules.internal.common.entity.ComparisonOperator;
import org.kuali.student.rules.internal.common.statement.MessageContextConstants;
import org.kuali.student.rules.internal.common.statement.propositions.functions.ComparisonOperatorComparable;
import org.kuali.student.rules.internal.common.statement.propositions.functions.Function;
import org.kuali.student.rules.rulemanagement.dto.RulePropositionDTO;

/**
 * A constraint that compares a constrained property (fact) to a given criterion. The threshold may be defined as minimum or
 * maximum.
 * 
 * @param <T>
 *            the type being constrained.
 * @author <a href="mailto:randy@berkeley.edu">Randy Ballew</a>
 * @author Kuali Student Team (len.kuali@gmail.com)
 */
public class SimpleComparableProposition<T extends Comparable<T>> extends AbstractProposition<T> {
    // ~ Instance fields --------------------------------------------------------

    private Function comparableFunction;
    T fact;
    List<Boolean> resultValues;
    
    // ~ Constructors -----------------------------------------------------------

    public SimpleComparableProposition() {
        super();
    }

    public SimpleComparableProposition(String id, String propositionName, 
    		ComparisonOperator operator, T expectedValue, T fact, RulePropositionDTO ruleProposition) {
        super(id, propositionName, PropositionType.SIMPLECOMPARABLE, operator, expectedValue);

        this.fact = fact;
        comparableFunction = new ComparisonOperatorComparable<T>(operator, expectedValue, this.fact);
    }

    // ~ Methods ----------------------------------------------------------------

    @Override
    public Boolean apply() {
        sanityCheck();

        //result = checkTruthValue(this.fact, super.expectedValue);
        result = (Boolean) comparableFunction.compute();

        this.resultValues = new ArrayList<Boolean>();
        this.resultValues.add(result);

        return result;
    }

    @Override
    public void buildMessageContextMap() {
        String s = getTypeAsString(this.fact);
        addMessageContext(MessageContextConstants.PROPOSITION_SIMPLE_COMPARABLE_MESSAGE_CTX_KEY_FACT, s);
    }

    private void sanityCheck() {
        if (fact == null)
            throw new IllegalStateException(getClass().getName() + ":  No fact to compare");
    }

    /**
     * @return the fact
     */
    public T getFact() {
        return fact;
    }
    /**
     * Gets results of proposition computation.
     * 
     * @return Proposition computation results
     */
    public Collection<?> getResultValues() {
    	return this.resultValues;
    }
}
