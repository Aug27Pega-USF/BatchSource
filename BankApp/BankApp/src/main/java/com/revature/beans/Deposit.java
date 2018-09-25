package com.revature.beans;

import java.util.Scanner;

public class Deposit extends Transaction {
private double amount;
	

	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Deposit(int bankId, int userid) {
		super(bankId, userid);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void performTransaction() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("In which account would you like to make the transaction?");
		String selection = sc.nextLine();
		System.out.println("Enter amount you desire to withdraw");
		amount = sc.nextDouble();
		/*if(selection == "saving") {
			double availableSavingBlce = Bank_Account_DAOImpl.getSavingBalance(bankId)
			if(amount < availableSavingBlce) {
				
			}
		}else {
			double availableCheckingBlce = Bank_Account_DAOImpl.getAvailableBlce(BankId)
		}*/
			

}
