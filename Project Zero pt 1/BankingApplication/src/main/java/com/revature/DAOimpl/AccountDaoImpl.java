package com.revature.DAOimpl;

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
	public void addAccountInfo(int acc_num, int stat, float bal) throws SQLException{
		conn= cf.getConnection();
		String [] primaryKeys =new String[1];
		primaryKeys[0]= "UserID";
		String sql = "INSERT INTO ACCOUNTS VALUES (USERSEQ.NEXTVAL,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql,primaryKeys);
		ps.setInt(1, acc_num);
		ps.setInt(2, stat);
		ps.setFloat(3,bal);
		ps.executeUpdate();
		
		
	}
	@Override
	public void deleteAccount(int user_ID) 
	{
		conn = cf.getConnection();	
		String sql = "DELETE * FROM ACCOUNTS WHERE USERID = " + user_ID;
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
	String sql = "SELECT * FROM ACCOUNT";
	Account s=null;
	try {
		Statement stmt1 = conn.createStatement();
		ResultSet rs = stmt1.executeQuery(sql);
		while (rs.next()) {
			s = new Account( userid = rs.getInt(1),
			acct_num = rs.getInt(2),
			statid = rs.getInt(3),
			bal = rs.getFloat(4));
		}
		list.add(s);
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("The sql getAllAccounts statement resulted in an error");
	}
	return list;
	}
	@Override
	public void approveAccount() 
	{
		String sql = "UPDATE * ACCOUNT SET STATID = " + 2 + " WHERE STATID = " + 1;
		try
		{
			stmt.execute(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Account could not be approved ");
		}
	
	}
	@Override
	public void doDeposit(double amount,int userID) 
	{
		String sql = "UPDATE ACCOUNT SET BALANCE = " + amount  + "WHERE USERID = " + userID;
		try
		{
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Balance not updated. Please try again.");
		}
		
	}
	
	
	
}
