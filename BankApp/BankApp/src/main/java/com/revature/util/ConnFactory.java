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
	public  Connection getConnection() throws SQLException
		//bad way
		/*String url = "";
		String username="";
		String password = "";
		return DriverManager.getConnection(url,username,password);
		*/
		//better way
		 {
		        Connection conn= null;
		        try {
		        Properties prop= new Properties();
		        prop.load(new FileReader("database.properties"));
		        Class.forName(prop.getProperty("driver"));
		        conn=DriverManager.getConnection(prop.getProperty("url"),
		                    prop.getProperty("usr"),
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
	
}
