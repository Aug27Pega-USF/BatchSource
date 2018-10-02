package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Admin;
import com.revature.beans.Customer;

public interface BankUserDAO {
	//CRUD operations
		public abstract void createCustomer(String username, String password) throws SQLException;
		public abstract void createAdmin(String username, String password) throws SQLException;
		public abstract List<Customer> getCustomerList() throws SQLException;
		public abstract List<Admin> getAdminList() throws SQLException;
		public abstract void updateCustomer(int user_id) throws SQLException;
		public abstract void deleteCustomer(int user_id) throws SQLException;
		public abstract Customer checkCustomerLogin(String username, String password) throws SQLException;
		public abstract Admin checkAdminLogin(String username, String password) throws SQLException;
	}
