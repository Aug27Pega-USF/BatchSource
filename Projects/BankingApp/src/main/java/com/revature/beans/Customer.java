package com.revature.beans;
/**
 * @author Kevin Medara
 * 
 * Represents a bank customer
 */
import java.util.ArrayList;

import com.revature.accounts.AbstractAccount;

public class Customer extends BankUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<AbstractAccount> customerAccounts;
 	
	public Customer(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
		this.customerAccounts = null;
		this.status = BankUser.Status.CUSTOMER;
	}
	
	public ArrayList<AbstractAccount> getCustomerAccounts() {
		return customerAccounts;
	}
	public void setCustomerAccounts(ArrayList<AbstractAccount> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}

	@Override
	public String toString() {
		return "Customer Name: " + firstName+" " + lastName
				+ ", username: " + username +  ", password: " + password + ", IDNumber: " + IDNumber
				+ "\n Accounts: " + customerAccounts;
	}
	
	
}
