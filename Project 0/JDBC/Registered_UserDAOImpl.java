package com.revature.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.util.ConnFactory;

public class Registered_UserDAOImpl implements Registered_UserDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public List<Registered_User> viewAccount() throws SQLException{
		List<Registered_User> userList = new ArrayList<Registered_User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery("SELECT * FROM BANK");
		Registered_User ru = null;
		while(rs.next()) {
			ru = new Registered_User();

		}
		return null;
	}
	
	public List<Registered_User> deleteAccount() throws SQLException{
		return null;
	}
	
	public List<Registered_User> withdrawDeposit() throws SQLException{
		return null;
	}
	
	public void logout(String Username) throws SQLException{
		
	}
	
	public List<Registered_User> updateUser() throws SQLException{
		return null;
	}

	@Override
	public void createAccountCustomer(int Account_ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call CREATEACCOUNTCUSTOMER(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, Account_ID);
		call.execute();
	}

	@Override
	public void createAccountAdmin(int Account_ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call CREATEACCOUNTADMIN(?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, Account_ID);
		call.execute();
	}
}
