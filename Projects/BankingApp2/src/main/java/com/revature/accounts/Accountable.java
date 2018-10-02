package com.revature.accounts;

import org.apache.logging.log4j.Logger;

public interface Accountable {

	public abstract Logger getLogger();
	public int getAccountNumber();
	public double getBalance();
	public void setBalance(double d);
	public String[] getaccountHolders();
	public void setaccountHolders(String ...accountHolders);
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(double amount,Account fromAccount, Account toAccount);
	

}
