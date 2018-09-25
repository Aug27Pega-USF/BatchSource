package com.revature.beans;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoImpl.Bank_Account_DAOImpl;

/*public class Deposit extends Transaction {
private double amount;*/
public class Deposit  {
private static double amount;

	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Deposit(double amount) {
		//super(bankId, userid);
		// TODO Auto-generated constructor stub
		this.amount = amount;
	}


	//@Override
	public static void performDeposit() throws SQLException{//deposit
		Bank_Account_DAOImpl badi = new Bank_Account_DAOImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("In which account would you like to make deposit?");
		String selection = sc.nextLine();
		
		System.out.println("enter account number");
		int anum = sc.nextInt();
		
		
		System.out.println("Enter amount you desire to deposit");
		amount = sc.nextDouble();
		
		if(selection.equalsIgnoreCase("saving")) {
				System.out.println(" your saving is up balance is "+badi.updateSavingBalance(anum, amount));
		}else if(selection.equalsIgnoreCase("checking")) {
			System.out.println(" your checking is up balance is "+badi.updateCheckingBalance(anum, amount));
			
		}
		
	}	
	}
	

