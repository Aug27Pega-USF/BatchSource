package com.revature.bank;


import java.util.Scanner;
import com.revature.account.*;


public class Register {

	public static void setUser () {
		
		/*
		 * String user;
		 * String password;
		String fullName;
		String phone;
		String accountType;
		double balance;
		boolean active;
		
		Scanner s= new Scanner(System.in);
		Account a= new Account();
		String filename="BankAccounts.txt";
		try {
			System.out.print("Username: ");
		String uname=s.nextLine();
		//System.out.println("");
		System.out.print("Password: ");
		String pswrd=s.nextLine();
		System.out.print("");
		System.out.print("Full Name: ");
		String fname=s.nextLine();
		System.out.print("Phone: ");
		String p=s.nextLine();		
		System.out.print("Account type (Type: Client, Employee, or Admin) : ");
		String actype=s.nextLine();
	//	System.out.print("Starting Balance: ");
	//	double b=s.nextDouble();
		
		
				//a.setActiveAct(false);
		a.setUsername(uname);
		a.setPassword(pswrd);
		a.setFullName(fname);
		a.setPhone(p);		
		//a.setBalance(b);
		a.setAccountType(actype);
		
		if(a.getAccountType().equals("Client"))
		{
			a.setActiveAct(false);	
		}
		else
		{
			a.setActiveAct(true);	
		}
		
		user=a.getUsername();
		password = a.getPassword();
		fullName=a.getFullName();
		phone=a.getPhone();
		//balance=a.getBalance();
		balance=100;
		active= a.isActiveAct();
		accountType= a.getAccountType();		
		//System.out.println(a.getUsername());
		//System.out.println(a.getPassword());
		
		a.saveAccount(user, password, fullName, active, phone, balance, accountType, filename);
		
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		 * 
		 */
		
		
		
	}
	
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
		try {
			System.out.print("Username: ");
		String uname=s.nextLine();
		//System.out.println("");
		System.out.print("Password: ");
		String pswrd=s.nextLine();
		System.out.print("");
		System.out.print("Full Name: ");
		String fname=s.nextLine();
		System.out.print("Phone: ");
		String p=s.nextLine();		
		System.out.print("Account type (Type: Client, Employee, or Admin) : ");
		String actype=s.nextLine();
		System.out.print("Starting Balance: ");
		double bal=s.nextDouble();
		
		
		if(actype.equals("Client"))
		{
			active=false;	
		}
		else
		{
			active=true;
		}
		
		Account a= new Account(uname,pswrd,fname,active, p,bal,actype);
		
		//Account Account(user, password, fullName, active, phone, balance, accountType);
		
		IOBank.accountList.add(a);
		
		IOBank.writeAccountFile();
		
		IOBank.readBankFile();
		System.out.println(IOBank.accountList.get(0).getUsername());
		System.out.println(IOBank.accountList.size());
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		
		
	}
}
