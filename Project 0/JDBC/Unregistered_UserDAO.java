package com.revature.JDBC;

import java.sql.SQLException;

public interface Unregistered_UserDAO {
	public abstract void createCustomer(String Username, String Password) throws SQLException;
	public abstract void createAdmin(String Username, String Password) throws SQLException;
}
