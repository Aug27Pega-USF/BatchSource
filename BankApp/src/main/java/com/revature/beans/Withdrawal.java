package com.revature.beans;

import java.sql.SQLException;
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
		Bank_Account_DAOImpl ba = new Bank_Account_DAOImpl();
		Bank_Account acct = new Bank_Account();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("In which account would you like to make the transaction?");
		String selection = sc.nextLine();
		
		System.out.println("enter account number");
		int anum = sc.nextInt();
		
		System.out.println("Enter amount you desire to withdraw");
		amount = sc.nextDouble();
		double availSav = acct.getSaving_balance();
		if(selection.equalsIgnoreCase("saving")) {
			if(amount < availSav ) {
			//logged overdraft message, might occur	
			System.out.println(" your saving balance is less than the amount ");
			}else {
				try {
					System.out.println(" your saving balance is down off "+ba.updateSavingBalance(anum, amount));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}else if(selection.equalsIgnoreCase("checking")) {
		if(amount < availSav ) {
			//logged overdraft message, might occur	
			System.out.println(" your checking balance is less than the amount ");
			}else {
				try {
					System.out.println(" your checking balance is down off "+ba.updateCheckingBalance(anum, amount));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
	}
		
		
		
	
	
		
	}

}
