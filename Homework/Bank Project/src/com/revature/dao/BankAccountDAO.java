package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;

public interface BankAccountDAO {

	//create new account
	public abstract void createAccount(int userID) throws SQLException;
	//delete account
	public abstract void deleteAccount(int accountID) throws SQLException;
	//deposit
	public abstract void depositAccount(int accountID, double deposit) throws SQLException;
	//withdraw
	public abstract void withdrawAccount(int accountID, double withdraw) throws SQLException;
	//Admin update account
	public abstract void updateAccountBalance(int accountID, double balance) throws SQLException;
	//view Account
	public abstract BankAccount viewAccount(int accountID) throws SQLException;
	//list Accounts
	public abstract List<BankAccount> getAccountList() throws SQLException;
}
