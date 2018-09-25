package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Admin;
import com.revature.dao.Admin_Dao;
import com.revature.util.ConnFactory;

public class Admin_DAOImpl implements Admin_Dao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createAdmin(String auname, String apwd, String afN) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTADMIN_INFO(?,?,?)}";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, auname);
		pst.setString(2, apwd);
		pst.setString(3, afN);
		pst.execute();				
	}

	public List<Admin> getAdminList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin getAdminByUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		Admin admin = null;
		String sql = "SELECT * FROM ADMINI WHERE ADMIN_USERNAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int adid = rs.getInt(1);
			String pass = rs.getString(2);
			String uname = rs.getString(3);
			String aname = rs.getString(4);
			
			
			admin = new Admin(adid,pass,uname, aname);
		}
		
		return admin;
	}
	
}
