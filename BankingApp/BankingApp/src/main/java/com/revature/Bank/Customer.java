package com.revature.Bank;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.AccountLogin;
import com.revature.beans.USERS;
import com.revature.daoimpl.USERSdaoImpl;


  
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	static String register; 
	static String login;
	static String x;
	static String username; 
	static String password;
	
	static Scanner scan = new Scanner(System.in);
	 
	 
	
	public static void MakeAccount() throws IOException {
     
		USERSdaoImpl userimpl = new USERSdaoImpl();
		
		System.out.println("Create Username:");
		String uname = scan.nextLine();
		
		System.out.println("Create Password:");
		 String pass = scan.nextLine();
		
		 USERS x = new USERS(uname, pass); 

        
        try {
			userimpl.createUSERS(x);
			System.out.println("User added!");
			
		} catch (SQLException e) {
			e.printStackTrace();}
		}
	
	
public static void LoginAccount() throws IOException {
	
	USERSdaoImpl userimpl = new USERSdaoImpl();
		
	System.out.println("Enter Username:");
		String LoginU = scan.next();

      
       System.out.println("Enter Password:");
       String LoginP = scan.next();
       
       AccountLogin y = new AccountLogin(LoginU, LoginP);
       
       try {
    			userimpl.getLoginList(y);
    			
    			
    		} catch (SQLException e) {
    			e.printStackTrace();}
    		}
       
     }












