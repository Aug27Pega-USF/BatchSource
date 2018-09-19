package basicbank;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class Driver {
	static Scanner sc = new Scanner(System.in);
	static Map<String, Customer> customerMap = new HashMap<String, Customer>();
	static Map<String, Employee> employeeMap = new HashMap<String, Employee>();	
	static Map<String, Admin> adminMap = new HashMap<String, Admin>();
	static Map<String, Account> accountMap = new HashMap<String, Account>();
	static Customer customer;
	static Employee employee;
	static Admin admin;


	public static void main(String[] args) {
		String filename = "BankSerial.txt";
        Driver object = null;
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
             
            //System.out.println("Transaction history has been logged.");
 
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        
        
        System.out.println("Welcome to the Iron Bank!\nPlease be mindful, we are undergoing construction and as such"
        		+ " we cannot provide our full service at this time.\nThank you for your patience.");
        System.out.println("~~Main Menu~~ \nChoose user type or exit: \n1 - Customer \n2 - Employee \n3 - Exit");
        
        while (true) {
        int choice = sc.nextInt();
        switch (choice) {
        	case 1://Customer
        		InitialCustomerMenu();
                break;
        	case 2://Employee
        		//System.out.println("Employee Menu:");
        		InitialEmployeeMenu();
        		break;
        	case 3:
        		System.out.println("The Iron Bank thanks you for your patronage. Have a merry day!");
        		System.exit(1);
        	}break;
        }
	}
	
	public static void InitialCustomerMenu() {
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
	
	public static void InitialEmployeeMenu() {
		System.out.println("\n~~Employee Menu~~\n1 - Register \n2 - Login \n3 - Main Menu");
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
		System.out.println("Please enter a password at least 6 characters long: ");
		password = sc.next();
		while(password.length() < 6)
		{
			System.out.println("Invalid password. Try again:");
			password=sc.next();
		}
		Customer customer = new Customer(name, password);
		customerMap.put(name, customer);
		System.out.println("Registered successfully!");
		CustomerMenu(customer);
	}
	
	private static void RegisterEmployee() {
		
		String password;
		System.out.println("Enter your account name: ");
		String name = sc.next();
		System.out.println("Please enter a password:"
				+ "\n(minimum of 8 chars; 1 digit, 1 lowercase, 1 uppercase, 1 special character)");
		password = sc.next();
		while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
		{
			System.out.println("Invalid password. Try again:");
			password=sc.next();
		}
		System.out.println("Is this an administrator account? \nY - Yes \nN - No");
		String choice = sc.next();
		if (choice.toString().equalsIgnoreCase("y")) {
			Admin admin = new Admin(name, password);
			adminMap.put(name, admin);
			System.out.println("New admin registered successfully.");
			AdminMenu(admin);
		} else if (choice.toString().equalsIgnoreCase("n")) {
			Employee employee = new Employee(name, password);
			employeeMap.put(name, employee);
			System.out.println("New employee registered successfully.");
			EmployeeMenu(employee);
		} else {
			System.out.println("Please answer yes or no.");
			RegisterEmployee();
		}
	}
	
	private static void CustomerMenu(Customer current) {

        String name = null;

        System.out.println("Customer Menu: \n1 - View Accounts \n2 - Create New Account \n3 - Edit Existing Account \n4 - Main Menu");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Your accounts:");
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
				System.out.println("New account created: " + account.getName());
				AccountMenu(account);
				break;
			case 3:
				System.out.println("Choose an account to edit ");
				String editaccount = sc.next();
				if (accountMap.containsKey(editaccount)) {
					Account accounttoedit = accountMap.get(editaccount);
					AccountMenu(accounttoedit);
				}
				else {
					System.out.println("Account not found.");
					CustomerMenu(current);
				}
				break;
			case 4:
				main(new String[0]);
				break;	
		}
	}
	
	private static void EmployeeMenu(Employee current) {
        String name = null;
        
        System.out.println("Employee Menu: \n1 - View All Accounts \n2 - Create New Account \n3 - Main Menu");
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
		        Account account = new Account(0, null,  usernames, false);
				accountMap.put(name, account);
				AccountMenu(account);
				break;
			case 3:
				main(new String[0]);
				break;
		}
	}
	
	private static void AdminMenu(Admin current) {
        //double balance = 0;
        String name = null;
       
        System.out.println("Administrator Menu: \n1 - View All Accounts \n2 - Edit Existing Account \n3 - Create New Account \n4 - Main Menu");
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
				Set<Entry<String, Employee>> st3 = employeeMap.entrySet();   

				    for (Map.Entry <String,Employee> me:st3)
				    {
				           System.out.print(me.getKey()+":");
				           System.out.println(me.getValue());
				    }
				  AdminMenu(current);
			
			case 2:
				System.out.println("Choose an account to edit ");
				String editaccount = sc.next();
				if (accountMap.containsKey(editaccount)) {
					Account accounttoedit = accountMap.get(editaccount);
					System.out.println("What would you  like to do? \n1 - Update Balance \n2 - Change Name \n3 - Edit Account Name \n4 - Approve Accounts");
					int choice2 = sc.nextInt();
					switch (choice2) {
					case 1:
						System.out.println("Set the new balance:");
						double editbalance = sc.nextDouble();
						accounttoedit.setBalance(editbalance);
						System.out.println("Balance updated.");
						break;
					case 2:
						System.out.println("Set the new name for this user:");
						String editname = sc.next();
						accounttoedit.setName(editname);
						System.out.println("Name updated.");
						break;
					case 3:
						System.out.println("Set the new Account Names separated by a space:");
						String editaccountname = sc.next();
						String editaccountname2 = sc.next();
						String[] accnames = { editaccountname, editaccountname2};
						accounttoedit.setUsernames(accnames);
						System.out.println("Account Name updated.");
						break;
					case 4:
						System.out.println("Do you want to approve this account? \nY - Yes \nN - No");
						String accountapproval = sc.next();
						if (accountapproval.toString().equalsIgnoreCase("y")) {
							accounttoedit.setApproved(true);
							System.out.println("Account approved.");
						} else if (editaccount.toString().equalsIgnoreCase("n")) {
							System.out.println("Account unaltered.");
						} else {
							System.out.println("Please answer yes or no.");
							AdminMenu(current);
						}
						AdminMenu(current);
						break;
					}
				}
				break;
			case 3:
				System.out.println("Enter an account name: ");
				name = sc.next();
		        String[] usernames = new String[]{current.getName(), null};
		        Account account = new Account(0, null,  usernames, false);
				accountMap.put(name, account);
				AccountMenu(account);
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
				System.out.println("Welcome back " + customer.getName() + "!");
					CustomerMenu(customer);	
			}
			else {
				System.out.println("Error: wrong password. Try logging in again.");
				InitialCustomerMenu();
			}
		}
		else {
			System.out.println("It seems no customer exists under that name.\nYou can either create"
					+ " a new customer account or log in as an existing customer.\n");
			main(new String[0]);
		}
	}
	
	private static void LoginEmployee() {
		System.out.println("Enter your account name:");
		String name = sc.next();
		System.out.println("Enter your password:");
		String password = sc.next();
		if (employeeMap.containsKey(name)) {
			employee = employeeMap.get(name);
			if (employee.getPassword().equals(password)) {
				System.out.println("Welcome back " + employee.getName() + "!");
					EmployeeMenu(employee);	
			}
			else {
				System.out.println("Error: wrong password. Try logging in again.");
				InitialEmployeeMenu();
			}
		}
		else {
			System.out.println("No employee registered with that name.\nYou must log in as"
					+ " an existing employee.\n");
			main(new String[0]);
		}
	}
	
	private static void AccountMenu(Account account) {
		System.out.println("\n~~Current Account Menu~~\n1 - View Balance \n2 - Deposit \n3 - Withdrawal \n4 - Transfer funds \n5 - Main Menu");	
		
		double balance = account.getBalance();
		
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Your balance is: $" + balance + ".");
				AccountMenu(account);
				break;
			case 2:
				System.out.println("How much would you like to deposit?");
				double deposit = sc.nextDouble();
				if (deposit > 0) {					
					account.setBalance(balance += deposit);
					System.out.println("You deposited $" + deposit + ". Your balance is now $" + balance + ".");
					AccountMenu(account);
				} else {
					System.out.println("Try entering a positive number.");
					AccountMenu(account);
				}
				break;
			case 3:
				System.out.println("Your balance is " + balance + ". How much would you like to withdraw?");
				double withdrawal = sc.nextDouble();
				if (withdrawal < balance) {
					account.setBalance(balance -= withdrawal);
					System.out.println("You withdrew $" + withdrawal + ". Your balance is now $" + balance + ".");
					AccountMenu(account);
				} else {
					System.out.println("Error: Insufficient funds available.");
					AccountMenu(account);
				}
				break;
			case 4:
				System.out.println("What is the second account name for transfer?");
				String accountnameoftransfer = sc.next();
				if (accountMap.containsKey(accountnameoftransfer)) {
					System.out.println("Account found!");
					System.out.println("Enter the amount to transfer:");
					double transferamount = sc.nextDouble();
					if (balance < transferamount) {
						System.out.println("Transfering funds...");
						Account payee = accountMap.get(accountnameoftransfer);
						payee.setBalance(payee.getBalance() + transferamount ); 
						//Adjusting balance of payer account
						account.setBalance(balance - transferamount);
						AccountMenu(account);
					} else {
						System.out.println("Error: Insufficient funds available in withdrawing account.");
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
