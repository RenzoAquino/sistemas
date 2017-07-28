package com.sgv.base.dao.impl;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.base.dao.ControlCompraDAO;
import com.sgv.base.dao.model.ControlCompra;
import com.sgv.common.core.GenericDAO;

public class ControlCompraDAOImp extends GenericDAO implements ControlCompraDAO {

	
	public ControlCompraDAOImp() {
		super();
	}
	@Override
	public int insert(ControlCompra item) throws PersistenceException {
		int id = 0;		

		//try {
			id = session.insert("com.sgv.base.dao.ControlCompraMapper.insert",item);
		/*
			session.commit();
		} finally {
			session.close();
		}*/
		
		return id;
	}
	@Override
	public int insertSelective(ControlCompra item) throws PersistenceException {
		int id = 0;		

		//try {
			id = session.insert("com.sgv.base.dao.ControlCompraMapper.insertSelective",item);
		/*	
			session.commit();
		} finally {
			session.close();
		}*/
		
		return id;
	}

}
