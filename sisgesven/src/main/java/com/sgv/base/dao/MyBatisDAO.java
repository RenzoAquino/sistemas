package com.sgv.base.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public abstract class MyBatisDAO<T, PK> implements ParentDAO<T, PK> {

	//private static Logger log = LoggerFactory.getLogger(MyBatisDAO.class);
	private static final String NAMESPACE = "mappers"; 
	  
	private SqlSessionFactory sf; //reference to mybatis session factory 
	private Class<T> type;

	
	/** 
	 * Define prefixes for easier naming convetions between XML mapper files and the DAO class 
	 **/
	public static final String PREFIX_SELECT_PK_QUERY = "selectByPrimaryKey";     //prefix of select queries in mapper files (eg. getAddressType) 
	public static final String PREFIX_SELECT_NAME_QUERY = "selectByName";     //
	public static final String PREFIX_SELECT_ALL_QUERY = "getAll";     //
	public static final String PREFIX_INSERT_PK_QUERY = "insert"; //prefix of create queries in mapper files (eg. createAddressType)
	public static final String PREFIX_INSERT_SELECTIVE_QUERY = "insertSelective"; //prefix of create queries in mapper files (eg. createAddressType)
	public static final String PREFIX_UPDATE_PK_QUERY = "updateByPrimaryKey";  //prefix of update queries in mapper files (eg. updateAddressType)
	public static final String PREFIX_UPDATE_SELECTIVE_QUERY = "updateByPrimaryKeySelective";  //
	public static final String PREFIX_DELETE_PK_QUERY = "deleteByPrimaryKey";  //prefix of delete queries in mapper files (eg. deleteAddressType)
	 
	/*
	T selectByPrimaryKey(PK ID) throws PersistenceException;//get obj of type T by the primary key 'id'
	T selectByName(String name) throws PersistenceException;//get obj of type T by the 'name' field, if one exists for that table
	ArrayList<T> getAll() throws PersistenceException;//get all objects of type T	
	int insert(T record)throws PersistenceException;//insert an object of type T into the database	
	int insertSelective(T record)throws PersistenceException;//insert an object of type T into the database
	int updateByPrimaryKeySelective(T record) throws PersistenceException; //update an object of type T 
	int updateByPrimaryKey(T record) throws PersistenceException; //update an object of type T 
	int deleteByPrimaryKey(PK ID) throws PersistenceException;//delete an object of type T

	 */
	
	 /** Default Constructor */
    public MyBatisDAO(Class<T> type,SqlSessionFactory sf) {
        this.type = type;
        this.sf = sf;
        if(sf==null)System.err.println("Error: Could not instantiate MyBatisDAO. Loading myBatis sessionFactory failed.");
        //log.error("Error: Could not instantiate MyBatisDAO. Loading myBatis sessionFactory failed.");  
    }
     
    /** Use this method to get a session factory for using in any methods impelmented in child dao classes */
   protected SqlSessionFactory getSessionFactory() {
	   return sf;
   }
   
   /** 
    *  Method inserts the object into the table.
    *  </br></br>
    *  You will usually override this method, especially if you're inserting associated objects.
    *  </br> 
    *  Example:
    *  </br>  
    *  If your DAO object is called CarInfo.java, 
    *  the corresponding mapper query id should be: &lt;insert id="createCarInfo" ...  
    *  </br></br>  
    *  SQL Executed (example): insert into [tablename] (fieldname1,fieldname2,...) values(value1,value2...) ... 
    *  
    */
   public int create(T o) throws PersistenceException{        
	SqlSession session = sf.openSession();
	Integer status = null;
	try
	 {   
	     String query = NAMESPACE+"."+PREFIX_INSERT_PK_QUERY+o.getClass().getSimpleName();
	  status = (Integer)session.insert(query,o);
	  session.commit();   
	 }
	 finally
	 {
	  session.close();
	 }  
	 return status;
	   }
}
