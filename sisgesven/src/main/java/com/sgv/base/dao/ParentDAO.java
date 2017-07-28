package com.sgv.base.dao;

import org.apache.ibatis.exceptions.PersistenceException;

public interface ParentDAO <T, PK>{
	 //public T get(PK id) throws PersistenceException;//get obj of type T by the primary key 'id' 
	 //public T getByName(String name) throws PersistenceException;//get obj of type T by the 'name' field, if one exists for that table
	 //public ArrayList<T> getAll() throws PersistenceException;//get all objects of type T
	 //public int insert(T objInstance) throws PersistenceException;//insert an object of type T into the database
	 //int update(T transientObject) throws PersistenceException; //update an object of type T    
	 //int delete(PK id)  throws PersistenceException;//delete an object of type T
	 
	/*
	T selectByPrimaryKey(PK ID) throws PersistenceException;//get obj of type T by the primary key 'id'
	T selectByName(String name) throws PersistenceException;//get obj of type T by the 'name' field, if one exists for that table
	ArrayList<T> getAll() throws PersistenceException;//get all objects of type T
	*/
	int insert(T record)throws PersistenceException;//insert an object of type T into the database	
	/*
	int insertSelective(T record)throws PersistenceException;//insert an object of type T into the database
	int updateByPrimaryKeySelective(T record) throws PersistenceException; //update an object of type T 
	int updateByPrimaryKey(T record) throws PersistenceException; //update an object of type T 
	int deleteByPrimaryKey(PK ID) throws PersistenceException;//delete an object of type T
	*/
}