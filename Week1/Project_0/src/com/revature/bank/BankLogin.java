package com.revature.bank;

import java.util.Scanner;

public class BankLogin {
	
	public static void checkLogin() 
	{
		Scanner s=  new Scanner(System.in);
		
		IOBank.readBankFile();
		//System.out.println(IOBank.accountList);
		boolean isLogin=false;
		int size=IOBank.accountList.size();
		
		System.out.println("Username: ");
		String uname= s.nextLine();
		System.out.println("Password: ");
		String pass=s.nextLine();
		
		for (int i=0; i<=size-1;i++)
		{
			
		if(IOBank.accountList.get(i).getUsername().equals(uname) && IOBank.accountList.get(i).getPassword().equals(pass))
		{
			System.out.println("Login Sucess");
			Transactions.selectAction(i);
			isLogin=true;
		}
		else 
		{
			System.out.println("Login Failed");
			checkLogin();
		}
		}
		
		
			
		
//		else
//		{
//			System.out.println("Login Fail. Please try again");
//		}
		
	}

}
