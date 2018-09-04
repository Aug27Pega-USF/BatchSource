package com.revature.accounts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.interfaces.Account;

public class SavingsAccount extends AbstractAccount {

	private static final Logger logger = LogManager.getLogger(SavingsAccount.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SavingsAccount(String ...acctHolder) {
		super(acctHolder);
		this.type = AbstractAccount.AccountType.SAVINGS;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
	@Override
	public void deposit(double amount) {
		if(amount >= 0) {
			this.setBalance(this.getBalance() + amount);
			System.out.println(this.getAccountNumber());
			System.out.println("Amount Deposited");
			System.out.println("New Balance: " + this.getBalance());
			this.getLogger().info("DEPOSIT - SUCCESS - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+ " AMOUNT: $"+amount);
		} else {
			System.out.println("Invalid Amount");
			this.getLogger().error("DEPOSIT - FAILED - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+" AMOUNT: $"+amount);
		}	
	}
	@Override
	public void withdraw(double amount) {
		if((this.accountBalance-amount >= 0)) {
		this.setBalance(this.getBalance() - amount);
		System.out.println(this.getAccountNumber());
		System.out.println("Amount Withdrawn: " +amount);
		System.out.println("New Balance: " + this.getBalance());
		this.getLogger().info("WITHDRAWAL - SUCCESS - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+ " AMOUNT: $"+amount);
		} else {
			System.out.println("Not Enough Funds To Withdraw.");
			this.getLogger().error("WITHDRAWAL - FAILED - ACCOUNT: "+this.getAccountNumber()+" TYPE: "+this.getType()+" AMOUNT: $"+amount);
		}
	}
	@Override
	public void transfer(double amount, Account fromAccount, Account toAccount) {
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);	
		this.getLogger().error("TRANSFER - FROM: "+fromAccount.getAccountNumber()+" TO: "+toAccount.getAccountNumber()+" AMOUNT: $"+amount);
	}
}
