package com.revature.tables;

public class TransactionTypes {
	private int transactionTypeID;
	private String transactionName;
	public TransactionTypes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionTypes(int transactionTypeID, String transactionName) {
		super();
		this.transactionTypeID = transactionTypeID;
		this.transactionName = transactionName;
	}
	public int getTransactionTypeID() {
		return transactionTypeID;
	}
	public void setTransactionTypeID(int transactionTypeID) {
		this.transactionTypeID = transactionTypeID;
	}
	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	@Override
	public String toString() {
		return "transactionType [transactionTypeID=" + transactionTypeID + ", transactionName=" + transactionName + "]";
	}
}
