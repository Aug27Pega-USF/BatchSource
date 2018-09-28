package com.revature.account;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.DAOimpl.AccountDaoImpl;
import com.revature.users.Customer;


public class Account {
	//variables
	

	public static int acc_num;
	public static int userID;
	public static float acc_balance;
	public static int stat;
	public List <Customer> custAccount;
	static Scanner in = new Scanner(System.in);
	public static String userName;
	public static String password;
	

	static AccountDaoImpl accountimpl = new AccountDaoImpl();
	
	//constructor
	public Account(String user, int acc_num, List <Customer> custOnAccount)
	{

		Account.acc_num = acc_num;
		acc_balance = 0.00f;
		custAccount = custOnAccount;
	}

	public Account(int i, int j, float f) {
		// TODO Auto-generated constructor stub
	}

	public static void createAcc()
	{
		
		System.out.println("Create a UserName: ");
		userName = in.next();
	
		System.out.println("Create a Password: ");
		password = in.next();
		
		try
		{
			accountimpl.createLogin(userName, password);
			System.out.println("User Added to database");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		acc_num = (int)((Math.random() * 900000000)+ 10000000);
		System.out.println("Your Account number is: " + acc_num );
		System.out.println("Your starting balance is: " + acc_balance);
		
		try
		{
			accountimpl.addAccountInfo(acc_num, acc_balance);;
			
			System.out.println("Account info added!");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void deposit (int money)
	{
		System.out.println("Enter a userID to deposit");
		userID = in.nextInt();
			if (money >=0)
			acc_balance = acc_balance + money;
			
		
		try {
			accountimpl.doDeposit(money,userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void withdraw(int take)
	{
		System.out.println("Enter a userID to Withdraw");
		userID = in.nextInt();
		
		System.out.println("Enter amount you want to withdraw");
		take = in.nextInt();
		
		if (acc_balance != 0)
		acc_balance = acc_balance - take;
		
		try {
			accountimpl.doWithdrawal(take, userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	//transfer between accounts 
	//doesnt work.....
	public int transfer(int amount)
	{
		withdraw(amount);
		deposit(amount);
		return amount;
	}
	public void checkBal()
	{
		System.out.println("Your Balance is:" + acc_balance);
	}
	public  void display(String userName, int acc_num, float acc_balance)
	{
		System.out.println("Acount User: " + userName);
		System.out.println("Account Number: " + acc_num);
		System.out.println("Account Balance: " + acc_balance);
		accountimpl.getAllAccounts();
		
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserNAme(String user) {
		Account.userName = user;
	}
	public int getAcc_num() {
		return acc_num;
	}

	public void setAcc_num(int acc_num) {
		Account.acc_num = acc_num;
	}

	public float getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(float acc_balance) {
		Account.acc_balance = acc_balance;
	}
	public List<Customer> getCustOnAccount()
	{
		return this.custAccount;
	}
	public static int getStat() 
	{
		return stat;
	}

	public static void setStat(int stat) 
	{
		Account.stat = stat;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		Account.password = password;
	}

	@Override
	public String toString() {
		return "Account [user=" + userName + ", acc_num=" + acc_num + ", acc_balance="
				+ acc_balance + ", stat=" + stat +"]";
	}

}
