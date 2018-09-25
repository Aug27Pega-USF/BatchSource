package com.revature.BanksAreGreat.Ihopethisworks;

public class Checking extends Account{
	private static String accountType = "Checking";
	
	Checking(double initialDeposit){
		super();
		this.setBalance(initialDeposit);//sets interest rates for checking accounts
		this.checkInterest(0);
	}
	
	public String toString() {
	return " Account Type: " + accountType + 
			"Account\n"+"Account Number "+ this.getAccountNumber() + "\n"+
			"Balance: "+ this.getBalance() + "\n"+
			"Interest Rate: "+ this.getInterest() + "\n";
	}
}
