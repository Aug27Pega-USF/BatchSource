package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.UserDAO;
import com.revature.models.User;

public class UserDAOImpl implements UserDAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// set up the connection to the database:
	private static String url = "jdbc:oracle:thin:@revaturepega.cgrij2uxx06e.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "DbAdmin";
	private static String password = "w33n13hut";

	@Override
	public void createUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call INSERTUSER(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			CallableStatement call;
			call = conn.prepareCall(sql);
			call.setString(1, u.getUsername());
			call.setString(2, u.getPassword());
			call.setString(3, u.getFirstname());
			call.setString(4, u.getLastname());
			call.setString(5, u.getStreet());
			call.setString(6, u.getCity());
			call.setString(7, u.getState());
			call.setString(8, u.getCountry());
			call.setInt(9, u.getZipcode());
			call.setString(10, u.getFavcolor());
			call.setString(11, u.getFavanimal());
			call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User selectUser(String uname, String upassword) {
		User u = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM SITEUSERS WHERE USERNAME = ? AND USERPASSWORD = ?");
			ps.setString(1, uname);
			ps.setString(2, upassword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getString(11), rs.getString(12));
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUserFavs(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call UPDATE_USER_FAVS(?, ?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, u.getUserid());
			call.setString(2, u.getFavcolor());
			call.setString(3, u.getFavanimal());
			call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserInfo(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call UPDATE_USER_INFO(?, ?, ?, ?, ?, ?, ?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, u.getUserid());
			call.setString(2, u.getFirstname());
			call.setString(3, u.getLastname());
			call.setString(4, u.getStreet());
			call.setString(5, u.getCity());
			call.setString(6, u.getState());
			call.setString(7, u.getCountry());
			call.setInt(8, u.getZipcode());
			call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserLogin(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call UPDATE_USER_LOGIN(?, ?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, u.getUserid());
			call.setString(2, u.getUsername());
			call.setString(3, u.getPassword());
			call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call DELETEUSER(?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, u.getUserid());
			call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
