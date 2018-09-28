package com.revature.beans;

public class Account {
	private int accountID;
	private int userID;
	private double balance;
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(int accountID, int userID, double balance) {
		super();
		this.accountID = accountID;
		this.userID = userID;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", userID=" + userID + ", balance=" + balance + "]";
	}
}
