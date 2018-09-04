package com.driver.accounts;

import java.util.ArrayList;
import java.util.Scanner;

import com.driver.func.Function;
import com.driver.transactions.Transaction;



public class Customer extends Account implements Transaction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/*
	 * Fields
	 */
	//for tracking how many users ever made were
	//for id tracking purposes
	private static int total_users;
	
	
	//for tracking how many accounts ever made were
	//for id tracking purposes
	private static int total_accounts;
	//account info
	
	private int number_of_accounts;
	private ArrayList<Integer> account_id = new ArrayList<Integer>();
	private ArrayList<String> account_name = new ArrayList<String>();
	private ArrayList<Integer> account_balance = new ArrayList<Integer>();
	private ArrayList<Boolean> account_status = new ArrayList<Boolean>();
	
	private ArrayList<Integer> joint_user = new ArrayList<Integer>();
	private ArrayList<Integer> joint_account = new ArrayList<Integer>();
	private ArrayList<Boolean> joint_status = new ArrayList<Boolean>();
	
	
	

	/*
	 * Constructor
	 */
	public Customer(String user_name, String password, int id) {
		super(user_name, password, id);
		//set the id so it's unique
		setUser_id(id);
		Customer.total_users++;
	}
	
	/*
	 * Methods
	 * apply for an account, apply to join account
		withdraw,deposit,transfer funds
		log out
	 */
	public void applyForAccount(Scanner s) {
		//type the name of the account you would like to apply for
		String new_account_name = "";
		boolean valid = false;
		
		System.out.println("Please type the name of your new account: ");
		
		while(!valid) {
			new_account_name = s.next();
			
			//compare name to any existing accounts
			boolean name_exists = false;
			for(String str: account_name) {
				if(str.equals(new_account_name))
					name_exists = true;
			}
			
			if (name_exists)
				System.out.println("Account name already exists - please make a new name");
			else
				valid = true;
		}
		
		account_id.add(total_accounts);
		total_accounts++;
		account_name.add(new_account_name);
		account_balance.add(0); //set balance to $0
		account_status.add(false); //unapproved
		
		number_of_accounts++;
		
		//thank you, waiting for employee approval
		logTransaction("Thank you! Waiting for employee approval on account \"" + new_account_name + "\"");
		System.out.println();
	}
	
	
	
	public void applyForJointAccount (ArrayList<Customer> customerList, Scanner s) {
		//type the user that you would like to join accounts with
		System.out.println("Type name of the user to join accounts with: ");
		String joint_user_name = s.next();
		
		//check that user isn't themself
		if( !getUser_name().equals(joint_user_name)) {
			
			//check that the user exists
			int joint_index = -1;
			for(int i= 0; i < customerList.size() && joint_index == -1; i++) {
				if (customerList.get(i).getUser_name().equals(joint_user_name)) {
					joint_index = i;
				}
			}
			
			if(joint_index != -1) {
				
				//select account to apply to
				System.out.println("Accounts available for \"" + customerList.get(joint_index).getUser_name() + "\"");
				System.out.println("Select account: ");
				
				int acc_num = customerList.get(joint_index).selectAccounts(customerList, s);
				
				//see that the account is approved
				if( customerList.get(joint_index).getAccount_status().get(acc_num)) {
					//check that we're not already joined to it
					boolean valid = true;
					for(int i = 0; i < joint_user.size(); i++) {
						//check if it's the same username
						if(joint_user.get(i) == customerList.get(joint_index).getUser_id()) {
							//check if it's the same account name
							for(int j = 0; j < joint_account.size(); j++) {
								if(joint_account.get(j) == customerList.get(joint_index).getAccount_id().get(acc_num) )
									valid = false;
							}
						}
					}
					
					//create a new joint access with status set to "unapproved"
					if(valid) {
						//add the index of the user we're joining
						joint_user.add(joint_index);
						//add the index of the account we're joining
						joint_account.add(acc_num);
						//set the status of the joint account
						joint_status.add(false);
						
						//thank you, waiting for employee approval
						logTransaction("Thank you! Waiting for employee approval on joint account \"" + customerList.get(joint_index).getAccount_name().get(acc_num) + "\"");
						System.out.println();
					}
					//no good
					else
						System.out.println("Account is already joined.");
				}
				
				else
					System.out.println("This account isn't approved yet");
			}
			
			else 
				System.out.println("User not found.");
			
		}
		else
			System.out.println("Cannot create a joint account with yourself.");
		
	}
	
	public void viewAllAccounts(ArrayList<Customer> customerList) {
		System.out.println();
		System.out.println("Viewing all account info:");
		
		if(account_name.size() == 0 && joint_user.size() == 0)
			System.out.println("No accounts on file!");
		else {
			//print standard accounts
			for(int i = 0; i < account_name.size(); i++) {
				
				System.out.println("	Account ID: " + account_id.get(i) + "");
				System.out.println("	Account Name: \"" + account_name.get(i) + "\"");
				System.out.println("	Current Balance: $" + account_balance.get(i));
				
				String status = "Unapproved";
				if(account_status.get(i))
					status = "Approved";
				System.out.println("	Current Status: " + status);
				System.out.println("*******************************");
			}
			
			//print joint accounts
			System.out.println("Joint Accounts:");
			System.out.println();
			
			for(int i = 0; i < joint_user.size(); i++) {
				
				System.out.println("	Joint User Name: \"" + customerList.get(joint_user.get(i)).getUser_name() + "\"");
				System.out.println("	Joint Account Name: \"" + customerList.get(joint_user.get(i)).getAccount_name().get(joint_account.get(i)) + "\"");
				System.out.println("	Current Balance: $" + customerList.get(joint_user.get(i)).getAccount_balance().get(joint_account.get(i)));
				
				String status = "Unapproved";
				if(joint_status.get(i))
					status = "Approved";
				System.out.println("	Current Status: " + status);
				System.out.println("*******************************");
			}
		}
		
		System.out.println();
	}
	
	
	/*
	 * WITHDRAWALS
	 */
	public void withdrawFunds(ArrayList<Customer> customerList, Scanner s) {

		if( getAccount_name().size() == 0 && getJoint_user().size() == 0)
			System.out.println("No accounts on file!");
		else {
			
			//account type selection
			System.out.println("Would you like to draw from a personal, or a joint account?");
			System.out.println("(1) - Personal Account");
			System.out.println("(2) - Joint Account");
			
			String result = Function.GetMenuSelection(s, 2);
			
			if(result.equals("1"))
				withdrawFundsPersonal(customerList, s);
			else if(result.equals("2"))	
				withdrawFundsJoint(customerList, s);
		}
		System.out.println();
	}
	
	public void withdrawFundsPersonal(ArrayList<Customer> customerList, Scanner s) {
		if( getAccount_name().size() > 0) {
			//which account would you like to with funds from?
			System.out.println("Which account would you like to withdraw funds from?");
			
			//select a number
			int acc_num = selectAccounts(customerList, s);
			
			//check if that account is approved
			if(getAccount_status().get(acc_num)) {
				//check if that account has a >0 balance
				if(getAccount_balance().get(acc_num) > 0) {
					
					System.out.println("How much would you like to withdraw: ");
					System.out.print("$");
					//get how much you want to withdraw
					int diff = 0;
	
					try{
						diff = Integer.parseInt(s.next());
					}catch (NumberFormatException ex) {
					    //handle exception here
						System.out.println("Please enter a valid number!");
					}
					
					//check that it's positive
					if (diff > 0) {
						//check if it's not more than the balance
						if(diff <= getAccount_balance().get(acc_num)) {
							//reduce the balance by that amount
							getAccount_balance().set(acc_num, getAccount_balance().get(acc_num) - diff);
							//feedback
							logTransaction("Withdrew $" + diff + " from \"" + getAccount_name().get(acc_num) + "\" account");
							logTransaction("Current balance is now: $" + getAccount_balance().get(acc_num));
							
						}
						
						else
							System.out.println("Amount request exceeds balance.");
					}
					else
						System.out.println("Number needs to be greater than 0");
				}
				
				else
					System.out.println("Account balance is $0");
				
			}
				
			else 
				System.out.println("Sorry, that account needs to be approved by an Employee.");
		}
		
		else 
			System.out.println("This user has no personal accounts.");
	}
	
	public void withdrawFundsJoint(ArrayList<Customer> customerList, Scanner s) {
		if(getJoint_user().size() > 0) {
			//which account would you like to with funds from?
			System.out.println("Which joint account would you like to withdraw funds from?");
			
			//select a number
			int acc_num = selectJointAccounts(customerList, s);
			
			//check if that account is approved
			if(joint_status.get(acc_num)) {
				//check if that account has a >0 balance
				if(customerList.get(joint_user.get(acc_num)).getAccount_balance().get(joint_account.get(acc_num)) > 0) {
					
					System.out.println("How much would you like to withdraw: ");
					System.out.print("$");
					//get how much you want to withdraw
					int diff = 0;
	
					try{
						diff = Integer.parseInt(s.next());
					}catch (NumberFormatException ex) {
					    //handle exception here
						System.out.println("Please enter a valid number!");
					}
					
					//check that it's positive
					if (diff > 0) {
						//check if it's not more than the balance
						if(diff <= customerList.get(joint_user.get(acc_num)).getAccount_balance().get(joint_account.get(acc_num))) {
							//reduce the balance by that amount
							customerList.get(joint_user.get(acc_num)).getAccount_balance().set(joint_account.get(acc_num), customerList.get(joint_user.get(acc_num)).getAccount_balance().get(joint_account.get(acc_num)) - diff);
							//feedback
							logTransaction("Withdrew $" + diff + " from \"" + customerList.get(joint_user.get(acc_num)).getAccount_name().get(joint_account.get(acc_num)) + "\" account");
							logTransaction("Current balance is now: $" + customerList.get(joint_user.get(acc_num)).getAccount_balance().get(joint_account.get(acc_num)));
						}
						
						else
							System.out.println("Amount request exceeds balance.");
					}
					else
						System.out.println("Number needs to be greater than 0");
				}
				
				else
					System.out.println("Account balance is $0");
				
			}
			else 
				System.out.println("Sorry, that account needs to be approved by an Employee.");
		}
		
		else 
			System.out.println("This user has no joint accounts yet.");
	}
	
	/*
	 * DEPOSITS
	 */
	public void depositFunds(ArrayList<Customer> customerList, Scanner s) {
		
		if(getAccount_name().size() == 0 && getJoint_user().size() == 0)
			System.out.println("No accounts on file!");
		else {
			//account type selection
			System.out.println("Would you like to deposit into a personal, or a joint account?");
			System.out.println("(1) - Personal Account");
			System.out.println("(2) - Joint Account");
			
			String result = Function.GetMenuSelection(s, 2);
			
			if(result.equals("1"))
				depositFundsPersonal(customerList, s);
			else if(result.equals("2"))	
				depositFundsJoint(customerList, s);
		}
		System.out.println();
	}
	
	public void depositFundsPersonal(ArrayList<Customer> customerList, Scanner s) {
		//check if there's any accounts yet
		if(getAccount_name().size() > 0) {
			//which account would you like to with funds from?
			System.out.println("Which account would you like to deposit funds into?");
			
			//select a number
			int acc_num = selectAccounts(customerList, s);
			
			System.out.println("How much money would you like to deposit: ");
			System.out.print("$");
			//check if that account is approved
			if(getAccount_status().get(acc_num)) {
				//get how much you want to withdraw
				int diff = 0;
	
				try{
					diff = Integer.parseInt(s.next());
				}catch (NumberFormatException ex) {
				    //handle exception here
					System.out.println("Please enter a valid number!");
				}
				
				//check that it's positive
				if (diff > 0) {
					//increase the balance by that amount
					getAccount_balance().set(acc_num, getAccount_balance().get(acc_num) + diff);
					//feedback
					logTransaction("Deposited $" + diff + " into \"" + getAccount_name().get(acc_num) + "\" account");
					logTransaction("Current balance is now: $" + getAccount_balance().get(acc_num));
					
				}
				else
					System.out.println("Number needs to be greater than 0");
			
			}
				
			else 
				System.out.println("Sorry, that account needs to be approved by an Employee.");
		}
		
		else 
			System.out.println("No personal accounts have been created yet.");
		
	}
	
	public void depositFundsJoint(ArrayList<Customer> customerList, Scanner s) {
		//check if there's any accounts yet
		if(getJoint_account().size() > 0) {
			//which account would you like to with funds from?
			System.out.println("Which joint account would you like to deposit funds into?");
			
			//select a number
			int acc_num = selectJointAccounts(customerList, s);
			
			//check if that account is approved
			if(getJoint_status().get(acc_num)) {
	
				System.out.println("How much would you like to deposit: ");
				System.out.print("$");
				//get how much you want to withdraw
				int diff = 0;
	
				try{
					diff = Integer.parseInt(s.next());
				}catch (NumberFormatException ex) {
				    //handle exception here
					System.out.println("Please enter a valid number!");
				}
				
				//check that it's positive
				if (diff > 0) {
					//reduce the balance by that amount
					
					customerList.get(getJoint_user().get(acc_num)).getAccount_balance().set(getJoint_account().get(acc_num), customerList.get(getJoint_user().get(acc_num)).getAccount_balance().get(getJoint_account().get(acc_num)) + diff);
					//feedback
					logTransaction("Deposited $" + diff + " into \"" + customerList.get(getJoint_user().get(acc_num)).getAccount_name().get(getJoint_account().get(acc_num)) + "\" account");
					logTransaction("Current balance is now: $" + customerList.get(getJoint_user().get(acc_num)).getAccount_balance().get(getJoint_account().get(acc_num)));
				}
				else
					System.out.println("Number needs to be greater than 0");
				
			}
			else 
				System.out.println("Sorry, that account needs to be approved by an Employee.");
		}
		
		else
			System.out.println("No Joint Accounts have been made yet.");
	}
	
	/*
	 * TRANSFERRALS
	 */
	public void transferFunds(ArrayList<Customer> customerList, Scanner s) {

		
		if(getAccount_name().size() == 0 && getJoint_user().size() == 0)
			System.out.println("No accounts on file!");
		else {
			
			//account type selection
			System.out.println("Would you like to transfer from a personal, or a joint account?");
			System.out.println("(1) - Personal Account");
			System.out.println("(2) - Joint Account");
			
			String result = Function.GetMenuSelection(s, 2);
			
			if(result.equals("1"))
				transferFundsPersonal(customerList, s);
			else if(result.equals("2"))	
				transferFundsJoint(customerList, s);
		}
		System.out.println();
	}
	
	public void transferFundsPersonal(ArrayList<Customer> customerList, Scanner s) {
		if( getAccount_name().size() > 0 ) {	
			//which account would you like to with funds from?
			System.out.println("Which account would you like to transfer funds from?");
			
			//select a number
			int acc_num = selectAccounts(customerList, s);
			
			
			//check if that account is approved
			if(getAccount_status().get(acc_num)) {
				//check if that account has a >0 balance
				if(getAccount_balance().get(acc_num) > 0) {
					
					System.out.println("How much would you like to transfer: ");
					System.out.print("$");
					//get how much you want to withdraw
					int diff = 0;
	
					try{
						diff = Integer.parseInt(s.next());
					}catch (NumberFormatException ex) {
					    //handle exception here
						System.out.println("Please enter a valid number!");
					}
					
					//check that it's positive
					if (diff > 0) {
						//check if it's not more than the balance
						if(diff <= getAccount_balance().get(acc_num)) {
							//select account to transfer to
							//account type selection
							System.out.println("Would you like to transfer $" + diff + " to a personal, or a joint account?");
							System.out.println("(1) - Personal Account");
							System.out.println("(2) - Joint Account");
							
							String result = Function.GetMenuSelection(s, 2);
							if(result.equals("1")) {
								int target_acc_num = selectAccounts(customerList, s);
								
								//reduce the balance by that amount
								getAccount_balance().set(acc_num, getAccount_balance().get(acc_num) - diff);
								getAccount_balance().set(target_acc_num, getAccount_balance().get(target_acc_num) + diff);
								//feedback
								logTransaction("Withdrew $" + diff + " from \"" + getAccount_name().get(acc_num) + "\" account");
								logTransaction("Current balance is now: $" + getAccount_balance().get(acc_num));
								logTransaction("Transferred $" + diff + " to \"" + getAccount_name().get(target_acc_num) + "\" account");
								logTransaction("Current balance is now: $" + getAccount_balance().get(target_acc_num));
								
							}
							else if(result.equals("2")) {
								int target_acc_num = selectJointAccounts(customerList, s);
								
								
								//reduce the balance by that amount
								getAccount_balance().set(acc_num, getAccount_balance().get(acc_num) - diff);
								customerList.get(getJoint_user().get(target_acc_num)).getAccount_balance().set(getJoint_account().get(target_acc_num), customerList.get(getJoint_user().get(target_acc_num)).getAccount_balance().get(getJoint_account().get(target_acc_num)) + diff);
								//feedback
								logTransaction("Withdrew $" + diff + " from \"" + getAccount_name().get(acc_num) + "\" account");
								logTransaction("Current balance is now: $" + getAccount_balance().get(acc_num));
								logTransaction("Transferred $" + diff + " into \"" + customerList.get(getJoint_user().get(target_acc_num)).getAccount_name().get(getJoint_account().get(target_acc_num)) + "\" account");
								logTransaction("Current balance is now: $" + customerList.get(getJoint_user().get(target_acc_num)).getAccount_balance().get(getJoint_account().get(target_acc_num)));
							}
								
						}
						
						else
							System.out.println("Amount request exceeds balance.");
					}
					else
						System.out.println("Number needs to be greater than 0");
				}
				
				else
					System.out.println("Account balance is $0");
				
			}
				
			else 
				System.out.println("Sorry, that account needs to be approved by an Employee.");
		}
		
		else 
			System.out.println("No personal accounts have been created yet.");
	}
	
	public void transferFundsJoint(ArrayList<Customer> customerList, Scanner s) {
		//check if there's any accounts yet
		if(getJoint_account().size() > 0) {
			//which account would you like to with funds from?
			System.out.println("Which joint account would you like to transfer funds from?");
			
			//select a number
			int acc_num = selectJointAccounts(customerList, s);
			
			//check if that account is approved
			if(getJoint_status().get(acc_num)) {
	
				System.out.println("How much would you like to transfer: ");
				System.out.print("$");
				//get how much you want to withdraw
				int diff = 0;
	
				try{
					diff = Integer.parseInt(s.next());
				}catch (NumberFormatException ex) {
				    //handle exception here
					System.out.println("Please enter a valid number!");
				}
				
				//check that it's positive
				if (diff > 0) {
					//select account to transfer to
					//account type selection
					System.out.println("Would you like to transfer $" + diff + " to a personal, or a joint account?");
					System.out.println("(1) - Personal Account");
					System.out.println("(2) - Joint Account");
					
					String result = Function.GetMenuSelection(s, 2);
					if(result.equals("1")) {
						int target_acc_num = selectAccounts(customerList, s);
						
						//transfer the balance by that amount
						customerList.get(getJoint_user().get(acc_num)).getAccount_balance().set(getJoint_account().get(acc_num), customerList.get(getJoint_user().get(acc_num)).getAccount_balance().get(getJoint_account().get(acc_num))  - diff);
						getAccount_balance().set(target_acc_num, getAccount_balance().get(target_acc_num) + diff);
						//feedback
						logTransaction("Withdrew $" + diff + " from \"" + customerList.get(getJoint_user().get(acc_num)).getAccount_name().get(getJoint_account().get(acc_num)) + "\" account");
						logTransaction("Current balance is now: $" + customerList.get(getJoint_user().get(acc_num)).getAccount_balance().get(getJoint_account().get(acc_num)));
						logTransaction("Transferred $" + diff + " to \"" + getAccount_name().get(target_acc_num) + "\" account");
						logTransaction("Current balance is now: $" + getAccount_balance().get(target_acc_num));
					}
					else if(result.equals("2")) {
						int target_acc_num = selectJointAccounts(customerList, s);
						
						//reduce the balance by that amount
						customerList.get(getJoint_user().get(acc_num)).getAccount_balance().set(getJoint_account().get(acc_num), customerList.get(getJoint_user().get(acc_num)).getAccount_balance().get(getJoint_account().get(acc_num))  - diff);
						customerList.get(getJoint_user().get(target_acc_num)).getAccount_balance().set(getJoint_account().get(target_acc_num), customerList.get(getJoint_user().get(target_acc_num)).getAccount_balance().get(getJoint_account().get(target_acc_num)) + diff);
						//feedback
						logTransaction("Withdrew $" + diff + " from \"" + customerList.get(getJoint_user().get(acc_num)).getAccount_name().get(getJoint_account().get(acc_num)) + "\" account");
						logTransaction("Current balance is now: $" + customerList.get(getJoint_user().get(acc_num)).getAccount_balance().get(getJoint_account().get(acc_num)));
						logTransaction("Transferred $" + diff + " into \"" + customerList.get(getJoint_user().get(target_acc_num)).getAccount_name().get(getJoint_account().get(target_acc_num)) + "\" account");
						logTransaction("Current balance is now: $" + customerList.get(getJoint_user().get(target_acc_num)).getAccount_balance().get(getJoint_account().get(target_acc_num)));
					}
				}
				else
					System.out.println("Number needs to be greater than 0");
			}
			else 
				System.out.println("Sorry, that account needs to be approved by an Employee.");
		}
		
		else
			System.out.println("No Joint Accounts have been made yet.");
	}
	
	
	/*
	 * SELECTING AN ACCOUNT
	 */
	public int selectAccounts(ArrayList<Customer> customerList, Scanner s) {
		//display accounts by number
		for(int i = 0; i < getAccount_name().size(); i++) {
			System.out.println("("+(i+1) + ") - " + getAccount_name().get(i));
		}
		//select a number
		return Integer.parseInt(Function.GetMenuSelection(s, getAccount_name().size()))-1;
	}
	
	public int selectJointAccounts(ArrayList<Customer> customerList, Scanner s) {
		//display accounts by number
		for(int i = 0; i < getJoint_account().size(); i++) {
			System.out.println("("+(i+1) + ") - " + customerList.get(getJoint_user().get(i)).getAccount_name().get(getJoint_account().get(i)));
		}
		//select a number
		return Integer.parseInt(Function.GetMenuSelection(s, getJoint_account().size()))-1;
	}
	
	/*
	 * Getters/Setters
	 */
	public static int getTotal_users() {
		return total_users;
	}

	public static void setTotal_users(int total_users) {
		Customer.total_users = total_users;
	}

	public static int getTotal_accounts() {
		return total_accounts;
	}

	public static void setTotal_accounts(int total_accounts) {
		Customer.total_accounts = total_accounts;
	}

	public int getNumber_of_accounts() {
		return number_of_accounts;
	}

	public void setNumber_of_accounts(int number_of_accounts) {
		this.number_of_accounts = number_of_accounts;
	}


	public ArrayList<Integer> getAccount_id() {
		return account_id;
	}

	public void setAccount_id(ArrayList<Integer> account_id) {
		this.account_id = account_id;
	}

	public ArrayList<String> getAccount_name() {
		return account_name;
	}

	public void setAccount_name(ArrayList<String> account_name) {
		this.account_name = account_name;
	}
	
	public ArrayList<Integer> getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(ArrayList<Integer> account_balance) {
		this.account_balance = account_balance;
	}

	public ArrayList<Boolean> getAccount_status() {
		return account_status;
	}

	public void setAccount_status(ArrayList<Boolean> account_status) {
		this.account_status = account_status;
	}
	
	public ArrayList<Integer> getJoint_user() {
		return joint_user;
	}

	public void setJoint_user(ArrayList<Integer> joint_user) {
		this.joint_user = joint_user;
	}

	public ArrayList<Integer> getJoint_account() {
		return joint_account;
	}

	public void setJoint_account(ArrayList<Integer> joint_account) {
		this.joint_account = joint_account;
	}

	public ArrayList<Boolean> getJoint_status() {
		return joint_status;
	}

	public void setJoint_status(ArrayList<Boolean> joint_status) {
		this.joint_status = joint_status;
	}

}
