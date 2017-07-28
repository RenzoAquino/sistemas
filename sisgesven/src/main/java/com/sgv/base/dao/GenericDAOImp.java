package com.sgv.base.dao;

import org.apache.ibatis.exceptions.PersistenceException;

public class GenericDAOImp<T, PK>  implements GenericDAO<T, PK>  {


	
	@Override
	public int insert(T id) throws PersistenceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
