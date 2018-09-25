package com.revature.BanksAreGreat.Ihopethisworks;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	//instance variables
	Scanner keyboard = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit;
	
	public static void main(String[] args) {
		//creates an object of this class
		Menu menu = new Menu();
		menu.runMenu();
		
	}
	
	public void runMenu(){
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}
	private void printHeader() {
		System.out.println("======================");
		System.out.println("|      WELECOME      |");
		System.out.println("======================");
	}
	private void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("Pleasse make a selection:");
		System.out.println("1) Create an account");
		System.out.println("2) Make a deposit");
		System.out.println("3) Make a withdrawl");
		System.out.println("4) List account balance");
		//System.out.println("5) Delete empty account");
		System.out.println("0) Exit");
	}
	private int getInput() {
		int choice = -1;
		do {
			System.out.print("Enter your choice: ");
			try {//catches if the user puts in a valid number or not
				choice = Integer.parseInt(keyboard.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Invalid selection. Numbers only please.");
			}
			if (choice <0 || choice > 4) {
				System.out.println("Choice outside of range. Please choose again.");
			}
		}while (choice <0 || choice > 4);
		return choice;
	}
	private void performAction(int choice) {
		switch (choice) {
		case 0:
			System.out.println("Thank you");
			System.exit(0);
			break;
		case 1:
			//create account
			createAnAccount();
			break;
		case 2:
			//make a deposit
			makeADeposit();
			break;
		case 3:
			//make a withdraw 
			makeAWithdraw();
			break;
		case 4:
			//list balance 
			listBalance();
			break;
		//case 5: 
			//delete account
			//deleteAccount();
		default: 
			System.out.println("Unknown error has occured.");
	}
}
	private void createAnAccount() {
		//while valid is NOT false have the user enter in checking or savings if they don't enter in one of those words then it'll say invalid account type 
		String firstName, lastName, ssn, accountType = "";
		double initialDeposit =0;
		boolean valid = false;
		while(!valid) {
			System.out.println("Enter checking or savings:");
			accountType = keyboard.nextLine();
			//will ignore the case SAVINGS savings Savings
			if(accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")) {
				valid = true;
			}else {
				System.out.println("Invalid account type. Please try again.");
			}
		}
			System.out.print("please enter your first name: ");
			firstName= keyboard.nextLine();
			System.out.print("please enter your last name: ");
			lastName= keyboard.nextLine();
			System.out.print("please enter your social security number: ");
			ssn = keyboard.nextLine();
			valid = false;
			while(!valid) {
				System.out.println("please enter your intitial deposit: ");
				try {
					initialDeposit = Double.parseDouble(keyboard.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("Deposit must be a number.");
				}
				if(accountType.equalsIgnoreCase("checking")) {
					if(initialDeposit < 100) {
						System.out.println("Checking accounts require a min of $100 to open");
					}else {
						valid =true;
					}
				}else if(accountType.equalsIgnoreCase("savings")) {
					if (initialDeposit < 50) {
						System.out.println("Checking accounts require a min of $50 to open");
					}else {
						valid = true;
					}
				}
			}
			//we can create an account now 
			Account account;
			if(accountType.equalsIgnoreCase("checking")) {
				account = new Checking(initialDeposit);
			}else {
				account = new Savings(initialDeposit);
			}
			Customer customer = new Customer(firstName, lastName, ssn, account);
			bank.addCustomer(customer);
	
	}

	private void makeADeposit() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.println("How much would you like to deposit?: ");
			double amount = 0;
			try {
				amount = Double.parseDouble(keyboard.nextLine());
			}catch(NumberFormatException e){
				amount =0;
			}
			bank.getCustomer(account).getAccount().deposit(amount);
		}
	}

	private void makeAWithdraw() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.print("How much would you like to withdraw?: ");
			double amount = 0;
			try {
				amount = Double.parseDouble(keyboard.nextLine());
			}catch(NumberFormatException e){
				amount =0;
			}
			bank.getCustomer(account).getAccount().withdraw(amount);
		}
		
	}
	
	private void listBalance() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.println(bank.getCustomer(account).getAccount());
		}else {
			System.out.println("Please select a vaild account.");
		}
	}
	
	private int selectAccount() {
		ArrayList<Customer> customers = bank.getCustomers();
		if(customers.size() <= 0) {
			System.out.println("No customers at your bank.");
		}
		for(int i = 0; i < customers.size(); i++) {
			System.out.println((i+1) +") "+ customers.get(i).basicInfo());
		}
		int account= 0;
		System.out.println("Please choose an account: ");
		try {
			account = Integer.parseInt(keyboard.nextLine()) - 1;
		}catch(NumberFormatException e){
			account =-1;
		}
		if(account < 0 || account > customers.size()) {
			System.out.println("invalid account selected.");
			account = -1;
		}
		return account;
		
	}
	
	//p0rivate void deleteAccount() {}
	
}
