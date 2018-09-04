package com.revature.interfaces;
import com.revature.accounts.AbstractAccount.AccountStatus;

public interface Account {

	 public void deposit(double amount); 

	 public void withdraw(double amount);

	 public long getAccountNumber();
	 
	 public void setAccounttHolders(String ...accounttHolders);
	 
	 public AccountStatus getStatus();
	 
	 public void setStatus(AccountStatus status);
	 
	 public String[] getAccounttHolders();
	 
	 public void transfer(double amount,Account fromAccount, Account toAccount);

	public double getBalance();

	public void setBalance(double d);
}

