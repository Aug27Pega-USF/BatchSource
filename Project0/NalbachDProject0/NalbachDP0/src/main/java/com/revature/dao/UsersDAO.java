package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.tables.Users;

public interface UsersDAO {
	public abstract void createUsers(String username, String password, String firstName,  String lastName) throws SQLException;
	public abstract List<Users> getUsersList() throws SQLException;
	public abstract int getLastUser() throws SQLException;
	public abstract int getLogin(String username, String password) throws SQLException;
	public abstract int getLevel(int userId) throws SQLException;
}
