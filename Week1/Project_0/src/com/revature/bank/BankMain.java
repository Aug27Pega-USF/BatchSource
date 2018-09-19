package com.revature.bank;

import java.util.Scanner;


public class BankMain extends Register  {
	
//	private String username;
//	private String password;
//	private String fullName;
//	private boolean activeAct;
//	private int phone;
//	private double balance;
//	private double withdraw;
//	private double deposit;
	
	public static void main(String[] args)
	{
		Scanner s= new Scanner(System.in);
		Register r= new Register();
		BankLogin l= new BankLogin();
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
			l.checkLogin();
			break;
		case "R":
			isTrue=true;
			r.createUser();
			break;
		default:
			System.out.println("Please use one of the variables given above");
		}
//		if(!input.equals("L")||!input.equals("R"))
//		
	}
		while(!isTrue);
		
		
	}

}
