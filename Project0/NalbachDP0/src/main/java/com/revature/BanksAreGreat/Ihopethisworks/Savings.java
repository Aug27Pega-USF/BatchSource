package com.revature.BanksAreGreat.Ihopethisworks;

public class Savings extends Account{
	private static String accountType = "Savings";


Savings(double initialDeposit){
	super();
	this.setBalance(initialDeposit);//sets interest rates for savings accounts
	this.checkInterest(0);
}

public String toString() { //fetches the account's information 
return  " Account Type: "+ accountType + 
		"Account\n"+"Account Number "+ this.getAccountNumber() + "\n"+
		"Balance: "+ this.getBalance() + "\n"+
		"Interest Rate: "+ this.getInterest() + "%\n";
}
}
