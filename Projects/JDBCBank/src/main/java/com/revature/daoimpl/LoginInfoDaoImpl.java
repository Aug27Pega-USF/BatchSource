package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.revature.beans.LoginInfo;
import com.revature.interfaces.Dao;
import com.revature.util.ConnectionFactory;

public class LoginInfoDaoImpl implements Dao<LoginInfo> {

	public static ConnectionFactory cf = ConnectionFactory.getInstance();

	@Override
	public <T> T get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoginInfo> getAll() {
		List<LoginInfo> l = new ArrayList<LoginInfo>();
		Connection conn = cf.getConnection();
		try {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM V_LOGIN_INFO");//Select from a view
		while(rs.next()) {
			LoginInfo lo = new LoginInfo(rs.getInt("USER_LOGIN_ID"), rs.getString("FIRSTNAME"),rs.getString("LASTNAME"),
					rs.getString("LOGIN_USERNAME"),rs.getString("LOGIN_PASSWORD"), rs.getString("ROLE_TYPE"));
			l.add(lo);
		}
		rs.close();
		stmt.close();
		conn.close();
		return l;
		} catch (SQLException e) {
			
		}
		return l;
	}

	@Override
	public boolean checkExistence(String col, String value) {
		Connection conn = cf.getConnection();
		Long i = 0L;
		ResultSet rs;
		String query = "Select COUNT(*) from LOGININFO where "+col+" = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, value);
				rs = ps.executeQuery();
				rs.next();
				i = rs.getLong(1);
				rs.close();
				conn.close();
				return (i > 0)? true:false ;
			}  catch (SQLException e) {
				e.printStackTrace();
				return true;
			}
	}

	@Override
	public void create(LoginInfo t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read(LoginInfo t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LoginInfo t, HashMap<String,String> params) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LoginInfo t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
