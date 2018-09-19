package com.revature.bank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;


public class Bank {
	static Scanner sc = new Scanner(System.in);
	static Map<String, Customer> customerMap = new HashMap<String, Customer>();
	static Map<String, Employee> employeeMap = new HashMap<String, Employee>();	
	static Map<String, Admin> adminMap = new HashMap<String, Admin>();
	static Map<String, Account> accountMap = new HashMap<String, Account>();
	static Customer customer;
	static Employee employee;
	static Admin admin;
	Connection conn = getConnection();

	
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection
					(prop.getProperty("url"),
					 prop.getProperty("usr"), 
					 prop.getProperty("password"));
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static void main(String[] args) {
		
		Connection conn = getConnection();
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			
			String s = "SELECT * FROM EMPLOYEE";
			PreparedStatement ps = conn.prepareStatement(s);
			ps.executeQuery(s);
			while (rs.next()) {
				System.out.println("TEST QUERY: " + rs.getString("FirstName"));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		String filename = "BankSerial.txt";
        Bank object = null;
        // Serialization 
        try
        {   
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
             
            // Method for serialization of object
            out.writeObject(object);
             
            out.close();
            file.close();
             
            System.out.println("Object has been serialized");
 
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }*/
        
        
        
        System.out.println("Choose account type or exit: (1)Customer (2)Employee (3)Exit");
        
        while (true) {
        int choice = sc.nextInt();
        switch (choice) {
        	case 1://Customer
        		InitialCustomerMenu();
                break;
        	case 2://Employee
        		InitialEmployeeMenu();
        		
        		break;
        	case 3:
        		System.exit(1);
        		
        	}break;
        }
	}
	public static void InitialCustomerMenu() {
		System.out.println("(1)Register (2)Login (3)Main Menu");
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
	public static void InitialEmployeeMenu() {
		System.out.println("(1)Register (2)Login (3)Main Menu");
        int choice = sc.nextInt();
        switch (choice) {
        	case 1://Register
        		RegisterEmployee();
        		break;
        	case 2://Login
        		LoginEmployee();
        		break;
        	case 3:
				main(new String[0]);
				break;
        }
        
	}
	private static void RegisterCustomer() {
		
		String password;
		System.out.println("Enter your account name: ");
		String name = sc.next();
		System.out.println("Please enter a password"
				+ "\nminimum of 8 chars; 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_] :");
		password = sc.next();
		while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
		{
			System.out.println("Invalid password try again :");
			password=sc.next();
		}
		Customer customer = new Customer(name, password);
		customerMap.put(name, customer);
		System.out.println("Registration Successful");
		CustomerMenu(customer);

		/* This prints the map containing name:password
	    Set<Entry<String, Customer>> st = customerMap.entrySet();   

	      for (Map.Entry <String,Customer> me:st)
	       {
	           System.out.print(me.getKey()+":");
	           System.out.println(me.getValue());
	       }*/
	}
	private static void RegisterEmployee() {
		
		String password;
		System.out.println("Enter your account name: ");
		String name = sc.next();
		System.out.println("Please enter a password"
				+ "\nminimum of 8 chars; 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_] :");
		password = sc.next();
		while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
		{
			System.out.println("Invalid password try again :");
			password=sc.next();
		}
		System.out.println("Is this an administrator account? Yes:No");
		String choice = sc.next();
		if (choice.toString().equalsIgnoreCase("yes")) {
			Admin admin = new Admin(name, password);
			adminMap.put(name, admin);
			System.out.println("Admin Registration Successful");
			AdminMenu(admin);
		} else if (choice.toString().equalsIgnoreCase("no")) {
			Employee employee = new Employee(name, password);
			employeeMap.put(name, employee);
			System.out.println("Employee Registration Successful");
			EmployeeMenu(employee);
		} else {
			System.out.println("Please enter Yes or No");
			RegisterEmployee();
		}
			
			

	}
	
	private static void CustomerMenu(Customer current) {

        String name = null;

       
        System.out.println("(1)View Accounts (2)Create Account (3)Main Menu");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Viewing Customer Accounts");
			    Set<Entry<String, Customer>> st = customerMap.entrySet();   

			      for (Map.Entry <String,Customer> me:st)
			       {
			           System.out.print(me.getKey()+":");
			           System.out.println(me.getValue());
			       }
			      CustomerMenu(current);
				break;
			case 2:
				System.out.println("Enter an account name: ");
				name = sc.next();
		        String[] usernames = new String[]{current.getName(), null};
		        Account account = new Account(0, null,  usernames, false);
				accountMap.put(name, account);
				AccountMenu(account);
				//
				break;
			case 3:
				main(new String[0]);
				break;
				
		}
	}
	private static void EmployeeMenu(Employee current) {
        String name = null;

       
        System.out.println("(1)View Accounts (2)Create Account (3)Main Menu");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Viewing Customer Accounts");
			    Set<Entry<String, Customer>> st = customerMap.entrySet();   

			      for (Map.Entry <String,Customer> me:st)
			       {
			           System.out.print(me.getKey()+":");
			           System.out.println(me.getValue());
			       }
			      
				System.out.println("Viewing Employee Accounts");
			    Set<Entry<String, Employee>> st2 = employeeMap.entrySet();   

			      for (Map.Entry <String,Employee> me:st2)
			       {
			           System.out.print(me.getKey()+":");
			           System.out.println(me.getValue());
			       }
			      EmployeeMenu(current);
				break;
			case 2:
				System.out.println("Enter an account name: ");
				name = sc.next();
		        String[] usernames = new String[]{current.getName(), null};
		        //String[] usernames = new String[]{current.getName(), name};
		        Account account = new Account(0, null,  usernames, false);
				accountMap.put(name, account);
				AccountMenu(account);
				//
				break;
			case 3:
				main(new String[0]);
				break;
				
		}
	}
	
