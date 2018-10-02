package com.revature.beans;
/**
 *@author Kevin Medara
 *
 * Holds all default implementation for account classes
 */

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Account {

	protected static final Logger logger = LogManager.getLogger("AccountLogger");
	protected List<?> holders;
	protected double balance;
	protected int id;
	protected String status;
	protected int statusID;
	protected int typeID;
	protected String type;
	protected Date dateCreate;
	//Random rand = new Random();
	
	
	/*when user opens account*/
	public Account() {
		this.status = "PENDING";
		this.statusID = 1;
		this.balance = 0.0;
		this.holders = new ArrayList<Integer>();
	}
	
	/*missing typeID and statusID, these are ambiguous to user*/
	public Account(int id, String status, String type, double balance, Date dateCreate, List<?> holders ) {
		this.id = id;
		this.status = status;
		this.type = type;
		this.balance = balance;
		this.dateCreate = dateCreate;
		this.holders = holders;
	}
	public List<?> getaccountHolders() {
		return this.holders;
	}
	public void setaccountHolders(List<?> accountHolders) {
		this.holders = accountHolders;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double accountBalance) {
		this.balance = accountBalance;
	}
	public int getAccountNumber() {
		return this.id;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<?> getHolders() {
		return holders;
	}

	public void setHolders(List<?> holders) {
		this.holders = holders;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	protected boolean isOpen() {
		if (this.getStatus().equalsIgnoreCase("open")){
			return true;
		}
		return false;
	}
	public Date getDateCreate() {
		return this.dateCreate;
	}
	public void setDateCreate(Date date) {
		// TODO Auto-generated method stub
		
	}
	public Logger getLogger() {
		return logger;
		
	}
	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

//	@Override
//	public void deposit(double amount) {
//		if(!this.isOpen()){
//			System.out.println("Account is not open for transactions.");
//		} else if(amount <=0) {
//			System.out.println("Invalid Amount");
//			this.getLogger().error("DEPOSIT - FAILED - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+" AMOUNT: $"+amount);
//		} else if (amount >= 0) {
//			this.setBalance(this.getBalance() + amount);
//			System.out.println(this.getAccountNumber());
//			System.out.println("Amount Deposited");
//			System.out.println("New Balance: " + this.getBalance());
//			this.getLogger().info("DEPOSIT - SUCCESS - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+ " AMOUNT: $"+amount);
//			
//		}	
//	}
	
//	@Override
//	public void withdraw(double amount) {
//		if(!this.isOpen()){
//			System.out.println("Account is not open for transactions.");
//		}
//		else if(amount <=0) {
//			System.out.println("Invalid Amount");
//			this.getLogger().error("DEPOSIT - FAILED - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+" AMOUNT: $"+amount);
//		} else if((this.getBalance() - amount) < 0) {
//			System.out.println("Not Enough Funds To Withdraw.");
//			this.getLogger().error("WITHDRAWAL - FAILED - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+" AMOUNT: $"+amount);
//		} else {
//			this.setBalance(this.getBalance()-amount);
//			System.out.println(this.getAccountNumber());
//			System.out.println("Amount Withdrawn: " + amount);
//			System.out.println("New Balance: " + this.getBalance());
//			this.getLogger().info("WITHDRAWAL - SUCCESS - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+ " AMOUNT: $"+amount);
//		}  
//	}
	
//	@Override
//	public void transfer(double amount, Account fromAccount, Account toAccount) {
//		fromAccount.withdraw(amount);
//		toAccount.deposit(amount);	
//		this.getLogger().info("TRANSFER - FROM: "+fromAccount+" TO: "+toAccount+" AMOUNT: $"+amount);
//	}
	@Override
	public String toString() {
		return this.getType()+/*" - Status: " + getStatus()+*/" - Account Number: " +getAccountNumber()+  " - Balance: "
				+ getBalance() +" - Holders: " + holders.toString(); 
	}
}
