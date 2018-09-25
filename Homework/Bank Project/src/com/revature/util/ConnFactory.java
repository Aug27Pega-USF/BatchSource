package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	private static ConnFactory cf = new ConnFactory();
	private ConnFactory() {
		super();
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			cf= new ConnFactory();
		}
		return cf;
	}
//	public Connection getConnection() {
//		Connection conn =null;
//		try {
//			Properties prop = new Properties();
//			prop.load(new FileReader("database.properties"));
//			Class.forName(prop.getProperty("driver"));
//			conn =  DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"),
//					prop.getProperty("password"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
	public static Connection getConnection() throws SQLException{
	 // This is bad. Hardcoded creds etc....
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@awdone.czkvfj7ro1bf.us-east-2.rds.amazonaws.com:1521:ORCL"; //endpoint
	String username= "Spindocked";
	String password="Nep3tune";
	return DriverManager.getConnection(url,username,password);
	}
}
