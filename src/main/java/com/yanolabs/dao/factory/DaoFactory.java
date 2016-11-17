package com.yanolabs.dao.factory;

import javax.inject.Qualifier;
import javax.persistence.EntityManager;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is the CDI {@link Qualifier} that can be used to determine what objects
 * qualify for which injection points. For this application, it is used to
 * qualify the {@link EntityManager} injection point.
 * 
 */
@Qualifier
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DaoFactory {
	
	public Class value();
}
