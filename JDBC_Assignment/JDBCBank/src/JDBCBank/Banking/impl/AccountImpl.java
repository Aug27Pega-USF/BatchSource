package JDBCBank.Banking.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import JDBCBank.Banking.accounts.Account;
import JDBCBank.Banking.dao.AccountDAO;
import JDBCBank.Banking.util.ConnFact;

public class AccountImpl implements AccountDAO{

	public static ConnFact f = new ConnFact();
	
	public void create(String accountname, int userid) throws SQLException {
		Connection c = f.getConnection(); //set up connection
		String sql = "{ call INSERT_BANK_ACCOUNT(?, ?)"; //sql statement to pass in
		CallableStatement call = c.prepareCall(sql); //call object storing the statement 
		call.setString(1, accountname); //conversion for SQL
		call.setInt(2, userid); //conversion for SQL
		call.execute(); //call the statement
	}

	public ArrayList<Account> read() throws SQLException {
		ArrayList<Account> accountList = new ArrayList<Account>();
		
		Connection c = f.getConnection();
		Statement stmt = c.createStatement(); //gets compiled on the sql side
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANK_ACCOUNT");
		Account s = null;
		
		//adds each entry back to a list
		while(rs.next()) {
			s = new Account(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)); //with SQL we don't start at 0
			accountList.add(s);
		}
		
		return accountList;
	}
	
	public Account readOne(String account_name, int current_user_id) throws SQLException {

		Connection c = f.getConnection();
		Statement stmt = c.createStatement(); //gets compiled on the sql side
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE ACCOUNT_NAME = '" + account_name + "' AND USER_ID = " + current_user_id; //sql statement to pass in
		ResultSet rs = stmt.executeQuery(sql);
		Account a = null;
		
		//adds each entry back to a list
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)); //with SQL we don't start at 0
		}
		
		return a;
	}

	
	public void update(int accountid, int balance) throws SQLException {
		Connection c = f.getConnection(); //set up connection
		String sql = "{ call UPDATE_BANK_ACCOUNT(?, ?)"; //sql statement to pass in
		CallableStatement call = c.prepareCall(sql); //call object storing the statement 
		call.setInt(1, accountid); //conversion for SQL
		call.setInt(2, balance); //conversion for SQL
		call.execute(); //call the statement
	}

	public void delete(int accountid) throws SQLException {
		Connection c = f.getConnection(); //set up connection
		String sql = "{ call REMOVE_BANK_ACCOUNT(?)"; //sql statement to pass in
		CallableStatement call = c.prepareCall(sql); //call object storing the statement 
		call.setInt(1, accountid); //conversion for SQL
		call.execute(); //call the statement
	}

	
}
