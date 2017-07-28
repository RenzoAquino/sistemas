package com.sgv.base.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.base.dao.model.ControlCompra;

public interface ControlCompraDAO {
	int insert(ControlCompra item)throws PersistenceException;//insert an object of type T into the database
	int insertSelective(ControlCompra item)throws PersistenceException;//insert an object of type T into the database
	
}
