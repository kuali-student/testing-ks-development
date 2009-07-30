
package org.kuali.student.core.comment.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Jun 05 15:33:47 EDT 2009
 * Generated source version: 2.2
 */

@XmlRootElement(name = "searchForComments", namespace = "http://student.kuali.org/commentService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchForComments", namespace = "http://student.kuali.org/commentService")

public class SearchForComments {

    @XmlElement(name = "commentCriteriaInfo")
    private org.kuali.student.core.comment.dto.CommentCriteriaInfo commentCriteriaInfo;

    public org.kuali.student.core.comment.dto.CommentCriteriaInfo getCommentCriteriaInfo() {
        return this.commentCriteriaInfo;
    }

    public void setCommentCriteriaInfo(org.kuali.student.core.comment.dto.CommentCriteriaInfo newCommentCriteriaInfo)  {
        this.commentCriteriaInfo = newCommentCriteriaInfo;
    }

}

