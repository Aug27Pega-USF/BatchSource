package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	//creates a user
	public abstract void createUser(String userName, String pWord,
			String firstName, String lastName) throws SQLException;
	//Attempts to login, return 0 if no user, else BankUserID
	public abstract int login(String username, String pWord) throws SQLException;
	//Delete User (by Admins)
	public abstract void deleteUser(int userID) throws SQLException;
	//View User
	public abstract User viewUser(int userID) throws SQLException;
	//List Users
	public abstract List<User> getUserList() throws SQLException;
	//promoteToAdmin
	public abstract void promoteToAdmin(int userID) throws SQLException;
	
 	
}
