package com.sgv.common.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class HandlerDB {

	public static void main(String[] args) throws IOException {
		  
		  //Objeto de conexión a base de datos tipo Connection
		  Connection conn = null;
		  
		  //Objeto de propiedades donde vamos a cargar las propiedades del archivo
		  Properties props = new Properties();
		  
		  
		  //Resultset donde vamos a buscar el resultado que genera el query
		  ResultSet rs = null;
		  
		  //Input Stream donde leemos el recurso donde está el archivo de propiedades
		  InputStream is = HandlerDB.class.getClassLoader().getResourceAsStream("db.properties");
		  
		  //Objeto que utilizaremos para lanzar un query a la base de datos
		  PreparedStatement ps = null;
		  
		  //Cargamos las propiedades que vienene del archivo
		  props.load(is);
		  
		  //Cerramos el recurso
		  is.close();
		  
		  //Abrimos try para controlar cualquier excepción de SQL que ocurra
		  try {
		   
		   //Abrimos conexión a base de datos
		   conn = DriverManager.getConnection(props.getProperty("url"), props);
		   
		   //Armamos el prepared statement con el query a realizar
		   ps = conn.prepareStatement("select now() as dia from dual");
		   
		   //Ejecutamos el query
		   rs = ps.executeQuery();
		     
		   //Obtenemos el resultado
		   if (rs.next()){
		    System.out.println(rs.getDate("dia").toString());
		   }
		   
		   //Si continuamos entonces estamos conectados de forma satisfactoria
		   System.out.println("Conectado a la Base de Datos");
		   
		  //Catch para atrapar alguna excepción de SQL
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   
		  //Bloque finally para cerrar la conexión
		  }finally{
		   if (conn!=null){
		   try {
		    conn.close();
		   } catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		   }
		  }
		 

		 }

		}