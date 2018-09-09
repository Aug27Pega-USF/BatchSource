package com.revature.accounts;
/**
 *@author Kevin Medara
 *
 * Holds all default implementation for account classes
 */

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public abstract class Account implements Accountable, Serializable {

	private static final long serialVersionUID = 1L;
	protected String[] accountHolders;
	protected double accountBalance;
	protected int accountNumber;
	private AccountStatus status;
	protected AccountType type;
	Random rand = new Random();
	
	public enum AccountStatus {
		OPEN,
		CLOSED,
		PENDING,
		DENIED
	}
	public enum AccountType {
		CHECKING,
		SAVINGS
	}
	
	protected Account(String ...accountHolders) {
		this.accountHolders = accountHolders;
		this.accountBalance = 0.0;
		this.accountNumber = rand.nextInt(90000000) + 1000000;// random 8 digit Account number
		this.status = AccountStatus.PENDING;
	}
	public String[] getaccountHolders() {
		return this.accountHolders;
	}
	public void setaccountHolders(String ...accountHolders) {
		this.accountHolders = accountHolders;
	}
	public double getBalance() {
		return this.accountBalance;
	}
	public void setBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
	public AccountStatus getStatus() {
		return this.status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	protected boolean isOpen() {
		if (this.getStatus().equals(Account.AccountStatus.OPEN)){
			return true;
		}
		return false;
	}
	@Override
	public void deposit(double amount) {
		if(!this.isOpen()){
			System.out.println("Account is not open for transactions.");
		} else if(amount <=0) {
			System.out.println("Invalid Amount");
			this.getLogger().error("DEPOSIT - FAILED - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+" AMOUNT: $"+amount);
		} else if (amount >= 0) {
			this.setBalance(this.getBalance() + amount);
			System.out.println(this.getAccountNumber());
			System.out.println("Amount Deposited");
			System.out.println("New Balance: " + this.getBalance());
			this.getLogger().info("DEPOSIT - SUCCESS - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+ " AMOUNT: $"+amount);
			
		}	
	}
	
	@Override
	public void withdraw(double amount) {
		if(!this.isOpen()){
			System.out.println("Account is not open for transactions.");
		}
		else if(amount <=0) {
			System.out.println("Invalid Amount");
			this.getLogger().error("DEPOSIT - FAILED - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+" AMOUNT: $"+amount);
		} else if((this.getBalance() - amount) < 0) {
			System.out.println("Not Enough Funds To Withdraw.");
			this.getLogger().error("WITHDRAWAL - FAILED - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+" AMOUNT: $"+amount);
		} else {
			this.setBalance(this.getBalance()-amount);
			System.out.println(this.getAccountNumber());
			System.out.println("Amount Withdrawn: " + amount);
			System.out.println("New Balance: " + this.getBalance());
			this.getLogger().info("WITHDRAWAL - SUCCESS - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+ " AMOUNT: $"+amount);
		}  
	}
	
	@Override
	public void transfer(double amount, Account fromAccount, Account toAccount) {
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);	
		this.getLogger().info("TRANSFER - FROM: "+fromAccount+" TO: "+toAccount+" AMOUNT: $"+amount);
	}
	@Override
	public String toString() {
		return this.getType()+" - Account Number: " +getAccountNumber()+  " - Balance: "
				+ getBalance() +" - Holders: " + Arrays.toString(accountHolders) + " - Status:" + getStatus();
	}
}
