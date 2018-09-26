package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dao.AdministratorDAO;
import com.revature.support.Administrator;
import com.revature.support.User;
import com.revature.util.ConnFactory;

public class AdministratorDAOImpl implements AdministratorDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

//	public void deleteUser(String uname) throws SQLException {
//		// TODO Auto-generated method stub
//		Connection conn = cf.getConnection();
//		String sql = "DELETE FROM ACCOUNT WHERE userid = ?";
//		String sql2 = "DELETE FROM ACCOUNTHHOLDER WHERE userid = ?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setInt(1, gone.getUid());
//		PreparedStatement ps2 = conn.prepareStatement(sql2);
//		ps2.setInt(1, gone.getUid());
//		ps.executeUpdate();
//		ps2.executeUpdate();
//		System.out.println();
//	}

	public void deleteAccount(User gone) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM ACCOUNT WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, gone.getUid());
		ps.executeUpdate();
		System.out.println("Account Deleted");
	}

	public void deleteAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		deleteAllAccounts();
		String sql = "DELETE FROM ACCOUNTHOLDER";
		Statement ps = conn.createStatement();
		ps.executeQuery(sql);
		System.out.println("It's all gone!");
	}

	public void deleteAllAccounts() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("TRUNCATE TABLE ACCOUNT");
		System.out.println("Accounts Deleted");
	}

	public Administrator adminLogin(String uname, String pass) throws SQLException {
		Connection conn = cf.getConnection();
		Administrator gw = null;
		String sql = "SELECT * FROM ADMINISTRATOR WHERE uname=? AND pass=?";
		PreparedStatement statement;
		statement = conn.prepareStatement(sql);

		statement.setString(1, uname); // set input parameter 1
		statement.setString(2, pass); // set input parameter 2
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			// fetch data from resultset
			gw = new Administrator(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		return gw;
	}

}
