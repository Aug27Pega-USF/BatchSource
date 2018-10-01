package com.revature.tables;

public class Account {
	private int accountNumber;
	private String accountName;
	private int userID;
	private float balance;
	public Account() { 
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountNumber, String accountName, int userID, float balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.userID = userID;
		this.balance = balance;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + 
				", balance=" + balance + ", userID=" + userID + "]";
	}
}

