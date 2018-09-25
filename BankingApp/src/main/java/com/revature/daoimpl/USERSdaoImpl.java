package com.revature.daoimpl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Bank.Account;
import com.revature.Bank.AccountBalance;
import com.revature.Bank.ConnectFact;
import com.revature.Bank.MainBank;
import com.revature.beans.AccountLogin;
import com.revature.beans.USERS;
import com.revature.dao.USERSdao;



public class USERSdaoImpl implements USERSdao{
public static ConnectFact cf = ConnectFact.getInstance();
	public void createUSERS1(String USERName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTUSERS(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,USERName);
		call.execute();
		
	}

	public List<USERS> getUSERSList() throws SQLException {
		List<USERS> USERSList = 
				new ArrayList<USERS>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
		USERS s = null; 
		while(rs.next()) {
			s = new USERS(rs.getString(1), rs.getString(2)); //itterating rows and getting the ID with name 
			USERSList.add(s); // returns list
		}
		return USERSList;
	}

	public void createUSERS(USERS x) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO USERS VALUES (MYSEQ.NEXTVAL,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,x.getUSER_NAME());
		ps.setString(2, x.getUSER_PASSWORD());
		ps.execute(); 
		
	}
	
	public void getUser(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT (*) FROM USERS INNER JOIN ACCOUNT ON USERS.USER_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,id);
		//ps.setString(2, x.getUSER_PASSWORD());
		ps.execute(); 
	
	}

	public void createUSERS(String userName) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void getLoginList(AccountLogin y ) throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM USERS WHERE USER_NAME=? AND USER_PASSWORD=?"); //count(*) returns the # of rows found matching the where clause
		stmt.setString(1, y.getLoginUser());
		stmt.setString(2, y.getLoginPassword());
		ResultSet rs = stmt.executeQuery ();//the number of rows are returned to the resultset so if one is found 1 is in the result set
		
		
		
	if(rs.next() && rs.getInt(1)==1)//rs.next checks to see if the next row exists if it does it will return true and move to the next row. rs.getInt(1) getting an integer from the first column
	{
				System.out.println("Login Successfull!");
		}else {
			System.out.println("User not found!");
			MainBank.AccountOptions(); 
		}
	


	}

	
}
	

		
	


