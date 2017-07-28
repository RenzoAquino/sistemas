package com.sgv.fakturama.dao.impl;

import com.sgv.common.core.GenericDAO;
import com.sgv.fakturama.dao.model.FktContact;

public class ContactoDAOImpl extends GenericDAO{

    public ContactoDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
     * Select instance of Person from the database.
     * @param person the instance to be persisted.
     */
   public FktContact selectByCompany(String filtro){
	   FktContact item = null;
        //SqlSession session = sqlSessionFactory.openSession();
        //try {
        	item = session.selectOne("com.sgv.fakturama.dao.FktContactMapper.selectByCompany", filtro);
 
        /*} finally {
            session.close();
        }*/
        System.out.println("selectByCompany("+filtro+") --> "+item);
        return item;
    } 

   public FktContact selectByPrimaryKey(Long id){
	   FktContact item = null;
        //SqlSession session = sqlSessionFactory.openSession();
        //try {
        	item = session.selectOne("com.sgv.fakturama.dao.FktContactMapper.selectByPrimaryKey", id);
        /*
        } finally {
            session.close();
        }*/
        System.out.println("selectByPrimaryKey("+id+") --> "+item);
        return item;
    } 
}
