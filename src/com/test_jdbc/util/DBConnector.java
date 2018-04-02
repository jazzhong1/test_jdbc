package com.test_jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnector {
	
	public DBConnector() {
	}
	
	public static Connection getConnect(){
			
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			
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
