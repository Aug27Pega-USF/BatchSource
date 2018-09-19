package com.revature.bank;

public class AdminFunctions {
	
	public static void withdrawFrom(int idx)
	{
		
		IOBank.readBankFile();
		String uname=IOBank.accountList.get(idx).getUsername();
		String passowrd=IOBank.accountList.get(idx).getPassword();
		String name=IOBank.accountList.get(idx).getFullName();
		double balance=IOBank.accountList.get(idx).getBalance();
		String phone=IOBank.accountList.get(idx).getPhone();
		String actType=IOBank.accountList.get(idx).getAccountType();
		
		Transactions.withdraw(balance);
		
	}
	
	public static void depositTo(int idx)
	{
		
		IOBank.readBankFile();
		String uname=IOBank.accountList.get(idx).getUsername();
		String passowrd=IOBank.accountList.get(idx).getPassword();
		String name=IOBank.accountList.get(idx).getFullName();
		double balance=IOBank.accountList.get(idx).getBalance();
		String phone=IOBank.accountList.get(idx).getPhone();
		String actType=IOBank.accountList.get(idx).getAccountType();
		
		Transactions.deposit(balance);
		
	}
	
	public static void transferFrom(int idx, int idx2)
	{
		
		IOBank.readBankFile();
		String uname=IOBank.accountList.get(idx).getUsername();
		String passowrd=IOBank.accountList.get(idx).getPassword();
		String name=IOBank.accountList.get(idx).getFullName();
		double balance=IOBank.accountList.get(idx).getBalance();
		String phone=IOBank.accountList.get(idx).getPhone();
		String actType=IOBank.accountList.get(idx).getAccountType();
		
		String uname2=IOBank.accountList.get(idx2).getUsername();
		String passowrd2=IOBank.accountList.get(idx2).getPassword();
		String name2=IOBank.accountList.get(idx2).getFullName();
		double balance2=IOBank.accountList.get(idx2).getBalance();
		String phone2=IOBank.accountList.get(idx2).getPhone();
		String actType2=IOBank.accountList.get(idx2).getAccountType();
		
		Transactions.deposit(balance);
		
	}

}
