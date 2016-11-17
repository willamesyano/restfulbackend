package com.yanolabs.dao.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This bean is used to hold the entity manager factory and to produce the
 * conversation scoped entity manager for injection
 */
@Alternative
@ApplicationScoped
public class DaoJseRepositoryProducer {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence_alvarafacil");
	
	@Produces
	@DaoRepository
	@RequestScoped
	public EntityManager produceEntityManager() {	
		EntityManager em = factory.createEntityManager();
		return em;
	}
	
	public void fechandoConexao(@Disposes @DaoRepository EntityManager em) {
		em.close();
	}

}
