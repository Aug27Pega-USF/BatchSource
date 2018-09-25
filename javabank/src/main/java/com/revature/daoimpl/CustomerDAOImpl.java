package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

import com.revature.dao.CustomerDAO;
import com.revature.exceptions.DuplicateUsernameException;
import com.revature.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	


	@Override
	public boolean registerAccount(String username, String password) throws SQLException {
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
	@Override
	public void listAccounts(int user_id) throws SQLException {
		Connection conn= cf.getConnection();
		String sql = "select BANK_ACCOUNT_ID, BALANCE from BANK_ACCOUNT WHERE USER_ID=? ORDER BY BANK_ACCOUNT_ID";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, user_id);
		System.out.println("Acc. ID : Balance");
		System.out.println("====================");
		ResultSet rs = 
				stmt.executeQuery();
		while (rs.next()) {
			String balance = String.format("$%.2f", rs.getDouble(2));
			System.out.println(rs.getInt(1)+ " : " + balance);
		}
	}
	
	public void viewTransactionHistory(int user_id) throws SQLException{
		Connection conn= cf.getConnection();
		String sql = "SELECT BANK_ACCOUNT_ID, AMOUNT, DIRECTION, TRANSACTION_DATE FROM TRANSACTION_HISTORY WHERE USER_ID=? ORDER BY TRANSACTION_DATE";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, user_id);
		System.out.println("Acc. ID : Amount : Action : TimeStamp");
		System.out.println("=====================================");
		ResultSet rs = 
				stmt.executeQuery();
		while (rs.next()) {
			String balance = String.format("$%.2f", rs.getDouble(2));
			Timestamp ts=rs.getTimestamp(4);
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timestamp = f.format(ts);
			System.out.println(rs.getInt(1)+ " : " + balance + " : " + rs.getString(3) + " : " + timestamp);
		}
	}

}
