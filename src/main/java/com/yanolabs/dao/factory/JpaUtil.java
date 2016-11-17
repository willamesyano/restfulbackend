package com.yanolabs.dao.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by willames on 10/11/16.
 */
public class JpaUtil {

    private static final String PERSISTENCE_UNIT = "backend_db";

    private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

    private static EntityManagerFactory entityManagerFactory;

    private JpaUtil(){
    }

    public static EntityManager getEntityManager(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        EntityManager entityManager = threadEntityManager.get();

        if(entityManager == null || !entityManager.isOpen()){
            entityManager = entityManagerFactory.createEntityManager();
            JpaUtil.threadEntityManager.set(entityManager);
        }

        return entityManager;
    }

    public static void closeEntityManager(){

        EntityManager em = threadEntityManager.get();

        if(em != null){
            EntityTransaction transaction = em.getTransaction();

            if(transaction.isActive()){
                transaction.commit();            }
        }

        em.close();

        threadEntityManager.set(null);
    }

    public static void closeEntityManagerFactory(){
        closeEntityManager();
        entityManagerFactory.close();
    }
}