	private static void AdminMenu(Admin current) {
        //double balance = 0;
        String name = null;
       
        System.out.println("(1)View Accounts (2)Edit an Account (3)Create Account (4)Main Menu");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Viewing Customer Accounts");
			    Set<Entry<String, Customer>> st = customerMap.entrySet();   

			      for (Map.Entry <String,Customer> me:st)
			       {
			           System.out.print(me.getKey()+":");
			           System.out.println(me.getValue());
			       }
			      
				System.out.println("Viewing Employee Accounts");
			    Set<Entry<String, Employee>> st2 = employeeMap.entrySet();   

			      for (Map.Entry <String,Employee> me:st2)
			       {
			           System.out.print(me.getKey()+":");
			           System.out.println(me.getValue());
			       }
			      
				System.out.println("Viewing Admin Accounts");
				Set<Entry<String, Admin>> st3 = adminMap.entrySet();   

				    for (Map.Entry <String,Admin> me:st3)
				    {
				           System.out.print(me.getKey()+":");
				           System.out.println(me.getValue());
				    }
				  AdminMenu(current);
			
			case 2:
				
				Stream.of(accountMap.keySet().toString())
                .forEach(System.out::println);
				System.out.println("Choose an account to edit ");
				
				String editaccount = sc.next();
				
				
		        
				
				
//				Set<Entry<String, Account>> acnt = accountMap.entrySet();
//				for (Map.Entry <String, Account> acc:acnt) 
//				{
//					System.out.println(acc.getKey()+" : "+acc.getValue());
//				}
				
				
				
				
				
				
				
					if (accountMap.containsKey(editaccount)) {
						Account accounttoedit = accountMap.get(editaccount);
						System.out.println("What would you like to edit? (1)Balance (2)Name (3)Account Name (4)Account Approval");
						int choice2 = sc.nextInt();
						switch (choice2) {
						case 1:
							System.out.println("Set the new balance");
							double editbalance = sc.nextDouble();
							accounttoedit.setBalance(editbalance);
							System.out.println("Balanced updated");
							break;
						case 2:
							System.out.println("Set the new name for this user ");
							String editname = sc.next();
							accounttoedit.setName(editname);
							System.out.println("Name updated");
							break;
						case 3:
							System.out.println("Set the new Account Names separated by a space ");
							String editaccountname = sc.next();
							String editaccountname2 = sc.next();
							String[] accnames = { editaccountname, editaccountname2};
							accounttoedit.setUsernames(accnames);
							System.out.println("Account Name updated");
							break;
						case 4:
							System.out.println("Do you want to approve this account? Yes:No");
							String accountapproval = sc.next();
							if (accountapproval.toString().equalsIgnoreCase("yes")) {
								accounttoedit.setApproved(true);
								System.out.println("Account approved");
							} else if (editaccount.toString().equalsIgnoreCase("no")) {
								System.out.println("Account unaltered");
							} else {
								System.out.println("Please enter Yes or No");
								AdminMenu(current);
							}
							AdminMenu(current);
							break;
						}AdminMenu(current);
					}
				break;
			case 3:
				System.out.println("Enter an account name: ");
				name = sc.next();
		        String[] usernames = new String[]{current.getName(), null};
		        Account account = new Account(0, null,  usernames, false);
				accountMap.put(name, account);
				AccountMenu(account);
				//
				break;
			case 4:
				main(new String[0]);
				break;
				
		}
	}
	
	
	private static void LoginCustomer() {
		System.out.println("Enter your account name: ");
		String name = sc.next();
		System.out.println("Enter your password: ");
		String password = sc.next();
		if (customerMap.containsKey(name)) {
			customer = customerMap.get(name);
			if (customer.getPassword().equals(password)) {
				System.out.println("Welcome back " + customer.getName() + ": ");
					CustomerMenu(customer);	
			}
		}

	}
	private static void LoginEmployee() {
		System.out.println("Enter your account name: ");
		String name = sc.next();
		System.out.println("Enter your password: ");
		String password = sc.next();
		if (employeeMap.containsKey(name)) {
			employee = employeeMap.get(name);
			if (employee.getPassword().equals(password)) {
				System.out.println("Welcome back " + employee.getName() + ": ");
					EmployeeMenu(employee);	
			}
		}

	}
	private static void AccountMenu(Account account) {
		System.out.println("(1)View Balance (2)Deposit (3)Withdrawal (4)Transfer funds (5)Main Menu ");	
		
		double balance = account.getBalance();
		
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Your balance is: $" + balance);
				AccountMenu(account);
				break;
			case 2:
				System.out.println("How much would you like to deposit? ");
				double deposit = sc.nextDouble();
				if (deposit > 0) {					
					account.setBalance(balance += deposit);
					System.out.println("You deposited $" + deposit + " your balance is now $" + balance);
					AccountMenu(account);
				} else {
					System.out.println("Try entering a positive number");
					AccountMenu(account);
				}
				break;
			case 3:
				System.out.println("Your balance is " + balance + " how much would you like to withdraw? ");
				double withdrawal = sc.nextDouble();
				if (withdrawal < balance) {
					account.setBalance(balance -= withdrawal);
					System.out.println("You withdrew $" + withdrawal + " your balance is now $" + balance);
					AccountMenu(account);
				} else {
					System.out.println("Insufficient funds");
					AccountMenu(account);
				}
				break;
			case 4:
				System.out.println("What is the account name to your transfering funds with? ");
				String accountnameoftransfer = sc.next();
				if (accountMap.containsKey(accountnameoftransfer)) {
					System.out.println("Account found!");
					System.out.println("Enter the amount of your transer");
					double transferamount = sc.nextDouble();
					if (balance < transferamount) {
						System.out.println("Transfering funds...");
						Account payee = accountMap.get(accountnameoftransfer);
						payee.setBalance(payee.getBalance() + transferamount ); 
						//Adjusting balance of payer account
						account.setBalance(balance - transferamount);
						AccountMenu(account);
					} else {
						System.out.println("Insufficient funds");
						AccountMenu(account);
					}
				} else {
					System.out.println("Account not found.");
					AccountMenu(account);
				}
				break;
			case 5:
				main(new String[0]);
				break;

				
		}
	}
}
