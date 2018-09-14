package myBankingApp.Bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Customer implements Serializable {		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8072197864683471251L;
	
	// PROPERTIES
	private ArrayList<Account> accounts;
	private String firstName;
	private String lastName;
	private String fullName;
	private String username;
	private String password;
	private long customerID;
		
	// CONSTRUCTOR
	public Customer(String firstName, String lastName, String username, String password, long customerID) {
		super();
		// Customer is initialized WITHOUT ANY ACCOUNTS
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = (firstName + ":" + lastName);
		this.username = username;
		this.password = password;
		this.customerID = customerID;
		this.accounts = new ArrayList<Account>();
	}
	
// Maybe think of implementing age, DOB, customerID, userName, 


	// OTHER METHODS
	public Account applyForAccount(Scanner SC, ArrayList<Account>openApps, ArrayList<Long>acctIDList) {
		
		System.out.println(this.firstName + " " + this.lastName +", you are now attempting to APPLY FOR AN ACCOUNT.");
		System.out.println("Please enter:\n '1' if you would like to APPLY for a Checking account.");
		System.out.println(" '2' if you would like to APPLY for a Savings account.");
		System.out.println(" 'Q' if you would like to exit.");
		
		String s = SC.nextLine();
		if(s.length() == 1) {
			if(s.equals("Q"))
				return null;
			try {
			int x = Integer.valueOf(s);
			switch(x) {
				case 1:
					if(findAccount("Checking") == null) {	// If the account doesn't already exist, make a new one
						String t = this.firstName + ":" + this.lastName;
						long tempAcctID = genRandomIDNum(acctIDList);
						acctIDList.add(tempAcctID);
						Account A = new Account(t, "Checking", tempAcctID);
						// Account added to customer's account list but it has a PENDING status
						this.accounts.add(A);
						// Account added to list of open applications waiting for employee/bankAdmin approval
						openApps.add(A);
						System.out.println("Congratulations! You have just applied for a CHECKING account.");
						System.out.println("Your account number is: " + A.getAccountNumber() + "\n");
						System.out.println(A);
						return A;
					}
					else
						System.out.println("ERROR - Sorry, but you already have an account of this type.");
					break;
				case 2:
					if(findAccount("Savings") == null) {	// If the account doesn't already exist, make a new one
						String t = this.firstName + ":" + this.lastName;
						// Generate new accountID number that hasn't been used before
						long tempAcctID = genRandomIDNum(acctIDList);
						acctIDList.add(tempAcctID);
						Account A = new Account(t, "Savings", tempAcctID);
						// Account added to customer's account list but it has a PENDING status
						this.accounts.add(A);
						// Account added to list of open applications waiting for employee/bankAdmin approval
						openApps.add(A);
						System.out.println("Congratulations! You have just applied for a SAVINGS account.");
						System.out.println("Your account number is: " + A.getAccountNumber() + "\n");
						System.out.println(A);
						return A;
					}
					else
						System.out.println("ERROR - Sorry, but you already have an account of this type.");
					break;
				default:
					System.out.println("ERROR - Your input was invalid. Please try again");
					System.out.println();		
					break;
			  	}
			} catch (NumberFormatException e) {
				System.out.println("ERROR - Your input was invalid. Please try again");
				System.out.println();		
			}
		}
		System.out.println("ERROR - Your input was invalid. Please try again");
		System.out.println();
		return null;
	}
	
	public boolean applyForJointAccount(Scanner SC, ArrayList<Account>openApps, ArrayList<Long>acctIDList, Customer C2) {
		// get names to apply for account. // call addAccountHolder
		// get second customer info
		// make sure she is in the system as a customer ? maybe pass in this 2nd customer's object.
		Account A = applyForAccount(SC, openApps, acctIDList);
		if(A != null) {
			A.addAccountHolder(C2.fullName);
			C2.accounts.add(A); // Add same account (account reference) to customer2's account list.
			return true;
		}
		return false;
	}
	
	public boolean viewAccountStatus(Scanner SC) {
		// get appropriate account
		if(showAccounts()) {
			System.out.println("Which account's STATUS would you like to see?");
			String st = SC.nextLine();
			Account A = findAccount(st);
			if(A != null) {															// getStat returns enum type
				System.out.println("Account STATUS of '" + A.getAccountType() + "' is : " + A.getStat() );	
			}
			else
				return false;
		}
		return false;
	}
	
	public boolean withdraw(Scanner SC) {
		if(showAccounts()) {
			System.out.println("Which account would you like to WITHDRAW from?");
			String x = SC.nextLine();
			Account A = findAccount(x);
			if(A != null) {
				System.out.println("How much would you like to WITHDRAW?");
				float y = Float.valueOf(SC.nextLine());
				if(A.withdraw(y))
					return true;
				else 
					return false;
			}
			else
				return false;
		}
		return false;
	}
	
	public boolean deposit(Scanner SC) {
		// float value
		if(showAccounts()) {
			System.out.println("Which account would you like to DEPOSIT to?");
			String x = SC.nextLine();
			Account A = findAccount(x);
			if(A != null) {
				System.out.println("How much would you like to DEPOSIT?");
				float y = Float.valueOf(SC.nextLine());
				if(A.deposit(y))
					return true;
				else 
					return false;
			}
			else
				return false;
		}
		return false;
	}
	
	public boolean transfer(Scanner SC) {
		//float value, String fromAccountType, String toAccountType
		if(showAccounts()) {
			System.out.println("Which account would you like to TRANSFER from?");
			String f = SC.nextLine();
			
			// find and get hold of fromAccount if it exists
			Account fromAccount = findAccount(f);
			if(fromAccount == null) 
				return false;
			
			// find and get hold of toAccount if it exists
			System.out.println("Which account would you like to TRANSFER to?");
			String to = SC.nextLine();
			Account toAccount = findAccount(to);
			if(toAccount == null)
				return false;
			// Make sure that we aren't transferring to the same account
			if(fromAccount == toAccount) {
				System.out.println("ERROR - You cannot transfer to the same account you transfer from!");
				return false;
			}
			// Find out how much we should transfer
			System.out.println("How much would you like to TRANSFER?");
			
			float value = Float.valueOf(SC.nextLine());
			// Perform transfer
			fromAccount.transfer(value, toAccount);
			return true;		
		}

		return false;
	}
	
	
	
	
	// OTHER METHODS
	public static long genRandomIDNum(ArrayList<Long>IDList) {
		Random rand = new Random(); 
		long value1;
		long value2;
		long value;
		while(true) {
			value1 = rand.nextInt(100000000);
	        value2 = rand.nextInt(100000000);
	        value = value1 * value2;
	        // check if it already exists
	        if(!IDList.contains(value))
	        	break;
		}
        return value;
	}
	
	
	
	
	public Account findAccount(String S) {
		if(accounts.isEmpty()) {
			System.out.println("Sorry but you have no active accounts.\n");
			return null;
		}
		for(Account A: accounts) {
			if(A.getAccountType().equals(S))
				return A;
		}
		// returns null if account is not found!
		return null;
	}
	public boolean showAccounts() {
		if(accounts.isEmpty()) {
			System.out.println("Sorry but you have no active accounts.\n");
			return false;
		}
		for(Account A: accounts) {
			System.out.println(A.getAccountType() + ":		$" + String.format("%.2f", A.getBalance()));
		}
		return true;
	}
	
	// GETTERS AND SETTERS
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", fullName="
				+ fullName + ", userName=" + username + ", password=" + password + ", customerID=" + customerID + "\n" +
				", accounts=" + accounts +  "]\n";
	}

	
	
	
	
}
