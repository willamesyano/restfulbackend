package com.yanolabs.business;

import com.yanolabs.dao.UFsDao;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class UFsBusiness extends Business<UFsDao> {

	@Inject
	UFsDao ufsDao;
	
	public UFsBusiness() {
		super();
	}
	
	@PostConstruct
	private void inicializar() {
		setDao(ufsDao);
	}
	
}
