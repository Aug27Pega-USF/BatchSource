package com.revature.bank;

import java.util.Scanner;


public class BankMain extends Register  {
	
	private String username;
	private String password;
	private String fullName;
	private boolean activeAct;
	private int phone;
	private double balance;
	private double withdraw;
	private double deposit;
	
	public static void main(String[] args)
	{
		Scanner s= new Scanner(System.in);
		Register r= new Register();
		BankLogin l= new BankLogin();
		
		System.out.println("Welcome to the Bank App!");
		System.out.println("Will you Register(R) or Login(L)? ");
		String input= s.nextLine();
		switch(input)
		{
		case "L":
			l.checkLogin();
			break;
		case "R":
			r.createUser();
			break;			
		
		}
		
		
	}

}
