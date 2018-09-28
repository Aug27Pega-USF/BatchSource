package com.revature.driver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.daoImpl.AccountDAOImpl;
import com.revature.daoImpl.UsersDAOImpl;

public class Bank {

	private static int admin;

	public static void main(String[] args) {
		UsersDAOImpl udi = new UsersDAOImpl();
		AccountDAOImpl adi = new AccountDAOImpl();
		Scanner scan = new Scanner(System.in);
		admin = 0;
		int choice;
		int n;
		do {
			System.out.println("Hello and welcome to JDBC Bank.");
			System.out.println();
			System.out.println("Press 1 if you are a registered user");
			System.out.println("Press 2 if you are a new user");
			System.out.println("Press 3 to quit");
			n = scan.nextInt();
			if(n == 1)
			{
				System.out.println("Please type in your username: ");
				String username = scan.next();
				System.out.println("Please type in your password: ");
				String password = scan.next();
				try {
					int userID = udi.userLogin(username, password);
					if(userID != 0) {
						int ID = udi.isUserAdmin(userID);
						if(ID == 0) {//User Options
							do {
								System.out.println("Welcome User");
								System.out.println("Here are your options: ");
								System.out.println("1) Create Bank Account");
								System.out.println("2) Withdraw from Account");
								System.out.println("3) Deposit into Account");
								System.out.println("4) Delete Account");
								System.out.println("5) View All Accounts");
								System.out.println("6) Logout");
								choice = scan.nextInt();
								switch (choice) {
								case 1:
									System.out.println("You have chosen to create a new bank account.");
									System.out.println("Put in starting balance: ");
									String UB = scan.next();
									int uB = Integer.parseInt(UB);
									try {
										adi.createAccount(userID, uB);
										System.out.println("You have created a new account.");
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
									
								case 2:// Need to finish
									System.out.println("You have chosen to withdraw from an account");
									System.out.println("Please insert account id that you wish to withdraw from: ");
									int aID = scan.nextInt();
									System.out.println("How much would you like to withdraw: ");
									double wd = scan.nextInt();
									adi.withdraw(aID, wd);
									System.out.println("Your withdrawl may have been successful.");
									break;
									
								case 3:// Need to finish
									System.out.println("You have chosen to deposit into an account.");
									System.out.println("Please select an account you wish to deposit into: ");
									int accountId = scan.nextInt();
									System.out.println("How much would you like to deposit: ");
									double depo = scan.nextInt();
									adi.deposit(accountId, depo);
									System.out.println("Your deposit was successful.");
									break; 
									
								case 4:
									System.out.println("You have chosen to delete one of your accounts.");
									System.out.println("Select AccountID: ");
									String AID = scan.next();
									int acID = Integer.parseInt(AID);
									try {
										adi.deleteAccount(acID);
										System.out.println("You have deleted the account.");
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								
								case 5:
									System.out.println("You have chosen to view all of your accounts.");
									try {
										System.out.println(adi.getAccountList(userID));
									}catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									System.out.println("Here are all of your accounts.");
									System.out.println();
									break;
									

								
								case 6:
									System.out.println("Thank you, now back to the main menu.");
									System.out.println();
									break;
									
								default:
									System.out.println();
									break;
								}
							}while(choice != 6);
						}
						if(ID == 1) {//Admin Options
							do {
								System.out.println("Welcome Admin User");
								System.out.println("Here are your options: ");
								System.out.println("1) Create New User Account");
								System.out.println("2) Create Bank Account");
								System.out.println("3) Withdraw from Account");
								System.out.println("4) Deposit into Account");
								System.out.println("5) Delete Account");
								System.out.println("6) Delete User");
								System.out.println("7) View All Users");
								System.out.println("8) Logout");
								choice = scan.nextInt();
								switch (choice) {

								case 1:
									System.out.println("Please input desired username");
									String uname = scan.next();
									System.out.println("Please input desired password");
									String uword = scan.next();
									try {
										udi.createUser(uname, uword, admin);
										System.out.println("Congratulations on making a new user account.");
										System.out.println();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;

								case 2:
									System.out.println("You have chosen to create a new bank account.");
									System.out.println("Put in starting balance: ");
									String UB = scan.next();
									int uB = Integer.parseInt(UB);
									try {
										adi.createAccount(userID, uB);
										System.out.println("You have created a new account.");
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
									
								case 3://Need to finish
									
									System.out.println("You have chosen to withdraw from an account");
									System.out.println("Please insert account id that you wish to withdraw from: ");
									int aID = scan.nextInt();
									System.out.println("How much would you like to withdraw: ");
									double wd = scan.nextInt();
									adi.withdraw(aID, wd);
									System.out.println("Your withdrawl may have been successful.");
									break;
									
								case 4://Need to finish
									System.out.println("You have chosen to deposit into an account.");
									System.out.println("Please select an account you wish to deposit into: ");
									int accountId = scan.nextInt();
									System.out.println("How much would you like to deposit: ");
									double depo = scan.nextInt();
									adi.deposit(accountId, depo);
									System.out.println("Your deposit was successful.");
									break; 
									
								case 5:
									System.out.println("You have chosen to delete an account.");
									System.out.println("Select AccountID: ");
									String AID = scan.next();
									int accID = Integer.parseInt(AID);
									try {
										adi.deleteAccount(accID);
										System.out.println("You have deleted the account.");
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
									
								case 6:
									System.out.println("You have chosen to delete a user");
									System.out.println("Please input which user you wish to delete by userID.");
									String a = scan.next();
									int user = Integer.parseInt(a);
									udi.deleteUser(user);
									System.out.println("This user has now been deleted.");
									break;
									
								case 7:
									System.out.println("You have chosen to view all users.");
									try {
										System.out.println(udi.getUserList());
									} catch (SQLException e) {
										e.printStackTrace();
									}
									System.out.println("Here is your list of users.");
										System.out.println();
									break;
									
								
								case 8:
									System.out.println("Thank you, now back to the main menu.");
									System.out.println();
									break;

								default:
									System.out.println();
									break;
								}
							}while(choice != 8);
						}
					}
					if(userID == 0)
					{
						System.out.println("You entered in the wrong information");
						System.out.println("Please register if you have not done so");
						System.out.println("Press enter to get back to the main menu");
						try {
							System.in.read();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
			else if(n == 2) {
				System.out.println("Please input desired username");
				String username = scan.next();
				System.out.println("Please input desired password");
				String password = scan.next();
				try {
					udi.createUser(username, password, admin);
					System.out.println("Congratulations on making a new user account.");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(n == 3) {
				break;
			}
			
		} while(n != 3);
		System.out.println("Thank you, please have a wonderful day.");
	}
}
