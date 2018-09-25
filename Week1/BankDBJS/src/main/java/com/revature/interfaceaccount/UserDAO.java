package com.revature.interfaceaccount;

import java.sql.SQLException;
import java.util.List;

import com.revature.accounts.Admin;
import com.revature.accounts.Users;



public interface UserDAO {

	public abstract void createUser(String name) throws SQLException;
	public abstract List<Users> getUser() throws SQLException;
}
