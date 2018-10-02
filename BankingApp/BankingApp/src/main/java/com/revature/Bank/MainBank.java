package com.revature.Bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class MainBank {
	
	
	static String username;
	static Scanner Keyboard = new Scanner(System.in);
	static File TextFile = new File("BankStorage.txt");
	static Account account;
	
	
	static Connection conn = getConnection();
    static Statement stmt;
    static ResultSet rs = null;
    static PreparedStatement ps;
    
    public static Connection getConnection() {
		
		
		   
		Connection conn = null;
		try {
	            Properties prop = new Properties();
	            prop.load(new FileReader("database.property"));
	            Class.forName(prop.getProperty("driver"));
	            try {
					conn = DriverManager.getConnection(prop.getProperty("url"),
					        prop.getProperty("usr"),
					        prop.getProperty("password"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		   return conn;
	}
	
	public static void main(String[] args) throws Exception {

		
		BankOption(); 
	    
	    
	    
	    }
	
public static void AccessCode() {
		
		BankAdmins.AccountAccess(); 
	}
	
	
	public static void BankOption() throws Exception {
		System.out.println("Select an option:\n1)Customer\n2)Administrator");
		int Choice = Keyboard.nextInt();
		switch(Choice) {
		case 1 :
			Initialize();
			break;
		case 2:
			AccessCode(); 
		    break;
		}
	
		
	}
		 
	public static void Initialize() throws Exception {
		System.out.println("Select an option:\n1)Create an account\n2)Login to your account");
		int Choice = Keyboard.nextInt(); 
		switch(Choice) {
		case 1 :
			Customer.MakeAccount();
			BankOption(); 
		break;
		case 2 :
			
			Customer.LoginAccount();
			AccountOptions();
		break;
		
		
	}
	}
	public static void AccountOptions()  {
		System.out.println("Select an option:\n1)Withdraw\n2)Deposit\"");
		int Choice = Keyboard.nextInt();
		switch(Choice) {
		case 1 :
			System.out.println("How much would you like to withdraw?");
			double withDraw = Keyboard.nextDouble();
			Account.Withdraw(withDraw);
			
			break;	
			
		case 2 :
			System.out.println("Enter amount of funds to deposit:");
			double DEposit = Keyboard.nextDouble();
			Account.Deposit(DEposit);
			
		break;	
		case 3 :
			
		break;
		}
		
		
		
	
		
		
	}

}
