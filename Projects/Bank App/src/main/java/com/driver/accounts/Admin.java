package com.driver.accounts;

import java.util.ArrayList;
import java.util.Scanner;

import com.driver.func.Function;
import com.driver.transactions.Transaction;

public class Admin extends Employee implements Transaction{

private static final long serialVersionUID = 1L;
	
	public int userID = 0;
	
	public Admin(String user_name, String password, int id) {
		super(user_name, password, id);
	}

	/*
	 * Methods
	 */
	
	public int selectUser(ArrayList<Customer> customerList, Scanner s) {
		//display users by number
		for(int i = 0; i < customerList.size(); i++) {
			System.out.println("("+(i+1) + ") - " + customerList.get(i).getUser_name());
		}
		//select a number
		return Integer.parseInt(Function.GetMenuSelection(s, customerList.size()))-1;
	}
	
	public void deleteUser(ArrayList<Customer> customerList, Scanner s) {
		//get a user
		System.out.println("Select User to delete:");
		userID = selectUser(customerList, s);
		
		logTransaction("User \"" + customerList.get(userID).getUser_name() + "\" and their accounts deleted.");
		logTransaction("Joint accounts associated also deleted.");
		
		//delete joint accounts first
		for(int i = 0; i < customerList.size(); i++) {
			//ignore the user we're deleting
			if(i != userID) {
				//check if their account is shared with the user that is to be deleted
				for(int j = 0; j < customerList.get(i).getJoint_account().size(); j++) {
					//remove each part of the joint account info
					if(customerList.get(i).getJoint_account().get(j) == userID) {
						customerList.get(i).getJoint_account().remove(j);
						customerList.get(i).getJoint_status().remove(j);
						customerList.get(i).getJoint_user().remove(j);
						j--;//manage iterator
					}
				}
			}
		}
		
		//delete that user
		customerList.remove(userID);
	}
	
	
	public void deleteAccount(ArrayList<Customer> customerList, Scanner s) {
		//get a user
		System.out.println("Select User:");
		userID = selectUser(customerList, s);
		
		//get their account type
		//account type selection
		System.out.println("Would you like to delete a personal, or a joint account?");
		System.out.println("(1) - Personal Account");
		System.out.println("(2) - Joint Account");
		
		String result = Function.GetMenuSelection(s, 2);
		
		if(result.equals("1")) {
			if( customerList.get(userID).getAccount_name().size() > 0 ) {
				System.out.println("Select an account to delete: ");
				//select a number
				int acc_num = selectAccounts(customerList, s);
				
				logTransaction("User \"" + customerList.get(userID).getUser_name() + "\"'s account, \""+ customerList.get(userID).getAccount_name().get(acc_num) + "\" deleted.");
				logTransaction("Joint accounts associated also deleted.");
				
				//delete joint accounts first
				for(int i = 0; i < customerList.size(); i++) {
					//ignore the user we're deleting
					if(i != userID) {
						//check if their account is shared with the user that is to be deleted
						for(int j = 0; j < customerList.get(i).getJoint_account().size(); j++) {
							//remove each part of the joint account info
							if(customerList.get(i).getJoint_account().get(j) == acc_num) {
								customerList.get(i).getJoint_account().remove(j);
								customerList.get(i).getJoint_status().remove(j);
								customerList.get(i).getJoint_user().remove(j);
								j--;//manage iterator
							}
						}
					}
				}
				
				//remove that account
				customerList.get(userID).getAccount_name().remove(acc_num);
				customerList.get(userID).getAccount_id().remove(acc_num);
				customerList.get(userID).getAccount_balance().remove(acc_num);
				customerList.get(userID).getAccount_status().remove(acc_num);	
				
				customerList.get(userID).setNumber_of_accounts(customerList.get(userID).getNumber_of_accounts() - 1);
				
			}
			else
				System.out.println("This user has no personal accounts.");
		}
		else if(result.equals("2"))	{
			//check if there's any accounts yet
			if(customerList.get(userID).getJoint_account().size() > 0) {
				System.out.println("Select a joint account to delete: ");
				//select a number
				int acc_num = selectJointAccounts(customerList, s);
				
				logTransaction("User \"" + customerList.get(userID).getUser_name() + "\"'s joint account, \""+ customerList.get(userID).getJoint_account().get(acc_num) + "\" deleted.");
				
				customerList.get(userID).getJoint_account().remove(acc_num);
				customerList.get(userID).getJoint_status().remove(acc_num);
				customerList.get(userID).getJoint_user().remove(acc_num);
			}
			else
				System.out.println("This user has no joint accounts.");
		}
	}
	
