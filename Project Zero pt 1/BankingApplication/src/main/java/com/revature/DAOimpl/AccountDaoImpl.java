package com.revature.DAOimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.AccountDAO;
import com.revature.account.Account;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDAO 
{
	public String userName;
	public String password;
	public int userid;
	public int acct_num;
	public int statid;
	public float bal;
	

	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn= cf.getConnection();
	Statement stmt;

	@Override
	public void createLogin(String userName, String password) throws SQLException 
	{
		conn= cf.getConnection();
		String [] primaryKeys =new String[1];
		primaryKeys[0]= "LoginID";
		String sql = "INSERT INTO LOGIN VALUES (BANKSEQ.NEXTVAL, ?, ?)";
		
		PreparedStatement ps = 
				conn.prepareStatement(sql,primaryKeys);
		ps.setString(1, userName);
		ps.setString(2, password);
		ps.executeUpdate();
	}
	@Override
	public void addAccountInfo(int acc_num, float bal) throws SQLException{
		conn= cf.getConnection();
		String [] primaryKeys =new String[1];
		primaryKeys[0]= "UserID";
		String sql = "INSERT INTO ACCOUNTS VALUES (USERSEQ.NEXTVAL,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql,primaryKeys);
		ps.setInt(1, acc_num);
		ps.setFloat(2,bal);
		ps.executeUpdate();
		
		
	}
	@Override
	public void deleteAccount(int user_ID) 
	{
		conn = cf.getConnection();	
		String sql = "DELETE * FROM ACCOUNTS WHERE USERID =  ?";
		try {
			stmt.execute(sql);	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to remove account. Please try again.");
		}
		
	}
	@Override
	public List<Account> getAllAccounts() 
	{	
		List<Account> list = new ArrayList<Account>();
	String sql = "SELECT * FROM ACCOUNTS";
	Account s=null;
	try {
		Statement stmt1 = conn.createStatement();
		ResultSet rs = stmt1.executeQuery(sql);
		while (rs.next()) {
			s = new Account( rs.getInt(1), rs.getInt(2),rs.getFloat(3));
		}
		list.add(s);
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("The sql getAllAccounts statement resulted in an error");
	}
	return list;
	}

	@Override
	public void doDeposit(double amount,int userID) throws SQLException 
	{
		String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USERID = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setDouble(1,amount);
		call.setInt(2, userID);
		call.executeUpdate();
	
		System.out.println("Balance was updated");

	}
	@Override
	public void doWithdrawal(double amount, int userID) throws SQLException {
		String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USERID = ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setDouble(1,amount);
		call.setInt(2, userID);
		call.executeUpdate();
	
		System.out.println("withdraw was made");
		
	}
	@Override
	public void doDelete(int userID) throws SQLException  {
	        Connection conn = cf.getConnection();
	        String sql= "{call DELETE_ACCT(?)";
	        CallableStatement call= conn.prepareCall(sql);
	        call.getInt(userID);
	        call.execute();
	}

	
	
}
