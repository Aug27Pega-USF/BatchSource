package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.tables.Users;

public interface UsersDAO {
	public abstract void createUsers(int Ssn, String username, String password, String firstName,  String lastName, String phone,String address, String state, String country, String email) throws SQLException;
	public abstract List<Users> getUsersList() throws SQLException;
}
