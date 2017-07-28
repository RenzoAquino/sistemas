package com.sgv.common.util;

import org.apache.ibatis.session.SqlSession;

import com.sgv.common.core.MyBatisFactory;

public class DBSessionUtil {
	 private static SqlSession session = null;
	
	 public static void create(){
		 System.out.println("ABRIENDO TRANSACCION...");
		 session = MyBatisFactory.getSqlSessionFactory().openSession();
	 }
	 public static SqlSession getSession(){
	    	return session;
	 }
	 public static void commit(){
		 session.commit();;
	 }
	 public static void rollback(){
		 session.rollback();;
	 }
	 public static void close(){
		 try {
			 System.out.println("CERRANDO TRANSACCION...");
			 session.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	 }
}
