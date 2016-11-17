package com.yanolabs.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FactoryDao {
	
	public Object getService(int proprietario, Class classe) {
		
		Object dao = null;
		try {
			Class[] construtorClasse = new Class[] { };
			Constructor constructor = classe.getConstructor(construtorClasse);
			dao = constructor.newInstance(new Object[] { });
			
			/*Method metodo = classe.getMethod("setarProprietario", Integer.class);
			metodo.invoke(service, proprietario);*/
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
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
		
		return dao;
	}

}
