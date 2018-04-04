package com.test_jdbc.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBQuery {	
	public DBQuery() {
	}
	
	public static Properties getQuery(){
		
		Properties prop=new Properties();{
			try {
				prop.load(new BufferedReader(new FileReader("source/query.properties")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		
		
		return prop;
		
	}

}
