package com.yanolabs.dao;

import com.yanolabs.dao.factory.JpaUtil;
import com.yanolabs.entity.ClientBeans;
import com.yanolabs.entity.ResourcesBeans;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by willames on 10/11/16.
 */
public class ClientDao {


    private EntityManager em = JpaUtil.getEntityManager();
    private EntityTransaction trx = em.getTransaction();

    public void addClient(ClientBeans cb){
        trx.begin();
        em.persist(cb);
        trx.commit();
        em.close();
    }

    public void updateClient(ClientBeans clientsBeans){
        trx.begin();
        em.merge(clientsBeans);
        trx.commit();
        em.close();
    }

    public void deleteClient(ClientBeans cb){
        trx.begin();
        em.remove(cb);
        trx.commit();
        em.close();
    }

    public List listAll() {
        TypedQuery<ClientBeans> query = em.createQuery("from ClientBeans order by codigoClient", ClientBeans.class);
        return query.getResultList();
    }

    public ClientBeans findByUsername(String username) {
        String consulta = "from ClientBeans where username = '" + username + "'";
        TypedQuery<ClientBeans> query = em.createQuery(consulta , ClientBeans.class);
        return query.getSingleResult();
    }

    public ClientBeans logout(ClientBeans cb){
        trx.begin();
        em.merge(cb);
        cb = findByUsername(cb.getUsername());
        trx.commit();
        em.close();
        return cb;
    }

    public ClientBeans findById(int id) {
        ClientBeans cb = em.find(ClientBeans.class, id);
        return cb;
    }
}
