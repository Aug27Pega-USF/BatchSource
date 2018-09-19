package com.revature.driver;

import java.util.Scanner;

public class BankLogin {
	
	public static void checkLogin() 
	{
		Scanner s=  new Scanner(System.in);
		
		boolean isLogin=false;	
		//inputs username and password
		System.out.println("Username: ");
		String uname= s.nextLine();
		System.out.println("Password: ");
		String pass=s.nextLine();
		
		//loop to find correct Username and Password from database. else it is a failed login.
		for ()
		{
		//compares current Username and password with input	from user
		if()
		{
			System.out.println("Login Sucess");
			//Transactions.selectAction(i);
			isLogin=true;
		}
		else 
		{
			System.out.println("Login Failed");
			checkLogin();
		}
		}
		
	}
	
	
}
