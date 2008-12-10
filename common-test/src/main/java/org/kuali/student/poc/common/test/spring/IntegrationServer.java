package org.kuali.student.poc.common.test.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IntegrationServer {
	public int port() default 9000;
	public String warPath();
	public String contextPath();
}
