package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.support.User;

public interface UserDAO {
	public abstract void createUser(String fname, String lname, String uname, String pass) throws SQLException;	
	public abstract List<User> getAccountHolders() throws SQLException;
	public abstract User userLogin(String uname, String pass) throws SQLException;
}
