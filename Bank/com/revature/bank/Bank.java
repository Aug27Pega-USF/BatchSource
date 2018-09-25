package com.revature.bank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
//execute query for select
//execute update for DML

public class Bank {
	static Scanner sc = new Scanner(System.in);
	static Map<String, Customer> customerMap = new HashMap<String, Customer>();
	static Map<String, Employee> employeeMap = new HashMap<String, Employee>();	
	static Map<String, Admin> adminMap = new HashMap<String, Admin>();
	static Map<String, Account> accountMap = new HashMap<String, Account>();
	static Customer customer;
	static Employee employee;
	static Admin admin;
	static Account account;
	static Connection conn = getConnection();
	static Statement stmt;
	static ResultSet rs = null;
	static PreparedStatement ps;
	
	
	
	
	public static Connection getConnection() {
		
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection
					(prop.getProperty("url"),
					 prop.getProperty("usr"), 
					 prop.getProperty("password")
					 );
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
	
	
	
	public static void main(String[] args) throws SQLException {
		
		try {
			stmt = conn.createStatement();
			/*rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			
			String s = "SELECT * FROM EMPLOYEE";
			PreparedStatement ps = conn.prepareStatement(s);
			ps = conn.prepareStatement(s);
			ps.executeQuery(s);
			while (rs.next()) {
				System.out.println("TEST QUERY: " + rs.getString("FirstName"));
			}*/
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

        
        
        
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
	public static void InitialCustomerMenu() throws SQLException {
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
	public static void InitialEmployeeMenu() throws SQLException {
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
	private static void RegisterCustomer() throws SQLException {
		
		String password;
		System.out.println("Enter your user name: ");
		String name = sc.next();
		System.out.println("Please enter a password"
				+ "\nminimum of 8 chars; 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_] :");
		password = sc.next();
		while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
		{
			System.out.println("Invalid password try again :");
			password=sc.next();
		}
		
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (NAME, USERTYPE, PASSWORD) "
				+ "VALUES (?,?,?)")) {
	        stmt.setString(1, name);
	        stmt.setString(2, "Customer");
	        stmt.setString(3, password);
	        stmt.executeUpdate();
	      }
		try (PreparedStatement stmt = conn.prepareStatement("SELECT USERID FROM USERS WHERE NAME = ?" 
	        + " AND USERTYPE = 'Customer' and Password = ?")) {
	        stmt.setString(1, name);
	        stmt.setString(2, password);
	        rs = stmt.executeQuery();
	        rs.next();
	        customer = new Customer(name, password, rs.getString("USERID"));
	        customerMap.put(name, customer);
	        /*System.out.println("Customer inside tryblock: " + customer);
	        System.out.println("rs is: " + rs.getString("USERID"));
	        System.out.println("customer.getUserID(): " + customer.getUserID());*/
	      }
		
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
	private static void RegisterEmployee() throws SQLException {
		
		String password;
		System.out.println("Enter your user name: ");
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
			
			try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERS (NAME, USERTYPE, PASSWORD) "
					+ "VALUES (?,?,?)")) {
		        stmt.setString(1, name);
		        stmt.setString(2, "Admin");
		        stmt.setString(3, password);
		        stmt.executeUpdate();
		      }
			try (PreparedStatement stmt = conn.prepareStatement("SELECT USERID FROM USERS WHERE NAME = ?" 
		        + " AND USERTYPE = 'Admin' and Password = ?")) {
		        stmt.setString(1, name);
		        stmt.setString(2, password);
		        rs = stmt.executeQuery();
		        rs.next();
		        admin = new Admin(name, password, rs.getString("USERID"));
		        adminMap.put(name, admin);
		      }
			
			System.out.println("Admin Registration Successful");
			AdminMenu(admin);
			
		} else if (choice.toString().equalsIgnoreCase("no")) {


			try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERS (NAME, USERTYPE, PASSWORD) "
					+ "VALUES (?,?,?)")) {
		        stmt.setString(1, name);
		        stmt.setString(2, "Employee");
		        stmt.setString(3, password);
		        stmt.executeUpdate();
		      }
			try (PreparedStatement stmt = conn.prepareStatement("SELECT USERID FROM USERS WHERE NAME = ?" 
		        + " AND USERTYPE = 'Employee' and Password = ?")) {
		        stmt.setString(1, name);
		        stmt.setString(2, password);
		        rs = stmt.executeQuery();
		        rs.next();
		        employee = new Employee(name, password, rs.getString("USERID"));
		        employeeMap.put(name, employee);
		      }
			
			System.out.println("Employee Registration Successful");
			EmployeeMenu(employee);
		} else {
			System.out.println("Please enter Yes or No");
			RegisterEmployee();
		}
	}
	
	private static void CustomerMenu(Customer current) throws SQLException {

        String name = null;

       
        System.out.println("(1)View Accounts (2)Create Account (3)Main Menu");
        int choice = sc.nextInt();
		switch(choice) {
			case 1:

				System.out.println("Viewing Customer Accounts");
			    /*Set<Entry<String, Customer>> st = customerMap.entrySet();   

			      for (Map.Entry <String,Customer> me:st)
			       {
			           System.out.print(me.getKey()+":");
			           System.out.println(me.getValue());
			       }*/
				try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE USERID = ?")) {			
					
					stmt.setString(1, current.getUserID());
					
				    rs = stmt.executeQuery();
				    
				    while (rs.next()) {
				    	System.out.println(rs.getString("NAME"));
				    }	    	
			        			       
				  }
				
				CustomerMenu(current);
				break;
			case 2:
				
				System.out.println("Enter an account name: ");
				name = sc.next();
				//System.out.println("current.getUserID() is: " + current.getUserID());
				String myUserID = current.getUserID();
				try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO ACCOUNT (USERID, BALANCE, NAME) "
						+ "VALUES (?,?,?)")) {
			        stmt.setString(1, myUserID);
			        stmt.setDouble(2, 0.00);
			        //stmt.setString(3, "0");
			        stmt.setString(3, name);
			        stmt.executeUpdate();
			      }
				try (PreparedStatement stmt = conn.prepareStatement("SELECT ACCOUNTID FROM ACCOUNT WHERE USERID = ?" 
				        + " AND NAME = ?")) {
				        stmt.setString(1, myUserID);
				        stmt.setString(2, name);
				        rs = stmt.executeQuery();
				        rs.next();
				        account = new Account(current.getUserID(), 0.00,rs.getInt("ACCOUNTID"),name );
				        accountMap.put(name, account);	
				      }
				
				System.out.println("Account Created");
				AccountMenu(account);				
				break;
			case 3:
				main(new String[0]);
				break;
				
		}
	}
	private static void EmployeeMenu(Employee current) throws SQLException {
        String name = null;

       
        System.out.println("(1)View Accounts (2)Create Account (3)Main Menu");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Viewing Customer Accounts");
			    //Set<Entry<String, Customer>> st = customerMap.entrySet();   
			 	try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE USERTYPE = ?")) {
					stmt.setString(1, "Customer");
				    rs = stmt.executeQuery();
				    while (rs.next()) {
				    	System.out.println(rs.getString("NAME"));
				    }	    	       
				  }
			    
                /*for (Map.Entry <String,Customer> me:st)
			       {
			           System.out.print(me.getKey()+":");
			           System.out.println(me.getValue());
			       }*/
			      
				System.out.println("Viewing Employee Accounts");
				try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE USERTYPE = ?")) {
					stmt.setString(1, "Employee");
				    rs = stmt.executeQuery();
				    while (rs.next()) {
				    	System.out.println(rs.getString("NAME"));
				    }	    	       
				  }
				
			    /*Set<Entry<String, Employee>> st2 = employeeMap.entrySet();  
			      for (Map.Entry <String,Employee> me:st2)
			       {
			           System.out.print(me.getKey()+":");
			           System.out.println(me.getValue());
			       }*/
			      EmployeeMenu(current);
				break;
			case 2:
				System.out.println("Enter an account name: ");
				name = sc.next();
		        //String[] usernames = new String[]{current.getName(), null};
		       	
				try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO ACCOUNT (USERID, BALANCE, NAME) "
						+ "VALUES (?,?,?)")) {
			        stmt.setString(1, current.getUserID());
			        stmt.setDouble(2, 0.00);
			        //stmt.setString(3, "0");
			        stmt.setString(3, name);
			        stmt.executeUpdate();
			      }
				try (PreparedStatement stmt = conn.prepareStatement("SELECT ACCOUNTID FROM ACCOUNT WHERE USERID = ?" 
				        + " AND NAME = ?")) {
				        stmt.setString(1, current.getUserID());
				        stmt.setString(2, name);
				        rs = stmt.executeQuery();
				        rs.next();
				        account = new Account(current.getUserID(), 0.00,rs.getInt("ACCOUNTID"),name );
				        accountMap.put(name, account);	
				      }
				
		        //Account account = new Account(current.getUserID(),0.00,0,name );
				accountMap.put(name, account);
				System.out.println("Administrator account created.");
				AccountMenu(account);
				
				break;
			case 3:
				main(new String[0]);
				break;
				
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void AdminMenu(Admin current) throws SQLException {
        //double balance = 0;
        String name = null;
       
        System.out.println("(1)View Accounts (2)Edit an Account (3)Create Account (4)Main Menu");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Viewing All Accounts");
			    //Set<Entry<String, Admin>> st = adminMap.entrySet();   
			   
				try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ACCOUNT")) {
					//stmt.setString(1, "Customer");
				    rs = stmt.executeQuery();
				    while (rs.next()) {
				    	System.out.println(rs.getString("USERID") + " : " + rs.getString("NAME"));
				    }	    	       
				  }			    
				
				  AdminMenu(current);
			
			case 2:
				
				System.out.println("Choose an account to edit : Enter the UserID");
				
				String editaccount = sc.next();
				///if (accountMap.containsKey(editaccount)) {
					
				try (PreparedStatement stmt = conn.prepareStatement
						("SELECT * FROM ACCOUNT WHERE USERID = ?")) {
					stmt.setString(1, editaccount);
				    rs = stmt.executeQuery();
				  
				    if (rs.next()){
				    	System.out.println("Inside of : if (rs.next()) ");
						//Account accounttoedit = accountMap.get(editaccount);

						System.out.println("What would you like to edit? (1)Balance (2)Name (3)Account Name");
						int choice2 = sc.nextInt();
						switch (choice2) {
						case 1:
							System.out.println("Set the new balance");
							double editbalance = sc.nextDouble();
							//TODO SQL set new balance
							
							try (PreparedStatement stmt2 = conn.prepareStatement("UPDATE ACCOUNT SET BALANCE = ?"
									+ "WHERE USERID = ?)")) {
								System.out.println("Inside update:");
						        stmt2.setDouble(1, editbalance);
						        stmt2.setString(2, editaccount);
						        stmt2.executeUpdate();
						      }
							try (PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM ACCOUNT "
									+ "WHERE USERID = " + editaccount +")")) {
						        stmt2.setDouble(1, editbalance);
						        stmt2.executeUpdate();
						      }
						
							
							
							//accounttoedit.setBalance(editbalance);
							System.out.println("Balanced updated");
							break;
						case 2:
							System.out.println("Set the new account name for this user ");
							String editname = sc.next();
							//TODO SQL set new name 
							
							
							//accounttoedit.setName(editname);
							System.out.println("Name updated");
							break;
						case 3:System.out.println("Account Name updated");
							break;
						case 4:
							break;
						}
				    }//end of if(rs.next())
				    
				}
			case 3:
				System.out.println("Enter an account name: ");
				name = sc.next();
		        //String[] usernames = new String[]{current.getName(), null};

		        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO ACCOUNT (USERID, BALANCE, ACCOUNTID, NAME) "
						+ "VALUES (?,?,?,?)")) {
			        stmt.setString(1, current.getUserID());
			        stmt.setDouble(2, 0.00);
			        stmt.setString(3, "0");
			        stmt.setString(4, name);
			        stmt.executeUpdate();
			      }
				
		        Account account = new Account(current.getUserID(), 0.00,0, name );
				accountMap.put(name, account);
		        System.out.println("Administrator account created.");
				AccountMenu(account);
				
				break;
			case 4:
				main(new String[0]);
				break;
				
		
		//}
	}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void LoginCustomer() throws SQLException {
		System.out.println("Enter your user name: ");
		String name = sc.next();
		System.out.println("Enter your password: ");
		String password = sc.next();
		
		try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE NAME = ?" 
		        + " AND PASSWORD = ?")) {
		        stmt.setString(1, name);
		        stmt.setString(2, password);
		        rs = stmt.executeQuery();
		        rs.next();
		        customer = new Customer(rs.getString("NAME"),rs.getString("PASSWORD"),rs.getString("USERID"));
		        customerMap.put(name, customer);
		        System.out.println("Welcome back " + rs.getString("NAME"));
		        CustomerMenu(customer);
		      }catch (SQLException e){
		    	  System.out.println("Your login combination is invalid");
		    	  LoginCustomer();
		      }
		
		/*if (customerMap.containsKey(name)) {
			customer = customerMap.get(name);
			if (customer.getPassword().equals(password)) {
				System.out.println("Welcome back " + customer.getName() + ": ");
					CustomerMenu(customer);	
			}
		}*/

	}
	private static void LoginEmployee() throws SQLException {
		System.out.println("Enter your account name: ");
		String name = sc.next();
		System.out.println("Enter your password: ");
		String password = sc.next();

		try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE NAME = ?" 
		        + " AND PASSWORD = ?")) {
		        stmt.setString(1, name);
		        stmt.setString(2, password);
		        rs = stmt.executeQuery();
		        rs.next();
		        
		        if (rs.getString("USERTYPE").equals("Admin")){
		        	adminMap.put(name, admin);
		        	admin = new Admin(rs.getString("NAME"),rs.getString("PASSWORD"),rs.getString("USERID"));
		        	AdminMenu(admin);
		        	System.out.println("Welcome back " + rs.getString("NAME"));
		        } else {
		        	employeeMap.put(name, employee);
		        	employee = new Employee(rs.getString("NAME"),rs.getString("PASSWORD"),rs.getString("USERID"));
		        	System.out.println("Welcome back " + rs.getString("NAME"));
		        	EmployeeMenu(employee);
		        }
		        
		      }/*catch (SQLException e){
		    	  System.out.println("Your login combination is invalid " + e);
		    	  LoginEmployee();
		      }
		*/
		
		/*if (employeeMap.containsKey(name)) {
			employee = employeeMap.get(name);
			if (employee.getPassword().equals(password)) {
				System.out.println("Welcome back " + employee.getName() + ": ");
					EmployeeMenu(employee);	
			}
		}*/

	}
	private static void AccountMenu(Account account) throws SQLException {
		System.out.println("(1)View Balance (2)Deposit (3)Withdrawal (4)Transfer funds (5)Main Menu ");	
		//TODO SQL new balance
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
				//TODO Possibly remove
				
				
				
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
