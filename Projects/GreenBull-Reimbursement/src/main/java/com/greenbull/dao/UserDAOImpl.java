package com.greenbull.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.greenbull.users.User;

public class UserDAOImpl implements UserDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//set up connection to the database
	private static String url = "jdbc:oracle:thin:@reimbursemant-database.c79flqc2drgd.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String uname = "greenbull";
	private static String password = "zackattack";
	
	
	@Override
	public User readUserByUsername(String username) {
		
		System.out.println("in readUserByUsername");
		//prep our new class instance to null
		User user = null;
		
	
		//connect to database
		try(Connection conn = DriverManager.getConnection(url, uname, password)){
			//SQL statement - should get one data entry
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMB_WORKERS WHERE USER_NAME = ?");
			//plugs in our variable
			ps.setString(1, username);
			//get from database
			ResultSet rs = ps.executeQuery();
			
			//fill our instance with the db data
			while(rs.next()) {
				System.out.println("Got some stuff from the data base");
				user = new User(rs.getString("USER_NAME"), rs.getString("PASS_WORD"), rs.getInt("USER_ID"), rs.getInt("TYPE_OF_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//returns an instance of User class
		return user;
	}

	public User updateUserByUsername(String username, String parameter, float value) {

		System.out.println("in updateUserByUsername");
		// prep our new class instance to null
		User user = null;

		// connect to database
		try (Connection conn = DriverManager.getConnection(url, uname, password)) {
			System.out.println("Inside updateUserByUsername");
			// SQL statement - should get one data entry
			PreparedStatement ps = conn.prepareStatement("UPDATE REIMB_WORKERS SET " + parameter + " = ? WHERE USER_NAME = ?");
			System.out.println("Inside updateUserByUsername2");
			// String parameter = "PENDING_REIMBURSEMENTS";
			// "UPDATE REIMB_WORKERS SET " + parameter + " = ? WHERE USER_NAME = ?
			// plugs in our variable
			ps.setFloat(1, value);
			System.out.println("value is: " + value);
			ps.setString(2, username);
			System.out.println("username is: " + username);
			System.out.println("Inside updateUserByUsername3");
			ps.executeUpdate();
			System.out.println("Inside updateUserByUsername4");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// returns an instance of User class
		return user;
	}

	
	//do we NEED this?
	@Override
	public List<User> readAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertUser(String firstname, String lastname, String username, String password2) {
		// connect to database
		try (Connection conn = DriverManager.getConnection(url, uname, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO REIMB_WORKERS (USER_ID, FIRST_NAME, LAST_NAME, USER_NAME, PASS_WORD) VALUES (REIMB_WORKERS_SEQ.NEXTVAL, ?, ?, ?, ?)");
			System.out.println("made a new user!!");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, password2);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
