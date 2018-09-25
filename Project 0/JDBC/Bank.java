package com.revature.JDBC;

import java.sql.SQLException;
import java.util.Scanner;

public class Bank {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String username;
		String password;
		String adminid;
		String result;
		int Account_ID;
		System.out.println("Login or register: (1 for login/2 for register)"); //gives user a choice
		result = scan.next(); //the result is whatever input the user inputted
		switch (result){// cases based off of result
		case "1": //if result was "1"
			System.out.println("Employee or Customer: (1 for employee/2 for customer)"); //gives another choice
			result = scan.next();
			switch (result) { //cases based off second input of result
			case "1":
				System.out.println("Username: ");
				username = scan.next(); //inputs username
				if(username != null) { //if username is not null
					System.out.println("Password: ");
					password = scan.next();// if password is not null
					if(password != null) {
						System.out.println("Admin ID: ");
						adminid = scan.next();
						if(adminid != null) //is admin id is not null
						{
							System.out.println("What would you like to do: ");
							System.out.println("1: Create Account");
							System.out.println("2: Update User");
							System.out.println("3: Delete User");
							System.out.println("4: View Account");
							System.out.println("5: Logout");
							result = scan.next();
							switch(result) {
							case "1": //if 1
								Registered_UserDAOImpl rudi = new Registered_UserDAOImpl();
								System.out.println(rudi.createAccountCustomer(Account_ID));//used to implement create account customer
							case "2": //if 2
								// would be used to implement update user
							case "3": //if 3
								Registered_UserDAOImpl rudi3 = new Registered_UserDAOImpl();
								System.out.println(rudi3.deleteAccount());// would implement delete account to delete every account
							case "4": //if 4
								Registered_UserDAOImpl rudi4 = new Registered_UserDAOImpl();
								try {
									System.out.println(rudi4.viewAccount()); //views account from the action view account
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							case "5"://if 5
								// user would logout
							default://anything else
								System.out.println("I'm sorry, that is not an option. Try 1, 2, 3, 4, or 5 ");
							}
						}
					}
				}
			case "2"://if 2 from second input
				System.out.println("Username: ");
				username = scan.next();//scans username
				if(username != null) {//if username is not null
					System.out.println("Password: ");
					password = scan.next();
					if(password != null) {//if password is not null
						System.out.println("What would you like to do: ");
						System.out.println("1: Create Account");
						System.out.println("2: Withdraw/Deposit");
						System.out.println("3: Delete Account");
						System.out.println("4: View Account");
						System.out.println("5: Logout");
						result = scan.next();
						switch(result) {
						case "1":
							//would implement create account customer
						case "2":
							// would be used to withdraw or deposit from account
						case "3":
							// would implement delete account to delete every account
						case "4":
							//views account from the action view account
						case "5":
							// user would logout
						default:
							System.out.println("I'm sorry, that is not an option. Try 1, 2, 3, 4, or 5 "); //try another option
						}
					}
				}
			default:
				System.out.println("I'm sorry, that is not an option. Try 1 or 2 "); //to try another option
			}
		case "2": //if 2 from first input
			Unregistered_UserDAOImpl uudi = new Unregistered_UserDAOImpl();
			System.out.println("Desired username: ");
			username = scan.next();//username becomes input for username
			System.out.println("Desired password: ");
			password = scan.next();// password becomes input for password
			try {
				uudi.createCustomer(username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		default: //any other choice for first input
			System.out.println("I'm sorry, that is not an option. Try 1 or 2 ");
			break;
		}

	}

}
