package com.revature.beans;

import java.io.Serializable;
import java.util.Arrays;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private double balance;
	private String name;
	private String[] usernames = new String[2];
	
	public Account(double balance, String name, String[] usernames) {
		this.balance = balance;
		this.name = name;
		this.usernames = usernames;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getUsernames() {
		return usernames;
	}

	public void setUsernames(String[] usernames) {
		this.usernames = usernames;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", name=" + name + ", usernames=" + Arrays.toString(usernames)
				+ "]";
	}
}