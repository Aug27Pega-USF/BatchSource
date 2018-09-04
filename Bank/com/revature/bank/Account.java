package com.revature.bank;

import java.io.Serializable;
import java.util.Arrays;

public class Account implements Serializable {
	private static final long serialVersionUID = 1339765_1L;
	private double balance;
	private String name;
	private String[] usernames = new String[2];
	private boolean approved;
	
	public Account(double balance, String name, String[] usernames, boolean approved) {
		this.balance = balance;
		this.name = name;
		this.usernames = usernames;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
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
				+ ", approved=" + approved + "]";
	}



}
