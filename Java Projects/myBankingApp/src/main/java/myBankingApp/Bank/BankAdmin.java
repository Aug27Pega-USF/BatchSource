package myBankingApp.Bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAdmin extends Employee implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5742721659039529450L;
	
	// Parent class 'Employee' holds variables for: firstName, lastName, username, password
	// CONSTRUCTOR
	public BankAdmin(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
	}
	
	
	// Parent class includes Getters and Setters AND methods such as: viewCustomerInfo, manageOpenAppsForAccounts...
	// OTHER METHODS
	public boolean cancelAccount(Scanner SC, ArrayList<Customer>customerList) {
		
		// find customer
		// find account we want to close
		// close it.
		System.out.println("You are trying to CANCEL a customer account. Let's find the customer first!");
		System.out.println("Please enter the first name of the customer ");
		String fN = SC.nextLine();
		System.out.println("Please enter the last name of the customer ");
		String lN = SC.nextLine();
		
		Customer customer = getCustomer(fN,lN,customerList);
		if(customer == null)
			return false;
		if(!customer.showAccounts())
			return false;
		System.out.println("Please enter the account you would like to cancel ");
		String accToCancel = SC.nextLine();
		
		Account A = customer.findAccount(accToCancel);
		
		if(A == null)
			return false;
		
		A.changeStatusToCLOSED();
		
		return true;
	}
	
	public boolean withdraw(Scanner SC, ArrayList<Customer>customerList) {
		// find customer
		// find specific account
		// try withdrawing value
		System.out.println("You are trying to WITHDRAW from customer account. Let's find the customer!");
		System.out.println("Please enter the first name of the customer ");
		String fN = SC.nextLine();
		System.out.println("Please enter the last name of the customer ");
		String lN = SC.nextLine();
		
		Customer customer = getCustomer(fN,lN,customerList);
		if(customer == null)
			return false;
		return customer.withdraw(SC);
	}
	
	public boolean deposit(Scanner SC, ArrayList<Customer>customerList) {
		// find customer,
		// find specific account
		// try depositing value
		
		System.out.println("You are trying to DEPOSIT to customer account. Let's find the customer!");
		System.out.println("Please enter the first name of the customer. ");
		String fN = SC.nextLine();
		System.out.println("Please enter the last name of the customer. ");
		String lN = SC.nextLine();
		
		Customer customer = getCustomer(fN,lN,customerList);
		if(customer == null)
			return false;
		return customer.deposit(SC);
	}
	
	public boolean transfer(Scanner SC, ArrayList<Customer>customerList) {
		// find customer
		System.out.println("You are trying to TRANSFER to customer account. Let's find the customer!");
		System.out.println("Please enter the first name of the customer. ");
		String fN = SC.nextLine();
		System.out.println("Please enter the last name of the customer. ");
		String lN = SC.nextLine();
		
		Customer customer = getCustomer(fN,lN,customerList);
		if(customer == null)
			return false;
		return customer.transfer(SC);
	}
		
	
	// SEARCH METHODS
	public Customer getCustomer(String fName, String lName, int customerID, ArrayList<Customer>customerList) {
		for(Customer C:customerList) {
			if(C.getFirstName().equals(fName) && C.getLastName().equals(lName) && C.getCustomerID() == customerID)
				return C;
		}
		return null;
	}
	public Customer getCustomer(String fName, String lName, ArrayList<Customer>customerList) {
		for(Customer C:customerList) {
			if(C.getFirstName().equals(fName) && C.getLastName().equals(lName)) 
				return C;
		}
		return null;
	}
	public Customer getCustomer(int customerID, ArrayList<Customer>customerList) {
		for(Customer C:customerList) {
			if(C.getCustomerID() == customerID )
				return C;
		}
		return null;
	}
	
}
