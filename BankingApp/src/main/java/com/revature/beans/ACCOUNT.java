package com.revature.beans;

public class ACCOUNT {

	private double ACCOUNT_BALANCE;

	public ACCOUNT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ACCOUNT(double aCCOUNT_BALANCE) {
		super();
		ACCOUNT_BALANCE = aCCOUNT_BALANCE;
	}

	public double getACCOUNT_BALANCE() {
		return ACCOUNT_BALANCE;
	}

	public void setACCOUNT_BALANCE(double aCCOUNT_BALANCE) {
		ACCOUNT_BALANCE = aCCOUNT_BALANCE;
	}

	@Override
	public String toString() {
		return "ACCOUNT [ACCOUNT_BALANCE=" + ACCOUNT_BALANCE + "]";
	}

}
