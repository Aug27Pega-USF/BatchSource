package com.trf.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.trf.DAO.EmployeeDao;
import com.trf.beans.Employee;
import com.trf.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public List<Employee> selectBasicInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int login(String username, String password) {
		Connection conn = cf.getConnection();
		String sql = "SELECT LOGIN(?,?) FROM DUAL";
		try {
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, username);
			prest.setString(2, password);
			ResultSet rs = prest.executeQuery();
			rs.next();
			int account_id = rs.getInt(1);
			if (account_id != 0) {
				System.out.println("Succesfully logged in " + username + ".");
			}
			return account_id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getLevel(int employeeid) {
		Connection conn = cf.getConnection();
		String sql = "SELECT GET_EMP_LEVEL(?) FROM DUAL";
		try {
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setInt(1, employeeid);;
			ResultSet rs = prest.executeQuery();
			rs.next();
			String account_level = rs.getString(1);
			return account_level;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
