package com.revature.JDBC;

import java.sql.SQLException;
import java.util.List;

public interface Registered_UserDAO {
	public abstract List<Registered_User> viewAccount() throws SQLException;
	public abstract List<Registered_User> deleteAccount() throws SQLException;
	public abstract List<Registered_User> withdrawDeposit() throws SQLException;
	public abstract void logout(String Username) throws SQLException;
	public abstract List<Registered_User> updateUser() throws SQLException;
	public abstract void createAccountCustomer(int Account_ID) throws SQLException;
	public abstract void createAccountAdmin(int Account_ID) throws SQLException;
}
