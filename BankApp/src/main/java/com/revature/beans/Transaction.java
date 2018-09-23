package com.revature.beans;

import java.util.Date;

public abstract class Transaction {
	protected int bankId;
	protected int userid;
	//private Bank_Account_DaoImpl;
	
	public abstract void performTransaction();

	public Transaction(int bankId, int userid) {
		super();
		this.bankId = bankId;
		this.userid = userid;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
