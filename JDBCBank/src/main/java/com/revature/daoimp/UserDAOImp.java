package com.revature.daoimp;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

public class UserDAOImp implements UserDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();

	//Create User method that takes in all parameters except for primary key that is sequenced and clearance level set automatically to user
	public void createUser(String userName, String password, String firstName, String lastName,
			String address, String city,String state,int zip)throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO USERS VALUES (SQ_USER_PK.NEXTVAL,?,?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt (1,2);
		call.setString (2,userName);
		call.setString(3, password);
		call.setString(4,firstName);
		call.setString(5, lastName);
		call.setString(6, address);
		call.setString(7, city);
		call.setString(8, state);
		call.setInt(9, zip);
		call.executeUpdate();
		
	}

	//List to get all users in account
	public void getUserList() throws SQLException {
		
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS");
		ResultSet rs = stmt.executeQuery();

		//Used RSMD so I could get all rows stacking on top of each other, had to research this one since regular result set wasn't getting my results for me
		//Using the RSMD i could get column count, that gave me the ability to stack results on top of each other in Console
		   ResultSetMetaData rsmd = rs.getMetaData();
		   System.out.println("All the Users of the Database");
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
		System.out.println();
	}
	 

	//Deletes user based on userID
	public void deleteUser(int userID) throws SQLException{
		Connection conn = cf.getConnection();

				String sql = "CALL DELETE_USER(?)";
				CallableStatement call = conn.prepareCall(sql);
				call.setInt(1, userID);
				call.executeUpdate();
				System.out.println("User has been deleted ");
				System.out.println("Hit any key to continue");
				try {
					System.in.read();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

	System.out.println();
	
	}
	//Updates only username and password
	public void updateUser(int userID, String userName,String password)throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE USERS SET USERNAME = ?, PASSWORD = ? WHERE USERID = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setString (1,userName);
		call.setString (2,password);
		call.setInt(3, userID);
		call.executeUpdate();
		System.out.println("Username and Password updated");
		
	}
	//Gets the newest user added to user list
	public void getNewUserList() throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select *from USERS where USERID = ( select max(USERID) from USERS )");
		ResultSet rs = stmt.executeQuery();		
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
	//Gets user based on userID
	public void getCertainUser(int id) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from USERS where USERID = ?");
		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();	
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
	//Used to check username and password for users to sign in
	public int userSignIn(String a, String b) throws SQLException {
		int userId = 0;
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select USERID from USERS where USERNAME = ? AND PASSWORD = ?");
		stmt.setString(1,a);
	    stmt.setString(2,b);
		ResultSet rs = stmt.executeQuery();		
		while (rs.next()) {
        userId = rs.getInt(1);
		}
		return userId;
		
	}
	//Used to get clearance level of user 1.Admin 2.User
	public int getUserClearance(int userId) throws SQLException {
		int clearanceId = 0;
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select CLEARANCEID from USERS where USERID = ?");
		stmt.setInt(1,userId);
		ResultSet rs = stmt.executeQuery();		
		while (rs.next()) {
			clearanceId = rs.getInt(1);
		}
		return clearanceId;
	}

}
