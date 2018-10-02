package com.revature.beans;

public class BankAccount {
	private int accountID;
	private int balance;
	private int userID;
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int accountID, int balance, int userID) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.userID = userID;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "BankAccount [accountID=" + accountID + ", balance=" + balance + ", userID=" + userID + "]";
	}
	
}
