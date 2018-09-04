package com.PrestonL.javabank;

import java.util.ArrayList;

public class Admin extends Employee {


	private static final long serialVersionUID = -6485895231141721735L;

	public Admin(String username, String password, String name) {
		super(username,password,name);
	}

	public void delete(int accountid, ArrayList<Customer> customerList, ArrayList<BankAccount> accountList) {
		for(int i=0; i!=customerList.size();i++) { //check all customers
			customerList.get(i).removeAccount(this, accountid); //remove all references to accountid.
		}
		for(int i=0; i<accountList.size();i++) {//remove reference to account id in bank account list.
			if(accountList.get(i).getAccountid()==accountid) {
				accountList.remove(i);
		}
		}
	}
	
	
	public String toString() {
		return "Bank Admin [username="+ super.getUsername() +", password="+super.getPassword()
				+ "]";
	}
	
	public String returnClass() {
		return "Admin";
	}
	
	
}
