package com.revature.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.revature.Bank;
import com.revature.accounts.Account;
import com.revature.accounts.CheckingAccount;
import com.revature.accounts.SavingsAccount;

public class Customer extends User{


	private static final long serialVersionUID = 1L;
	public File accountFile = new File("Accounts.txt");
	private ArrayList<Account> customerAccounts;
	private static Bank theBank = new Bank();
	
	/*Constructor for creating user*/
	public Customer(String firstName, String lastName, String username, String password, String social) {
		this(firstName, lastName, username, password, social,  User.Status.CUSTOMER);
		
	}
	/*Called by first constructor*/
	public Customer(String firstName, String lastName, String username, String password, String social, Status customer) {
		super(firstName, lastName, username, password, social);
		this.customerAccounts = new ArrayList<Account>();
		this.status = User.Status.CUSTOMER;
		this.status = customer;
	}
	
	public ArrayList<Account> getCustomerAccounts() {
		return this.customerAccounts;
	}
	
	public void setCustomerAccounts(ArrayList<Account> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}
	
	public void applyForAccount(HashMap<Integer,Customer> customerMap, File customerFile, Scanner keyboard) {
	  Account account = null;
      System.out.println("What type of account would you like to apply for?\n1)Checking\n2)Savings");
  	  String choice = keyboard.nextLine();
  	  while(!choice.equals("1") && !choice.equals("2")){
  		System.out.println("Invalid Input. Expecting integer");
  		choice = keyboard.nextLine();
  	  }
		if(choice.equals("1")) {
			account = new CheckingAccount(this.getName());	
	    } else if (choice.equals("2")) {
			account = new SavingsAccount(this.getName());
	    }
		this.customerAccounts.add(account);
		customerMap.put(((Integer)this.getIDNumber()), this);
		customerMap.put(this.getIDNumber(), this);
		serializer.writeToFile(customerMap, customerFile);	
	}
	
	public void applyForJointAccount(HashMap<Integer,Customer> customerMap, File customerFile, Scanner keyboard) {
	  System.out.println("What type of joint account would you like to apply for?\n1)Checking\n2)Savings");
   	  String choice = keyboard.nextLine();
   	  while(!choice.equals("1") && !choice.equals("2")){
  		System.out.println("Invalid Input.");
  		choice = keyboard.nextLine();
  	  }
		Customer otherUser;
		System.out.println("Enter the customer ID of the joint account holder.");
		String i = keyboard.nextLine();
		while(!i.matches("^\\d{7}$") || Integer.parseInt(i) == this.getIDNumber()) {
			System.out.println("Please pick a valid user.");
			i = keyboard.nextLine();
		}
	    otherUser = theBank.findCustomerByID(Integer.parseInt(i), customerMap);
		Account account = null;
		if(choice.equals("1")) {
			account = new CheckingAccount(this.getName(), otherUser.getName());	
		} else if (choice.equals("2")) {
			account = new SavingsAccount(this.getName(), otherUser.getName());
		}
		this.getCustomerAccounts().add(account);
		((Customer)otherUser).getCustomerAccounts().add(account);
		customerMap.replace(this.getIDNumber(), this);
		customerMap.replace(otherUser.getIDNumber(), otherUser);
		serializer.writeToFile(customerMap, customerFile);	
	}
	
	@Override
	public String toString() {
		return " Customer [IDNumber: " + getIDNumber() + " First Name: " + getFirstName() + " Last Name: " + getLastName() + " Username: " + getUsername() 
		 + " Password: " + getPassword() + " SSN: " + getSocialNum() + " Accounts: " + getCustomerAccounts()+"\n";
	}
	


}
