package com.revature.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Users;
import com.revature.dao.UsersDAO;
import com.revature.util.ConnFactory;

public class UsersDAOImpl  implements UsersDAO{
public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createUser(String username, String password, int admin) throws SQLException{ //for creating a new nonadmin user
		Connection conn = ConnFactory.getConnection();
		String sql = " call MAKECUSTOMER (?, ?, ?) "; //calls the procedure makecustomer for the database
		CallableStatement ps = conn.prepareCall(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setInt(3, admin);
		ps.execute();
	}
	
	public void deleteUser(int userID) throws SQLException{ 
		Connection conn = ConnFactory.getConnection();
		String sql = " call DELETEUSER (?) "; 
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, userID);
		ps.execute();
	}
	
	public List<Users> getUserList() throws SQLException { //For admin case 7 only
		List<Users> userList =
				new ArrayList<Users>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS"); 
		Users u = null;
		while(rs.next()){
			u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			userList.add(u);
		}
		return userList;
	}
	
	public int isUserAdmin(int userID) throws SQLException { //checks if a user is an admin
		int admin = 0;
		Connection conn = cf.getConnection();
		String sql = "SELECT ADMIN FROM USERS WHERE USERID=? "; //
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		ResultSet rs = call.executeQuery();
		while(rs.next()) {
			admin=rs.getInt(1);
		}
		return admin;
		
	}

	public int userLogin(String username, String password) throws SQLException {
		int userId = 0;
		Connection conn = cf.getConnection();
		String result = "SELECT USERID from USERS where USERNAME = ? AND PASSWORD = ?";
		CallableStatement call = conn.prepareCall(result);
		call.setString(1,username);
	    call.setString(2,password);
		ResultSet rs = call.executeQuery();		
		while (rs.next()) {
        userId = rs.getInt(1);
		}
		return userId;
	}
}
