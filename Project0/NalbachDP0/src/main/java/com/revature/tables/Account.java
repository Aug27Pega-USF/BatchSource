package com.revature.tables;

public class Account {
	private int accountID;
	private String accountName;
	private int userID;
	private int accounttypeID;
	private int currentBalance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountID, String accountName, int userID, int accounttypeID, int currentBalance) {
		super();
		this.accountID = accountID;
		this.accountName = accountName;
		this.userID = userID;
		this.accounttypeID = accounttypeID;
		this.currentBalance = currentBalance;
	}
	public int getaccountID() {
		return accountID;
	}
	public void setaccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
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
	public int getAccounttypeID() {
		return accounttypeID;
	}
	public void setAccounttypeID(int accounttypeID) {
		this.accounttypeID = accounttypeID;
	}
	public int getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
	@Override
	public String toString() {
		return "Account_Types [accountID=" + accountID + ", accountName=" + accountName + 
				", currentBalance=" + currentBalance + ", userID=" + userID + ", accounttypeID=" + accounttypeID +"]";
	}
}
