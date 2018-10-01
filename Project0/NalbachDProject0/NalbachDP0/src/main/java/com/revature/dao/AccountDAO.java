package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.tables.Account;

public interface AccountDAO {
	public abstract void createAccount(String accountName, int userID, float balance) throws SQLException;
	public abstract List<Account> getAccountList() throws SQLException;
	public abstract void getCertainAccount(int accountId) throws SQLException;
	public abstract void getCertain2Account(int accountId, int userId) throws SQLException;
	public abstract int getLastAccount() throws SQLException;
}
