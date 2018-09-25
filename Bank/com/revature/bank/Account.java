package com.revature.bank;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1339765_1L;
	private String UserID;
	private Double balance;
	private int AccountID;
	private String name;
	//private String[] usernames = new String[2];
	//private boolean approved;
	public Account(String userID, Double balance, int accountID, String name) {
		super();
		UserID = userID;
		this.balance = balance;
		AccountID = accountID;
		this.name = name;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
/*	public Account(double balance, String name, String[] usernames, boolean approved) {
		this.balance = balance;
		this.name = name;
		this.usernames = usernames;
	}*/



}
