package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.User;

public interface BankAccountDAO {

	//create new account
	public abstract void createAccount(int userID) throws SQLException;
	//delete account
	public abstract void deleteAccount(int accountID) throws SQLException;
	//deposit
	public abstract void depositAccount(int accountID, int deposit) throws SQLException;
	//withdraw
	public abstract void withdrawAccount(int accountID, int withdraw) throws SQLException;
	//Admin update account
	public abstract void updateAccountBalance(int accountID, int balance) throws SQLException;
	//view Account
	public abstract void viewUser(int userID) throws SQLException;
	//list Accounts
	public abstract List<BankAccount> getAccountList() throws SQLException;
}
