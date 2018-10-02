package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.dao.AccountDAO;
import com.revature.util.ConnFactory;

public class AccountDAOImpl implements AccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createAccount(String acctname, double amount, int user_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTACCOUNT(?, ?, ?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, acctname);
		call.setDouble(2, amount);
		call.setInt(3, user_id);
		call.execute();
	}
	
	public void updateAccountUser(String acctname) throws SQLException {
		
	}
	public void updateAccountUser(int account_id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public void updateAccountBalance(int account_id, double amount) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("UPDATE BANKACCOUNTS SET BALANCE = ? WHERE ACCTID = ?");
		stmt.setDouble(1, amount);
		stmt.setInt(2, account_id);
		stmt.executeQuery();
		System.out.println("Your account balance is now $" + amount + ".");
	}

	public List<Account> getAccountList() throws SQLException {
		Account s = null;
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKACCOUNTS");
		while(rs.next()) {
			s = new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			accountList.add(s);
		}
		return accountList;
	}
	
	public List<Account> getUserAccounts(int user_id) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKACCOUNTS WHERE USERID IN('"+ user_id +"') ORDER BY ACCTID");
		Account s = null;
		while(rs.next()) {
			s = new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
			accountList.add(s);
		}
		return accountList;
	}
	
	public void deleteAccount(int account_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call DELETEACCOUNT(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, account_id);		
		call.execute();
	}
}
