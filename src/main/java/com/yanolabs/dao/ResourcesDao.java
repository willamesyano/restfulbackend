package com.yanolabs.dao;

import com.yanolabs.dao.factory.JpaUtil;
import com.yanolabs.entity.ResourcesBeans;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by willames on 10/11/16.
 */
public class ResourcesDao{


    private EntityManager em = JpaUtil.getEntityManager();
    private EntityTransaction trx = em.getTransaction();

    public void addResource(ResourcesBeans resourcesBeans){
        trx.begin();
        em.persist(resourcesBeans);
        trx.commit();
        em.close();
    }

    public void updateResource(ResourcesBeans resourcesBeans){
        trx.begin();
        em.merge(resourcesBeans);
        trx.commit();
        em.close();
    }

    public void deleteResource(ResourcesBeans rb){
        trx.begin();
        em.remove(rb);
        trx.commit();
        em.close();
    }

    public List listAll() {
        TypedQuery<ResourcesBeans> query = em.createQuery("from ResourcesBeans order by codigoResource", ResourcesBeans.class);
        return query.getResultList();
    }

    public ResourcesBeans findById(int id) {
        ResourcesBeans rb = em.find(ResourcesBeans.class, id);
        return rb;
    }

}
