package MyBank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

enum Level
{
	CUSTOMER, EMPLOYEE, ADMIN
;
}
public class Driver{
	
		static Level level;
		static Scanner in = new Scanner(System.in);
		
		public static void user(Level level)
		{
			switch(level)
			{
			case CUSTOMER:
				Customer me = new Customer();
				me.CustomerOptions();
				break;
			case EMPLOYEE: 
				Employee emp = new Employee();
				emp.employeeOptions();
				break;
			case ADMIN:
				Admin boss = new Admin();
				boss.adminOptions();
				break;
				
				
			default:
				break;
			}
		}
		public static void main(String [] args) 
		{
			System.out.println("WELCOME TO THE BANK");
			System.out.println("Are you a: Customer, Employee, Admin");
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
	        } catch (Exception e){
	            return "Error: " + e.getMessage();
	        }
		
	        }
		
}//end of driver

