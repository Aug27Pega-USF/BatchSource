package com.revature.beans;

public class Bank_Account {
	private int bank_account_id;
	private int account_number;
	private int user_id;
	private double saving_balance;
	private double checking_balance;
	
	public Bank_Account() {}

	public Bank_Account(int bank_account_id, int account_number, int user_id, double saving_balance,
			double checking_balance) {
		super();
		this.bank_account_id = bank_account_id;
		this.account_number = account_number;
		this.user_id = user_id;
		this.saving_balance = saving_balance;
		this.checking_balance = checking_balance;
	}

	public int getBank_account_id() {
		return bank_account_id;
	}

	public void setBank_account_id(int bank_account_id) {
		this.bank_account_id = bank_account_id;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getSaving_balance() {
		return saving_balance;
	}

	public void setSaving_balance(double saving_balance) {
		this.saving_balance = saving_balance;
	}

	public double getChecking_balance() {
		return checking_balance;
	}

	public void setChecking_balance(double checking_balance) {
		this.checking_balance = checking_balance;
	}

public double depositToSaving(double amount) {
	this.saving_balance += amount;
	return this.saving_balance;
}	
public double depositTochecking(double amount) {
	this.checking_balance += amount;
	return this.checking_balance;
}	
public double withdrawFromSaving(double amount) {
	this.saving_balance -= amount;
	return this.saving_balance;
}
public double withdrawFromchecking(double amount) {
	this.checking_balance -= amount;
	return this.checking_balance;
}

	@Override

	public String toString() {
		return "bank_account_id=" + bank_account_id + ", account_number=" + account_number + ", user_id="
				+ user_id + ", saving_balance=" + saving_balance + ", checking_balance=" + checking_balance +"";
	}
	
	
	

}
