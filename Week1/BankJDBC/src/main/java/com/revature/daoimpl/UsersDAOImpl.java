package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.accounts.Users;
import com.revature.interfaceaccount.UserDAO;
import com.revature.util.ConnFactory;

public class UsersDAOImpl implements UserDAO {

	public static ConnFactory cf=  ConnFactory.getInstance();
	//Logger log= new Logger();
	@Override
	public void createUser(String fname, String lname, String uname, String pswrd) throws SQLException {
		Connection conn= cf.getConnection();
		String[] primaryKeys= new String[1];
		primaryKeys[0]= "User_Id";
		String sql= "INSERT INTO BANK_USERS VALUES(SQ_PK_BANK_USERS2.NEXTVAL,?,?,?,?)";
		
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, uname);
		ps.setString(4, pswrd);
		ps.executeUpdate();
		System.out.println("User Created");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public void createAccount(int uid, String name, double balance) throws SQLException {
		//Create check for invalid User IDs for accounts meaning account must have valid user IDS
		Connection conn= cf.getConnection();
		String[] primaryKeys= new String[1];
		primaryKeys[0]= "User_Id";
		String sql= "INSERT INTO USER_ACCOUNTS VALUES(SQ_PK_USER_ACCOUNTS2.NEXTVAL,?,?,?)";
		try {
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setInt(1, uid);
		ps.setString(2, name);
		ps.setDouble(3, balance);
		ps.executeUpdate();
		System.out.println("Account Created");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public int getUserID(String uname) throws SQLException {
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM BANK_USERS");
		int id=0;
		String name;
		while(rs.next())
		{
			name=rs.getString(4);
			if(name.equals(uname))
			{
				id=rs.getInt(1);
			}
			
		}				
		return id;
	}

	@Override
	public boolean checkUserLogin(String uname, String pswrd) throws SQLException {
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM BANK_USERS");
		boolean isTrue=false;
		while(rs.next())
		{
			if(uname.equals(rs.getString(4)) && pswrd.equals(rs.getString(5)))
			{
			isTrue=true;
			}
		}
		
		return isTrue;
	}

	@Override
	public Users getUser(int uid) throws SQLException {
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM BANK_USERS");
		Users u= null;
		while(rs.next())
		{
			if(rs.getInt(1)==uid)
			{
				u=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				
			}
			
		}				
		return u;
	}
	

	@Override
	public boolean checkName(String uname) throws SQLException {
		Connection conn= cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM BANK_USERS");
		boolean isTrue=false;
		while(rs.next())
		{
			if(rs.getString(4).equals(uname))
			{
				isTrue=true;
			}
		}
		
		return isTrue;
		
	}

	
}
