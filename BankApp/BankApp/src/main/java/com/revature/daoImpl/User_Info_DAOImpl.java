package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return null;
	}

	public User_Info getUserByUsername(String usr) throws SQLException {
		Connection conn = cf.getConnection();
		User_Info user = null;
		String sql = "select username from User_Info where username = ? ";
		PreparedStatement call = conn.prepareStatement(sql);
		call.setString(1, usr);//usr is the arg we pass to the sql above
		ResultSet rs = call.executeQuery();
		while(rs.next()) {
			int uid = rs.getInt(1);
			String usre = rs.getString("username");//get the value of username(col name) in db and set it to usr
			String ps = rs.getString("3");
			String fn = rs.getString(4);
			String ln = rs.getString(5);
			
			user = new User_Info(uid,usre,ps,fn,ln);
		}
		return user;
	}

	public void updateUser_Info(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void removeUser_Info(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public User_Info getUserByPassword(String psd) throws SQLException {
		Connection conn = cf.getConnection();
		User_Info user = null;
		String sql = "select password from User_Info where password = ? ";
		PreparedStatement call = conn.prepareStatement(sql);
		call.setString(1, psd);
		ResultSet rs = call.executeQuery();
		while(rs.next()) {
			int uid = rs.getInt(1);
			String usr = rs.getString(2);
			String pasd = rs.getString("password");
			String fn = rs.getString(4);
			String ln = rs.getString(5);
			
			user = new User_Info(uid,usr,pasd,fn,ln);
			
		}
		return user;
	}

}
