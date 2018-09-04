package com.revature.account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;


public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String fullName;
	private boolean activeAct;
	private String phone;
	private double balance;
	private String accountType;
	
	
/*	public void saveAccount(String username, String password, String fullName, boolean activeAct, String phone, double balance, String accountType,
			 String filepath) 
	{
		try 
		{
			FileWriter fw= new FileWriter(filepath, true);
			BufferedWriter bw= new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			
			pw.println(username+", "+password+", "+fullName+", "+activeAct+", "+phone+", "+balance+", "+accountType);
			pw.flush();
			pw.close();
			
			//JOptionPane.showMessageDialog(null, "Account Saved");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", fullName=" + fullName + ", activeAct="
				+ activeAct + ", phone=" + phone + ", balance=" + balance + ", accountType=" + accountType + "]";
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}
	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public boolean isActiveAct() {
		return activeAct;
	}
	public void setActiveAct(boolean activeAct) {
		this.activeAct = activeAct;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	public Account(String username, String password, String fullName, boolean activeAct, String phone, double balance,
			String accountType) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.activeAct = activeAct;
		this.phone = phone;
		this.balance = balance;
		this.accountType = accountType;
	}

}
