package com.revature.driver;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankRegister {
	public static Scanner s= new Scanner(System.in);
	public static void createUser()
	{
				
		String user;
	    String password;
		String fullName;
		String phone;
		String accountType;
		double balance;
		boolean active;
		
		//Scanner s= new Scanner(System.in);
	//	Account a= new Account();
		//String filename="BankAccounts.txt";
		
		//get user input for new account information.
		try {
			System.out.print("Username: ");
		String uname=s.nextLine();
		//System.out.println("");
		System.out.print("Password: ");
		String pswrd=s.nextLine();
		System.out.print("");
		System.out.print("First Name: ");
		String fname=s.nextLine();
		System.out.print("Last Name: ");
		String lname=s.nextLine();
		double bal=0;
		do {
			try {
		System.out.print("Starting Balance: ");
		bal=s.nextDouble();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please use a number.");
			}
			s.nextLine();
		}while(bal<=0);
		
		//Account a= new Account(uname,pswrd,fname,active, p,bal,actype);
		
		//Account Account(user, password, fullName, active, phone, balance, accountType);
		
	//	IOBank.accountList.add(a);
		
	//	IOBank.writeAccountFile();
		
		System.out.println("Registered User Saved");
		
//		System.out.println("Would you like to Login? (Y/N)");
//		String input= s.nextLine();
//		switch(input)
//		{
//		case "Y":
//			BankLogin.checkLogin();
//			break;
//		case "N":
//			
//			break;			
//		
//		}
		//IOBank.readBankFile();
		//System.out.println(IOBank.accountList.get(0).getUsername());
		//System.out.println(IOBank.accountList.size());
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		
		
	}
}
