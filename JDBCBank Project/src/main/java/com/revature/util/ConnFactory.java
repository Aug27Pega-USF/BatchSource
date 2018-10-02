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
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		// This is the correct order of exceptions!
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"),
					prop.getProperty("pw"));
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
	}
	/*public static Connection getConnection() throws SQLException {
		*~<>~This is bad design, don't hardcode creds or private info, etc.~<>~
		String url = ""; //endpoint from Amazon Database
		String username = "";
		String password = "";
		return DriverManager.getConnection(url, username, password);
	}
	public static Connection getConnectionFromFile(String filename)
			throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
	}
	 */
}