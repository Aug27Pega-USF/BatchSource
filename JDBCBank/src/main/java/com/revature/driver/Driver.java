package com.revature.driver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.centers.RegistrationCenter;
import com.revature.centers.UserCenter;
import com.revature.daoimp.UserDAOImp;

public class Driver {

	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int n;
		do {
		System.out.println("************Welcome to JABCBank************");
		System.out.println("Please choose from the following options:");
		System.out.println("Press 1 For registered Users");
		System.out.println("Press 2 to register as a User");
		System.out.println("Press 3 to exit the system");
		n = input.nextInt();
		if(n == 1) {
			System.out.println("You have choosen to go into Users. Is this correct (Y/N)?");
			String c = input.next();
			if(c.equalsIgnoreCase("Y")) {
				System.out.println("Type in UserName");
				String userName = input.next();
				System.out.println("Type in Password");
				String password = input.next();
				UserDAOImp usi = new UserDAOImp();
				try {
					int userId = usi.userSignIn(userName,password);
					if(userId != 0){
						int clearanceId = usi.getUserClearance(userId);
						if(clearanceId == 1) {
							System.out.println("Transferring to Administration center");
							UserCenter.adminCenter(userId);
						}else if(clearanceId == 2) {
							System.out.println(clearanceId);
							System.out.println("Transferring to User Center");
							UserCenter.userCenter(userId);
						}
					}else if (userId ==0) {
					System.out.println("You information entered was not correct");
					System.out.println("If you haven't registered please Register first");
					System.out.println("Press any key to continue back to main menu");
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
				
			}else {
				System.out.println();
			}
		}else if(n == 2) {
			System.out.println("You have choosen to register. Is this correct (Y/N)?");
			String c = input.next();
			if(c.equalsIgnoreCase("Y")) {
				System.out.println("Transferring to Registration");
				RegistrationCenter.registration();
			}else {
				System.out.println();
			}
		}else if(n == 3){
			break;
		}

	}while (n != 3);
		System.out.println("Thank you for choosing JDBCBank");
	}
}
