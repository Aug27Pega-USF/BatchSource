package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.util.ConnFactory;

public class ConnFactory {
	
	private static ConnFactory cf= new ConnFactory();
	private ConnFactory()
	{
		super();
	}
	
	public static synchronized ConnFactory getInstance()
	{
		if (cf==null) {
			cf= new ConnFactory();
		}
		return cf;
	}
	
	public static Connection getConnection()
	{
		Connection conn= null;
		try {
		Properties prop= new Properties();
		prop.load(new FileReader("database.properties"));
		Class.forName(prop.getProperty("driver"));
		conn= DriverManager.getConnection(prop.getProperty("url"), 
					prop.getProperty("user"),
					prop.getProperty("password"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}

	/*public static Connection getConnection() throws SQLException{
		
		
		*This is bad. Hardcoded creds etc.*
		String url= "";//endpoint
		String username= "";
		String password="";
		
		return DriverManager.getConnection(url, username, password);
		
		}
		*/ 
		//Better Way
		
//	public static Connection getConnectionFromFile(String fileName) 
//			throws IOException, SQLException{
//				Properties prop= new Properties();
//				InputStream in = new FileInputStream(fileName);
//				
//		return null;		
//	}
	
}