package com.sgv.fakturama.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sgv.common.core.GenericDAO;
import com.sgv.fakturama.dao.model.FktUserproperty;

public class UserPropertyDAOImpl extends GenericDAO{

    public UserPropertyDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
     * Select instance of Person from the database.
     * @param person the instance to be persisted.
     */
   public Map<String, String> selectByLikeName(String name){
	   
	   List<FktUserproperty> list = null;
	   Map<String, String> map = new HashMap<String,String>() ;
        //SqlSession session = sqlSessionFactory.openSession();
        //try {
        	list = session.selectList("com.sgv.fakturama.dao.FktUserpropertyMapper.selectByLikeName", name+"%");
        	for (FktUserproperty item : list) {
				map.put(item.getNAME(), item.getT_VALUE());
			}
        /*
   		} finally {
            session.close();
        }*/
        //System.out.println("selectByLikeName("+name+") --> "+map);
        return map;
    } 
}
