package com.yanolabs.dao.factory;

import com.yanolabs.business.Business;
import com.yanolabs.dao.DAO;
import com.yanolabs.dao.FactoryDao;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;

public class DaoFactoryProducer {

	@Inject
	public FactoryDao factoryDao;

	@Produces
	@DaoFactory(Business.class)
	public DAO create(InjectionPoint injectionPoint) {
		//	  ParameterizedType superclass = (ParameterizedType) injectionPoint.getAnnotated().getAnnotation(DaoFactory.class).value().getGenericSuperclass();
		ParameterizedType type = (ParameterizedType) injectionPoint.getAnnotated().getAnnotation(DaoFactory.class).value().getGenericSuperclass();
		Class classe = (Class) type.getActualTypeArguments()[0];
		return  (DAO) factoryDao.getService(0, classe);
	}
}