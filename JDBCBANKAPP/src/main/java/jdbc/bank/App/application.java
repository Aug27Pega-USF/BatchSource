package jdbc.bank.App;


import java.util.Scanner;

import APP.bankapp;
import jdbc.bank.DAOIMPL.AccountsDAOimpl;
import jdbc.bank.DAOIMPL.transactionsDAOimpl;






public class application {
		public static Scanner sc = new Scanner(System.in);	
		static int selector;
		
		static void introMenu() {
			System.out.println("1.New Account");
			System.out.println("2.Login");
			System.out.println("Your Decision: ");
			
		}
		
		static void accountMenu() {
			System.out.println("1.Withdraw");
			System.out.println("2.Deposit");
			System.out.println("3.Close Account");
			System.out.println("Your Decision: ");
		}
public static void main(String[] args) throws Exception{
	ConnFactory.getInstance();
	introMenu();
	Integer selector;
	selector = sc.nextInt();
	do{introMenuD(selector);
	switch(selector) {
	
	case 1:
	
	// New user input
	bankapp ba = new bankapp();
	ba.newUser();
	introMenu();
	selector = sc.nextInt();
	introMenuD(selector);
	

	
	
	//user login
	case 2:	
		Integer selector1;
		bankapp bal = new bankapp();
		bal.Login();
		
		AccountsDAOimpl ga = new AccountsDAOimpl();
		
		accountMenu();
		
		selector1 = sc.nextInt();
		do{AccountMenuD(selector1);
		
		switch(selector1) {
		
		case 1:
			bankapp auw = new bankapp();
			auw.AccountUpdateW();
			accountMenu();
			AccountMenuD(selector1);
			break;
		
		case 2:
		bankapp aud = new bankapp();
		aud.AccountUpdateD();
		accountMenu();
		AccountMenuD(selector1);
		break;
	
	}
	}while(selector == 4);

	}
	break;
	}while(selector == 4);
	

	}


	


static void introMenuD(Integer selector) {
switch (selector) {
case 1 :
	System.out.println("1. New Account");
	
case 2:
	System.out.println("2. Login");
	
case 3:
	System.out.println("3. Return");
	
}
}

static void AccountMenuD(Integer selector1) {
switch (selector) {

case 1 :
	System.out.println("1. Withdraw");
	
case 2:
	System.out.println("2. Deposit");
	
case 3:
	System.out.println("3. Close Account");
	
}
}
}

