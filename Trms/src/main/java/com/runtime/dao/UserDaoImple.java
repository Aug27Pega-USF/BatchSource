package com.runtime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.runtime.bean.User;
import com.runtime.util.ConnFactory;

public class UserDaoImple implements UserDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public int insertUser(User user) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO USERS VALUES(SALES_ID_CREATE.NEXTVAL,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, user.getJobType());
		ps.setString(2, user.getJobPos());
		ps.setString(3, user.getReportsTo());
		ps.setString(4, user.getUserName());
		ps.setString(5, user.getPassWord());
		ps.setString(6, user.getFirstName());
		ps.setString(7, user.getLastName());
		ps.setString(8, user.getAddress());
		ps.setString(9, user.getEmail());
		ps.setString(10, user.getPhoneNum());

		return ps.executeUpdate();
	}

	@Override
	public List<User> getUserList() throws SQLException {
		List<User> getUsers = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
		User s = null;
		while (rs.next()) {

			s = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
					rs.getString(11));

			getUsers.add(s);

		}

		return getUsers;
	}

	@Override
	public int getUserById(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserById(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserById(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserByUsrPass(String username, String password) throws SQLException {
		User user = null;
		Connection conn = cf.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?");
		ps.setString(1, username);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
					rs.getString(11));
		}
		return user;
	}

}
