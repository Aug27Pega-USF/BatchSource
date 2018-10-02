package com.revature.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*Used to establish connection between application and database
 * Singleton Factory
 * 
 */

public class ConnectionFactory {

	private static ConnectionFactory cf;
	
	private ConnectionFactory() {
		super();
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(cf ==null) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			System.out.println("Specified File Was Not Found. Terminating Program.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Object Creation Failed. Terminating Program.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection Failed. Terminating Program.");
			e.printStackTrace();
		}
		return conn;
	}
}
