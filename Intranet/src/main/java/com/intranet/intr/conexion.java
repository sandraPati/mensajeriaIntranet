/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class conexion {
    Connection Conexion=null;
	InitialContext initContext;	
	
	public conexion() throws SQLException{
		
        try {
            Class.forName("org.postgresql.Driver");
            String servidor="jdbc:postgresql://localhost:5432/intranet";//estrella
            String usuario="postgres";
            String password="Zt4CIBxzrO";
            //Zt4CIBxzrO
            Conexion=DriverManager.getConnection(servidor, usuario, password);
            
        }catch(ClassNotFoundException ex){
            ex.getMessage();
        } catch (SQLException e) {
            e.getMessage();
        }
	        
	        
	    }
	    
	
	 public Connection getConnection() {
	        return Conexion;
	    }
	 
	 public void disConnection() {
	        try {
	            Conexion = null;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
