package com.revature.bank;

import java.util.InputMismatchException;
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
		boolean isTrue=false;
		
		if(actType.equals("Client"))
		{
		
		System.out.println("What will you do now "+name+"? (Withdraw/W, or Deposit/D)");
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
		System.out.println("What will you do now "+name+"? (Withdraw/W, Deposit/D, View Accounts/V or Approve Accounts/A)");
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
			System.out.println("What will you do now "+name+"? (Withdraw/W, Deposit/D, View Accounts/V, Approve Accounts/A) or Cancel Accounts");
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
		double w=0;
		do
		{
		try 
		{
		
		System.out.println("Current Balance: "+balance);
		System.out.println("How much will you withdraw?");
		w=s.nextDouble();
		if(w<0)
		{
			throw new NegativeNumberException();
		}
		else if(w>balance){
			System.out.println("The withdraw amount is greater than your current balance");
			//withdraw(balance);
		}
		else
		{
			balance-=w;
			System.out.println("Current Balance: "+balance);
			IOBank.accountList.get(0).setBalance(balance);
			//IOBank.writeAccountFile();
		}
		}
		catch(NegativeNumberException e)
		{
			System.out.println("You can not use negative numbers!");
			//withdraw(balance);
		} 
		catch(InputMismatchException e)
		{
			System.out.println("Please use numbers.");
			//withdraw(balance);
		}
		s.nextLine();
		}
		while(w<=0);
					
	}
	
	public static void deposit(double balance) 
	{
		double d=0;
	do {
		try {
			
		System.out.println("Current Balance: "+balance);
		System.out.println("How much will you deposit?");
		d=s.nextDouble();
		if(d<0)
		{
			throw new NegativeNumberException();
		}
		else
		{
		balance+=d;
		System.out.println("Current Balance: "+balance);
		IOBank.accountList.get(0).setBalance(balance);
		}
			
			
		}
		
		catch(NegativeNumberException e)
		{
			System.out.println("You can not use negative numbers!");
			//deposit(balance);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please use numbers.");
			//deposit(balance);
			
		}
		s.nextLine();
		}while(d<=0);
	
		
		
		
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

	public static void transfer(double balance, double balance2)
	{
		double w=0;
		double d=0;
		
		System.out.println("Current Balance in first account: "+balance);
		System.out.println("Current Balance in second account: "+balance2);
		System.out.println("Which account shall receive the deposit?");
		String input=s.nextLine();
		switch(input)
		{
		case "One":
			w=balance2;
			d=balance;
		break;
		
		case "Second":
			w=balance;
			d=balance2;
		break;
		}
		System.out.println("How much will be withdrawn?");
		
	}
			
}
