package com.revature.dao;

import java.sql.SQLException;

import com.revature.bean.Account;



public interface AccountDAO {
	public abstract void createAccount(int userID, int typeID, double balance)
					throws SQLException;
	public abstract void getAccountList(int userID) throws SQLException;
	public abstract int getLastAccount() throws SQLException;
	public abstract void getCertainAccount(int accountID, int userID) throws SQLException;
	public abstract void withdrawlUpdateAccount(int accountID, int userID,double balance) throws SQLException;
	public abstract void depositUpdateAccount(int accountID, int userID,double balance)throws SQLException;
	public abstract void deleteAccount(int accountID, int userID)throws SQLException;
}
