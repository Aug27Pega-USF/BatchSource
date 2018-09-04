package com.driver;


import com.driver.accounts.Account;
import com.driver.accounts.Admin;
import com.driver.accounts.Customer;
import com.driver.accounts.Employee;
import com.driver.enus.AccountType;
import com.driver.enus.MenuState;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.driver.func.Function;
import com.driver.io.IO;

public class Driver {
	
	public static void main(String[] args) {
		
		//open input stream
		Scanner scan = new Scanner(System.in);
		
		//state control
		boolean quit = false;
		MenuState menuState = MenuState.MAIN_MENU;
		
		AccountType accountType = AccountType.NONE;
		
		
		String result = ""; //for storing the result of a scan
		String user_entered = ""; //stores the current username entered
		String password_entered = ""; //stores the current password entered
		int current_account_id = 0; //stores the current account number
		
		//user accounts
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		
		String IDsFile = "IDs.txt";
		String AccountsFile = "Accounts.txt";
		//get numbers for users and accounts so their ids are consistent for file accessing
		Customer.setTotal_users(Integer.parseInt(IO.readFile(IDsFile)));
		Customer.setTotal_accounts(Integer.parseInt(IO.readFile(AccountsFile)));
		
		customerList = IO.readCustomerFile();
		employeeList = IO.readEmployeeFile();
		adminList = IO.readAdminFile();
		
		
		//main loop
		while(!quit) {
			//getting the state of the app
			switch(menuState) {
				/*
				 * Logging In/Quitting the App
				 */
				case MAIN_MENU:
					//reset the current account type
					accountType = AccountType.NONE;
					
					//prompt for app
					System.out.println();
					System.out.println("*******************************");
					System.out.println("*******************************");
					System.out.println("*******************************");
					System.out.println("Hello! Welcome to the Revature Banking App.");
					
					//prompt for main menu
					System.out.println("How can we help you today?");
					System.out.println("(1) - Login");
					System.out.println("(2) - Exit");
					
					//get input
					result = Function.GetMenuSelection(scan, 2);
					
					//logging in
					if (result.equals("1")) 
						menuState = MenuState.LOGIN;
					//exiting
					else if (result.equals("2")) 
						quit = true;
					System.out.println();
					break;
					
				/*
				 * Logging in
				 */
				case LOGIN:
					//prompt to login
					System.out.println("Type in your login name: ");
					
					//get the login
					user_entered = scan.next();
					
					//check if the user account exists
					//check if they're a customer
					for (Customer c : customerList) {
					  if(c.getUser_name().equals(user_entered)) {
						  accountType = AccountType.CUSTOMER;
						  current_account_id = c.getUser_id();
						  password_entered = c.getPassword();
					  }
					}
					
					//no customer found, look for an employee
					if (accountType == AccountType.NONE) {
						for (Employee e : employeeList) {
						  if(e.getUser_name().equals(user_entered)) {
							  accountType = AccountType.EMPLOYEE;
							  current_account_id = e.getUser_id();
							  password_entered = e.getPassword();
						  }
						}
					}
					
					//no employee found, look for an admin
					if (accountType == AccountType.NONE) {
						for (Admin a : adminList) {
						  if(a.getUser_name().equals(user_entered)) {
							  accountType = AccountType.ADMIN;
							  current_account_id = a.getUser_id();
							  password_entered = a.getPassword();
						  }
						}
					}
				
					switch(accountType) {
						default:
						case NONE:
							menuState = MenuState.NEW_USER_MENU; //go to password setting
							break;
							
						case CUSTOMER:
						case EMPLOYEE:
						case ADMIN:
							menuState = MenuState.CHECK_PASSWORD; 
							break;
					}	
					System.out.println();
					break;
				
				//state for checking password on login
				case CHECK_PASSWORD:
					//make them enter the right password
					result = "";
					
					while(!password_entered.equals(result)) {
						System.out.println("Please type Password for account: ");
						result = scan.next();
					}
					
					//proceed to correct menu
					switch(accountType) {
						default:
						case NONE:
							menuState = MenuState.NEW_USER_MENU; //go to password setting
							break;
						case CUSTOMER:
							menuState = MenuState.CUSTOMER_MENU; 
							break;
						case EMPLOYEE:
							menuState = MenuState.EMPLOYEE_MENU; 
							break;
						case ADMIN:
							menuState = MenuState.ADMIN_MENU; 
							break;
					}
					System.out.println();
					break;
					
					
				case NEW_USER_MENU:
					System.out.println("The account \"" + user_entered + "\" does not appear to be in our systems.");
					System.out.println("What would you like to do?");
					System.out.println("(1) - Create New Account");
					System.out.println("(2) - Return to Main Menu");
					
					//get input
					result = Function.GetMenuSelection(scan, 2);
					
					//logging in
					if (result.equals("1")) 
						menuState = MenuState.NEW_PASSWORD;
					//exiting
					else if (result.equals("2")) 
						menuState = MenuState.MAIN_MENU;
					System.out.println();
					break;
					
				//state for setting a new password
				case NEW_PASSWORD:
					//reiterating the username
					System.out.println("Setting an account for \"" + user_entered + "\"...");
					System.out.println();
					
					//check what kind of user they are
					while(accountType == AccountType.NONE) {
						System.out.println("Are you a Customer, Employee, or Admin: ");
						System.out.println("(1) - Customer");
						System.out.println("(2) - Employee");
						System.out.println("(3) - Admin");
						
						//get input
						result = Function.GetMenuSelection(scan, 3);
						
						if (result.equals("1")) 
							accountType = AccountType.CUSTOMER;
						else if (result.equals("2")) 
							accountType = AccountType.EMPLOYEE;
						else if (result.equals("3")) 
							accountType = AccountType.ADMIN;
						else
							System.out.println("Please enter a valid choice!");
					}
					
					//setting a password
					result = "!@#$%"; //clear these out so they're not the same
					password_entered = "";
					
					while(!password_entered.equals(result)) {
						System.out.println();
						System.out.println("Create a password for your account: ");
						password_entered = scan.next();
						
						//double checking
						System.out.println("Retype to confirm password: ");
						result = scan.next();
						
						if(!password_entered.equals(result)) 
							System.out.println("Passwords do not match!");
					}	
					
					switch(accountType) {
						default:
						case CUSTOMER:
							current_account_id = Customer.getTotal_users(); //store the current index of the account number
							customerList.add(new Customer(user_entered, password_entered, customerList.size()));
							//print everything back
							Account.NewAccountMessage(user_entered, password_entered, "CUSTOMER");
							menuState = MenuState.CUSTOMER_MENU;
							
							break;
							
						case EMPLOYEE:
							current_account_id = employeeList.size(); //store the current index of the account number
							employeeList.add(new Employee(user_entered, password_entered, employeeList.size()));
							//print everything back
							Account.NewAccountMessage(user_entered, password_entered, "EMPLOYEE");
							menuState = MenuState.EMPLOYEE_MENU;
							break;
							
						case ADMIN:
							current_account_id = adminList.size(); //store the current index of the account number
							adminList.add(new Admin(user_entered, password_entered, adminList.size()));
							//print everything back
							Account.NewAccountMessage(user_entered, password_entered, "ADMIN");
							menuState = MenuState.ADMIN_MENU;
							break;
					}
					System.out.println();
					break;
					
				case CUSTOMER_MENU:
					/*
					 * open an account, apply to join account
						withdraw,deposit,transfer funds
						log out
					 */
					
					System.out.println("Welcome " + user_entered + "! What would you like to do?");

					System.out.println("(1) - Apply for New Account");
					System.out.println("(2) - Apply for Joint Account");
					System.out.println("(3) - View Accounts");
					System.out.println("(4) - Withdraw Funds");
					System.out.println("(5) - Deposit Funds");
					System.out.println("(6) - Transfer Funds");
					System.out.println("(7) - Logout");
					
					//get input
					result = Function.GetMenuSelection(scan, 7);
					
					//menu
					if (result.equals("1"))
						customerList.get(current_account_id).applyForAccount(scan);
					else if (result.equals("2"))
						customerList.get(current_account_id).applyForJointAccount(customerList, scan);
					else if (result.equals("3"))
						customerList.get(current_account_id).viewAllAccounts(customerList);
					else if (result.equals("4"))
						customerList.get(current_account_id).withdrawFunds(customerList, scan);
					else if (result.equals("5"))
						customerList.get(current_account_id).depositFunds(customerList, scan);
					else if (result.equals("6"))
						customerList.get(current_account_id).transferFunds(customerList, scan);
					else if (result.equals("7")) 
						menuState = MenuState.MAIN_MENU;
					System.out.println();
					
					break;
					
				case EMPLOYEE_MENU:
					/*
					 * view all customer information (accounts, balances, personal information), 
					 * manage accounts (approve/deny them), log out 
					 */
					System.out.println();
					System.out.println("Welcome " + user_entered + "! What would you like to do?");

					System.out.println("(1) - View all Customer Information");
					System.out.println("(2) - Approve/Deny Accounts");
					System.out.println("(3) - Logout");
					
					//get input
					result = Function.GetMenuSelection(scan, 3);
					
					if (result.equals("1")) 
						employeeList.get(current_account_id).viewAllAccounts(customerList);
					
					else if (result.equals("2")) 
						employeeList.get(current_account_id).approveAccount(customerList, scan);
						
					else if (result.equals("3")) 
						menuState = MenuState.MAIN_MENU;
					System.out.println();
					
					break;
					
				case ADMIN_MENU:
					/*
					 * edit accounts (withdraw, deposit, transfer between), canceling account, log out
					 */
					System.out.println("Welcome! What would you like to do:");

					System.out.println("(1) - View all Customer Information");
					System.out.println("(2) - Approve/Deny Accounts");
					System.out.println("(3) - Delete User");
					System.out.println("(4) - Withdraw Funds");
					System.out.println("(5) - Deposit Funds");
					System.out.println("(6) - Transfer Funds");
					System.out.println("(7) - Logout");
					System.out.println("(8) - Delete User");
					
					//get input
					result = Function.GetMenuSelection(scan, 8);
					
					if(result.equals("1")) 
						adminList.get(current_account_id).viewAllAccounts(customerList);
					else if (result.equals("2")) 
						adminList.get(current_account_id).approveAccount(customerList, scan);
					else if (result.equals("3")) 
						adminList.get(current_account_id).deleteAccount(customerList, scan);
					else if (result.equals("4"))
						adminList.get(current_account_id).withdrawFunds(customerList, scan);
					else if (result.equals("5"))
						adminList.get(current_account_id).depositFunds(customerList, scan);
					else if (result.equals("6"))
						adminList.get(current_account_id).transferFunds(customerList, scan);
					else if (result.equals("7")) 
						menuState = MenuState.MAIN_MENU;	
					else if (result.equals("8")) 
						adminList.get(current_account_id).deleteUser(customerList, scan);
					
					System.out.println();
					break;
			}
		}

		//saving out text data
		IO.writeFile( Integer.toString(Customer.getTotal_users()), IDsFile );
		IO.writeFile( Integer.toString(Customer.getTotal_accounts()), AccountsFile );
		
		IO.writeCustomerFile(customerList);
		IO.writeEmployeeFile(employeeList);
		IO.writeAdminFile(adminList);
		
		//close the input stream
		scan.close();
	}
}

