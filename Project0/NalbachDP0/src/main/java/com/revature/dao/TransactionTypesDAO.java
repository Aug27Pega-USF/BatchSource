package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.tables.TransactionTypes;

public interface TransactionTypesDAO {
	public abstract void createtransactionTypes(String transactionName) throws SQLException;
	public abstract List<TransactionTypes> getTransactionTypesList() throws SQLException;
}
