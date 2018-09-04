package com.revature.bank;

import java.util.Scanner;

import com.revature.exceptions.NegativeNumberException;



public class Transactions {

	static Scanner s= new Scanner(System.in);
	public static void selectAction(int idx)
	{
		
		IOBank.readBankFile();
		String uname=IOBank.accountList.get(idx).getUsername();
		String passowrd=IOBank.accountList.get(idx).getPassword();
		String name=IOBank.accountList.get(idx).getFullName();
		double balance=IOBank.accountList.get(idx).getBalance();
		String phone=IOBank.accountList.get(idx).getPhone();
		String actType=IOBank.accountList.get(idx).getAccountType();
		
		if(actType.equals("Client"))
		{
		System.out.println("Will you do now "+name+"? (Withdraw/W, or Deposit/D)");
		String input= s.nextLine();
		switch(input)
		{
		case "D":
			deposit(balance);
			break;
		case "W":
			withdraw(balance);
			break;			
		
		}
	}
	else if(actType.equals("Employee"))
		{
		System.out.println("Will you do now "+name+"? (Withdraw/W, Deposit/D, View Accounts/V or Approve Accounts/A)");
		String input= s.nextLine();
		switch(input)
		{
		case "D":
			deposit(balance);
			break;
		case "W":
			withdraw(balance);
			break;			
		case "V":
			//method goes here
			break;			
		case "A":
			//method goes here
			break;			
		
		
		}
	}
		if(actType.equals("Admin"))
		{
			System.out.println("Will you do now "+name+"? (Withdraw/W, Deposit/D, View Accounts/V, Approve Accounts/A) or Cancel Accounts");
			String input= s.nextLine();
			switch(input)
			{
			case "D":
				deposit(balance);
				break;
			case "W":
				withdraw(balance);
				break;			
			case "V":
				System.out.println(IOBank.accountList);
				break;			
			case "A":
				//method goes here
				break;			
			case "C":
				//method goes here
				break;			
			}
			
		}
	}
	
	public static void withdraw(double balance)
	{
		try {System.out.println("Current Balance: "+balance);
		System.out.println("How much will you withdraw?");
		double w=s.nextDouble();
		if(w<0)
		{
			throw new NegativeNumberException();
		}
		balance-=w;
			System.out.println("Current Balance: "+balance);
			IOBank.accountList.get(0).setBalance(balance);
		}
		catch(NegativeNumberException e)
		{
			System.out.println("You can not use negative numbers!");
		} 
			
		
			
	}
	
	public static void deposit(double balance) 
	{
		
		try {
		System.out.println("Current Balance: "+balance);
		System.out.println("How much will you deposit?");
		double d=s.nextDouble();
		if(d<0)
		{
			throw new NegativeNumberException();
		}
		
		balance+=d;
		System.out.println("Current Balance: "+balance);
		IOBank.accountList.get(0).setBalance(balance);
		}
		catch(NegativeNumberException e)
		{
			System.out.println("You can not use negative numbers!");
		}
			
		}
	
	
	public static void approve()
	{
		System.out.println();
		
		for(int i=0;i<IOBank.accountList.size();i++)
		{
			if(IOBank.accountList.get(i).isActiveAct()==false)
			{
				String uname=IOBank.accountList.get(i).getUsername();
				//String passowrd=IOBank.accountList.get(0).getPassword();
				String name=IOBank.accountList.get(i).getFullName();
				double balance=IOBank.accountList.get(i).getBalance();
				String phone=IOBank.accountList.get(i).getPhone();
				String actType=IOBank.accountList.get(i).getAccountType();
				System.out.println("Will you approve of this account?");
				System.out.println("Username: "+uname);
				System.out.println("Name: "+name);
				System.out.println("Phone: "+phone);
				System.out.println("Balance: "+balance);
				System.out.println("Account Type: "+actType);
				System.out.println("(Aprrove/A, or No/N)");
				String input= s.nextLine();
				switch(input)
				{
				case "A":
					IOBank.accountList.get(i).setActiveAct(true);
					break;
				case "N":
					
					break;			
				}
				
			}
		}
	}
}
