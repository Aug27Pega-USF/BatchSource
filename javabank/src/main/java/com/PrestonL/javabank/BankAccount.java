package com.PrestonL.javabank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class BankAccount implements Serializable{

	private static final long serialVersionUID = -3997398158092734405L;
	private ArrayList<String> nameList;
	private double balance;
	private Date creation;
	private int accountid;
	boolean application=false;

	public BankAccount(int accountid) {
		super(); //this is called when registering to prevent repeat account id. 
		this.accountid=accountid;
		this.balance=0;
		nameList= new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		this.creation=(cal.getTime());
		application=true;
	}

	public BankAccount(String name, int accountid) {
		super();
		this.balance = 0;
		nameList= new ArrayList<String>();
		this.nameList.add(name);
		Calendar cal = Calendar.getInstance();
		this.creation=(cal.getTime());
		this.accountid=accountid;
	}

	public BankAccount(ArrayList<String> nameList, int accountid) {
		super();
		this.balance = 0;
		this.nameList = nameList;
		Calendar cal = Calendar.getInstance();
		this.creation=(cal.getTime());
		this.accountid=accountid;
	}

	public String toString() {
		String name = "("; 
		for (int i=0; i!=nameList.size(); i++) {
			name+=nameList.get(i);
			if (i!=nameList.size()-1) {
				name+=",";
			}
		}
		name+=")";
		String temp= "BankAccount "+ this.accountid +" [Owner(s)=" + name + ", balance= " + String.format("$%.2f", balance);
		if (application) {
			return temp +", Applied on= " + getCreationDate() + "]";
		}
		else
			return temp +", Account Opened= " + getCreationDate() + "]";
	}

	public String getCreationDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(creation);
	}

	public boolean isApplication() {
		return application;
	}

	public void approved() {
		this.application=false;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean deposit(double amount) {
		if (amount >= 0 && !(BigDecimal.valueOf(amount).scale() > 2)) {
			balance=balance+amount;
			System.out.println("Successful Deposit of "+ String.format("$%.2f", amount)+" into account " +accountid +".\nAccount " + accountid+ " current balance is " + String.format("$%.2f.", balance));
			return true;
		}
		System.out.println("Error. Attempt to deposit an invalid $ amount into account " + accountid+".");
		return false;
	}

	public boolean withdraw(double amount) {
		if (amount >= 0 && !(BigDecimal.valueOf(amount).scale() > 2) && amount<=balance ) {
			balance=balance-amount;
			System.out.println("Successful Withdrawal of "+ String.format("$%.2f", amount)+" from account " +accountid +".\nAccount " + accountid+ " current balance is " + String.format("$%.2f.", balance));
			return true;
		}
		if (amount>balance && !(BigDecimal.valueOf(amount).scale() > 2)) {
			System.out.println("Error. Attempt to withdraw a $ amount larger than the current balance of account " + accountid+ ".\nAccount "+ accountid+ " current balance is " + String.format("$%.2f.", balance));
			return false;
		}
		System.out.println("Error. Attempt to withdraw an invalid $ amount from account " + accountid +".");
		return false;
	}

	public ArrayList<String> getName() {
		return nameList;
	}

	public String getNameList() {
		String name = "("; 
		for (int i=0; i!=nameList.size(); i++) {
			name+=nameList.get(i);
			if (i!=nameList.size()-1) {
				name+=",";
			}
		}
		name+=")";
		return name;
	}

	public void addNameList(ArrayList<String> nameList) {
		for(int i=0;i!=nameList.size();i++) {
			this.nameList.add(nameList.get(i));
		}
	}
	public Date getCreation() {
		return creation;
	}

	public int getAccountid() {
		return accountid;
	}




}
