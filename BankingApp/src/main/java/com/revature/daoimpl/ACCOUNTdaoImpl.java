package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Bank.ConnectFact;
import com.revature.beans.ACCOUNT;
import com.revature.dao.ACCOUNTdao;

public class ACCOUNTdaoImpl implements ACCOUNTdao {
	public static ConnectFact cf = ConnectFact.getInstance();
	public void createAB(String AccountBalance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTACCOUNT(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,AccountBalance);
		call.execute();
		
	}
	

	public List<ACCOUNT> getACCOUNTList() throws SQLException {
		List<ACCOUNT> ACCOUNTList = 
				new ArrayList<ACCOUNT>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
		ACCOUNT s = null; 
		while(rs.next()) {
			s = new ACCOUNT(rs.getDouble(1)); //itterating rows and getting the ID with name 
			ACCOUNTList.add(s); // returns list
		}
		return ACCOUNTList;

		}
	}


