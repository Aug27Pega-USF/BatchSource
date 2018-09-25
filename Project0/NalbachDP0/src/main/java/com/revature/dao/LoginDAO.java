package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.tables.Login;

public interface LoginDAO {
	public abstract void createLogin(String username, String password) throws SQLException;
	public abstract List<Login> getLoginList() throws SQLException;
}
