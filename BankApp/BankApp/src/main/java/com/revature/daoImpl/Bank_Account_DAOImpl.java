package com.revature.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Bank_Account;
import com.revature.dao.Bank_Account_Dao;

public class Bank_Account_DAOImpl implements Bank_Account_Dao {

	public void createAccount(int acctN, int uid, double saving, double checking) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public List<Bank_Account> getBank_AccountList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Bank_Account getBank_Account(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateBank_Account(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void removeBank_Account(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public double getSavingBalance(double saving) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCheckingBalance(double checking) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
