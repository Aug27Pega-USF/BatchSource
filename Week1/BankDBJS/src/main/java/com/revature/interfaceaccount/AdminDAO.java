package com.revature.interfaceaccount;

import java.sql.SQLException;
import java.util.List;

import com.revature.accounts.Admin;
import com.revature.accounts.Users;

public interface AdminDAO {

	public abstract List<Users> getUser() throws SQLException;
	public abstract void createUser(String name) throws SQLException;
	public abstract void deleteUser(int id) throws SQLException;
	public abstract void updateUser(int id) throws SQLException;
	//public abstract void checkAdminLogin(String name, String password) throws SQLException;
	public abstract List<Admin> checkAdminLogin(String name, String password) throws SQLException;
}
