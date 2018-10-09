package com.runtime.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.runtime.bean.User;

public class UserDaoImple implements UserDao {
	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}
	private static String url = "jdbc:oracle:thin:@aug27pega.c6dt4deskvoq.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String usr = "BenCoAdmin";
	private static String pss = "IaminTheMoney";

	@Override
	public int insertUser(User user) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, usr, pss)) {

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO USERS VALUES(ID_CREATE.NEXTVAL,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, user.getJobType());
			ps.setString(2, user.getReportsTo());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassWord());
			ps.setString(5, user.getFirstName());
			ps.setString(6, user.getLastName());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getEmail());
			ps.setString(9, user.getPhoneNum());

			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> getUserList() throws SQLException {
		List<User> getUsers = new ArrayList<User>();
		try (Connection conn = DriverManager.getConnection(url, usr, pss)) {

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
			User s = null;
			while (rs.next()) {

				s = new User(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

				getUsers.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
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

		try (Connection conn = DriverManager.getConnection(url, usr, pss)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME=? AND PSSWORD=?");
			ps.setString(1, username);
			ps.setString(2, password);
	        
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
