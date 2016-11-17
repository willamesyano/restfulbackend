package com.yanolabs.core.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationsUtil {

    public String findAnnotationFieldID(Class<?> clazz) {

	try {
	    Field[] fields = clazz.getDeclaredFields();
	    if (fields.length == 0) {
		return null;
	    }

	    for (Field field : fields) {

		Annotation[] annotations = field.getAnnotations();

		for (Annotation annotation2 : annotations) {

		    if (annotation2.toString().equals("@javax.persistence.Id()"))
			return field.getName();
		}
	    }

	    Class superClass = clazz.getSuperclass();
	    if (superClass != null) {
		return findAnnotationFieldID(superClass);
	    }

	} catch (SecurityException e) {
	    e.printStackTrace();
	}

	return null;
    }
}
