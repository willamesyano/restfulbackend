package com.yanolabs.core.utils;

import org.apache.commons.lang.WordUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;

@ApplicationScoped
public class ReflectionUtil {

    @Inject
    AnnotationsUtil annotationsUtil;
    
    public void invocaMetodoInt(Object entity, String nomeMetodo, int valor) {

	try {
	    Method metodo = entity.getClass().getMethod(nomeMetodo, Integer.TYPE);

	    metodo.invoke(entity, valor);

	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	}
    }

    public void invocaMetodoString(Object entity, String nomeMetodo, String valor) {

	try {
	    Method metodo = entity.getClass().getMethod(nomeMetodo, String.class);

	    metodo.invoke(entity, valor);

	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	}
    }

    public void invocaMetodoTimeStamp(Object entity, String nomeMetodo, Timestamp valor) {

	try {
	    Method metodo = entity.getClass().getMethod(nomeMetodo, Timestamp.class);

	    metodo.invoke(entity, valor);

	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    // TODO Auto-generated catch block
//	    e.printStackTrace();
	}
    }

    public Object invocaMetodo(Object entity, String nomeMetodo, Object listaValores[]) {

	Object retorno = null;

	try {

	    Method[] metodos = entity.getClass().getMethods();
	    Method metodo = null;

	    for (int i = 0; i < metodos.length; i++) {
		metodo = metodos[i];
		if (metodo.getName().equals(nomeMetodo))
		    break;
	    }

	    retorno = metodo.invoke(entity, listaValores);

	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return retorno;
    }
    
    public Object invocaMetodo(Object entity, String nomeMetodo) {

  	Object retorno = null;

  	try {

  	    Method[] metodos = entity.getClass().getMethods();
  	    Method metodo = null;

  	    for (int i = 0; i < metodos.length; i++) {
  		metodo = metodos[i];
  		if (metodo.getName().equals(nomeMetodo))
  		    break;
  	    }

  	    retorno = metodo.invoke(entity);

  	} catch (IllegalArgumentException e) {
  	    // TODO Auto-generated catch block
  	    e.printStackTrace();
  	} catch (IllegalAccessException e) {
  	    // TODO Auto-generated catch block
  	    e.printStackTrace();
  	} catch (InvocationTargetException e) {
  	    // TODO Auto-generated catch block
  	    e.printStackTrace();
  	} catch (SecurityException e) {
  	    // TODO Auto-generated catch block
  	    e.printStackTrace();
  	}

  	return retorno;
      }
    
    public Object getTipoCampo(Object entity, String nomeCampo) {

	
	try {

	    Field[] campos = entity.getClass().getDeclaredFields();
	    Field campo = null;

	    for (int i = 0; i < campos.length; i++) {
		campo = campos[i];
		if (campo.getName().equals(nomeCampo))
		    break;
	    }

	    if (campo.getType().isAssignableFrom(Integer.class))
		return Integer.class;

	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return String.class;
    }      
    
    public int invocaMetodoGetID(Object object) {

   	int retorno = 0;
   	try {
   	    
   	    String id = annotationsUtil.findAnnotationFieldID(object.getClass());

   	    Method metodo = object.getClass().getMethod("get" + WordUtils.capitalize(id));
   	    retorno = (Integer) metodo.invoke(object, new Object[] {});

   	} catch (IllegalArgumentException e) {
   	    // TODO Auto-generated catch block
   	    e.printStackTrace();
   	} catch (IllegalAccessException e) {
   	    // TODO Auto-generated catch block
   	    e.printStackTrace();
   	} catch (InvocationTargetException e) {
   	    // TODO Auto-generated catch block
   	    e.printStackTrace();
   	} catch (SecurityException e) {
   	    // TODO Auto-generated catch block
   	    e.printStackTrace();
   	} catch (NoSuchMethodException e) {
   	    // TODO Auto-generated catch block
   	    e.printStackTrace();
   	}

   	return retorno;
       }
}
