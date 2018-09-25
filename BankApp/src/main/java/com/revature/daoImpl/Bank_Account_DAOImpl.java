package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bank_Account;
import com.revature.beans.User_Info;
import com.revature.dao.Bank_Account_Dao;
import com.revature.util.ConnFactory;

public class Bank_Account_DAOImpl implements Bank_Account_Dao {
	public static ConnFactory cd = ConnFactory.getInstance();
	
	public void createAccount(int anum,int uid, double saving, double checking) throws SQLException {
				Connection conn = cd.getConnection();
				String sql = "{call INSERTBANK_ACCOUNT(?,?,?,?)}";
				PreparedStatement call = conn.prepareStatement(sql);
				call.setInt(1, anum);
				call.setInt(2, uid);
				call.setDouble(3, saving);
				call.setDouble(4, checking);
				call.execute();		
	}

	public List<Bank_Account> getBank_AccountList() throws SQLException {
		List<Bank_Account> accounts = new ArrayList<Bank_Account>();
		Connection conn = cd.getConnection();
		Bank_Account account = null;
		String sql = "SELECT * FROM Bank_Account ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int aid = rs.getInt(1);
			int anum = rs.getInt(2);
			int uid = rs.getInt(3);
			double saving = rs.getDouble(4);
			double checking = rs.getDouble(5);
			
			account = new Bank_Account(aid,anum,uid,saving,checking);
			accounts.add(account);
			
		}
		System.out.println();
		return accounts;	
		}

	public Bank_Account getBank_AccountById(int id) throws SQLException {
		Connection conn = cd.getConnection();
		Bank_Account account = null;
		String sql = "SELECT BANK_ACCOUNT_ID, ACCOUNT_NUMBER, USER_ID,SAVING_BALANCE,CHECKING_BALANCE"
				+ " FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			account = new Bank_Account(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getDouble(5));
		}
	return account;	
		
	}

	public void updateBank_Account(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void removeBank_Account(int id) throws SQLException {
		Connection conn = cd.getConnection();
		String sql = "DELETE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeQuery();
	}

	public double updateSavingBalance(int anum, double saving) throws SQLException {//by saving column
		Connection conn = cd.getConnection();
		String sql = "{CALL DEPOSIT_INTO_SAVING(?,?)}";
		PreparedStatement call = conn.prepareStatement(sql);
		call.setInt(1, anum);
		call.setDouble(2, saving);// the arg we pass to the sql above
		call.execute();
		return saving;		
	}

	public double updateCheckingBalance(int anum, double checking) throws SQLException {
		Connection conn = cd.getConnection();
		String sql = "{CALL DEPOSIT_INTO_CHECKING(?,?)}";
		PreparedStatement call = conn.prepareStatement(sql);
		call.setInt(1, anum);
		call.setDouble(2, checking);//usr is the arg we pass to the sql above
		call.execute();
		return checking;		
	}

}
