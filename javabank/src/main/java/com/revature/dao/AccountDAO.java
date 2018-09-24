package com.revature.dao;

import java.sql.SQLException;

import com.revature.exceptions.*;

public interface AccountDAO {
	public boolean deposit(double amount, int account_id, int user_id) throws SQLException, ImproperAmountException;
	public boolean withdraw(double amount, int account_id, int user_id) throws SQLException, ImproperAmountException;
	public void deleteAccount(int account_id, int user_id) throws SQLException, NotEmptyException;
	public void createAccount(int user_id) throws SQLException;
}
