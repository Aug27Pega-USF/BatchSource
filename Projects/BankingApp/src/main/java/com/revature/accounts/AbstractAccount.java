package com.revature.accounts;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

import org.apache.logging.log4j.Logger;

import com.revature.interfaces.Account;

/**
 * 
 * @author Kevin Medara
 * 
 * Represents an account within the bank
 *
 */
public abstract class AbstractAccount implements Account, Serializable {
	
	protected abstract Logger getLogger();
	private static final long serialVersionUID = 1L;
	protected String[] accounttHolders;
	protected double accountBalance;
	protected long accountNumber;
	public AccountStatus status;
	protected AccountType type;
	Random rand = new Random();
	public enum AccountStatus {
		OPEN,
		CLOSED,
		PENDING
	}
	public enum AccountType {
		CHECKING,
		SAVINGS
	}
	public AbstractAccount(String ...acctHolder) {
		super();
		this.accounttHolders = acctHolder;
		this.accountBalance = 0;
		this.accountNumber = rand.nextInt(90000000) + 1000000;// random 8 digit Account number
		this.status = AccountStatus.PENDING;
	}
	public double getBalance() {
		return accountBalance;
	}
	public void setBalance(double acctBalance) {
		this.accountBalance = acctBalance;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	
	public String[] getAccounttHolders() {
		return accounttHolders;
	}
	public void setAccounttHolders(String ...accounttHolders) {
		this.accounttHolders = accounttHolders;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
	public abstract void transfer(double amount, Account fromAccount, Account toAccount); 
	
	@Override
	public String toString() {
		return  type + ": acctHolders:" + Arrays.toString(accounttHolders) + ", Balance:" + accountBalance + ", Account Number:"
				+ accountNumber + ", status:" + status+"\n";
	}
}
