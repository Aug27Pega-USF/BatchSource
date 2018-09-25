package com.revature.bean;

public class Transaction {
	private int transactionID;
	private int accountID;
	private int typeID;
	private double transactionAmount;
	private double endingBalance;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transactionID, int accountID, int typeID, double transactionAmount, double endingBalance) {
		super();
		this.transactionID = transactionID;
		this.accountID = accountID;
		this.typeID = typeID;
		this.transactionAmount = transactionAmount;
		this.endingBalance = endingBalance;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public double getEndingBalance() {
		return endingBalance;
	}
	public void setEndingBalance(double endingBalance) {
		this.endingBalance = endingBalance;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", accountID=" + accountID + ", typeID=" + typeID
				+ ", transactionAmount=" + transactionAmount + ", endingBalance=" + endingBalance + "]";
	}
	
	

}
