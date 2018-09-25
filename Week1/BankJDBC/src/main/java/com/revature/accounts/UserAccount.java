package com.revature.accounts;

public class UserAccount {

	private int id;
	private int userId;
	private String accountName;
	private double balance;
	
	
	
	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", userId=" + userId + ", accountName=" + accountName + ", balance=" + balance
				+ "]";
	}

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public UserAccount(int id, int userId, String accountName, double balance) {
		super();
		this.id = id;
		this.userId = userId;
		this.accountName = accountName;
		this.balance = balance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}


