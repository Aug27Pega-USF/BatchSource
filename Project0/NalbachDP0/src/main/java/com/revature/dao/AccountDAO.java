package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.tables.Account;

public interface AccountDAO {
	public abstract void createAccount(int accountID, String accountName, int userID, int accounttypeID, int currentBalance) throws SQLException;
	public abstract List<Account> getAccountList() throws SQLException;
}