	/*
	 * WITHDRAWALS
	 */

	public void withdrawFunds(ArrayList<Customer> customerList, Scanner s) {
		if(customerList.size() == 0)
			System.out.println("No accounts on file!");
		else {
			
			System.out.println("Select User to withdraw from:");
			//get a user
			userID = selectUser(customerList, s);
			
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
		if( customerList.get(userID).getAccount_name().size() > 0 ) {	
			//which account would you like to with funds from?
			System.out.println("Which account would you like to withdraw funds from?");
			
			//select a number
			int acc_num = selectAccounts(customerList, s);
			
			//check if that account is approved
			if(customerList.get(userID).getAccount_status().get(acc_num)) {
				//check if that account has a >0 balance
				if(customerList.get(userID).getAccount_balance().get(acc_num) > 0) {
					
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
						if(diff <= customerList.get(userID).getAccount_balance().get(acc_num)) {
							//reduce the balance by that amount
							customerList.get(userID).getAccount_balance().set(acc_num, customerList.get(userID).getAccount_balance().get(acc_num) - diff);
							//feedback
							logTransaction("Withdrew $" + diff + " from \"" + customerList.get(userID).getAccount_name().get(acc_num) + "\" account");
							logTransaction("Current balance is now: $" + customerList.get(userID).getAccount_balance().get(acc_num));
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
		//check if there's any accounts yet
		if(customerList.get(userID).getJoint_account().size() > 0) {	
			//which account would you like to with funds from?
			System.out.println("Which joint account would you like to withdraw funds from?");
			
			//select a number
			int acc_num = selectJointAccounts(customerList, s);
			
			
			//check if that account is approved
			if(customerList.get(userID).getJoint_status().get(acc_num)) {
				//check if that account has a >0 balance
				if(customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num)) > 0) {
					
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
						if(diff <= customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num))) {
							//reduce the balance by that amount
							customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().set(customerList.get(userID).getJoint_account().get(acc_num), customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num)) - diff);
							//feedback
							logTransaction("Withdrew $" + diff + " from \"" + customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_name().get(customerList.get(userID).getJoint_account().get(acc_num)) + "\" account");
							logTransaction("Current balance is now: $" + customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num)));
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
			System.out.println("No Joint Accounts have been made yet.");
	}

	/*
	 * DEPOSIT
	 */

	public void depositFunds(ArrayList<Customer> customerList, Scanner s) {
		if(customerList.get(userID).getAccount_name().size() == 0 && customerList.get(userID).getJoint_user().size() == 0)
			System.out.println("No accounts on file!");
		else {
			
			//get a user
			System.out.println("Select User to deposit into:");
			userID = selectUser(customerList, s);
			
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
		if(customerList.get(userID).getAccount_name().size() > 0) {
			//which account would you like to with funds from?
			System.out.println("Which account would you like to deposit funds into?");
			
			//select a number
			int acc_num = selectAccounts(customerList, s);
			
			System.out.println("How much money would you like to deposit: ");
			System.out.print("$");
			//check if that account is approved
			if(customerList.get(userID).getAccount_status().get(acc_num)) {
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
					customerList.get(userID).getAccount_balance().set(acc_num, customerList.get(userID).getAccount_balance().get(acc_num) + diff);
					//feedback
					logTransaction("Deposited $" + diff + " into \"" + customerList.get(userID).getAccount_name().get(acc_num) + "\" account");
					logTransaction("Current balance is now: $" + customerList.get(userID).getAccount_balance().get(acc_num));
				
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
		if(customerList.get(userID).getJoint_account().size() > 0) {
			//which account would you like to with funds from?
			System.out.println("Which joint account would you like to deposit funds into?");
			
			//select a number
			int acc_num = selectJointAccounts(customerList, s);
			
			//check if that account is approved
			if(customerList.get(userID).getJoint_status().get(acc_num)) {
	
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
					
					customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().set(customerList.get(userID).getJoint_account().get(acc_num), customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num)) + diff);
					//feedback
					logTransaction("Deposited $" + diff + " into \"" + customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_name().get(customerList.get(userID).getJoint_account().get(acc_num)) + "\" account");
					logTransaction("Current balance is now: $" + customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num)));
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
	 * TRANSFERRANCE
	 */

	public void transferFunds(ArrayList<Customer> customerList, Scanner s) {
		if(customerList.get(userID).getAccount_name().size() == 0 && customerList.get(userID).getJoint_user().size() == 0)
			System.out.println("No accounts on file!");
		else {
			
			//get a user
			System.out.println("Select User to transfer with:");
			userID = selectUser(customerList, s);
			
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
		if( customerList.get(userID).getAccount_name().size() > 0 ) {
			//which account would you like to with funds from?
			System.out.println("Which account would you like to transfer funds from?");
			
			//select a number
			int acc_num = selectAccounts(customerList, s);
			
			
			//check if that account is approved
			if(customerList.get(userID).getAccount_status().get(acc_num)) {
				//check if that account has a >0 balance
				if(customerList.get(userID).getAccount_balance().get(acc_num) > 0) {
					
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
						if(diff <= customerList.get(userID).getAccount_balance().get(acc_num)) {
							//select account to transfer to
							//account type selection
							System.out.println("Would you like to transfer $" + diff + " to a personal, or a joint account?");
							System.out.println("(1) - Personal Account");
							System.out.println("(2) - Joint Account");
							
							String result = Function.GetMenuSelection(s, 2);
							if(result.equals("1")) {
								int target_acc_num = selectAccounts(customerList, s);
								
								//reduce the balance by that amount
								customerList.get(userID).getAccount_balance().set(acc_num, customerList.get(userID).getAccount_balance().get(acc_num) - diff);
								customerList.get(userID).getAccount_balance().set(target_acc_num, customerList.get(userID).getAccount_balance().get(target_acc_num) + diff);
								//feedback
								logTransaction("Withdrew $" + diff + " from \"" + customerList.get(userID).getAccount_name().get(acc_num) + "\" account");
								logTransaction("Current balance is now: $" + customerList.get(userID).getAccount_balance().get(acc_num));
								logTransaction("Transferred $" + diff + " to \"" + customerList.get(userID).getAccount_name().get(target_acc_num) + "\" account");
								logTransaction("Current balance is now: $" + customerList.get(userID).getAccount_balance().get(target_acc_num));
							}
							else if(result.equals("2")) {
								int target_acc_num = selectJointAccounts(customerList, s);
								
								
								//reduce the balance by that amount
								customerList.get(userID).getAccount_balance().set(acc_num, customerList.get(userID).getAccount_balance().get(acc_num) - diff);
								customerList.get(customerList.get(userID).getJoint_user().get(target_acc_num)).getAccount_balance().set(customerList.get(userID).getJoint_account().get(target_acc_num), customerList.get(customerList.get(userID).getJoint_user().get(target_acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(target_acc_num)) + diff);
								//feedback
								logTransaction("Withdrew $" + diff + " from \"" + customerList.get(userID).getAccount_name().get(acc_num) + "\" account");
								logTransaction("Current balance is now: $" + customerList.get(userID).getAccount_balance().get(acc_num));
								logTransaction("Transferred $" + diff + " into \"" + customerList.get(customerList.get(userID).getJoint_user().get(target_acc_num)).getAccount_name().get(customerList.get(userID).getJoint_account().get(target_acc_num)) + "\" account");
								logTransaction("Current balance is now: $" + customerList.get(customerList.get(userID).getJoint_user().get(target_acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(target_acc_num)));
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
		// TODO Auto-generated method stub
		if(customerList.get(userID).getJoint_account().size() > 0) {
			//which account would you like to with funds from?
			System.out.println("Which joint account would you like to transfer funds from?");
			
			//select a number
			int acc_num = selectJointAccounts(customerList, s);
			
			//check if that account is approved
			if(customerList.get(userID).getJoint_status().get(acc_num)) {
	
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
						customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().set(customerList.get(userID).getJoint_account().get(acc_num), customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num))  - diff);
						customerList.get(userID).getAccount_balance().set(target_acc_num, customerList.get(userID).getAccount_balance().get(target_acc_num) + diff);
						//feedback
						logTransaction("Withdrew $" + diff + " from \"" + customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_name().get(customerList.get(userID).getJoint_account().get(acc_num)) + "\" account");
						logTransaction("Current balance is now: $" + customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num)));
						logTransaction("Transferred $" + diff + " to \"" + customerList.get(userID).getAccount_name().get(target_acc_num) + "\" account");
						logTransaction("Current balance is now: $" + customerList.get(userID).getAccount_balance().get(target_acc_num));
					}
					else if(result.equals("2")) {
						int target_acc_num = selectJointAccounts(customerList, s);
						
						//reduce the balance by that amount
						customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().set(customerList.get(userID).getJoint_account().get(acc_num), customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num))  - diff);
						customerList.get(customerList.get(userID).getJoint_user().get(target_acc_num)).getAccount_balance().set(customerList.get(userID).getJoint_account().get(target_acc_num), customerList.get(customerList.get(userID).getJoint_user().get(target_acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(target_acc_num)) + diff);
						//feedback
						logTransaction("Withdrew $" + diff + " from \"" + customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_name().get(customerList.get(userID).getJoint_account().get(acc_num)) + "\" account");
						logTransaction("Current balance is now: $" + customerList.get(customerList.get(userID).getJoint_user().get(acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(acc_num)));
						logTransaction("Transferred $" + diff + " into \"" + customerList.get(customerList.get(userID).getJoint_user().get(target_acc_num)).getAccount_name().get(customerList.get(userID).getJoint_account().get(target_acc_num)) + "\" account");
						logTransaction("Current balance is now: $" + customerList.get(customerList.get(userID).getJoint_user().get(target_acc_num)).getAccount_balance().get(customerList.get(userID).getJoint_account().get(target_acc_num)));
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


	public int selectAccounts(ArrayList<Customer> customerList, Scanner s) {
		//display accounts by number
		for(int i = 0; i < customerList.get(userID).getAccount_name().size(); i++) {
			System.out.println("("+(i+1) + ") - " + customerList.get(userID).getAccount_name().get(i));
		}
		//select a number
		return Integer.parseInt(Function.GetMenuSelection(s, customerList.get(userID).getAccount_name().size()))-1;
	}


	public int selectJointAccounts(ArrayList<Customer> customerList, Scanner s) {
		//display accounts by number
		for(int i = 0; i < customerList.get(userID).getJoint_account().size(); i++) {
			System.out.println("("+(i+1) + ") - " + customerList.get(customerList.get(userID).getJoint_user().get(i)).getAccount_name().get(customerList.get(userID).getJoint_account().get(i)));
		}
		//select a number
		return Integer.parseInt(Function.GetMenuSelection(s, customerList.get(userID).getJoint_account().size()))-1;
	}


}