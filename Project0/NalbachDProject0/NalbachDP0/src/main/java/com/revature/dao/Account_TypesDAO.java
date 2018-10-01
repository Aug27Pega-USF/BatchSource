package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.tables.Account_Types;

public interface Account_TypesDAO {
	public abstract void createAccount_Types(String accountName) throws SQLException;
	public abstract List<Account_Types> getAccount_TypesList() throws SQLException;
}
