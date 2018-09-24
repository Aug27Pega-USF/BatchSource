package com.revature.dao;

import java.sql.SQLException;

public interface CustomerDAO {

	public void listAccounts(int user_id)  throws SQLException;
	public boolean registerAccount(String username, String password)  throws SQLException;
	public int login(String username, String password)  throws SQLException;
	public void viewTransactionHistory(int current_user) throws SQLException;
}

