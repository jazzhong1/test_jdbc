package com.test_jdbc.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBConnector {
	
	public DBConnector() {
	}
	
	public static Connection getConnect(){
		
		Properties prop=new Properties();{
			try {
				prop.load(new BufferedReader(new FileReader("source/driver.properties")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		Connection conn = null;
		try {
			Class.forName(prop.getProperty("driver"));
			 conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pw"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void disConnect(ResultSet rs, Statement st, Connection conn){
		
		try {
			rs.close();
			st.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
public static void disConnect(Statement st, Connection conn){
		
		try {
			st.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
