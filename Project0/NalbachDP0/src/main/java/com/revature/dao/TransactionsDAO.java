package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.tables.Transactions;

public interface TransactionsDAO {
	public abstract void createTransactions(int accountNumber, String transactionName, float balance) throws SQLException;
	public abstract List<Transactions> getTransactionsList() throws SQLException;
}
