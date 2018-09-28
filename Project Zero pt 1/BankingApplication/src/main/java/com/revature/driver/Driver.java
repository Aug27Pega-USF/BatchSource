package com.revature.driver;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


import com.revature.users.Admin;
import com.revature.users.Customer;
import com.revature.users.Employee;

enum Level
{
	CUSTOMER, EMPLOYEE, ADMIN, LOGOUT
;
}
public class Driver{
	
		static Level level;
		static Scanner in = new Scanner(System.in);
		static Scanner sc = new Scanner(System.in);
		static String  emp_password = "emppass";
		static String admin_password = "adminpass";
		static String temp;
		static int userID;
		static long acc_num;
		static float acc_balance;
		static int stat;
		String userName;
		String password;
		ArrayList <Customer> users;
		static Level out = Level.LOGOUT;
		
	
		
	
		public static void user(Level level) throws SQLException
		{
			while(level != out)
			{
				switch(level)
				{
				case CUSTOMER:
					String userName = null;
					String password = null;
					ArrayList <Customer> users = null;
					Customer me = new Customer(userName, password,0, users);
					me.CustomerOptions();
					break;
				case EMPLOYEE: 
					Employee emp = new Employee(null);
					System.out.println("Enter your employee password: ");
					temp = in.next();
					if (temp.equals(emp_password))
					{
						emp.employeeOptions(null);
					}
					else 
						System.out.println("Either your password is wrong or you are not an employee!");
					break;
				case ADMIN:
					Admin boss = new Admin(null);
					System.out.println("Enter your Admin password: ");
					temp = in.next();
					if(temp.equals(admin_password))
					{
						boss.adminOptions();
					}
					else
						System.out.println("YOU'RE NOT AN ADMIN");
					break;
				case LOGOUT:
					System.out.println("You have logout of the bank");
					break;
					
				default:
					break;
				}
			}
		}
		public static void main(String [] args) throws SQLException 
		{
			System.out.println("WELCOME TO THE BANK");
			System.out.println("Are you a: Customer, Employee, Admin or do  you want to logout?");
			String pick = getInput("Please enter a option: ");
			level = Level.valueOf(pick.toUpperCase());
			user(level);  
		}//end of main
		   private static String getInput(String prompt)
	       { 
		        BufferedReader stdin = new BufferedReader(
		                new InputStreamReader(System.in));
		        System.out.print(prompt);
		        System.out.flush();
		        try{
		            return stdin.readLine();
		        }catch (Exception e){
		            return "Error: " + e.getMessage();
		        }
			
	       }
		
}//end of driver

