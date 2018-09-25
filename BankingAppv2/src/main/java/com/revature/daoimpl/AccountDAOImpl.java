package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.support.Account;
import com.revature.support.Transactions;
import com.revature.support.User;
import com.revature.util.ConnFactory;

public class AccountDAOImpl implements AccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	/*Scanner scan = new Scanner(System.in);*/
	public void createNewAccount(User nu, double balance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO ACCOUNT VALUES (NULL, ?, ?)";
		// VALUES(userid, fname, lname, uname, pass)

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, nu.getUid());
		ps.setDouble(2, balance);
		ps.executeUpdate();
	}

	public List<Account> getAllAccounts() throws SQLException {
		List<Account> Accounts = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
		Account s = null;
		while (rs.next()) {
			s = new Account(rs.getInt(1),rs.getInt(2),rs.getDouble(3));
			Accounts.add(s);
		}
		return Accounts;
	}

	public List<Account> getAllAccountsSingleUser(User nu) throws SQLException {
		List<Account> Accounts = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM ACCOUNT WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, nu.getUid());
		//ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
		//ResultSet rs = ps.executeQuery(sql);
		ResultSet rs = ps.executeQuery();
		Account s = null;
		while (rs.next()) {
			s = new Account(rs.getInt(1),rs.getInt(2),rs.getDouble(3));
			Accounts.add(s);
		}
		return Accounts;
	}
	public void deleteEmptyAccounts(User u) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM ACCOUNT WHERE userid = ? AND bal = 0";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,u.getUid());
		ps.executeUpdate();
		System.out.println("Account Deleted");
	}

	public double withdrawFromAccount(User u, double w) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		Transactions t = new Transactions();
		List<Account> Accounts = getAllAccountsSingleUser(u);
		Account uact = Accounts.get(0);
		double new_bal = t.withdrawal(uact.getBal(), w);
		System.out.println("Preparing to withdraw $" + w + " from account");
		String sql = "UPDATE ACCOUNT SET bal = ? WHERE accid = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, new_bal);
		stmt.setInt(2,uact.getAid());
		stmt.executeUpdate();
		return new_bal;
	}

	public double depositIntoAccount(User u, double d) throws SQLException {
		Connection conn = cf.getConnection();
		Transactions t = new Transactions();
		List<Account> Accounts = getAllAccountsSingleUser(u);
		Account uact = Accounts.get(1);
		double new_bal = t.deposit(uact.getBal(), d);
		System.out.println("Preparing to deposit $" + d + " into account");
		String sql = "UPDATE ACCOUNT SET bal = ? WHERE accid = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, new_bal);
		stmt.setInt(2,uact.getAid());
		stmt.executeUpdate();
		return new_bal;
	}
}
