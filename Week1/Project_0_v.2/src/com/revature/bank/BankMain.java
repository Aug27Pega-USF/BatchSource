package com.revature.bank;
import com.revature.enums.AccountType;
import com.revature.io.*;

public class BankMain {
	
	static AccountType a= AccountType.Guest;
	public static void main(String[] args)
	{
		
		//System.out.println(a);
		IOBank.readAccountFile();
	}

}
