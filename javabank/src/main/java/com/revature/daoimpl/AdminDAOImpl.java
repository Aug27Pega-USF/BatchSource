package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.revature.dao.AdminDAO;
import com.revature.exceptions.*;
import com.revature.util.ConnFactory;

public class AdminDAOImpl implements AdminDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void deleteUser(int user_id) throws SQLException {
		try {
			if (checkUser(user_id)) {
			Connection conn = cf.getConnection();
			String sql = "{ call DELETE_USER(?)";
			CallableStatement call= conn.prepareCall(sql);
			call.setInt(1, user_id);
			call.execute();
			System.out.println("User " + user_id + " and all associated accounts have been deleted.");
			}
		} catch (UnassociatedException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateUser(int user_id, String username, String password) throws SQLException {
		try {
			if (checkUser(user_id)) {
			try {
				Connection conn = cf.getConnection();
				String sql = "{ call UPDATE_BANK_USER(?,?,?)";
				CallableStatement call= conn.prepareCall(sql);
				call.setInt(1, user_id);
				call.setString(2, username);
				call.setString(3, password);
				call.execute();
				System.out.println("User " + user_id + " has been updated.");
			} catch (SQLException e) {
				System.out.println("Cannot update username. Username already taken.");
			}
			}
		} catch (UnassociatedException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void viewUsers() throws SQLException {
		Connection conn= cf.getConnection();
		Statement stmt = conn.createStatement();
		System.out.println("UserId : Username");
		System.out.println("=================");
		ResultSet rs = 
				stmt.executeQuery("select USER_ID, USERNAME from BANK_USER WHERE USER_TYPE='C' ORDER BY USER_ID");
		while (rs.next()) {
			System.out.println(rs.getInt(1)+ " : " + rs.getString(2));
		}
	}

	@Override
	public boolean createUser(String username, String password) throws SQLException, DuplicateUsernameException {
		Connection conn= cf.getConnection();
		Random ran = new Random();
		boolean check=false;
		int id = 0;
		try {
			String sql = "SELECT USER_ID FROM BANK_USER WHERE USERNAME=?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, username);
			ResultSet rs= prest.executeQuery();
			if(!rs.next()) {
			}
			else {
				throw new DuplicateUsernameException("Username is taken.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}	
		do{
			try {
				check=true;
				id=100000+ran.nextInt(899999);
				String sql = "{ call INSERT_BANK_USER(?,?,?)";
				CallableStatement call= conn.prepareCall(sql);
				call.setInt(1, id);
				call.setString(2, username);
				call.setString(3, password);
				call.execute();
			} catch (SQLException e) {
				check=false;
			}		
		}while(!check);
		System.out.println("Created user " + id + ".");
		return check;
	}

	@Override
	public int login(String username, String password) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "SELECT LOGIN(?,?) FROM DUAL";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, username);
			prest.setString(2, password);
			ResultSet rs = prest.executeQuery();
			rs.next();
			int account_id=rs.getInt(1);
			if(account_id!=0) {
				System.out.println("Succesfully logged in " + username + ".");
			}
			return account_id;
	}

	public boolean checkUser(int user_id) throws UnassociatedException {
		try {
			Connection conn= cf.getConnection();
			String sql = "SELECT USER_ID FROM BANK_USER WHERE USER_ID=?";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setInt(1, user_id);
			ResultSet rs= prest.executeQuery();
			if (rs.next()) {
				return true;
			}
			else {
				throw new UnassociatedException("There is no user with that user id.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
