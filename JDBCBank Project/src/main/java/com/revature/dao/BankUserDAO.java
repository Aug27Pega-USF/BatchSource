package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Admin;
import com.revature.beans.Customer;

public interface BankUserDAO {
	//CRUD operations
		public abstract void createCustomer(String custName) throws SQLException;
		public abstract void deleteCustomer(String custName) throws SQLException;
		public abstract List<Customer> getCustomerList() throws SQLException;
	}
