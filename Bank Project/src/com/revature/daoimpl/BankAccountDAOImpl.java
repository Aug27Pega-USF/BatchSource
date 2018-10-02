package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.User;
import com.revature.dao.BankAccountDAO;
import com.revature.util.ConnFactory;

public class BankAccountDAOImpl implements BankAccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	static BankAccountDAOImpl adi = new BankAccountDAOImpl();

	@Override
	public void createAccount(int userID) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "CALL ADD_BANK_ACCOUNT (?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,userID);
		call.execute();
		conn.close();
		System.out.println("ADDING ACCOUNT");
	}

	@Override
	public void deleteAccount(int accountID) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "CALL DELETE_BANK_ACCOUNT(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountID);
		call.execute();
	}

	@Override
	public void depositAccount(int accountID, int deposit) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "CALL DEPOSIT_BANK_ACCOUNT(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountID);
		call.setDouble(2, deposit);
		call.execute();
	}

	@Override
	public void withdrawAccount(int accountID, int withdraw) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql2 = "CALL WITHDRAW_BANK_ACCOUNT(?,?)";
		CallableStatement call = conn.prepareCall(sql2);
		call.setInt(1, accountID);
		call.setDouble(2, withdraw);
		call.execute();
	}

	@Override
	public void updateAccountBalance(int accountID, int balance) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "CALL UPDATE_BANK_BALANCE(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountID);
		call.setDouble(2, balance);
		call.execute();
	}

	@Override
	public void viewUser(int userID) throws SQLException {
		int balance = 0;
		Connection conn = ConnFactory.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE USERID = '" + userID + "'";
		ResultSet rs = stmt.executeQuery(sql);
		BankAccount a = null;
		while (rs.next()) {
			a = new BankAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			System.out.println(rs.getInt(1) + " : " + rs.getInt(2));
		}
		rs.close();
	}

	public List<BankAccount> viewAccounts(int userID) throws SQLException {
		List<BankAccount> accountList = new ArrayList<BankAccount>();
		Connection conn = ConnFactory.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM BANK_ACCOUNT WHERE USERID = ?");
		stmt.setInt(1, userID);
		ResultSet rs = stmt.executeQuery();
		BankAccount b = null;
		while (rs.next()) {
			//System.out.println(rs.getObject("BALANCE"));
			//System.out.println(rs.getObject("ACCOUNTID"));
			//System.out.println(rs.getObject("USERID"));

			b = new BankAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			accountList.add(b);
		}
		rs.close();
		return accountList;
	}

	@Override
	public List<BankAccount> getAccountList() throws SQLException {
		List<BankAccount> accountList = new ArrayList<BankAccount>();
		Connection conn = ConnFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANK_ACCOUNT");
		BankAccount b = null;
		while (rs.next()) {
			b = new BankAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			accountList.add(b);
		}
		rs.close();
		return accountList;
	}
}
