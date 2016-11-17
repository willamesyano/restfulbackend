package com.yanolabs.dao;

import com.yanolabs.entity.CidadesBeans;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CidadesDao extends DAO {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public CidadesDao() {
		super(CidadesBeans.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<CidadesBeans> listarCidadesUF(int codigoUF) {
		Criteria criteria = criaCriteria()
				.add(Restrictions.eq("codigoUF", codigoUF))
				.addOrder(Order.asc("cidade"));
		
		return criteria.list();
	}
}
