package com.revature.interfaceaccount;

import java.sql.SQLException;
import java.util.List;

import com.revature.accounts.UserAccount;

public interface UserAccountsDAO {

	public String findUserInfo(int uid)throws SQLException;
	
	public String findAccountInfo(int uid, int actId)throws SQLException;
	
	public List<UserAccount> getAccountList(int uid) throws SQLException;
		
	public Double accountBalance(int actId)throws SQLException;
	
	public void withdrawBalance(int actId, double amount)throws SQLException;
	
	public void depositToBalance(int actId, double amount)throws SQLException;
	
	public abstract void deleteAccountIfEmpty(int actId);
	
	
}
