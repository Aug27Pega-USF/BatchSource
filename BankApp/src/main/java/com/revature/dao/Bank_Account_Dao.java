package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Bank_Account;

public interface Bank_Account_Dao {
	//CRUD
	
	public abstract void createAccount(int acctN, int uid, double saving, double checking) throws SQLException;
	public abstract List<Bank_Account> getBank_AccountList() throws SQLException;
	public abstract Bank_Account getBank_Account(int id) throws SQLException;
	public abstract void updateBank_Account(int id) throws SQLException;
	public abstract void removeBank_Account(int id) throws SQLException;
	public abstract double getSavingBalance(double saving) throws SQLException;
	public abstract double getCheckingBalance(double checking) throws SQLException;


}
