package com.revature.driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.*;
//import com.revature.dao.*;
import com.revature.daoimpl.*;

public class Driver {
	static Scanner sc = new Scanner(System.in);
	static BankUserDAOImpl budi = new BankUserDAOImpl();
	static AccountDAOImpl adi = new AccountDAOImpl();

	public static void main(String[] args) throws SQLException {
//		try {
//			budi.createAdmin("Julian", "frogger"); //1
//			budi.createCustomer("Donkey Kong", "pauline"); //2
//			budi.createCustomer("Master Chief", "cortana"); //3
//			budi.createCustomer("Evan", "normalman"); //4
//			System.out.println("List of Users:");
//			System.out.println(budi.getCustomerList());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
        System.out.println("Welcome to the Iron Bank!\nPlease be mindful, we are undergoing construction and as such"
        		+ " we cannot provide our full service at this time.\nWe thank you for your patience.");
        System.out.println("~~Main Menu~~ \nChoose user type or exit: \n1 - Customer \n2 - Admin \n3 - Exit");
        
        while (true) {
        int choice = sc.nextInt();
        switch (choice) {
        	case 1://Customer
        		InitialCustomerMenu();
                break;
        	case 2://Employee
        		InitialAdminMenu();
        		break;
        	case 3:
        		System.out.println("The Iron Bank thanks you for your patronage. Have a merry day!");
        		System.exit(1);
        	}break;
        }
	}
	
	public static void InitialCustomerMenu() throws SQLException {
		System.out.println("\n~~Customer Menu~~\n1 - Register \n2 - Login \n3 - Main Menu");
        int choice = sc.nextInt();
        switch (choice) {
        	case 1://Register
        		RegisterCustomer();
        		break;
        	case 2://Login
        		LoginCustomer();
        		break;
        	case 3:
				main(new String[0]);
				break;
        }
	}
	
	private static void RegisterCustomer() throws SQLException {
		String name;
		String password;
		System.out.println("Enter your account name: ");
		name = sc.next();
		System.out.println("Please enter a password at least 6 characters long: ");
		password = sc.next();
		while(password.length() < 6)
		{
			System.out.println("Invalid password. Try again:");
			password=sc.next();
		}
		budi.createCustomer(name, password);
		System.out.println("Registered successfully!");
		Customer c = null;
		c = budi.checkCustomerLogin(name, password);
		CustomerMenu(c);
	}
	
	private static void LoginCustomer() throws SQLException {
		System.out.println("Enter your account name: ");
		String name = sc.next();
		System.out.println("Enter your password: ");
		String password = sc.next();
		Customer c = null;
		c = budi.checkCustomerLogin(name, password);
		if (c == null) {
			System.out.println("It seems no customer exists under that name.\nYou can either create"
					+ " a new customer account or log in as an existing customer.\n");
			InitialCustomerMenu();
		} else {
			System.out.println("Welcome back " + c.getName() + "!");
			CustomerMenu(c);
		}
	}
	
	private static void CustomerMenu(Customer c) throws SQLException {
        String type = null;
        int user_id;
        double amount;
        int editacct;
        Account edita = null;
        List<Account> lista = null;
        System.out.println("Customer Menu: \n1 - View Accounts \n2 - Create New Account \n3 - Edit Existing Account"
        		+ "\n4 - Main Menu");
		int choice = sc.nextInt();
		switch(choice) {
			case 1: //View accounts
				System.out.println("Your accounts:");
			    if(adi.getUserAccounts(c.getUserId()).isEmpty()) {
			    	System.out.println("You have no accounts at this time.");
			    }
			    else {
			    	System.out.println(adi.getUserAccounts(c.getUserId()));
			    }
			    CustomerMenu(c);
				break;
			case 2: //Create account
				System.out.println("What kind of account would you like?");
				type = sc.next();
		        user_id = c.getUserId();
		        System.out.println("How much would you like to deposit into this new account?");
		        amount = sc.nextDouble();
		        adi.createAccount(type, amount, user_id);
		        lista = null;
				lista = adi.getUserAccounts(c.getUserId());
				System.out.println("New account created: " + lista.get(lista.size()-1).getType());
				AccountMenu(lista.get(lista.size()-1));
				break;
			case 3: //edit account
				System.out.println("Choose the account ID you wish to edit: ");
				System.out.println(adi.getUserAccounts(c.getUserId()));
				editacct = sc.nextInt();
				lista = null;
				lista = adi.getUserAccounts(c.getUserId());
				for(Account acct : lista) {
					if(acct.getAccountid() != editacct) {
						continue;
					}
					else {
						edita = acct;
						AccountMenu(edita);
					}
				}
				System.out.println("Sorry, that account doesn't exist.");
				CustomerMenu(c);
				break;
			case 4: //main menu
				main(new String[0]);
				break;
		}
	}
	
