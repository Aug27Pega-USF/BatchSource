package com.revature.centers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimp.AccountDAOImp;
import com.revature.daoimp.TransactionDAOImp;
import com.revature.daoimp.UserDAOImp;

public class UserCenter {

	
	//User center options
	public static void userCenter(int userId) throws SQLException {
		Scanner input = new Scanner (System.in);
		int n;
		do {
		System.out.println("Welcome to the User Center, Please choose from following options");
		System.out.println("Press 1 to create account");
		System.out.println("Press 2 to view all your accounts");
		System.out.println("Press 3 to view a certain account");
		System.out.println("Press 4 to make a deposit into one of your accounts");
		System.out.println("Press 5 to make a withdrawl from one of your accounts");
		System.out.println("Press 6 to delete a certain account");
		System.out.println("Press 7 To view your transactions related to your account");
		System.out.println("Press 8 to change the username and password");
		
		n = input.nextInt();
		if(n ==1) {
			System.out.println("Account Creation. Is this correct (Y/N)?");
			String c = input.next();
			if(c.equalsIgnoreCase("Y")) {
				int typeID =0;
				double balance =0.0;
				
				do {
				System.out.println("What type of Acount? 1.Checking or 2.Savings");
				n = input.nextInt();
				if(n ==1) {
					System.out.println("Creating a Checking Account");
					typeID = 1;
				}else if(n ==2) {
					System.out.println("Creating a Savings Account");
					typeID = 2;
				}else {
					System.out.println("Not correct input");
					
				}
				}while(n != 1 && n != 2);
				System.out.println("How much would you like to deposit");
				balance = input.nextDouble();
				AccountDAOImp ca = new AccountDAOImp();
				try {
					ca.createAccount(userId, typeID, balance);
					System.out.println("Great work on creating your new account.");
					System.out.println("on main user menu select option 2 to view your account information");
					System.out.println("Hit any key to continue");
					try {
						System.in.read();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println();
			}
		}else if(n ==2) {
			System.out.println("View all your accounts. Is this correct (Y/N)?");
			String c1 = input.next();
			if(c1.equalsIgnoreCase("Y")) {
				AccountDAOImp ca = new AccountDAOImp();
				try {
					ca.getAccountList(userId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println();
			}

		}else if(n ==3) {
			System.out.println("View one of your accounts. Is this correct (Y/N)?");
			String c2 = input.next();
			if(c2.equalsIgnoreCase("Y")) {
				System.out.println("Which account id would you like to view");
				int accountId = input.nextInt();
				AccountDAOImp ca = new AccountDAOImp();
				try {
					ca.getCertainAccount(accountId,userId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println();
			}

		}else if(n ==4) {
			System.out.println("Make a Deposit. Is this correct (Y/N)?");
			String c3 = input.next();
			if(c3.equalsIgnoreCase("Y")) {
				System.out.println("What account id would you like to deposit into");
				int accountId = input.nextInt();
				System.out.println("How much would you like to deposit");
				double deposit = input.nextDouble();
				AccountDAOImp ca = new AccountDAOImp();
				try {
					ca.depositUpdateAccount(accountId,userId,deposit);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println();
			}

		}else if(n ==5) {
			System.out.println("Make a Withdrawl. Is this correct (Y/N)?");
			String c4 = input.next();
			if(c4.equalsIgnoreCase("Y")) {
				System.out.println("What account id would you like to pull from");
				int accountId = input.nextInt();
				System.out.println("How much would you like to withdrawl");
				double withdrawl = input.nextDouble();
				AccountDAOImp ca = new AccountDAOImp();
				try {
					ca.withdrawlUpdateAccount(accountId,userId,withdrawl);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println();
			}

		}else if(n ==6) {
			System.out.println("Deleting an account. Is this correct (Y/N)?");
			String c5 = input.next();
			if(c5.equalsIgnoreCase("Y")) {
				System.out.println("Which account id would you like to delete");
				int accountId = input.nextInt();
				AccountDAOImp ca = new AccountDAOImp();
				try {
					ca.deleteAccount(accountId,userId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println();
			}

		}else if(n ==7) {
			System.out.println("Checking an accounts transactions. Is this correct (Y/N)?");
			String c6 = input.next();
			if(c6.equalsIgnoreCase("Y")) {				
				AccountDAOImp gal = new AccountDAOImp();
				try {
					gal.getAccountList(userId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Which account id would you like to pull");
				int accountId = input.nextInt();
				TransactionDAOImp gtl= new TransactionDAOImp();
				try {
					gtl.getTransactionList(accountId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println();
			}

		}else if(n ==8) {
			System.out.println("Updating username and password for system. Is this correct (Y/N)?");
			Scanner input1 = new Scanner (System.in);
			String c7 = input1.next();
			if(c7.equalsIgnoreCase("Y")) {
				System.out.println("Asking questions to change");
				System.out.println("Enter new username you would like to use");
				Scanner input2 = new Scanner (System.in);
				String userName = input2.nextLine();
				System.out.println("Enter new password you would like to use");
				String password = input2.nextLine();
				UserDAOImp uu = new UserDAOImp();
				uu.updateUser(userId,userName,password);
				
			}else {
				System.out.println();
			}
		}
		
		}while(n != 9);
	}
	
	//administrator options
	public static void adminCenter(int userId) {
		Scanner input = new Scanner (System.in);
		int n;
		do {
		System.out.println("Welcome to your Administration Center, Please choose from following options");
		System.out.println("Press  1 to create account a new User");
		System.out.println("Press  2 to view a certain Users information");
		System.out.println("Press  3 to view all users");
		System.out.println("Press  4 to view account(s) associated with a certain User");
		System.out.println("Press  5 to Empty account of a User for deletion");
		System.out.println("Press  6 to Update a User");
		System.out.println("Press  7 to Delete a User");
		System.out.println("To Exit to main menu press 9");
		n = input.nextInt();
		if(n ==1) {
			System.out.println("Create new User. Is this correct (Y/N)?");
			String c = input.next();
			if(c.equalsIgnoreCase("Y")) {
				System.out.println("Transferring to Registration");
				RegistrationCenter.registration();
			}else {
				System.out.println();
			}
			
		}else if(n ==2) {
			System.out.println("View a certain users information. Is this correct (Y/N)?");
			String c = input.next();
			if(c.equalsIgnoreCase("Y")) {
				System.out.println("Please enter the user id you are looking up");
				int userLook = input.nextInt();
				UserDAOImp gcu = new UserDAOImp();
				try {
					gcu.getCertainUser(userLook);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println();
			}
		}else if(n ==3) {
			System.out.println("View all Users. Is this correct (Y/N)?");
			String c = input.next();
			if(c.equalsIgnoreCase("Y")) {
				UserDAOImp gul = new UserDAOImp();
				try {
					gul.getUserList();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				System.out.println();
			}
		}else if(n ==4) {
			System.out.println("View all Accounts of a certain User. Is this correct (Y/N)?");
			String c = input.next();
			if(c.equalsIgnoreCase("Y")) {
				AccountDAOImp gua = new AccountDAOImp();
				System.out.println("Which User would you like to you at");
				int userID = input.nextInt();
				try {
					gua.getAccountList(userID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				System.out.println();
			}
		}else if(n ==5){
			System.out.println("Make a Withdrawl To Delete and Account. Is this correct (Y/N)?");
			String c4 = input.next();
			if(c4.equalsIgnoreCase("Y")) {
				System.out.println("What User id would you like to pull Account from");
				int userID = input.nextInt();
				System.out.println("What account id would you like to pull from");
				int accountId = input.nextInt();
				System.out.println("How much is needed to withdrawl to close");
				double withdrawl = input.nextDouble();
				AccountDAOImp ca = new AccountDAOImp();
				try {
					ca.withdrawlUpdateAccount(accountId,userID,withdrawl);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println();
				}
			}else if(n ==6){
				System.out.println("Updating username and password for system. Is this correct (Y/N)?");
				Scanner input1 = new Scanner (System.in);
				String c7 = input1.next();
				if(c7.equalsIgnoreCase("Y")) {
					Scanner input2 = new Scanner (System.in);
					System.out.println("Which User would you like to update");
					int userID = input2.nextInt();
					System.out.println("Enter new username you would like to use");
					Scanner input3 = new Scanner (System.in);
					String userName = input3.nextLine();
					System.out.println("Enter new password you would like to use");
					String password = input3.nextLine();
					UserDAOImp uu = new UserDAOImp();
					try {
						uu.updateUser(userID,userName,password);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
				System.out.println();
				}
			}else if(n ==7){
				System.out.println("Delete a User. Is this correct (Y/N)?");
				//Scanner input = new Scanner (System.in);
				String c7 = input.next();
				if(c7.equalsIgnoreCase("Y")) {
					System.out.println("Which User would you like to update");
					int userID = input.nextInt();
					UserDAOImp ud = new UserDAOImp();
					try {
						ud.deleteUser(userID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
				System.out.println();
				}
			}else {
				System.out.println();
				}
			
		}while(n != 9);
	}

}
