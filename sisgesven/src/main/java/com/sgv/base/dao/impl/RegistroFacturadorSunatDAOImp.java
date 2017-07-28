package com.sgv.base.dao.impl;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.base.dao.RegistroFacturadorSunatDAO;
import com.sgv.base.dao.model.TxxxxBandfact;
import com.sgv.common.core.GenericDAO;
import java.lang.Double;
public class RegistroFacturadorSunatDAOImp extends GenericDAO implements RegistroFacturadorSunatDAO {

	
	public RegistroFacturadorSunatDAOImp() {
		super();
	}
	/*
	@Override
	public int insert(ControlVenta item) throws PersistenceException {
		int id = 0;		

		try {
			id = session.insert("com.sgv.base.dao.mapper.ControlVentaMapper.insert",item);
			session.commit();
		} finally {
			session.close();
		}
		
		return id;
	}
	*/
	@Override
	public int insertSelective(TxxxxBandfact item) throws PersistenceException {
		int result = 0;		
		result = session.insert("com.sgv.base.dao.mapper.TxxxxBandfactMapper.insertSelective",item);		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.sgv.base.dao.impl.RegistroFacturadorSunatDAO#selectByPrimaryKey(com.sgv.base.dao.model.TxxxxBandfact)
	 */
	@Override
	public TxxxxBandfact selectByPrimaryKey(TxxxxBandfact item) throws PersistenceException {
		TxxxxBandfact result = null;		
		result = session.selectOne("com.sgv.base.dao.mapper.TxxxxBandfactMapper.selectByPrimaryKey",item);
		return result;
	}	
	
	@Override
	public int updateByPrimaryKeySelective(TxxxxBandfact item) throws PersistenceException {
		int result = 0;		
		result = session.update("com.sgv.base.dao.mapper.TxxxxBandfactMapper.updateByPrimaryKeySelective",item);		
		return result;
	}	
	
	@Override
	public TxxxxBandfact selectByReference(TxxxxBandfact item) throws PersistenceException {
		TxxxxBandfact result = null;		
		result = session.selectOne("com.sgv.base.dao.mapper.TxxxxBandfactMapper.selectByReference",item);
		return result;
	}
	@Override
	public Double obtenerValorActualSecuencia() throws PersistenceException {
		Double result = null;		
		result = session.selectOne("com.sgv.base.dao.mapper.TxxxxBandfactMapper.obtenerValorActualSecuencia");
		System.out.println("DAO valor Actual "+result);
		return result;
	}
}
