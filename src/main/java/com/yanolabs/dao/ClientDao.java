package com.yanolabs.dao;

import com.yanolabs.dao.factory.JpaUtil;
import com.yanolabs.entity.ClientBeans;

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

    public void addClient(ClientBeans clientsBeans){
        trx.begin();
        em.persist(clientsBeans);
        trx.commit();
        em.close();
    }

    public void updateClient(ClientBeans clientsBeans){
        trx.begin();
        em.merge(clientsBeans);
        trx.commit();
        em.close();
    }

    public void deleteClient(int id){
        trx.begin();
        ClientBeans cb = em.find(ClientBeans.class, id);
        em.remove(cb);
        trx.commit();
        em.close();
    }

    public List listarTodos() {
        TypedQuery<ClientBeans> query = em.createQuery("from ClientBeans order by codigoClient", ClientBeans.class);
        return query.getResultList();
    }

    public List listById(int id) {
        TypedQuery<ClientBeans> query = em.createQuery("from ClientBeans where codigoClient = id", ClientBeans.class);
        return query.getResultList();
    }

    public ClientBeans listByUsername(String username) {
        String consulta = "from ClientBeans where username = '" + username + "'";
        TypedQuery<ClientBeans> query = em.createQuery(consulta , ClientBeans.class);
        return query.getSingleResult();
    }

}
