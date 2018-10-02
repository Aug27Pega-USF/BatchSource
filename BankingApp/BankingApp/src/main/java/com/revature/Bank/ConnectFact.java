package com.revature.Bank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectFact {
	private static ConnectFact cf = new ConnectFact();
	private ConnectFact() {
		super();
	}
	public static synchronized ConnectFact getInstance() {
		if(cf == null) {
			cf = new ConnectFact();
		}
		return cf; 
	}
	public Connection getConnection() throws SQLException{
		
		
		   
		Connection conn = null;
		try {
	            Properties prop = new Properties();
	            prop.load(new FileReader("database.property"));
	            Class.forName(prop.getProperty("driver"));
	            conn = DriverManager.getConnection(prop.getProperty("url"),
	                    prop.getProperty("usr"),
	                    prop.getProperty("password"));
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		   return conn;
	}
	

	
	
	
}