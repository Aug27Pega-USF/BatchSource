package com.revature.daoimp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.User;

import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

public class UserDAOImp implements UserDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createUser(String userName, String password, String firstName, String lastName,
			String address, String city,String state,int zip,int areaCode, int phone, int ssn,int lastfour)throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO USERS VALUES (SQ_USER_PK.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		//call.setInt(1,+"Sq");
		call.setInt (1,2);
		call.setString (2,userName);
		call.setString(3, password);
		call.setString(4,firstName);
		call.setString(5, lastName);
		call.setString(6, address);
		call.setString(7, city);
		call.setString(8, state);
		call.setInt(9, zip);
		call.setInt(10, areaCode);
		call.setInt(11, phone);
		call.setInt(12, ssn);
		call.setInt(13, lastfour);
		call.executeUpdate();
		
	}

	public void getUserList() throws SQLException {
		
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS");
		//PreparedStatement stmt = conn.prepareStatement("select *from USERS where USERID = ( select max(USERID) from USERS )");
		ResultSet rs = stmt.executeQuery();
		//System.out.println(rs);
		
		//User s = null;

		   ResultSetMetaData rsmd = rs.getMetaData();
		   System.out.println("The information entered into users is:");
		   int columnsNumber = rsmd.getColumnCount();
		while(rs.next()) {
			for (int i = 1; i <= columnsNumber; i++)
			{
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
			System.out.println();
			//s= new User(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14));
			//userList.add(s);			
		}	
		System.out.println();
	}
	 

	public void createUser(String firstName, String lastName, String address, String city,
			String state,int areaCode, int phone, int ssn, int lastfour) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void getNewUserList() throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select *from USERS where USERID = ( select max(USERID) from USERS )");
		ResultSet rs = stmt.executeQuery();		
		//User s = null;
		   ResultSetMetaData rsmd = rs.getMetaData();
		   System.out.println("The user with that ID is: ");
		   int columnsNumber = rsmd.getColumnCount();
		while(rs.next()) {
			for (int i = 1; i <= columnsNumber; i++)
			{
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
			System.out.println();		
		}
	}

	public void getCertainUser(int id) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from USERS where USERID = ?");
		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();	
		
		//User s = null;
		   ResultSetMetaData rsmd = rs.getMetaData();
		   System.out.println("The User information you requested is:");
		   int columnsNumber = rsmd.getColumnCount();
		while (rs.next()){
			for (int i = 1; i <= columnsNumber; i++)
			{
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
			System.out.println();		
		}
		System.out.println();
	}

	public int userSignIn(String a, String b) throws SQLException {
		int userId = 0;
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select USERID from USERS where USERNAME = ? AND PASSWORD = ?");
		stmt.setString(1,a);
	    stmt.setString(2,b);
		ResultSet rs = stmt.executeQuery();		
		//User s = null;
		//ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
        //System.out.println("Username and Password exist"); 
        userId = rs.getInt(1);
		}
		return userId;
		
	}

	public int getUserClearance(int userId) throws SQLException {
		int clearanceId = 0;
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select CLEARANCEID from USERS where USERID = ?");
		stmt.setInt(1,userId);
		ResultSet rs = stmt.executeQuery();		
		//User s = null;
		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
			//System.out.println("Clearence level is " + rs.getInt(1)); 
			clearanceId = rs.getInt(1);
		}
		return clearanceId;
	}

}
