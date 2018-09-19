package com.revature.driver;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		BankRegister r= new BankRegister();
		boolean isTrue= false;
		System.out.println("Welcome to the Bank App!");
			do
			{
				System.out.println("Will you Register(R) or Login(L)? ");
				String input= s.nextLine();
				switch(input)
				{
				case "L":
					isTrue=true;
					//l.checkLogin();
					break;
				case "R":
					isTrue=true;
					r.createUser();
					break;
				default:
					System.out.println("Please use one of the variables given above");
				}	
			}
			while(!isTrue);		
	}
}

