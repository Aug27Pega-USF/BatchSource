package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Users;

public interface AccountDAO {
	public abstract void createAccount(int userID, int balance) throws SQLException;
	public abstract void deleteAccount(int accountID) throws SQLException;
	public abstract List<Account> getAccountList(int accountID) throws SQLException;
	public abstract double deposit(int accountID, double input) throws SQLException;
	public abstract double withdraw(int accountID, double input) throws SQLException;
}
