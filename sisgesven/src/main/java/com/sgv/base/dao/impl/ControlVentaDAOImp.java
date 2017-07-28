package com.sgv.base.dao.impl;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.base.dao.ControlVentaDAO;
import com.sgv.base.dao.model.ControlVenta;
import com.sgv.common.core.GenericDAO;

public class ControlVentaDAOImp extends GenericDAO implements ControlVentaDAO {

	
	public ControlVentaDAOImp() {
		super();
	}
	@Override
	public int insert(ControlVenta item) throws PersistenceException {
		int result = 0;		

		//try {
		result = session.insert("com.sgv.base.dao.mapper.ControlVentaMapper.insert",item);
		/*	
			session.commit();
		} finally {
			session.close();
		}*/
		
		return result;
	}
	@Override
	public int insertSelective(ControlVenta item) throws PersistenceException {
		int result = 0;		

		//try {                    
		result = session.insert("com.sgv.base.dao.mapper.ControlVentaMapper.insertSelective",item);
		/*
			session.commit();
		} finally {
			session.close();
		}*/
		
		return result;
	}

	@Override
	public ControlVenta selectByDocumento(ControlVenta item) throws PersistenceException {
		ControlVenta result = null;		
		result = session.selectOne("com.sgv.base.dao.mapper.ControlVentaMapper.selectByDocumento",item);
		return result;
	}
	

	@Override
	public int updateByDocumento(ControlVenta item) throws PersistenceException {
		int result = 0;		                   
		result = session.update("com.sgv.base.dao.mapper.ControlVentaMapper.updateByDocumento",item);
		return result;
	}
	
	@Override
	public ControlVenta selectByReference(ControlVenta item) throws PersistenceException {
		System.out.println("DAO:"+item);
		ControlVenta result = null;		
		result = session.selectOne("com.sgv.base.dao.mapper.ControlVentaMapper.selectByReference",item);
		return result;
	}
}
