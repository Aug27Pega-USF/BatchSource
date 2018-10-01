package com.revature.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Connection.ConnFactory;
import com.revature.dao.Account_TypesDAO;
import com.revature.tables.Account_Types;

public class Account_TypesDAOImpl implements Account_TypesDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createAccount_Types(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql= "{call INSERTACCOUNT_TYPES(?)";
		CallableStatement call= conn.prepareCall(sql);
		call.setString(1,username);
		call.execute();
	}

	public List<Account_Types> getAccount_TypesList() throws SQLException {
		List<Account_Types> Account_TypesList = 
				new ArrayList<Account_Types>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT_TYPES");
		Account_Types s = null;
		while(rs.next()) {
			s=new Account_Types(rs.getInt(1),rs.getString(2));
			Account_TypesList.add(s);
		}
		return Account_TypesList;
	}
}
