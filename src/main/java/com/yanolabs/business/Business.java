package com.yanolabs.business;

import com.yanolabs.dao.DAO;

import javax.inject.Inject;
import java.io.Serializable;

public class Business<D extends DAO> implements Serializable {

    protected D dao;
    @Inject

    public Business() {
    }

    public D getDao() {
	return (D) dao;
    }

    public void setDao(D dao) {
	this.dao = dao;
    }

    public void incluir(Object objeto) throws Exception{
	getDao().incluir(objeto);
    }
    
    public void atualizar(Object objeto) throws Exception{
	objeto = getDao().atualizar(objeto);	
    }

    public void excluir(Object objeto) throws Exception{
	getDao().excluir(objeto);
    }

}
