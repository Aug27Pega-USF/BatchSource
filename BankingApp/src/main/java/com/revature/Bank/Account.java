package com.revature.Bank;

import java.util.Scanner;

public class Account {
	
	//Instance variables
	static double accountBalance;
	static String user;
	static double money; 
	static double withdraw; 
	static double deposit; 
	static String yes;
	static String no; 
	static String option; 
	
	
	static Scanner Prophet = new Scanner(System.in);
	
	
	public static void Withdraw(double withdraw) {
		 
		accountBalance = 500;
		
		
		
		if (accountBalance - withdraw <= 0) {
    	 System.out.println("Broke boy!");
		}
    	 else 
    		 accountBalance = accountBalance - withdraw;
    	 System.out.println("Your Current Balance is: "+ accountBalance);
    	 System.out.println("    ");
    	 System.out.println("Would you like to make another transaction?");
    	 System.out.println("     ");
    	 
    	 System.out.println("Select an option:\n1)Yes\n2)No");
    	 int Selection = Prophet.nextInt();
    	 switch(Selection) {
 		case 1 :
 			try {
				MainBank.AccountOptions();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
 			
 			break;
 		case 2:
 			 
 			System.out.println("Have a good day!");
 		    break;
 		}
    	 
     } 
	
    	 
    	 public static void Deposit(double deposit) {
    		 accountBalance = 500;
    		 
    		 if (money >= 0) {
    	     accountBalance = accountBalance + deposit;
    	     System.out.println("Your Current Balance is: "+ accountBalance);
    	     System.out.println("     ");
    		 System.out.println("Would you like to make another transaction?");
        	 System.out.println("     ");
        	 
        	 System.out.println("Select an option:\n1)Yes\n2)No");
        	 int Selection = Prophet.nextInt();
        	 switch(Selection) {
     		case 1 :
     			try {
    				MainBank.BankOption();
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
     			
     			break;
     		case 2:
     			 
     			System.out.println("Have a good day!");
     		    break;
     		}
    		 }
    	 }
 
      public static void Transfer() {
  
    	  
      }












}