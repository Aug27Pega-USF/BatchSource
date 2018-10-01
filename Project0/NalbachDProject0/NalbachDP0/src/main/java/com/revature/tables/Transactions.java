package com.revature.tables;

public class Transactions {
	private int transactionID;
	private int accountNumber;
	private String transactionName;
	private float balance;
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions(int transactionID, int accountNumber, String transactionName, float balance) {
		super();
		this.transactionID = transactionID;
		this.accountNumber =accountNumber;
		this.transactionName = transactionName;
		this.balance = balance;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "transactionType [transactionID=" + transactionID +", accountNumber="+ accountNumber+ ", transactionName=" + transactionName + ", balance="+ balance+"]";
	}

}
