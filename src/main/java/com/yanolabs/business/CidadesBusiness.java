package com.yanolabs.business;

import com.yanolabs.dao.CidadesDao;
import com.yanolabs.entity.CidadesBeans;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

public class CidadesBusiness extends Business<CidadesDao> {

    @Inject
    CidadesDao cidadesDao;

    public CidadesBusiness() {
	super();
    }

    @PostConstruct
    protected void inicializar() {
	setDao(cidadesDao);
    }

    @Override
    public void incluir(Object objeto) throws Exception {
        super.incluir(objeto);
    }
    
    @Override
    public void atualizar(Object objeto) throws Exception {
        super.atualizar(objeto);
    }
    
    @Override
    public void excluir(Object objeto) throws Exception {     
        super.excluir(objeto);
    }
    
	public List<CidadesBeans> listarCidadesUF(int codigoUF) {
		return cidadesDao.listarCidadesUF(codigoUF);
	}
}
