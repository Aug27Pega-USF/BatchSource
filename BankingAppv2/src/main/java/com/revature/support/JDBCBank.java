package com.revature.support;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.daoimpl.AccountDAOImpl;
import com.revature.daoimpl.UserDAOImpl;

public class JDBCBank {
	static Scanner scan = new Scanner(System.in);
	// static Storage s = new Storage();
	static MenuLogic m = new MenuLogic();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAOImpl kaioken = new UserDAOImpl();
		AccountDAOImpl kikoho = new AccountDAOImpl();

		// User testing = m.register();
//		User testing = new User(1,"Lois","Lane","AuthorX","llckjk3815");
//		User testing1 = m.register();
//		
//		try {
//			kaioken.createUser(testing1.getFname(), testing1.getLname(), testing1.getUname(), testing1.getPw());
//			System.out.println(kaioken.getAccountHolders());
//			System.out.println("Please enter a starting balance:");
//			double bal = scan.nextDouble();
//			kikoho.createNewAccount(testing,bal);
//			kikoho.deleteEmptyAccounts(testing);
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		User retUser = null;
		String traverse = "";
		System.out.println("Welcome to the Sullivan Bank! Are you a new user?");
		traverse = scan.nextLine();
		if (traverse.equals("yes"))// create new user and account
		{
			User newUser = m.register();
			try {
				kaioken.createUser(newUser.getFname(), newUser.getLname(), newUser.getUname(), newUser.getPw());
				//User refreshUser = kaioken.userLogin(newUser.getUname(), newUser.getPw());
				System.exit(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Please Login with your credentials.");
			System.out.println("Please enter your username:");
			String uname = scan.nextLine();
			System.out.println("Please enter your password:");
			String p = scan.nextLine();
			try {
				retUser = kaioken.userLogin(uname, p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Welcome to the main menu\n"+
				"Here are your options:\n"+
				"1: view your account(s)\n"+
				"2: create new account\n"+
				"3: delete accounts with an empty balance\n"+
				"4: withdraw from account\n"+
				"5: deposit into account");
		System.out.println("Please enter a number");
		int menuSelect = scan.nextInt();
		switch(menuSelect) {
		case 1:
			System.out.println("Returning Accounts...");
			List<Account> retAct = null;
			try {
				retAct = kikoho.getAllAccountsSingleUser(retUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Account i: retAct){
				System.out.println(i);
			}
			break;
		case 2:
			System.out.println("Create a new account...");
			System.out.println("Please enter a Starting Balance");
			double balance = 0;
			balance = scan.nextDouble();
			try {
				kikoho.createNewAccount(retUser, balance);
				System.out.println(kikoho.getAllAccountsSingleUser(retUser));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 3:
			try {
				kikoho.deleteEmptyAccounts(retUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Accounts deleted");
			break;
		case 4:
			System.out.println("Please enter the amount that you want to withdraw:");
			double w = scan.nextDouble();
			try {
				kikoho.withdrawFromAccount(retUser, w);
			}catch(SQLException s){
				s.printStackTrace();
			}
			System.out.println("Your have withdrawn from your account.");
			break;
		case 5:
			System.out.println("Please enter the amount that you want to deposit:");
			double d = scan.nextDouble();
			try {
				kikoho.depositIntoAccount(retUser, d);
			}catch(SQLException s){
				s.printStackTrace();
			}
			System.out.println("Your have deposited into your account.");
			break;
		
		}
	}
}