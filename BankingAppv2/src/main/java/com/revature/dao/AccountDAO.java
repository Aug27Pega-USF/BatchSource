package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.support.Account;
import com.revature.support.User;

public interface AccountDAO {
	public abstract void createNewAccount(User nu, double balance) throws SQLException;

	public abstract List<Account> getAllAccounts() throws SQLException;
	
	public abstract List<Account> getAllAccountsSingleUser(User nu) throws SQLException;
	public abstract void deleteEmptyAccounts(User u) throws SQLException;
	public abstract double withdrawFromAccount(User u, double w) throws SQLException;
	public abstract double depositIntoAccount(User u, double d) throws SQLException;
}