	public static void InitialAdminMenu() throws SQLException {
		System.out.println("\n~~Admin Menu~~\n1 - Register \n2 - Login \n3 - Main Menu");
        int choice = sc.nextInt();
        switch (choice) {
        	case 1://Register
        		RegisterAdmin();
        		break;
        	case 2://Login
        		LoginAdmin();
        		break;
        	case 3:
				main(new String[0]);
				break;
        } 
	}
	
	private static void RegisterAdmin() throws SQLException {
		String name;
		String password;
		System.out.println("Enter your account name: ");
		name = sc.next();
		System.out.println("Please enter a password:"
				+ "\n(minimum of 8 chars; 1 digit, 1 lowercase, 1 uppercase, 1 special character)");
		password = sc.next();
		while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
		{
			System.out.println("Invalid password. Try again:");
			password=sc.next();
		}
		budi.createAdmin(name, password);
		System.out.println("Registered new admin successfully!");
		Admin u = null;
		u = budi.checkAdminLogin(name, password);
		AdminMenu(u);
	}
	
	private static void LoginAdmin() throws SQLException {
		System.out.println("Enter your account name:");
		String name = sc.next();
		System.out.println("Enter your password:");
		String password = sc.next();
		Admin u = null;
		u = budi.checkAdminLogin(name, password);
		if (u == null) {
			System.out.println("No admin registered with that name. \nYou must log in as an existing admin.\n");
			InitialAdminMenu();
		} else {
			System.out.println("Welcome back " + u.getName() + "!");
			AdminMenu(u);
		}
	}
	
	private static void AdminMenu(Admin u) throws SQLException {
		List<Account> lista = null;
		List<Customer> listc = null;
		String type = null;
		Account a = null;
		Customer c = null;
		int user_id;
		double amount;
		int edita;
		double net = 0;
		int deletec;
		System.out.println("Administrator Menu:"
        		+ "\n1 - View All Accounts"
        		+ "\n2 - View All Customers"
        		+ "\n3 - Create New Account"
        		+ "\n4 - Edit Existing Account"
        		+ "\n5 - Empty and Delete Account"
        		+ "\n6 - Create new Customer"
        		+ "\n7 - Edit Existing Customer"
        		+ "\n8 - Delete Customer"
        		+ "\n9 - View All Admins"
        		+ "\n0 - Main Menu");
		int choice = sc.nextInt();
		switch(choice) {
			case 1: //view accounts
				System.out.println("Viewing Accounts:");
				System.out.println(adi.getAccountList());
				AdminMenu(u);
				break;
			case 2: //view customers
				System.out.println("Viewing Customers:");
				System.out.println(budi.getCustomerList());
				AdminMenu(u);
				break;
			case 3: //create account
				a = null;
				System.out.println("What kind of account would you like?");
				type = sc.next();
				System.out.println("To which user will this account belong?");
		        user_id = sc.nextInt();
		        System.out.println("How much would you like to deposit into this new account?");
		        amount = sc.nextDouble();
		        adi.createAccount(type, amount, user_id);
		        lista = null;
				lista = adi.getUserAccounts(user_id);
				System.out.println("New account created: " + lista.get(lista.size()-1).getType() + " under user # " + lista.get(lista.size()-1).getUser() + ".");
				AccountMenu(lista.get(lista.size()-1));
				break;
			case 4: //edit account
				System.out.println("Choose the account ID you wish to edit: ");
				System.out.println(adi.getAccountList());
				edita = sc.nextInt();
				lista = null;
				a = null;
				lista = adi.getAccountList();
				for(Account acct : lista) {
					if(acct.getAccountid() != edita) {
						continue;
					}
					else {
						a = acct;
						AccountMenu(a);
					}
				}
				System.out.println("Sorry, that account doesn't exist.");
				AdminMenu(u);
				break;
			case 5: //empty and delete account
				System.out.println("Enter the account id to be deleted: ");
				System.out.println(adi.getAccountList());
				edita = sc.nextInt();
				lista = null;
				a = null;
				lista = adi.getAccountList();
				for(Account acct : lista) {
					if(acct.getAccountid() != edita) {
						continue;
					}
					else {
						a = acct;
						break;
					}
				}
		        adi.deleteAccount(edita);
		        System.out.println("The total amount of $" + a.getBalance() + " has been withdrawn and account #" + a.getAccountid() + " has been deleted.");
		        AdminMenu(u);
				break;
			case 6: //create customer
				String name;
				String password;
				System.out.println("Enter the new customer's username: ");
				name = sc.next();
				System.out.println("Please enter a password at least 6 characters long: ");
				password = sc.next();
				while(password.length() < 6)
				{
					System.out.println("Invalid password. Try again:");
					password=sc.next();
				}
				budi.createCustomer(name, password);
				System.out.println("Registered new customer successfully!");
				AdminMenu(u);
				break;
			case 7: //edit customer
				System.out.println("We regret to inform you that at this time, this"
						+ "functionality has been placed on hold for further improvement.");
				AdminMenu(u);
				break;
			case 8: //delete customer
				listc = null;
				c = null;
				System.out.println("Enter the user id of the customer you wish to delete: ");
				System.out.println(budi.getCustomerList());
				deletec = sc.nextInt();
				listc = budi.getCustomerList();
				for(Customer cust : listc) {
					if(cust.getUserId() != deletec) {
						continue;
					}
					else {
						c = cust;
						break;
					}
				}
				System.out.println(c);
				if(c == null) {
					System.out.println("It appears that customer doesn't exist.");
					AdminMenu(u);
				}
				else {
					lista = null;
					lista = adi.getUserAccounts(deletec);
					for(Account acct : lista) {
//						if(acct.getUser() != deletec) {
//							continue;
//						}
//						else {
							net += acct.getBalance();
							adi.deleteAccount(acct.getAccountid());
//						}
					}
				}
				budi.deleteCustomer(deletec);
				System.out.println("All remaining balances have been withdrawn and registered accounts have been deleted. Total withdrawn is $" + net + ".");
				System.out.println("Customer " + c.getName() + " has been successfully deleted.");
				AdminMenu(u);
				break;
			case 9: //view admins
				System.out.println("List of all Iron Bank admins:");
				budi.getAdminList();
				AdminMenu(u);
			case 0: //main menu
				main(new String[0]);
				break;				
		}
	}
	
