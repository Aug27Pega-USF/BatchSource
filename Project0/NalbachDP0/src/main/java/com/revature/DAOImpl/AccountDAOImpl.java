package com.revature.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Connection.ConnFactory;
import com.revature.dao.AccountDAO;
import com.revature.tables.Account;

public class AccountDAOImpl implements AccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createAccount(int accountID, String accountName, int userID, int accounttypeID, int currentBalance) throws SQLException {
		Connection conn =cf.getConnection();
		String sql = "{call INSERTACCOUNT (?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, accountName);
		call.setInt(2, userID);
		call.setInt(3, accounttypeID);
		call.setInt(4, currentBalance);
		call.execute();
	}
	
	public List<Account> getAccountlist() throws SQLException {
		List<Account> AccountList = 
				new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
		Account l = null;
		while(rs.next()) {
			l=new Account(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),rs.getInt(5));
			AccountList.add(l);
		}
		return AccountList;
	}

	public List<Account> getAccountList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
