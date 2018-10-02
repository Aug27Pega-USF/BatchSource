package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.dao.BankUserDAO;
import com.revature.util.ConnFactory;

public class BankUserDAOImpl implements BankUserDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createCustomer(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTUSER(?, ?, ?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.setString(3, "N");
		call.execute();
	}
	
	public void createAdmin(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTUSER(?, ?, ?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.setString(3, "Y");
		call.execute();
	}
	
	public List<Customer> getCustomerList() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSERS WHERE ISADMIN = 'N'");
		Customer s = null;
		while(rs.next()) {
			s = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			customerList.add(s);
		}
		return customerList;
	}
	
	public List<Admin> getAdminList() throws SQLException {
		List<Admin> adminList = new ArrayList<Admin>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSERS WHERE ISADMIN = 'Y'");
		Admin s = null;
		while(rs.next()) {
			s = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			adminList.add(s);
		}
		return adminList;
	}
	
	public void updateCustomer(int user_id) throws SQLException {
		
	}
	
	public void deleteCustomer(int user_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call DELETEUSER(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, user_id);
		System.out.println(user_id);
		System.out.println(call);
		call.execute();
	}
	
	public Customer checkCustomerLogin(String username, String password) throws SQLException {
//		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM BANKUSERS WHERE USERNAME = ? AND USERPASSWORD = ?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		Customer s = null;
		while(rs.next()) {
			s = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		return s;
	}
	
	public Admin checkAdminLogin(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM BANKUSERS WHERE USERNAME = ? AND USERPASSWORD = ?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		Admin s = null;
		while(rs.next()) {
			s = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		return s;
	}
}
