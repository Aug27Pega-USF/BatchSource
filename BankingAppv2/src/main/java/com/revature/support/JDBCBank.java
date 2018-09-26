package com.revature.support;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.daoimpl.AccountDAOImpl;
import com.revature.daoimpl.AdministratorDAOImpl;
import com.revature.daoimpl.UserDAOImpl;

public class JDBCBank {
	static Scanner scan = new Scanner(System.in);
	// static Storage s = new Storage();
	static MenuLogic m = new MenuLogic();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAOImpl kaioken = new UserDAOImpl();
		AccountDAOImpl kikoho = new AccountDAOImpl();
		AdministratorDAOImpl makankosappo = new AdministratorDAOImpl();

		User retUser = null;
		Administrator admin = null;
		String traverse = "";
		String check = "";
		System.out.println("Welcome to the Sullivan Bank! Are you a new user?");
		traverse = scan.nextLine();
		if (traverse.equals("yes"))// create new user and account
		{
			User newUser = m.register();
			try {
				kaioken.createUser(newUser.getFname(), newUser.getLname(), newUser.getUname(), newUser.getPw());
				// User refreshUser = kaioken.userLogin(newUser.getUname(), newUser.getPw());
				System.exit(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Welcome back! Are you a user or an admin?");
			traverse = scan.nextLine();
			if (traverse.equals("admin")) {
				System.out.println("Please Login with your credentials.");
				System.out.println("Please enter your username:");
				String uname = scan.nextLine();
				System.out.println("Please enter your password:");
				String p = scan.nextLine();
				try {
					admin = makankosappo.adminLogin(uname, p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				admin.toString();// currently returning null
			}
			else if (traverse.equals("user")) {
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
				retUser.toString();
			}

		}
		System.out.println("check if user or admin");
		check = scan.nextLine();
		if (check.equals("user") && retUser != null) {
			System.out.println("Welcome to the main menu\n" + "Here are your options:\n" + "1: view your account(s)\n"
					+ "2: create new account\n" + "3: delete accounts with an empty balance\n"
					+ "4: withdraw from account\n" + "5: deposit into account");
			System.out.println("Please enter a number");
			int menuSelect = scan.nextInt();
			switch (menuSelect) {
			case 1:
				System.out.println("Returning Accounts...");
				List<Account> retAct = null;
				try {
					retAct = kikoho.getAllAccountsSingleUser(retUser);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Account i : retAct) {
					System.out.println(i);
				}
				break;
			case 2:
				System.out.println("Create a new account...");
				System.out.println("Please enter a Starting Balance");
				double balance = 0;
				balance = scan.nextDouble();
				scan.nextLine();
				System.out.println("Please enter a name for your new account");
				String aname = scan.nextLine();
				try {
					kikoho.createNewAccount(retUser, balance, aname);
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
				scan.nextLine();
				System.out.println("Please enter the name of the account you want to withdraw from:");
				String n1 = scan.nextLine();
				try {
					kikoho.withdrawFromAccount(retUser, w, n1);
				} catch (SQLException s) {
					s.printStackTrace();
				}
				System.out.println("Your have withdrawn from your account.");
				break;
			case 5:
				System.out.println("Please enter the amount that you want to deposit:");
				double d = scan.nextDouble();
				scan.nextLine();
				System.out.println("Please enter the name of the account you want to deposit into:");
				String n2 = scan.nextLine();
				try {
					kikoho.depositIntoAccount(retUser, d, n2);
				} catch (SQLException s) {
					s.printStackTrace();
				}
				System.out.println("Your have deposited into your account.");
				break;
			}
		}
		else if (check.equals("admin") && admin != null) {
			System.out.println("Welcome to the Admin menu\n" + "Here are your options:\n" 
					+ "1: view All users\n"
					+ "2: create new user\n" 
					+ "3: delete all users\n");
			System.out.println("Please enter a number");
			int menuSelect = scan.nextInt();
			switch (menuSelect) {
			case 1:
				System.out.println("View all users");
				try {
					kaioken.getAccountHolders();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Creating new User");
				User newUser = m.register();
				try {
					kaioken.createUser(newUser.getFname(), newUser.getLname(), newUser.getUname(), newUser.getPw());
					// User refreshUser = kaioken.userLogin(newUser.getUname(), newUser.getPw());
					System.exit(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("New user created.");
				break;
			case 3:
				System.out.println("Deleting all Users");
				try {
					makankosappo.deleteAllAccounts();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You madman! They're all gone!");
				break;
			}
		}
	}
}