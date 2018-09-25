package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User_Info;
import com.revature.dao.User_Info_Dao;
import com.revature.util.ConnFactory;

public class User_Info_DAOImpl implements User_Info_Dao {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createUser(String uname, String pwd, String fN, String lN) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTUSER_INFO(?,?,?,?)}";
		PreparedStatement call = conn.prepareStatement(sql);
		call.setString(1, uname);
		call.setString(2, pwd);
		call.setString(3, fN);
		call.setString(4, lN);
		call.execute();		
	}

	public List<User_Info> getUser_InfoList() throws SQLException {
		List<User_Info> users = new ArrayList<User_Info>();
		Connection conn = cf.getConnection();
		User_Info user = null;
		String sql = "SELECT * FROM USER_INFO ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int uid = rs.getInt(1);
			String usr = rs.getString(2);
			String pass = rs.getString(3);
			String fname = rs.getString(4);
			String lname = rs.getString(5);
			
			user = new User_Info(uid,usr,pass,fname,lname);
			users.add(user);
			
		}
		return users;
	}

	public User_Info getUserByUsername(String usr) throws SQLException {
		Connection conn = cf.getConnection();
		User_Info user = null;
		String sql = "SELECT * FROM USER_INFO WHERE USERNAME = ? ";
		PreparedStatement call = conn.prepareStatement(sql);
		call.setString(1, usr);//usr is the arg we pass to the sql above
		ResultSet rs = call.executeQuery();
		while(rs.next()) {
			Integer uid = rs.getInt(1);
			String usre = rs.getString(2);
			String ps = rs.getString(3);
			String fn = rs.getString(4);
			String ln = rs.getString(5);
			
			user = new User_Info(uid,usre,ps,fn,ln);
		}
		return user;
	}

	public void updateUser_Info(int id, String username, String password, String firstname, String lastname) throws SQLException {
		Connection conn  = cf.getConnection();
		//User_Info user = null;
		String sql = "{CALL UPDATE_USER_INFO(?,?,?,?,?}";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, firstname);
		ps.setString(4, lastname);
		ps.setInt(5, id);
		
		//ps.executeUpdate();
		
		
	}

	public void removeUser_Info(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM USER_INFO WHERE USER_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeQuery();
	}

	public User_Info getUserById(int id) throws SQLException {
		Connection conn = cf.getConnection();
		User_Info user = null;
		String sql = "SELECT USER_ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME FROM USER_INFO WHERE USER_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			user = new User_Info(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
	return user;	
	}

}
