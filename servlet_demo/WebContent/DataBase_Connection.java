package com.cg.laxman.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;

public class DataBase_Connection {
	private static Connection conn=null;
	private static OracleDataSource datasource=null;
	private static DataBase_Connection instance=null;
	
	private DataBase_Connection() throws IOException,SQLException{  //this is the constructor.
		try{
			datasource=prepare_Datasource();
		}catch(SQLException sql){
			System.out.println("This is sql error");
		}
	}
	
	public static DataBase_Connection getInstance() throws IOException, SQLException {  //this method calls the constructor so it also throws both the exceptions
		if(instance==null){
			instance=new DataBase_Connection();                                        //static-->this method is called with class name
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		try{
			conn=datasource.getConnection();
		}catch(SQLException sql){
			System.out.println("This is sql connection");
		}
		return conn;
	}
	
	
	private OracleDataSource prepare_Datasource() throws SQLException{
		if(datasource==null){
			datasource=new OracleDataSource();
				
			datasource.setURL("jdbc:oracle:thin:@localhost:1521:XE");
			datasource.setUser("system");
			datasource.setPassword("root");
		}
		return datasource;
	}
}
