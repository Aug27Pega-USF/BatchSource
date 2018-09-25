package com.revature.BanksAreGreat.Ihopethisworks;

public class Customer {

	private String firstName;
	private String lastName;
	private String ssn;
	private Account account;

	public Customer(String firstName, String lastName, String ssn, Account account) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.account = account;
	}
	
	public String toString() {
		return "\nCustomer Information\n"+ 
				"First Name: "+ firstName+ "\n"+
				"Last Name: "+ lastName+ "\n"+
				"SSN: " + ssn + "\n"+
				account;
				
	}
	public String basicInfo() {
		return "First Name: "+ firstName+ 
				" Last Name: "+ lastName+ 
				" SSN" + ssn +
				" Account number:"+ account.getAccountNumber();
				
	}
	
	Account getAccount() {
		return account;
	}
}
