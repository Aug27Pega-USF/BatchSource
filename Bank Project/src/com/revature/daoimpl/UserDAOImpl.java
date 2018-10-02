package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

public class UserDAOImpl implements UserDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createUser(String userName, String pWord,
		String firstName, String lastName) throws SQLException {
		Connection conn= ConnFactory.getConnection();
		String sql = "CALL ADD_BANK_USER(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,userName);
		call.setString(2,pWord);
		call.setString(3,firstName);
		call.setString(4,lastName);
		call.execute();
		conn.close();
		System.out.println("New User Created!\n");
	}
	@Override
	public int login(String userName, String pWord) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void deleteUser(int userID) throws SQLException {
		Connection conn= ConnFactory.getConnection();
		String sql = "CALL DELETE_BANK_USER(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,userID);
		call.execute();
		conn.close();
	}
	@Override
	public User viewUser(int u_ID) throws SQLException {
		Connection conn = ConnFactory.getConnection();		
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM BANK_USER WHERE USERID IN('"+u_ID+"')";
		ResultSet rs =stmt.executeQuery(sql);
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
		}
		rs.close();
		conn.close();
		return u;
	}
	@Override
	public List<User> getUserList() throws SQLException {
		List<User> userList =new ArrayList<User>();
		Connection conn= ConnFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANK_USER");
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
			userList.add(u);
		}
		rs.close();
		conn.close();
		return userList;
	}
	@Override
	public void promoteToAdmin(int userID) throws SQLException {
		Connection conn= ConnFactory.getConnection();
		String sql = "CALL PROMOTE_USER(?)";
		CallableStatement call= conn.prepareCall(sql);
		call.setInt(1, userID);
		call.execute();
		conn.close();
	}
}
