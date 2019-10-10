package com.sullivan.dao;

import java.sql.SQLException;
import java.util.List;

import com.sullivan.support.Account;
import com.sullivan.support.User;

public interface AccountDAO {
	public abstract void createNewAccount(User nu, double balance, String aname) throws SQLException;
	public abstract List<Account> getAllAccounts() throws SQLException;
	public abstract List<Account> getAllAccountsSingleUser(User nu) throws SQLException;
	public abstract void deleteEmptyAccounts(User u) throws SQLException;
	public abstract double withdrawFromAccount(User u, double w, String aname) throws SQLException;
	public abstract double depositIntoAccount(User u, double d, String aname) throws SQLException;
}
