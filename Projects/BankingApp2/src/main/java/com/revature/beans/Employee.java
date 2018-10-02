package com.revature.beans;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import com.revature.Serialize;
import com.revature.accounts.Account;

public class Employee extends User {

	//public static Bank theBank = new Bank();
 	private File customerFile = new File("BankCustomers.txt");
 	private Serialize serializer = new Serialize();
 	HashMap<Integer, Customer> customerMap = serializer.readFromFile(customerFile);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Employee(String firstName, String lastName, String username, String password, String social) {
		super(firstName, lastName, username, password, social);
		this.setStatus(User.Status.EMPLOYEE);
	}
	
	public void chooseCustomerToView(HashMap<Integer,Customer> customerMap, Scanner keyboard){
		Customer C;
		System.out.println("Enter the ID of the customer you would you like to view");
		String choice = keyboard.nextLine();
		 while(!choice.matches("\\d+")) { 
	  		   System.out.println("Must be a valid number. Try again.\n*******************************");
	  		   choice = keyboard.nextLine();
	  	   }
		 try {
			 C = theBank.findCustomerByID(Integer.parseInt(choice), customerMap);
			 theBank.printPersonalCustomerInfo(C);
		 } catch(NullPointerException e) {
			 System.out.println("There is no customer with that id number.\n*******************************");
		 }
		
	}
	
	public void approveOrDenyAccount(Scanner keyboard, HashMap<?,?> customerMap) {
		System.out.println("Enter the account number for the account you would like to approve or deny.");
		String choice = keyboard.nextLine();
		while(!choice.matches("\\d+")) { 
	  		   System.out.println("Must be a valid number. Try again.\n*******************************");
	  		   choice = keyboard.nextLine();
	  	   }
		try {
			Account account = theBank.findAccountByID(Integer.parseInt(choice), customerMap);
			System.out.println("Would you like to approve or deny the account?\n1)Approve\n2)Deny");
			choice = keyboard.nextLine();
			while(!choice.matches("\\d+")) { 
		  		   System.out.println("Must be a valid number. Try again.\n*******************************");
		  		   choice = keyboard.nextLine();
		  	   }
		if(Integer.parseInt(choice) == 1) {
			account.setStatus(Account.AccountStatus.OPEN);
		} else if (Integer.parseInt(choice) == 2) {
			account.setStatus(Account.AccountStatus.DENIED);
		} else {
			System.out.println("Not a valid option.\n*******************");
		}
			
		} catch (NullPointerException e) {
			System.out.println("Account does not exist\n*********************");
		}
		
		serializer.writeToFile(customerMap, customerFile);
	}


//	@Override
//	public String toString() {
//		return " Employee [IDNumber: " + getIDNumber() + " First Name: " + getFirstName() + " Last Name: " + getLastName() + " Username: " + getUsername() 
//		 + " Password: " + getPassword() + " SSN: " + getSocialNum() + "]\n";
//	}
	
	

}
