package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.accounts.Admin;
//import com.revature.accounts.UserAccount;
import com.revature.accounts.Users;

import com.revature.interfaceaccount.AdminDAO;
import com.revature.util.ConnFactory;

public class AdminDAOImpl implements AdminDAO {

	public static ConnFactory cf=  ConnFactory.getInstance();
	
	public List<Users> getUser() throws SQLException {
		List<Users> usersList= new ArrayList<Users>();
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM BANK_USERS");
		Users s =null;
		while(rs.next())
		{
			s = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			usersList.add(s);
		}
		return usersList;
	}
	
	public List<Admin> getAdmin() throws SQLException {
		List<Admin> usersList= new ArrayList<Admin>();
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM ADMIN_ACCOUNTS");
		Admin s =null;
		while(rs.next())
		{
			s = new Admin(rs.getString(4),rs.getString(5),rs.getString(2),rs.getString(3),rs.getInt(1));
			usersList.add(s);
		}
		return usersList;
	}

	public void createUser(String fname, String lname, String uname, String pswrd) throws SQLException {
		Connection conn= cf.getConnection();
		String[] primaryKeys= new String[1];
		primaryKeys[0]= "User_Id";
		String sql= "INSERT INTO BANK_USERS VALUES(SQ_PK_BANK_USERS2.NEXTVAL,?,?,?,?)";
		
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, uname);
		ps.setString(4, pswrd);
		ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

	public void deleteUser(int id) throws SQLException {
		Connection conn= cf.getConnection();
		String sql="{ call DELETE_USER(?)";
		CallableStatement call= conn.prepareCall(sql);
		call.setInt(1, id);
		call.execute();
		System.out.println("User Deleted");
	
	}

	public void updateUser(int id, String fname, String lname, String uname, String pswrd) throws SQLException {
		Scanner s= new Scanner(System.in);
		Connection conn= cf.getConnection();
		String[] primaryKeys= new String[1];
		primaryKeys[0]= "User_Id";
		String sql = "UPDATE BANK_USERS SET FIRST_NAME= ?, LAST_NAME= ?, USERNAME= ?, PASSWORD= ? WHERE USER_ID = ?";
	      PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, uname);
			ps.setString(4, pswrd);
			ps.setInt(5,id);
			ps.executeUpdate();		
	}

	public boolean checkAdminLogin(String name, String password) throws SQLException {
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM ADMIN_ACCOUNTS");
		boolean isTrue=false;
		while(rs.next())
		{
			//System.out.println(rs.getString(4)+ " "+ rs.getString(5));
			if(name.equals(rs.getString(4)) && password.equals(rs.getString(5)))
			{
			isTrue=true;
			}
		}
		return isTrue;
	}

	@Override
	public int getAdminID(String uname) throws SQLException {
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM ADMIN_ACCOUNTS");
		int id=0;
		String name;
		while(rs.next())
		{
			name=rs.getString(4);
			if(name.equals(uname))
			{
				id=rs.getInt(1);
			}
			
		}				
		return id;
	}

}
