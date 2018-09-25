package com.revature.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Connection.ConnFactory;
import com.revature.dao.UsersDAO;
import com.revature.tables.Users;

public class UsersDAOImpl implements UsersDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createUsers(String Ssn, String username, String password, String firstName,  String lastName, String phone,String address, String state, String country, String email) throws SQLException {
		Connection conn =cf.getConnection();
		String sql = "{call INSERTUSERS (?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, Ssn);
		call.setString(2, username);
		call.setString(3, password);
		call.setString(4, firstName);  
		call.setString(5, lastName); 
		call.setString(6, phone);
		call.setString(7, address); 
		call.setString(8, state); 
		call.setString(9, country); 
		call.setString(10, email);
		call.execute();
	}
	
	public List<Users> getUserslist() throws SQLException {
		List<Users> UsersList = 
				new ArrayList<Users>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
		Users l = null;
		while(rs.next()) {
			l=new Users(rs.getInt(1), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getString(5),  rs.getString(6),  rs.getString(7),  rs.getString(8),  rs.getString(9),  rs.getString(10));
			UsersList.add(l);
		}
		return UsersList;
	}

	public List<Users> getUsersList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
