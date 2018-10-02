package com.revature.driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daoimpl.BankAccountDAOImpl;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.util.ConnFactory;

public class Driver {
	static UserDAOImpl udi = new UserDAOImpl();
	static BankAccountDAOImpl adi = new BankAccountDAOImpl();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {
		while (true) {
			System.out.println("WELCOME TO THE BANK OF DURHAM");
			System.out.println("******************************");
			System.out.println("(1) LOGIN\n(2) CREATE LOGIN\n(3) EXIT");

			int option = sc.nextInt();
			switch (option) {
			case 1:
				oldLogin();
				break;
			case 2:
				newLogin();
				break;
			case 3:
				System.out.println("SYSTEM EXITING...");
				sc.close();
				System.exit(1);
				break;
			default:
				System.err.println("INVALID OPTION");
			}
		}
	}

	public static void newLogin() {
		System.out.print("ENTER LOGIN NAME: ");
		String uLogName = sc.next().toUpperCase();
		System.out.print("\nENTER PASSWORD: ");
		String uPWord = sc.next().toUpperCase();
		System.out.print("\nENTER FIRST NAME: ");
		String uFName = sc.next().toUpperCase();
		System.out.print("\nENTER LAST NAME: ");
		String uLName = sc.next().toUpperCase();
		try {
			udi.createUser(uLogName, uPWord, uFName, uLName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void oldLogin() {
		while (true) {
			System.out.print("ENTER LOGIN NAME: ");
			String uLogName = sc.next().toUpperCase();
			System.out.print("\nENTER PASSWORD: ");
			String uPWord = sc.next().toUpperCase();
			Connection conn;
			try {
				conn = ConnFactory.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "SELECT * FROM BANK_USER WHERE USERNAME IN('" + uLogName + "')";
				ResultSet rs = stmt.executeQuery(sql);
				User u = null;
				while (rs.next()) {
					u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getInt(6));
				}
				rs.close();
				if ((u.getPWord().equals(uPWord))&&(u.getAdminFlag() == 0)) {
					System.out.println("WELCOME, CUSTOMER " + u.getFirstName() + " " + u.getLastName());
					customerMenu(u);
				} else if ((u.getPWord().equals(uPWord))&&(u.getAdminFlag() == 1)) {
					System.out.println("WELCOME, ADMIN " + u.getFirstName() + " " + u.getLastName());
					adminMenu(u);
				} else {
					System.out.println("INVALID USERNAME OR PASSWORD");
					mainMenu();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	static void customerMenu(User u) {
		try {
			while (true) {
				System.out.println("Customer Accounts: ");
				adi.viewUser(u.getUserID());
				System.out.println(u);
				System.out.println("******************************");
				System.out.println("(1) CREATE ACCOUNT\n(2) DELETE ACCOUNT\n"
						+ "(3) DEPOSIT\n(4) WITHDRAW\n(5) LOGOUT TO MAIN MENU");
				int option = sc.nextInt();
				switch (option) {
				case 1:
					adi.createAccount(u.getUserID());
					break;
				case 2:
					System.out.println("ACCOUNT NUMBER: ");
					int acctNumDelete = sc.nextInt();
					adi.deleteAccount(acctNumDelete);
					break;
				case 3:
					System.out.println("ACCOUNT NUMBER: ");
					int acctNumD = sc.nextInt();
					System.out.println("AMOUNT TO DEPOSIT: ");
					int deposit = sc.nextInt();
					adi.depositAccount(acctNumD, deposit);
					break;
				case 4:
					System.out.println("ACCOUNT NUMBER: ");
					int acctNumW = sc.nextInt();
					System.out.println("AMOUNT TO WITHDRAW: ");
					int withdraw = sc.nextInt();
					adi.withdrawAccount(acctNumW, withdraw);
					break;
				case 5:
					System.out.println("HAVE A NICE DAY!");
					mainMenu();
					break;
				default:
					System.out.println("INVALID OPTION");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void adminMenu(User u) {
		try {
			while (true) {
				System.out.println(u);
				System.out.println("******************************");
				System.out.println("(1) CREATE CUSTOMER\n(2) DELETE ACCOUNT\n"
						+ "(3)ADJUST BALANCE\n"
//						+ "(4)VIEW ACCOUNTS\n"
						+ "(4) PROMOTE TO ADMIN\n"
						+ "(5)LOGOUT TO MAIN MENU");
				int option = sc.nextInt();
				switch (option) {
				case 1:
					newLogin();
					break;
				case 2:
					System.out.println("WHAT ACCOUNT TO DELETE: ");
					int acctNumDelete = sc.nextInt();
					adi.deleteAccount(acctNumDelete);
					break;
				case 3:
					System.out.println("WHAT ACCOUNT TO READJUST:");
					int acctNumAdjust = sc.nextInt();
					System.out.println("WHAT BALANCE TO SET: ");
					int acctBalanceReset = sc.nextInt();
					adi.updateAccountBalance(acctNumAdjust, acctBalanceReset);
					break;
//				case 4:
//					udi.getUserList();
//					break;
				case 4:
					System.out.println("USERID TO PROMOTE: ");
					int id = sc.nextInt();
					udi.promoteToAdmin(id);
					break;
				case 5:
					System.out.println("HAVE A NICE DAY!");
					mainMenu();
					break;
				default:
					System.out.println("INVALID OPTION");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
