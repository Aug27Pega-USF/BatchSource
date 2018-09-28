package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Users;

public interface UsersDAO {
	public abstract void createUser(String username, String password, int admin) throws SQLException;
	public abstract List<Users> getUserList() throws SQLException;
	public abstract int isUserAdmin(int userID) throws SQLException;
	public abstract int userLogin(String username, String password) throws SQLException;
}
