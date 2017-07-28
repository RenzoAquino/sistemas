package com.sgv.base.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.base.dao.model.TxxxxBandfact;

public interface RegistroFacturadorSunatDAO {

	public int insertSelective(TxxxxBandfact item) throws PersistenceException;
	TxxxxBandfact selectByPrimaryKey(TxxxxBandfact item) throws PersistenceException;
	int updateByPrimaryKeySelective(TxxxxBandfact item) throws PersistenceException;
	TxxxxBandfact selectByReference(TxxxxBandfact item) throws PersistenceException;
	public Double obtenerValorActualSecuencia() throws PersistenceException;

}