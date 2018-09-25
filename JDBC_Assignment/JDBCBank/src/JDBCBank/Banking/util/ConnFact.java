package JDBCBank.Banking.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;


public class ConnFact {

	//ref for the connector
	public static ConnFact f = new ConnFact();

	//basic constructor
	public ConnFact() {
		super();
	}
	
	//getting an instance of the connector object
	//if it's gone for whatever reason
	public static synchronized ConnFact getInstance() {
		if (f == null) {
			f = new ConnFact();
		}
		return f;
	}
	
	
	//class that connects us to the SQL server
	//based on credentials provided in a file
	public Connection getConnection() {
		//object holding our connection to the database
		Connection conn = null;
		
		try {
			//for streaming from a file
			Properties p = new Properties();
			//load our file
			p.load(new FileReader("Database.properties"));
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"), 
												p.getProperty("user"), 
												p.getProperty("password"));
			/*
			Statement statement = conn.createStatement();
			
			statement.execute("CREATE TABLE APP_LOGS(THREAD VARCHAR(20), DATE_OF_OCCURENCE DATETIME, CLASS VARCHAR(100),"
                    + " LINE_NUMBER INTEGER, LEVEL VARCHAR(10), MESSAGE VARCHAR(1000), STACKTRACE CLOB)");
            */
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/*
	@BeforeAll
    public static void setup() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
 
            statement.execute("CREATE TABLE APP_LOGS(THREAD VARCHAR(20), DATE_OF_OCCURENCE DATETIME, CLASS VARCHAR(100),"
                    + " LINE_NUMBER INTEGER, LEVEL VARCHAR(10), MESSAGE VARCHAR(1000), STACKTRACE CLOB)");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */

		 
}
