package com.revature.DAO;

import java.sql.SQLException;
import java.util.List;

import com.revature.users.Customer;

public interface CustomerDAO {
	
	//hold customer info 
	public abstract List<Customer> getCustomerList() throws SQLException;
	//get customers by there ID
	public abstract void getCustomerID(int userID);
	//get them by user name
	public abstract void getCustomerUser(String userName) throws SQLException;	
	
}