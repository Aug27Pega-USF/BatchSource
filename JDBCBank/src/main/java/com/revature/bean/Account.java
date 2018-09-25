package com.revature.bean;

public class Account {
	private int accountID;
	private int UserID;
	private int typeID;
	private double balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountID, int userID, int typeID, double balance) {
		super();
		this.accountID = accountID;
		UserID = userID;
		this.typeID = typeID;
		this.balance = balance;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", UserID=" + UserID + ", typeID=" + typeID + ", balance=" + balance
				+ ", statusID=" + "]";
	}
	

}
