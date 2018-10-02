package com.revature.Bank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.USERS;

import com.revature.daoimpl.USERSdaoImpl;

public class BankAdmins {


static Scanner ScanIt = new Scanner(System.in);

	
public static void AccountAccess() {
	
	System.out.println("Please enter access code:");
	int Integer = ScanIt.nextInt();
	
	if (Integer == 121964) {
		MainMenu(); 
	}else System.out.println("Access Denied!");
	
}

public static void MainMenu() {
	
	
	System.out.println("Select an option:\n1)View Accounts\n2)Create Account\n3)Delete Account");
	int choose = ScanIt.nextInt(); 
	switch(choose) {
	case 1 :
		
		 USERS x = new USERS();
		
		USERSdaoImpl udi = new USERSdaoImpl();
		try {
			
			
			List<USERS> USERSList =	udi.getUSERSList(x); // Lists the users
			System.out.println(USERSList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Would you like to make another transaction?");
	   	 System.out.println("     ");
	   	 
	   	 System.out.println("Select an option:\n1)Yes\n2)No");
	   	 int Selection = ScanIt.nextInt();
	   	 switch(Selection) {
			case 1 :
				try {
					AccountAccess();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				break;
			case 2:
				 
				System.out.println("Have a good day!");
			    break;
			}
		
		
		break;	
		
	case 2 :
		
		try {
			Customer.MakeAccount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Would you like to make another transaction?");
   	 System.out.println("     ");
   	 
   	 System.out.println("Select an option:\n1)Yes\n2)No");
   	 int Pick = ScanIt.nextInt();
   	 switch(Pick) {
		case 1 :
			try {
				AccountAccess();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			break;
		case 2:
			 
			System.out.println("Have a good day!");
		    break;
		}
		
		
	break;	
	case 3 :
		USERSdaoImpl impl = new USERSdaoImpl();
		
		System.out.println("Enter ID that you want to delete:");
		String uname = ScanIt.next();
		
		
		
		 USERS y = new USERS(uname, null); 

        
        try {
			impl.DeleteCustomer(uname);
			System.out.println("User deleted!");
			
		} catch (SQLException e) {
			e.printStackTrace();}
		System.out.println("Would you like to make another transaction?");
	   	 System.out.println("     ");
	   	 
	   	 System.out.println("Select an option:\n1)Yes\n2)No");
	   	 int Select = ScanIt.nextInt();
	   	 switch(Select) {
			case 1 :
				try {
					AccountAccess();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				break;
			case 2:
				 
				System.out.println("Have a good day!");
			    break;
			}
        
        break;
		}
	
		
		
	
	}
	
}



	
	

