package com.revature.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory cf = new ConnectionFactory();
	private ConnectionFactory() {
		super();
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(cf==null) {
			cf= new ConnectionFactory();
		}
	return cf;
	}
	
	public static Connection getConnection() {
		Connection conn =null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn =  DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"),
					prop.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return conn;
	
	/*public static Connection getConnection() throws SQLException{
		 * THis is bad. Harcoded creds etc....
		String url = ""; //endpoint
		String username= "";
		String password="";
		return DriverManager.getConnection(url,username,password);
		}
		*/
		//Better way
	
			
	}
	
}
