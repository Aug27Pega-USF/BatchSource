package com.driver.accounts;


import java.util.ArrayList;
import java.util.Scanner;

import com.driver.func.Function;

public class Employee extends Account{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Employee(String user_name, String password, int id) {
		super(user_name, password, id);
	}



	/*
	 * Methods
	 * view all customer information (accounts, balances, personal information), manage accounts (approve/deny them), 
		log out 
	 */
	
	public void viewAllAccounts(ArrayList<Customer> customerList) {
		for(int i= 0; i < customerList.size(); i++) {
			System.out.println("***********************");
			System.out.println("Accounts for customer " + customerList.get(i).getUser_id());
			System.out.println("Customer Name: " + customerList.get(i).getUser_name());
			System.out.println("Customer Password: " + customerList.get(i).getPassword());
			customerList.get(i).viewAllAccounts(customerList);
		}
	}
	
	public void approveAccount(ArrayList<Customer> customerList, Scanner s) {
		//go through each customer
		for(int i = 0; i < customerList.size(); i++) {
			
			//go through each account now
			for(int j = 0; j < customerList.get(i).getAccount_name().size(); j++) {
				//check if an account needs approval
				if( !customerList.get(i).getAccount_status().get(j) ) {
					
					System.out.println("Customer \"" + customerList.get(i).getUser_name() 
										+ "\" account \"" + customerList.get(i).getAccount_name().get(j) 
										+ "\" needs approval.");
					
					//get whether approve or disapprove
					System.out.println("(1) - Approve");
					System.out.println("(2) - Deny");
					
					//get input
					String result = Function.GetMenuSelection(s, 2);
					//set status on approve
					if(result.equals("1")) {
						logTransaction("Account \"" + customerList.get(i).getAccount_name().get(j) 
								+ "\" approved!");
						customerList.get(i).getAccount_status().set(j, true);	
					}
					
					//delete account if disapproved
					else if(result.equals("2")) {
						logTransaction("Account \"" + customerList.get(i).getAccount_name().get(j) 
								+ "\" denied. Account removed.");
						customerList.get(i).getAccount_name().remove(j);
						customerList.get(i).getAccount_id().remove(j);
						customerList.get(i).getAccount_balance().remove(j);
						customerList.get(i).getAccount_status().remove(j);	
						
						customerList.get(i).setNumber_of_accounts(customerList.get(i).getNumber_of_accounts() - 1);
						
						j--; //push iterator back to keep going through this
					}
				}
			}
			
			//go through each join account now
			for(int j = 0; j < customerList.get(i).getJoint_account().size(); j++) {
				//check if an account needs approval
				if( !customerList.get(i).getJoint_status().get(j) ) {
					
					System.out.println("Customer \"" + customerList.get(i).getUser_name() 
										+ "\" joint account with user \"" 
										+ customerList.get(customerList.get(i).getJoint_user().get(j)).getUser_name() 
										+ "\"'s account \""+ customerList.get(customerList.get(i).getJoint_user().get(j)).getAccount_name().get(customerList.get(i).getJoint_account().get(j))
										+ "\" needs approval.");
					//get whether approve or disapprove
					System.out.println("(1) - Approve");
					System.out.println("(2) - Deny");
					
					//get input
					String result = Function.GetMenuSelection(s, 2);
					//set status on approve
					if(result.equals("1")) {
						logTransaction("Joint account \"" + customerList.get(i).getJoint_account().get(j) 
								+ "\" approved!");
						customerList.get(i).getJoint_status().set(j, true);

					}
					
					//delete account if disapproved
					else if(result.equals("2")) {
						logTransaction("Joint account \"" + customerList.get(i).getJoint_account().get(j) 
								+ "\" denied. Joint account removed.");
						customerList.get(i).getJoint_user().remove(j);
						customerList.get(i).getJoint_status().remove(j);
						customerList.get(i).getJoint_account().remove(j);	
						
						j--; //reverse iterator for next check
					}
				}
			}
			
		}
		//print message on finish
	}
}
