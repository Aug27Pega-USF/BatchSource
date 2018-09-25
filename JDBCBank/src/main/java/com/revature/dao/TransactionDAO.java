package com.revature.dao;

import java.sql.SQLException;

import com.revature.bean.Transaction;


public interface TransactionDAO {
	public abstract void createTransaction(int accountID, double transactionAmount,int typeID, double endingBalance)
			throws SQLException;
	public abstract void getTransactionList(int accountID) throws SQLException;
}
