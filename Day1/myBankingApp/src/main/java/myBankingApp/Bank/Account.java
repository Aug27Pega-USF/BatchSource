package myBankingApp.Bank;

import java.util.*;
import java.io.Serializable;
//import java.lang.Throwable;

enum Status {
	PENDING, ACTIVE, CLOSED
}


public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2351591086812727556L;
	
	private BankLogger bankLogger = new BankLogger();
	
	private ArrayList<String> accountHolders;
	private String accountType;
	private int accountNumber;
	private float balance;
	private boolean overDrawn;	
	private Status stat;
	
	// CONSTRUCTOR WITH PARAMETERS
	// This constructor may be called when a list of more-than-one owner is available to start an account...
	public Account(ArrayList<String> accountHolders, String accountType, int accountNumber) {
		super();
		this.accountHolders = accountHolders;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.balance = 0.00f;
		this.overDrawn = false;
		this.stat = Status.PENDING;
	}
	// This constructor may be called when a only ONE person is trying to start an account...
	public Account(String accountOwner, String accountType, int accountNumber) {
		super();
		this.accountHolders = new ArrayList<String>();
		this.accountHolders.add(accountOwner);
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.balance = 0.00f;
		this.overDrawn = false;
		this.stat = Status.PENDING;
	}
	
	// OTHER METHODS!
	public boolean deposit(float value) {

		// Make sure the Account is actually ACTIVE
		if(this.stat != Status.ACTIVE) {
			System.out.println("ERROR - The account has NOT yet been approved.  FAILURE to deposit from account: "
			+ this.accountType);
			return false;
		}
		// Handles user attempt to depositing negative amount
		if(value < 0.00f) {
			System.out.println("Error - You are trying to deposit a negative value from account: "+ this.accountType
		+ "Please try again.");
			return false;
		}
		else {
			// TODO  - IMPLEMENT LOG!
			this.balance += value;
			System.out.println("You have successfully DEPOSITED to account '" +this.accountType +"':		$" + value);
			System.out.println("Your current balance is in this account is:		$" + this.balance);
			bankLogger.loggerLevel("You have successfully DEPOSITED from account '" +this.accountType + "':		$" + value);
			bankLogger.loggerLevel("Your current balance in this account is:		$" + this.balance);
			if(this.overDrawn)
				this.overDrawn = false;
			return true;
		}
	}
	
	public boolean withdraw(float value) {
		// Make sure the Account is actually ACTIVE
		if(this.stat != Status.ACTIVE) {
			System.out.println("ERROR - The account has NOT yet been approved. FAILURE to withdraw from account: " 
		+ this.accountType);
			return false;
		}
		
		if(value < 0.00f) {
			System.out.println("ERROR - You are trying to withdraw a negative value from account: "+ this.accountType 
					+" Please try again. ");
			return false;
		}
		else
		if (value  == this.balance ){
			// TODO  - IMPLEMENT LOG!
			this.balance = 0.00f;
			System.out.println("WARNING - The balance is now zero in account: " + this.accountType);
			
			bankLogger.loggerLevel("You have successfully WITHDRAWN from account '" +this.accountType + "':		$" + value);
			bankLogger.loggerLevel("Your current balance in this account is:		$" + this.balance);
			return true;
		}
		else
		if (value > this.balance) {
			// TODO  - IMPLEMENT LOG!
			System.out.println("ERROR - The amount you are trying to withdraw is greater than what is available in account: "
			+ this.accountType);
			System.out.println("Please try again. ");
			// this.overDrawn = true;	// implement this only if overdrawing (with fees) is available
			return false;
		}
		else 
		if (value < this.balance ) {
			// TODO  - IMPLEMENT LOG!
			this.balance -= value;
			System.out.println("You have successfully WITHDRAWN from account '" +this.accountType + "':		$" + value);
			System.out.println("Your current balance in this account is:		$" + this.balance);
			
			bankLogger.loggerLevel("You have successfully WITHDRAWN from account '" +this.accountType + "':		$" + value);
			bankLogger.loggerLevel("Your current balance in this account is:		$" + this.balance);

			return true;
		}
		
		System.out.println("ERROR - Unexpected error within account 'withdraw' function. Account: "+ this.accountType);
		return false;	
	}
	
	public boolean transfer(float value, Account toAccount) {
		
		if(this.withdraw(value)) {
			if(toAccount.deposit(value)) {
				System.out.println("Transfer FROM: " + this.accountType + " TO: " + toAccount.accountType + " was SUCCESSFUL.");
				System.out.println("Current balance in '" + this.accountType +"' is:		$" + 
				this.getBalance());
				System.out.println("Current balance in '" + toAccount.accountType +"' is:		$" + 
						toAccount.getBalance());
				
				bankLogger.loggerLevel("The following TRANSFER will take place:");
				
				return true;
			}
			this.deposit(value);
			return false;
		}
		System.out.println("ERROR - Transfer FROM: " + this.accountType + " TO: " + toAccount.accountType + " has FAILED.");
		return false;
	}
	
	public boolean addAccountHolder(String S) {
		
		// Make sure the Account is actually ACTIVE
		if(this.stat != Status.ACTIVE) {
			System.out.println("ERROR - This account has NOT yet been approved. FAILURE to add account holder. ");
			return false;
		}
		
		// Add account holder name if the holder is not already in the accountHolder list
		if(!this.accountHolders.contains(S)) {
			System.out.println("You have successfully ADDED account holder '" + S + " to this account.");
			// Add account holder to list
			this.accountHolders.add(S);
			return true;
		}
		else
		if(this.accountHolders.contains(S)) {
			System.out.println("ERROR - Cannot add account holder. The account holder '" + S + " is already an account holder.");
		}
		else
			System.out.println("ERROR - Unexpected error attempting to add '" + S + " as an account holder of this account.");
		return false;
	}
	
	public boolean changeStatusToACTIVE() {
		this.stat = Status.ACTIVE;
		return true;
	}
	
	public boolean changeStatusToCLOSED() {
		this.stat = Status.CLOSED;
		return true;
	}
	
	public boolean changeStatusToPENDING() {
		this.stat = Status.PENDING;
		return true;
	}
	
	// GETTERS AND SETTERS
	public ArrayList<String> getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(ArrayList<String> accountHolders) {
		this.accountHolders = accountHolders;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public boolean isOverDrawing() {
		return overDrawn;
	}

	public void setOverDrawing(boolean overDrawing) {
		this.overDrawn = overDrawing;
	}
	
	public boolean isOverDrawn() {
		return overDrawn;
	}
	
	public void setOverDrawn(boolean overDrawn) {
		this.overDrawn = overDrawn;
	}
	
	public Status getStat() {
		return stat;
	}
	
	public void setStat(Status stat) {
		this.stat = stat;
	}
	
	@Override
	public String toString() {
		return "Account [accountHolders=" + accountHolders + ", accountType=" + accountType + ", accountNumber="
				+ accountNumber + ", balance=" + balance + ", overDrawn=" + overDrawn + ", accountStatus= " + stat + "]\n";
	}
	
	
	
	
	
}
