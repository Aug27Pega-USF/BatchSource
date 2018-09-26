package proj.banking.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB_ConnectionFactory {
	private static DB_ConnectionFactory instance;
	
	public static synchronized DB_ConnectionFactory getInstance() {
		if(instance == null) {
			instance = new DB_ConnectionFactory();
		}
		return instance;
	}
	
	public static synchronized Connection getConnection() {
		Connection dbConnection = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			dbConnection = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"), prop.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbConnection;
	}
}
