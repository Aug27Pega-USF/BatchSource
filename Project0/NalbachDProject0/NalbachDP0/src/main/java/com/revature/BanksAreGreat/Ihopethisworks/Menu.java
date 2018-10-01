package com.revature.BanksAreGreat.Ihopethisworks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.Connection.UserAdmin;
import com.revature.DAOImpl.AccountDAOImpl;
import com.revature.DAOImpl.TransactionsDAOImpl;
import com.revature.DAOImpl.UsersDAOImpl;
import com.revature.tables.*;

public class Menu {
	//instance variables
	static Scanner keyboard = new Scanner(System.in);
	//Bank bank = new Bank(); 
	static boolean exit;
	static String userInput = "";
	private static Object userId;
	
	public static void main(String[] args) {
		//creates an object of this class		
		Menu menu = new Menu();
		Menu.runMenu();
	}
	
	//run the menu while the user input is not exit 
	public static void runMenu(){
		printHeader();
		System.out.println("You are now exiting the system.");
	}
	
	//prints a header
	private static void printHeader() {
	int choice;
	do{
		System.out.println("======================");
		System.out.println("|      WELCOME       |");
		System.out.println("======================");
		System.out.println("1) Login");
		System.out.println("2) Create users account");
		System.out.println("Press 9 to exit the system");
		Scanner src = new Scanner(System.in); 
		choice = src.nextInt();
		if(choice == 1) {
			login();
		}else if(choice == 2){
			createAnAccount();
		}else if(choice==9){
			break;
		}
	}while(choice!=9);
	}
	//main menu case 1
	public static void login() {
		UserAdmin ua = new UserAdmin();
		int userId = 0;
		int userType = 2; 
		UsersDAOImpl udi = new UsersDAOImpl(); 
		System.out.println("Please enter username: ");
		Scanner scan = new Scanner(System.in); 
		String username = scan.nextLine();
		System.out.println("Please enter password: "); 
		String password = scan.nextLine();
		
		try {
			userId = udi.getLogin(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			userType = udi.getLevel(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(userType == 1) {
			ua.userAdminChoices(userId);
		}else if(userType == 2) {
			ua.userChoices(userId);
		}
			
	}
	public static void userAdminChoices(int userId) {
		System.out.println("Admin Menu: ");
		System.out.println("1) View all users: ");
		System.out.println("2) View users accounts");
		System.out.println("3) Delete user" );
		System.out.println("0) Exit ");
	}
	
	//Main menu case 2
	private static void createAnAccount() {
		String firstName, lastName, username, password;
		UsersDAOImpl udi = new UsersDAOImpl();
			System.out.println("enter a username: ");
			username = keyboard.nextLine();
			System.out.println("enter a password: ");
			password = keyboard.nextLine();
			System.out.print("please enter your first name: ");
			firstName = keyboard.nextLine();
			System.out.print("please enter your last name: ");
			lastName = keyboard.nextLine();
			
			try {
				udi.createUsers(username, password, firstName, lastName);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				//udi.createUsers("184565", "Dnal", "working", "Donna", "Nalbach", 2);
				System.out.println(udi.getUserslist());
			}catch(SQLException e) {
				e.printStackTrace();
			}
			AccountDAOImpl adi = new AccountDAOImpl();
			int userId = 0;
			try {	
				userId =udi.getLastUser();
				//System.out.println(adi.getAccountList());
			}catch(SQLException e) {
				e.printStackTrace();
			}
			int accountId = 0;
			try {
				
				adi.createAccount("OK", userId, 52);
				accountId =adi.getLastAccount();
				adi.getCertain2Account(accountId, userId);

			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			TransactionsDAOImpl ttdi = new TransactionsDAOImpl();
			try {
				ttdi.createTransactions( accountId, "TransactionName", 2);
				System.out.println(ttdi.getTransactionsList());
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
				System.out.println("please enter your intitial deposit: ");
				try {
					int initialDeposit1 = (int) Double.parseDouble(keyboard.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("Deposit must be a number.");
				
				}
	}

}