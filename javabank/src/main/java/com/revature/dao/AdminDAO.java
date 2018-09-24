package com.revature.dao;

import java.sql.SQLException;

import com.revature.exceptions.DuplicateUsernameException;

public interface AdminDAO {
	public void deleteUser(int user_id)  throws SQLException;
	public void updateUser(int user_id, String username, String password)  throws SQLException;
	public void viewUsers() throws SQLException;
	public boolean createUser(String username, String password) throws SQLException, DuplicateUsernameException;
	public int login(String username, String password) throws SQLException;
}
