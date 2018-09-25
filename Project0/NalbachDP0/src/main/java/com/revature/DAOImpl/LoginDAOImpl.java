package com.revature.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Connection.ConnFactory;
import com.revature.dao.LoginDAO;
import com.revature.tables.Login;


public class LoginDAOImpl implements LoginDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createLogin(String username, String password) throws SQLException {
		Connection conn =cf.getConnection();
		String sql = "{call INSERTLOGIN (?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.execute();
	}
	
	public List<Login> getLoginlist() throws SQLException {
		List<Login> loginList = 
				new ArrayList<Login>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LOGIN");
		Login l = null;
		while(rs.next()) {
			l=new Login(rs.getInt(1), rs.getString(2), rs.getString(3));
			loginList.add(l);
		}
		return loginList;
	}

	public List<Login> getLoginList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
