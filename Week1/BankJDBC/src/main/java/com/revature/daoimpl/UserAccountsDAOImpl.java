package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.accounts.UserAccount;
import com.revature.accounts.Users;
import com.revature.interfaceaccount.UserAccountsDAO;
import com.revature.util.ConnFactory;



public class UserAccountsDAOImpl implements UserAccountsDAO{
	private static final Logger log = LogManager.getLogger(UserAccountsDAOImpl.class.getName());
	
	public static ConnFactory cf=  ConnFactory.getInstance();
	
	public String findUserInfo(int uid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String findAccountInfo(int uid, int actId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Double accountBalance(int actId) throws SQLException {
		List<UserAccount> accountList= new ArrayList<UserAccount>();
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();		
		double balance=0;
		ResultSet rs= stmt.executeQuery("SELECT * FROM USER_ACCOUNTS WHERE ACT_ID= "+actId);
		while(rs.next())
		{
			if(rs.getInt(1)==actId)
				{
				balance= rs.getDouble(4);				
				}
		}
		return balance;
	}

	public void withdrawBalance(int actId, double amount) throws SQLException {
		//UsersDAOImpl user= new UsersDAOImpl();
		Connection conn= cf.getConnection();
		//Statement stmt= conn.createStatement();
		double newBalance;
		newBalance= accountBalance(actId);
		newBalance-=amount;
		
			String[] primaryKeys= new String[1];
			primaryKeys[0]= "Act_Id";
			String sql= "UPDATE USER_ACCOUNTS SET BALANCE=? WHERE ACT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setDouble(1, newBalance);
			ps.setInt(2,actId);
			ps.executeUpdate();		
		log.info("WITHDRAW WAS MADE FROM " + actId + " FOR  $" + amount);
			
	}

	public void depositToBalance(int actId, double amount) throws SQLException {
		Connection conn= cf.getConnection();
		//Statement stmt= conn.createStatement();
		double newBalance;
		newBalance= accountBalance(actId);
		newBalance+=amount;
		
			String[] primaryKeys= new String[1];
			primaryKeys[0]= "Act_Id";
			String sql= "UPDATE USER_ACCOUNTS SET BALANCE=? WHERE ACT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setDouble(1, newBalance);
			ps.setInt(2,actId);
			ps.executeUpdate();		
			log.info("DEPOSIT WAS MADE FROM " + actId + " FOR  $" + amount);
	}

	@Override
	public List<UserAccount> getAccountList(int uid) throws SQLException {
		List<UserAccount> accountList= new ArrayList<UserAccount>();
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM USER_ACCOUNTS");
		UserAccount s =null;
		while(rs.next())
		{
			if(rs.getInt(2)== uid) 
			{
			s = new UserAccount(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDouble(4));
			accountList.add(s);
			}
		}
		return accountList;
	}

	@Override
	public void deleteAccountIfEmpty(int actId) {
		Connection conn= cf.getConnection();
		String sql="{ call DELETE_ACCOUNT(?)";
		try {
			Statement stmt= conn.createStatement();
			ResultSet rs;		
			rs = stmt.executeQuery("SELECT * FROM USER_ACCOUNTS WHERE ACT_ID= "+actId);		
			while(rs.next())
			{
			if(rs.getDouble(4)<=0) 
			{
			CallableStatement call= conn.prepareCall(sql);
			call.setInt(1, actId);
			call.execute();
			}
			else {
				System.out.println("Account must be empty before deletion. Please withdraw all fund from account balance to proceed with deletion.");
			}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
