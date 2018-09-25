package JDBCBank.Banking.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBCBank.Banking.accounts.Users;
import JDBCBank.Banking.dao.UsersDAO;
import JDBCBank.Banking.util.ConnFact;

public class UserImpl implements UsersDAO {

	public static ConnFact f = ConnFact.getInstance();
	

	public void create(String username, String password, String firstname, String lastname) throws SQLException {
		Connection c = f.getConnection(); //set up connection
		String sql = "{ call INSERT_BANK_USERS(?, ?, ?, ?)"; //sql statement to pass in
		CallableStatement call = c.prepareCall(sql); //call object storing the statement 
		call.setString(1, username); //conversion for SQL
		call.setString(2, password); //conversion for SQL
		call.setString(3, firstname); //conversion for SQL
		call.setString(4, lastname); //conversion for SQL
		call.execute(); //call the statement
	}


	public ArrayList<Users> read() throws SQLException {
		ArrayList<Users> userList = new ArrayList<Users>();
		
		Connection c = f.getConnection();
		Statement stmt = c.createStatement(); //gets compiled on the sql side
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANK_USERS");
		Users u = null;
		
		//adds each entry back to a list
		while(rs.next()) {
			u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)); //with SQL we don't start at 0
			userList.add(u);
		}
		
		return userList;
	}
	
	public Users readOne(String user_name) throws SQLException {

		Connection c = f.getConnection();
		Statement stmt = c.createStatement(); //gets compiled on the sql side
		String sql = "SELECT * FROM BANK_USERS WHERE USER_NAME = '" + user_name + "'"; //sql statement to pass in
		ResultSet rs = stmt.executeQuery(sql);
		Users u = null;
		
		//adds each entry back to a list
		while(rs.next()) {
			u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)); //with SQL we don't start at 0
		}
		
		return u;
	}

	public void update(int userid, String first_name, String last_name) throws SQLException {
		Connection c = f.getConnection(); //set up connection
		String sql = "{ call UPDATE_USER(?, ?, ?)"; //sql statement to pass in
		CallableStatement call = c.prepareCall(sql); //call object storing the statement 
		call.setInt(1, userid); //conversion for SQL
		call.setString(2, first_name); //conversion for SQL
		call.setString(3, last_name); //conversion for SQL
		call.execute(); //call the statement
	}

	public void delete(int userid) throws SQLException {
		Connection c = f.getConnection(); //set up connection
		String sql = "{ call REMOVE_BANK_USERS(?)"; //sql statement to pass in
		CallableStatement call = c.prepareCall(sql); //call object storing the statement 
		call.setInt(1, userid); //conversion for SQL
		call.execute(); //call the statement
	}

}
