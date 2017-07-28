package com.sgv.base.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.base.dao.model.ControlVenta;

public interface ControlVentaDAO {
	int insert(ControlVenta item)throws PersistenceException;//insert an object of type T into the database
	int insertSelective(ControlVenta item)throws PersistenceException;//insert an object of type T into the database
	ControlVenta selectByDocumento(ControlVenta item) throws PersistenceException;
	int updateByDocumento(ControlVenta item) throws PersistenceException;
	ControlVenta selectByReference(ControlVenta item) throws PersistenceException;
	
}
