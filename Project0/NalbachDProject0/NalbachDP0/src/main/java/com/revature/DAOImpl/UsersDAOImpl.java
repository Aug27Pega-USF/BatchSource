package com.revature.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Connection.ConnFactory;
import com.revature.dao.UsersDAO;
import com.revature.tables.Users;
//an interface like UsersDAO is useful to implement abstraction 
//here we have the connection factory which provides us with a connection to SQL 
//the next part is a callable procedure that allows us to autoincrement the primary key for the table Users 
public class UsersDAOImpl implements UsersDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createUsers(String username, String password, String firstName, String lastName) throws SQLException {
		Connection conn =cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERS(USER_ID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,USER_TYPE) VALUES(USERSSEQ.NEXTVAL , ?, ?, ?, ?, ?)");
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.setString(3, firstName);  
		stmt.setString(4, lastName); 
		stmt.setInt(5, 2);
		stmt.executeQuery();
	}

	//this calls the array list users 
	public static List<Users> getUserslist() throws SQLException {
		List<Users> UsersList = 
				new ArrayList<Users>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USER_ID=?");
		Users l = null;
		while(rs.next()) {
			l=new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			UsersList.add(l);
		}
		return UsersList;
	}
	public void update(int userid, String firstName, String lastName) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{ call UPDATE_USER(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userid);
		call.setString(2, firstName);
		call.setString(3, lastName);
		call.execute();
	}
	
	public void deleteUser(int userid)throws SQLException{
		Connection conn = cf.getConnection();
		String sql ="{call REMOVE_USERS(?)"; 
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userid);
		call.executeUpdate();
		System.out.println("User has been deleted ");
	}
	public void updateUser(int userID, String userName,String password)throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE USERS SET USERNAME = ?, PASSWORD = ? WHERE USER_ID = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setString (1,userName);
		call.setString (2,password);
		call.setInt(3, userID);
		call.executeUpdate(); //Executes the SQL statement in this PreparedStatement object, which must be an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE; or an SQL statement that returns nothing, such as a DDL statement.
		System.out.println("Username and Password updated");
	}
	
	public void getCertainUser(int userId) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ?");
		stmt.setInt(1,userId);
		ResultSet rs = stmt.executeQuery();	
		   java.sql.ResultSetMetaData rsmd = rs.getMetaData();
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

	@Override
	public int getLastUser() throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT USER_ID FROM USERS WHERE USER_ID = ( SELECT MAX(USER_ID) FROM USERS)");
        ResultSet rs = stmt.executeQuery();        
        int userId = 0;
		while (rs.next()) {
        	userId = rs.getInt(1);
        	//System.out.println(userId);
        }
        return userId;
	}
	//Main menu case 1: login setup
	public int getLogin(String username, String password) throws SQLException {
		int userId =0;
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT USER_ID FROM USERS WHERE USERNAME = ? AND PASSWORD = ?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			userId = rs.getInt(1);
			//System.out.println(userId);
		}
		return userId;
	}
	//Main menu login permissions
	@Override
	public int getLevel(int userId) throws SQLException {
		int userType =0;
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT USER_TYPE FROM USERS WHERE USER_ID = ?");
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			userType = rs.getInt(1);
			//System.out.println(userType);
		
		}
		return userType;
	}
	//Admin menu case 2 setup
	public void viewUsersAccounts(int userId) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ?");
		stmt.setInt(1,userId);
		ResultSet rs = stmt.executeQuery();	
		   java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		   System.out.println("The User information for" +userId);
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
	public List<Users> getUsersList() throws SQLException {
		return null;
	}

}
