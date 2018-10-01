package com.revature.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.DAOImpl.AccountDAOImpl;
import com.revature.DAOImpl.UsersDAOImpl;
import com.revature.tables.Account;
import com.revature.tables.Users;

public class UserAdmin {
	private static final int Account = 0;
	private static final int List = 0;
	static Scanner scan = new Scanner(System.in);

	public static void userAdminChoices(int userId) {
		int userId1;
		int input = 9;
		UsersDAOImpl udi = new UsersDAOImpl();
		do {
			Scanner choice = new Scanner(System.in);
			System.out.println("Admin Menu: ");
			System.out.println("1) View all users: ");
			System.out.println("2) View users accounts");
			System.out.println("3) Delete user");
			System.out.println("0) Exit ");
			input = choice.nextInt();
			switch (input) {
			case 0:
				System.out.println("Thank you");
				System.exit(0);
				break;
			case 1:
				// view all your users
				System.out.println("View all Accounts (Y/N)?");
				String vall = scan.next();
				if (vall.equalsIgnoreCase("Y")) {
					AccountDAOImpl adi = new AccountDAOImpl();
					try {
						adi.allUserAccounts();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					// allUserAccounts();
					break;
				}
			case 2:
				// view a users accounts
				System.out.println("Which account number would you like to view?");
				int accountNumber = scan.nextInt();
				AccountDAOImpl adi = new AccountDAOImpl();
				try {
					adi.getCertainAccount(accountNumber);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// viewUsersAccounts();
				break;
			case 3:
				// delete a specific user
				System.out.println("Which user would you like to delete? Enter in UserID");
				userId1 = scan.nextInt();
				try {
					udi.deleteUser(userId1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} while (input != 0);

		}
	

	public static void userChoices(int userId) {
		int userId1;
		int input;
		
		do {
			UsersDAOImpl udi = new UsersDAOImpl();
			AccountDAOImpl adi = new AccountDAOImpl();
			Scanner choice = new Scanner(System.in);
			System.out.println("User Menu ");
			System.out.println("1) View all your accounts ");
			System.out.println("2) View a specific account ");
			System.out.println("3) Make a deposit");
			System.out.println("4) Make a withdrawl");
			System.out.println("5) Delete empty account");
			System.out.println("6) Create an account");
			System.out.println("0) Exit ");
			input = choice.nextInt();
			switch (input) {
			case 0:
				System.out.println("Thank you");
				System.exit(0);
				break;
			case 1:
				// view all your accounts
				System.out.println("Do you want to view all of your accounts?(Y/N)");
				String val = scan.next();
				if (val.equalsIgnoreCase("Y")) {
					try {
						adi.allAccounts(userId);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				// viewAllAccounts();
				break;
			case 2:
				System.out.println("Which account number would you like to view?");
				int accountNumber = scan.nextInt();
				AccountDAOImpl adi1 = new AccountDAOImpl();
				try {
					adi1.getCertain2Account(accountNumber, userId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				// make a deposit
				System.out.println("Which account number would you like to make a deposit into?");
				int accountNumber1 = scan.nextInt(); 
				System.out.println("How much would you like to deposit?");
				float balance = scan.nextFloat();
				AccountDAOImpl adi2 = new AccountDAOImpl(); 
				try {
					adi2.makeDeposit(accountNumber1, userId, balance);
				}catch(SQLException e) {
					e.printStackTrace();
				}
				// makeADeposit();
				break;
			case 4:
				// make a withdraw
				System.out.println("Which account number would you like to withdraw from?");
				int accountNumber11 = scan.nextInt(); 
				System.out.println("How much would you like to withdraw?");
				float balance1 = scan.nextFloat();
				AccountDAOImpl adi3 = new AccountDAOImpl(); 
				try {
					adi3.makeAWithdraw(accountNumber11, userId, balance1);
				}catch(SQLException e) {
					e.printStackTrace();
				}
				// makeAWithdraw();
				break;
			case 5:
				// delete an empty account
				System.out.println("Which account number would you like to delete?");
				int accountNumber111 = scan.nextInt(); 
				try {
					AccountDAOImpl adi111 = new AccountDAOImpl();
					adi111 .deleteEmptyAccount(accountNumber111, userId);
				}catch(SQLException e) {
					e.printStackTrace();
				}
				// deleteEmptyAccount();
				break;
			case 6: 
				//createAccount 
				System.out.println("Would you like to create a new account?(Y/N)");
				String vall = scan.next();
				if (vall.equalsIgnoreCase("Y")) {
				System.out.println("How much would you like to deposit?");
				float balance11 = scan.nextFloat();
				String accountName = "checking";
				AccountDAOImpl adi4 = new AccountDAOImpl();
				try {
					adi4.createAccount(accountName, userId, balance11);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Your account balance is :" + balance11);
				}
			}
		}while(input!=0);
	
	}
}


