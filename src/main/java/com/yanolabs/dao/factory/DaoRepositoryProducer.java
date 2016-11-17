package com.yanolabs.dao.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This bean is used to hold the entity manager factory and to produce the
 * conversation scoped entity manager for injection
 */
public class DaoRepositoryProducer {

	@PersistenceContext
	private EntityManager em;
	
	@Produces
	@DaoRepository
	@RequestScoped
	public EntityManager produceEntityManager() {
		return em;
	}
	
}