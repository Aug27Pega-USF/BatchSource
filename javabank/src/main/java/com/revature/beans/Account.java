package com.revature.beans;

public class Account {
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	private double balance;
	private int account_id;
	private int user_id;
	
	public Account(int account_id, int user_id) {
		super();
		this.balance = 0;
		this.account_id = account_id;
		this.user_id = user_id;
	}	
	
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", account_id=" + account_id + ", user_id=" + user_id + "]";
	}
}
