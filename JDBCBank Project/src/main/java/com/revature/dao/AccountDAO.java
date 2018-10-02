package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

public interface AccountDAO {
	public abstract void createAccount(String acctname, double amount, int user_id) throws SQLException;
	public abstract List<Account> getAccountList() throws SQLException;
	public abstract List<Account> getUserAccounts(int user_id) throws SQLException;
	public abstract void updateAccountBalance(int account_id, double amount) throws SQLException;
	public abstract void updateAccountUser(int account_id) throws SQLException;
	public abstract void deleteAccount(int account_id) throws SQLException;
}
