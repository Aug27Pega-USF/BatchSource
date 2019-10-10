package com.sullivan.dao;

import java.sql.SQLException;

import com.sullivan.support.Administrator;
import com.sullivan.support.User;

public interface AdministratorDAO {
	//public abstract void deleteUser(User gone) throws SQLException;

	public abstract void deleteAccount(User gone) throws SQLException;

	public abstract void deleteAllUsers() throws SQLException;

	public abstract void deleteAllAccounts() throws SQLException;
	
	public abstract Administrator adminLogin(String uname, String pass) throws SQLException;
}
