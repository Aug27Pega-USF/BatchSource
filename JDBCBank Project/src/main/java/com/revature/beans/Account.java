package com.revature.beans;

import java.io.Serializable;
import java.util.Arrays;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int accountid;
	private double balance;
	private String type;
	private int user;
	
	public Account(int account_id, String type, double balance, int user_id) {
		this.accountid = account_id;
		this.type = type;
		this.user= user_id;
		this.balance = balance;
	}
	
	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type= type;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user= user;
	}

	@Override
	public String toString() {
		return "Account [Account ID: " + accountid + ", balance = " + balance + ", type: " + type + ", user ID: " + user + "\n]";
	}
}