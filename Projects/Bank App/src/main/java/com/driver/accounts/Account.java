package com.driver.accounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Parent Account Class
 * Shared by Customers and Employees for their individual login information and functions
 */
public class Account implements Serializable{
	
	
	/*
	 * Fields
	 */
	private static final Logger log = LogManager.getLogger(Account.class.getName());
	private static final long serialVersionUID = 1L;
	private int user_id;
	
	//login info
	private String user_name;
	private String password;
	
	/*
	 * Constructor
	 */
	public Account(String user_name, String password, int id) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.user_id = id;
	}

	/*
	 * Methods
	 */
	public static void NewAccountMessage(String user_name, String password, String type) {
		//print everything back
		System.out.println("************************");
		System.out.println("NEW "+ type + " ACCOUNT CREATED!");
		System.out.println("Username: " + user_name);
		System.out.println("Password: " + password);
		System.out.println();
		log.info("NEW "+ type + " ACCOUNT CREATED! Username: " + user_name + ", Password: " + password);
		System.out.println("************************");
	}
	
	public static void logTransaction(String str) {
		System.out.println(str);
		log.info(str);
	}
	
	/*
	 * Getters/Setters
	 */
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	
}

