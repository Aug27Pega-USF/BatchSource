package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.dao.BankAccountDAO;
import com.revature.util.ConnFactory;

public class BankAccountDAOImpl implements BankAccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createAccount(int userID) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		String sql = "CALL ADD_BANK_USER(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,userID);
	}

	@Override
	public void deleteAccount(int accountID) throws SQLException {
		Connection conn= cf.getConnection();
		String sql = "CALL DELETE_BANK_ACCOUNT(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,accountID);
		call.execute();
	}

	@Override
	public void depositAccount(int accountID, double deposit) throws SQLException {
		Connection conn= cf.getConnection();
		String sql = "CALL DEPOSIT_BANK_ACCOUNT(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,accountID);
		call.setDouble(1,deposit);
		call.execute();
	}

	@Override
	public void withdrawAccount(int accountID, double withdraw) throws SQLException {
		Connection conn= cf.getConnection();
		String sql = "CALL WITHDRAW_BANK_ACCOUNT(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,accountID);
		call.setDouble(1,withdraw);
		call.execute();
		
	}

	@Override
	public void updateAccountBalance(int accountID, double balance) throws SQLException {
		Connection conn= cf.getConnection();
		String sql = "CALL UPDATE_BANK_BALANCE(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1,accountID);
		call.setDouble(1,setBalance);
		call.execute();
	}

	@Override
	public BankAccount viewAccount(int accountID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccount> getAccountList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
