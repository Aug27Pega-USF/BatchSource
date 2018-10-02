package com.revature.beans;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import com.revature.Serialize;

import com.revature.accounts.Account;

public class Admin extends Employee {
	
	private static Serialize serializer = new Serialize();
	private static final long serialVersionUID = 1L;

	/*Admin constructor*/
	public Admin(String firstName, String lastName, String username, String password, String social) {
		super(firstName, lastName, username, password, social);
		this.setStatus(User.Status.ADMIN);
	}
	
	/*Delete an account*/
	public void deleteAccount(HashMap<Integer, Customer> customerMap, File customerFile, Scanner keyboard) {
		System.out.println("Which account would you like to delete?");
		String choice = keyboard.nextLine();
		 while(!choice.matches("^\\d{8}$")) {
				System.out.println("Please pick a valid account number.\n*******************************");
				choice = keyboard.nextLine();
			  }
		 try {
			 Account account = theBank.findAccountByID(Integer.parseInt(choice), customerMap);
			 account.setStatus(Account.AccountStatus.CLOSED);
			 
		 } catch(NullPointerException e) {
			System.out.println("Account does not exist\n**********************");
		 }
		serializer.writeToFile(customerMap, customerFile);
	}
	
//	@Override
//	public String toString() {
//		return " Admin [IDNumber: " + getIDNumber() + " First Name: " + getFirstName() + " Last Name: " + getLastName() + " Username: " + getUsername() 
//		 + " Password: " + getPassword() + " SSN: " + getSocialNum() + "]\n";
//	}

}
