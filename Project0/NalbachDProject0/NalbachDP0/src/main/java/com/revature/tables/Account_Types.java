package com.revature.tables;

public class Account_Types {
	private int Account_Type_Id;
	private String accountName;
	public Account_Types() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account_Types(int Account_Type_Id, String accountName) {
		super();
		this.Account_Type_Id = Account_Type_Id;
		this.accountName = accountName;
	}
	public int getAccount_Type_Id() {
		return Account_Type_Id;
	}
	public void setAccount_Type_Id(int Account_Type_Id) {
		this.Account_Type_Id = Account_Type_Id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	@Override
	public String toString() {
		return "Account_Types [Account_Type_Id=" + Account_Type_Id + ", accountName=" + accountName + "]";
	}
}
