package com.revature.driver;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.daoimpl.UserAccountsDAOImpl;
import com.revature.daoimpl.UsersDAOImpl;

public class UserView {

	Scanner s = new Scanner(System.in);
	Scanner p = new Scanner(System.in);
	UsersDAOImpl user= new UsersDAOImpl();
	UserAccountsDAOImpl uact= new UserAccountsDAOImpl();
	
	public void User_Choices(int u_id)
	{
		Driver m= new Driver();
		
		boolean isExit=false;
		System.out.println("Welcome Admin");
		while(!isExit)
		{
			System.out.println("Choices:");
			System.out.println("(1) View  Accounts");
			System.out.println("(2) Create Account");
			//System.out.println("(3) Update User");
			System.out.println("(3) Delete Account");
			System.out.println("(4) Withdraw/Deposit from Account");
			System.out.println("(5) Logout");
			int choice= s.nextInt();
			try {
					switch(choice)
					{
					case 1:
						System.out.println(uact.getAccountList(u_id));
						break;
					case 2:
						newAccount(u_id);
						break;
					case 3:
						deleteAccount(u_id);
						break;
					case 4:
						userTransactions(u_id);
						break;
					case 5:
						isExit=true;
						break;
						default:
							System.out.println("Please Choose one of the choices.");
					}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
	

	}
	
	public void newAccount(int uid)
	{
		boolean isExit= false;
		String n="Checking";
		double b=0;
		while(!isExit)
		{
			try
			{
			System.out.println("Name of Account:");
			 n= s.nextLine();
			System.out.println("Balance for account:");
			 b= p.nextDouble();
			 isExit=true;
			}catch(InputMismatchException e)
			{
				e.printStackTrace();
			}
		}
		isExit=false;
		while(!isExit) 
		{
		System.out.println("Name: "+n+ " Balance: "+b);
		System.out.println("Is this ok?");
		System.out.println("(1) Yes");
		System.out.println("(2) No");
		int a= p.nextInt();
			switch(a)
			{
			case 1:
				try {
					user.createAccount(uid, n, b);
					isExit=true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
			case 2:
				isExit=true;
			break;
			default:
				System.out.println("Please use a correct variable");
			}
		}
		
		
	}

	public void deleteAccount(int uid)
	{
		//boolean isExit=false;
		try {			
			System.out.println(uact.getAccountList(uid));
			System.out.println("Which empty account will you delete?");
			int d_id= p.nextInt();
			//double currentbal=uact.accountBalance(d_id);
			uact.deleteAccountIfEmpty(d_id);				
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (InputMismatchException e) {
			e.printStackTrace();
		}
	}

	public void userTransactions(int uid)
	{
		boolean isExit=false;
		boolean isContinue=false;
		double amount=0;
		int t_id=0;
		
		while(!isExit)
		{
			try {
				System.out.println(uact.getAccountList(uid));
			
			System.out.println("Which account will you choose for your transactions?");
			t_id= p.nextInt();
			System.out.println("Will you deposit(1) or withdraw(2) or leave(3)");
			int choice= p.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("How much will you depsoit?");
					amount= s.nextDouble();
					uact.depositToBalance(t_id, amount);
					break;
				case 2:
					System.out.println("How much will you withdraw?");
					amount= s.nextDouble();
					uact.withdrawBalance(t_id, amount);
					break;
				case 3:
					isExit=true;
					break;
				default:				
					System.out.println("Please use one of the proper variables");
					
				}
								
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (InputMismatchException e)
			{
				e.printStackTrace();
			}
		}
	}
}

