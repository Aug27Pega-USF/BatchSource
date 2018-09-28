package com.revature.daoImpl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.util.ConnFactory;

public class AccountDAOImpl  implements AccountDAO{
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createAccount(int userID, int balance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "call MAKEACCOUNT(?, ?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, userID);
		ps.setDouble(2, balance);
		ps.execute();
	}

	public void deleteAccount(int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "call DELETEACCOUNT(?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, accountID);
		ps.execute();
	}

	public List<Account> getAccountList(int userID) throws SQLException { //For admin case 7 only
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		String sql = "SELECT ACCOUNTID, USERID, BALANCE FROM ACCOUNTS WHERE USERID = ?";
		PreparedStatement call = conn.prepareStatement(sql);
		call.setInt(1, userID);
		ResultSet rs = call.executeQuery();  
		Account a = null;
		while(rs.next()){
			a = new Account(rs.getInt(1), userID = rs.getInt(2), rs.getInt(3));
			accountList.add(a);
		}
		return accountList;
	}


	public double deposit(int accountID, double input) throws SQLException {
		double balance = 0;
		int aID = accountID;
		Connection conn = cf.getConnection();
		String sql = "SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNTID = ?";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, accountID);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			balance = rs.getDouble("BALANCE");
		}
		balance = balance + input;
		String sql2 = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCOUNTID = ?";
		CallableStatement pd = conn.prepareCall(sql2);
		pd.setDouble(1, balance);
		pd.setInt(2, aID);
		pd.execute();
		return balance;
	}

	public double withdraw(int accountID, double input) throws SQLException {
		double balance = 0;
		int aID = accountID;
		Connection conn = cf.getConnection();
		String sql = "SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNTID = ?";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, accountID);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			balance = rs.getDouble("BALANCE");
		}
		if(balance >0 ) {
			if(balance > input) {
				balance = balance - input;
			}
		}
		String sql2 = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCOUNTID = ?";
		CallableStatement pd = conn.prepareCall(sql2);
		pd.setDouble(1, balance);
		pd.setInt(2, aID);
		pd.execute();
		return balance;
	}

}
