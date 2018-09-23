package com.revature.beans;

import java.util.Scanner;

import com.revature.daoImpl.Bank_Account_DAOImpl;

public class Withdrawal extends Transaction {
	private double amount;
	

	public Withdrawal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Withdrawal(int bankId, int userid) {
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

}
