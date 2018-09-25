package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.support.User;
import com.revature.util.ConnFactory;

public class UserDAOImpl implements UserDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn = cf.getConnection();

	// VALUES(userid, fname, lname, uname, pass)
	public void createUser(String fname, String lname, String uname, String pass) throws SQLException {
		// TODO Auto-generated method stub
		// Connection conn = cf.getConnection();
		String sql = "INSERT INTO ACCOUNTHOLDER VALUES (NULL, ?, ?, ?, ?)";
		// VALUES(userid, fname, lname, uname, pass)

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, uname);
		ps.setString(4, pass);
		ps.executeUpdate();
		/*
		 * call.setString(uname, pass, fname, lname); call.execute();
		 */
	}

	public List<User> getAccountHolders() throws SQLException {
		List<User> AccountHolders = new ArrayList<User>();
		// Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTHOLDER");
		User s = null;
		while (rs.next()) {
			s = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			AccountHolders.add(s);
		}
		return AccountHolders;
	}

	public User userLogin(String uname, String pass) throws SQLException{
		User gw = null;
		String sql = "SELECT * FROM ACCOUNTHOLDER WHERE uname=? AND pass=?";
		PreparedStatement statement;
		statement = conn.prepareStatement(sql);

		statement.setString(1, uname); // set input parameter 1
		statement.setString(2, pass); // set input parameter 2
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			// fetch data from resultset
			gw = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		return gw;
	}
}
