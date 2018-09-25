package com.revature.support;

import java.util.Scanner;

import com.revature.support.User;

public class MenuLogic {
	/*
	 * register: Allows a new user to register and create account.
	 * once created, not allowed to make transactions until account is approved*/
	public User register() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Creating new Account...");
		User newUser = new User();
		System.out.println("Please Enter Your First Name:");
		String fname = scan.nextLine();
		newUser.setFname(fname);
		System.out.println("Please Enter Your Last Name:");
		String lname = scan.nextLine();
		newUser.setLname(lname);
		System.out.println("Please Enter Your Username:");
		String uname = scan.nextLine();
		newUser.setUname(uname);
		System.out.println("Please enter a password:");
		String pw = scan.nextLine();
		newUser.setPw(pw);
		//scan.close();
		return newUser;
	}
}
