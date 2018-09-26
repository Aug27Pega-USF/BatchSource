package com.revature.daoimp;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.revature.bean.Account;
import com.revature.dao.AccountDAO;
import com.revature.util.ConnFactory;

public class AccountDAOImp implements AccountDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	//Create an account and pushed to transactions
	public void createAccount(int userID, int typeID, double balance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO ACCOUNT VALUES (SQ_ACCT_ID.NEXTVAL,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt (1,userID);
		call.setInt (2,typeID);
		call.setDouble(3, balance);
		call.executeUpdate();
		int transType = 1;
		double transAmount= balance;
		int accountID=getLastAccount();
		TransactionDAOImp ct = new TransactionDAOImp();
		ct.createTransaction(accountID,transAmount,transType,balance);
		
	}
	
	//Gets all accounts based on userID
	public void getAccountList(int userID) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT ACCOUNT.ACCOUNTID AS ACCOUNT_NUM, ACCOUNT.USERID,"
													 + " ACCOUNT.BALANCE, ACCOUNTTYPE.TYPENAME FROM ACCOUNT INNER JOIN"
													 + " ACCOUNTTYPE ON ACCOUNT.TYPEID = ACCOUNTTYPE.TYPEID WHERE USERID=?");
		stmt.setInt(1,userID);
		ResultSet rs = stmt.executeQuery();	
		   ResultSetMetaData rsmd = rs.getMetaData();
		   System.out.println("The Account(s) information you requested is:");
		   int columnsNumber = rsmd.getColumnCount();
		while (rs.next()){
			for (int i = 1; i <= columnsNumber; i++)
			{
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print( rsmd.getColumnName(i)+ " " + columnValue);
		    }
			System.out.println();		
		}
		System.out.println("Hit any key to continue");
		try {
			System.in.read();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println();
	}
	//Gets a certain account based on account id and user id
	public void getCertainAccount(int accountID, int userID) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT ACCOUNT.ACCOUNTID AS ACCOUNT_NUM, ACCOUNT.USERID, ACCOUNT.BALANCE,"
														+ " ACCOUNTTYPE.TYPENAME AS TYPE_OF_ACCOUNT FROM ACCOUNT INNER JOIN ACCOUNTTYPE "
														+ "ON ACCOUNT.TYPEID = ACCOUNTTYPE.TYPEID WHERE ACCOUNTID =? AND USERID=?");
		stmt.setInt(1,accountID);
		stmt.setInt(2, userID);
		ResultSet rs = stmt.executeQuery();	
		   ResultSetMetaData rsmd = rs.getMetaData();
		   System.out.println("The Account information you requested is:");
		   int columnsNumber = rsmd.getColumnCount();
		while (rs.next()){
			for (int i = 1; i <= columnsNumber; i++)
			{
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print( rsmd.getColumnName(i)+ " " + columnValue);
		    }
			System.out.println();		
		}
		System.out.println("Hit any key to continue");
		try {
			System.in.read();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println();
	}

	//Deletes and account based on userid and account id
	public void deleteAccount(int accountID, int userID)throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select BALANCE from ACCOUNT where ACCOUNTID = ? AND USERID =?");
		stmt.setInt(1,accountID);
		stmt.setInt(2,userID);
		ResultSet rs = stmt.executeQuery();	
		if(rs.next()==false) {
			System.out.println("Something Went wrong please try again");
		}else {
				System.out.println("CheckingBalance");
				double balanceCheck = rs.getDouble(1);
				if(balanceCheck!=0) {
					System.out.println("You need to empty account before you can delete");
				}else {
				String sql = "CALL DELETE_ACCOUNT(?,?)";
				CallableStatement call = conn.prepareCall(sql);
				call.setInt (1,accountID);
				call.setInt(2, userID);
				call.executeUpdate();
				System.out.println("Account has been deleted ");
				System.out.println("Hit any key to continue");
				try {
					System.in.read();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				}
			}
	System.out.println();
	}

	//deposits into account number based on userid and creates a transaction for it
	public void depositUpdateAccount(int accountID, int userID,double balance)throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select BALANCE from ACCOUNT where ACCOUNTID = ? AND USERID =?");
		stmt.setInt(1,accountID);
		stmt.setInt(2,userID);
		ResultSet rs = stmt.executeQuery();	
			if(rs.next()==false) {
				System.out.println("Something Went wrong please try again");
			}else {
				
					System.out.println("CheckingBalance");
					double balanceCheck = rs.getDouble(1);
					double amount = balance;
					balance = balance + balanceCheck;
					String sql = "UPDATE ACCOUNT SET BALANCE= ? where ACCOUNTID = ? AND USERID = ?";
					CallableStatement call = conn.prepareCall(sql);
					call.setDouble (1,balance);
					call.setInt (2,accountID);
					call.setInt(3, userID);
					call.executeUpdate();
					int transType =1;
					TransactionDAOImp ct = new TransactionDAOImp();
					ct.createTransaction(accountID,amount,transType,balance);
					System.out.println("Balance has been update your new balance is: " + balance);
					System.out.println("Hit any key to continue");
					try {
						System.in.read();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}	
		System.out.println();
	}
	
	//checks balance before taking money away then pushing to transactions
	public void withdrawlUpdateAccount(int accountID, int userID,double balance)throws SQLException{
		
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select BALANCE from ACCOUNT where ACCOUNTID = ? AND USERID =?");
		stmt.setInt(1,accountID);
		stmt.setInt(2,userID);
		ResultSet rs = stmt.executeQuery();	

			if(rs.next()==false) {
				System.out.println("Something Went wrong please try again");
			}else {
				
					System.out.println("CheckingBalance");
					double balanceCheck = rs.getDouble(1);
					int greaterLess = Double.compare(balance, balanceCheck);
				    
				      if(greaterLess < 0) {
				    	  	double amount = balance;
				    	  	balance = (balanceCheck - balance);
							String sql = "UPDATE ACCOUNT SET BALANCE= ? where ACCOUNTID = ? AND USERID = ?";
							CallableStatement call = conn.prepareCall(sql);
							call.setDouble (1,balance);
							call.setInt (2,accountID);
							call.setInt(3, userID);
							call.executeUpdate();
							int transType =2;
							TransactionDAOImp ct = new TransactionDAOImp();
							ct.createTransaction(accountID,amount,transType,balance);
							System.out.println("Balance has been update your new balance is: " + balance);
							System.out.println("Hit any key to continue");
							try {
								System.in.read();
							}catch (IOException e1) {
								e1.printStackTrace();
							}
				      } else if(greaterLess > 0) {
				    	  System.out.println("You do not have enough funds to make that transaction");
				    	  System.out.println("balance is less than withdrawl amount");
				      } else {
				    	  	double amount = balance;
				    	  	balance = ( balanceCheck - balance);
							String sql = "UPDATE ACCOUNT SET BALANCE= ? where ACCOUNTID = ? AND USERID = ?";
							CallableStatement call = conn.prepareCall(sql);
							call.setDouble (1,balance);
							call.setInt (2,accountID);
							call.setInt(3, userID);
							call.executeUpdate();
							int transType =2;
							TransactionDAOImp ct = new TransactionDAOImp();
							ct.createTransaction(accountID,amount,transType,balance);
							System.out.println("Balance has been update your new balance is: " + balance);
							System.out.println("Hit any key to continue");
							try {
								System.in.read();
							}catch (IOException e1) {
								e1.printStackTrace();
							}
				      }

				}
			
		System.out.println();
		
	}

	//gets the last account entered into system
	public int getLastAccount()throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select ACCOUNTID from ACCOUNT where ACCOUNTID = ( select max(ACCOUNTID) from ACCOUNT )");
		ResultSet rs = stmt.executeQuery();
		int accountID = 0;
		while (rs.next()){
			 accountID = rs.getInt(1);
		}
		System.out.println(accountID);
		return accountID;
	}


}
