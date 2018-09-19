package com.revature.accounts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Customers extends Accounts{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static boolean status;
	private static double balance;
	
	public static double getWithdraw(double balance)
	{
		boolean isValid=false;
		Scanner s= new Scanner(System.in);
		do
		{
		try
		{
		System.out.println("Balance: "+balance);
		System.out.println("How much will you withdraw?");
		double w= s.nextDouble();
		if(w>balance)
		{
			System.out.println("Withdraw amount is higher than current balance.");
		}
		else if(w<0)
		{
			System.out.println("Negative Numbers not allowed");
		}
		else 
		{
			balance-=w;
			isValid=true;
		}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Use a number please!");
		}
		s.nextLine();
		}
		while(!isValid);
		
		return balance;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