	private static void AccountMenu(Account a) throws SQLException {
//		List<Account> lista = null;	
		double balance;
		double deposit;
		double withdrawal;
//		int deletea;
		System.out.println("\n~~Current Account Menu~~\n1 - View Balance \n2 - Deposit \n3 - Withdrawal \n4 - Delete Account \n5 - Main Menu");
		int choice = sc.nextInt();
		switch(choice) {
			case 1: //view balance
				if(a == null) {
					System.out.println("No account exists. Most likely was recently deleted."
							+ "\nExiting to login menu.");
					InitialCustomerMenu();
				} else {
				System.out.println("Your current balance is $" + a.getBalance() + ".");
				AccountMenu(a);
				}
				break;
			case 2: //deposit
				System.out.println("How much would you like to deposit?");
				deposit = sc.nextDouble();
				if (deposit > 0) {	
					balance = a.getBalance() + deposit;
					System.out.println("You deposited $" + deposit + ".");
					adi.updateAccountBalance(a.getAccountid(), balance);
					a.setBalance(balance);
					AccountMenu(a);
				} else {
					System.out.println("Only positive numbers, please.");
					AccountMenu(a);
				}
				break;
			case 3: //withdraw
				System.out.println("How much would you like to withdraw?");
				withdrawal = sc.nextDouble();
				if (withdrawal < a.getBalance()) {
					balance = a.getBalance() - withdrawal;
					System.out.println("You withdrew $" + withdrawal + ".");
					adi.updateAccountBalance(a.getAccountid(), balance);
					a.setBalance(balance);
					AccountMenu(a);
				} else {
					System.out.println("Insufficient funds available.");
					AccountMenu(a);
				}
				break;
			case 4: //delete account
				adi.deleteAccount(a.getAccountid());
		        System.out.println("The total amount of $" + a.getBalance() + " has been withdrawn and account #" + a.getAccountid() + " has been deleted.");
		        a = null;
		        AccountMenu(a);
				break;
			case 5: //main menu
				main(new String[0]);
				break;
		}
	}
}
