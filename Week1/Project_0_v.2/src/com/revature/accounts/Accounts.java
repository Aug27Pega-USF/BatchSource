package com.revature.accounts;

import java.io.Serializable;

import com.revature.enums.AccountType;

public class Accounts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String name;
	//private double balance;
	//private boolean status;
	int id;
	AccountType accounttype= AccountType.Guest;
	//private String accountType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	@Override
	public String toString() {
		return "Accounts [username=" + username + ", password=" + password + ", name=" + name +
				 ", id=" + id + ", accounttype=" + accounttype + "]";
	}
	public AccountType getM() {
		return accounttype;
	}
	public void setM(AccountType m) {
		this.accounttype = m;
	}	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
		
}
