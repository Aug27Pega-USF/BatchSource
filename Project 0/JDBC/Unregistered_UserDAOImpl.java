package com.revature.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class Unregistered_UserDAOImpl implements Unregistered_UserDAO{
public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createCustomer(String Username, String Password) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{call INSERTCUSTOMER(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, Username);
		call.execute();
	}
	
	public void createAdmin(String Username, String Password) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{call INSERTADMIN(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, Username);
		call.execute();
	}
}
