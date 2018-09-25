package com.revature.runtime;

import java.sql.SQLException;
import java.util.Scanner;

public class Runtime {

	public static void main(String[] args) {
		
		System.out.println("====== WELCOME TO BANK OF REVATURE ====== ");
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your username or register a new username");
		String username = sc.nextLine();
		System.out.println("Please enter your password or register a new password");
		String passwd = sc.nextLine();*/
		Front frt = new Front();
		try {
			frt.process();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//frt.checkLogin(username, passwd);//should check the usr and pwd with db
		//if success present the menu
		//if failure ask to register and create a user info for them
		//
	}

}
