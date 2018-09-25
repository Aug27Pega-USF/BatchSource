package com.revature.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.CustomerDAO;
import com.revature.users.Customer;
import com.revature.util.ConnFactory;

public class CustomerDaoImpl implements CustomerDAO 
{
	public String userName;
	public String password;

	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn= cf.getConnection();
	Statement stmt;
	
	public void createCustomer(String userName, String password) throws SQLException
	{
		String [] primaryKeys =new String[1];
		primaryKeys[0]= "userID";
		String sql = "INSERT INTO LOGIN VALUES (USERID.NEXTVAL, ?)";
		
		PreparedStatement ps = 
				conn.prepareStatement(sql,primaryKeys);
		ps.setString(1,userName);
		ps.executeUpdate();
		
	}

	public void getCustomerID(int userID) 
	{
		
		try(Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER WHERE USERID = " + userID);
			rs.next();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
	}

	public void getCustomerUser(String userName) throws SQLException 
	{
		
		
	}

	public List<Customer> getCustomerList() throws SQLException 
	{
		List<Customer> customerList=
				new ArrayList <Customer>();
				stmt = conn.createStatement();
		ResultSet rs = 
				stmt.executeQuery("SELECT * FROM CUSTOMER");
		Customer s=null;
		while(rs.next()) 
		{
			s = new Customer(rs.getString(1),rs.getString(2), 0, customerList);
			customerList.add(s);
		}
		return customerList;
	}
}


