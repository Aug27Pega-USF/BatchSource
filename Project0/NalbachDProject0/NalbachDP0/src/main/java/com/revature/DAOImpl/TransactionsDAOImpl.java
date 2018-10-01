package com.revature.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Connection.ConnFactory;
import com.revature.dao.TransactionsDAO;
import com.revature.tables.Account;
import com.revature.tables.Transactions;
import com.revature.tables.Users;

public class TransactionsDAOImpl implements TransactionsDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createTransactions(int accountNumber, String transactionName, float balance) throws SQLException {
		Connection conn = cf.getConnection();
		//java.sql.SQLException: Invalid column index
		String sql= "{call INSERTTRANSACTIONS(?,?,?)";
		CallableStatement call= conn.prepareCall(sql);
		call.setInt(1,accountNumber);
		call.setString(2, transactionName);
		call.setFloat(3,balance);
		call.execute();
	}

	public List<Transactions> getTransactionsList() throws SQLException {
		List<Transactions> TransactionsList = 
				new ArrayList<Transactions>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSACTIONS");
		Transactions s = null;
		while(rs.next()) {
			s=new Transactions(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4));
			TransactionsList.add(s);
		}
		return TransactionsList;
	}
	ArrayList<Users> users = new ArrayList<Users>();
	
	public void addCustomer(Users users) {
		users.add(users);	
	}

	Users getUsers(int account) {
		return users.get(account);
	}
	ArrayList<Users> getUsers(){
		return users;
	}

}
