package jdbc.bank.App;


import java.util.Scanner;

import APP.bankapp;
import jdbc.bank.DAOIMPL.AccountsDAOimpl;






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
			System.out.println("5.Sign Out");
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
	selector = sc.nextInt();
	break;

	
	
	//user login
	case 2:	
		Integer selector1;
		bankapp bal = new bankapp();
		bal.Login();
		AccountsDAOimpl ga = new AccountsDAOimpl();
		
		accountMenu();
		
		selector1 = sc.nextInt();
		AccountMenuD(selector1);
		switch(selector1){
		
		case 1:
		
		case 2:
			
		case 5:
	
		}
	
	}
	break;
	}while(selector >4);
	

}
static void introMenuD(Integer selector) {
switch (selector) {
case 1 :
	System.out.println("1. New Account");
	break;
case 2:
	System.out.println("2. Login");
	break;
case 3:
	System.out.println("3. Return");
	break;
}
}

static void AccountMenuD(Integer selector1) {
switch (selector) {

case 1 :
	System.out.println("1. Withdraw");
	break;
case 2:
	System.out.println("2. Deposit");
	break;
case 3:
	System.out.println("=5. Return");
	break;
}
}
}

