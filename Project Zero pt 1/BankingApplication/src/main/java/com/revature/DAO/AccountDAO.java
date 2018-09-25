package com.revature.DAO;

import java.sql.SQLException;
import java.util.List;

import com.revature.account.Account;


public interface AccountDAO {

	//creates the accounts that will be held in the login table 
	public abstract void createLogin(String userName, String password) throws SQLException;
	
	//create account info
	public void addAccountInfo(int acc_num,int status,float bal) throws SQLException;
	
	public void deleteAccount(int acc_id);
	//get all the accounts that are made
	public List<Account> getAllAccounts();
	//approve pending accounts
	public void approveAccount();
	//for withdraw,deposit, and transfer
	public void doDeposit(double amount, int userID);
	
}
