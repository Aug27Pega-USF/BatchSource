package com.revature.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.account.Account;

public class Customer extends Account

{
	

	public Customer(String user, String acc_type, int acc_num, List<Customer> custOnAccount) {
		super(user, acc_num, custOnAccount);
		
		
	}

	//variables
	public String userName;
	public String password;
	int num;
	int userChoice;
	boolean quit = false;
	Scanner in = new Scanner(System.in);
	public ArrayList<Account> accounts;
	
	
	
    //make an instance of the account 
	
	
	void displayInfo()
	{
		System.out.println("Account User: " + userName);
		System.out.println("Account Number: " + acc_num);
		System.out.println("Account Balance: " +acc_balance); 
	}
	public void CustomerOptions()
	{
		while (quit != true)
		{
			System.out.println("1. Create Account");
			System.out.println("2. Desposit money");
			System.out.println("3. Withdraw money");
			System.out.println("4. Check Balance");
			System.out.println("5. Display Account Details");
			System.out.println("0. to quit \n");
			System.out.println("Enter your Choice: ");
			userChoice = in.nextInt();
			
		
			switch (userChoice) 
			{
				case 1: 
					
					Account.createAcc();
					
	                break;
	                
				case 2: // deposit
					
		             System.out.print("Enter Amount Of Money : ");
		             int amount = in.nextInt();
		             deposit(amount);       
		             break;
	                  
				 case 3: // withdraw money                      
	                   
	                if(acc_balance==0)
	                System.out.print("Your Account is Empty.\n");
	             
	                System.out.print("Enter Amout Of Money : ");   
	                int withd = in.nextInt(); 
	                
	                        
					if(withd > acc_balance)
					{
	                   System.out.print("Enter Valid Amout of Money : ");
	                   withd=in.nextInt();
					}
	                      
	                 withdraw(withd);  
	                
				 case 4: // check balance 
	                  checkBal();                       
	                  break;    
	                 
				 case 5: //display all bank info
					 display();
					 break;
					 
				 case 0:
					 quit = true;
					 break;
					 
				default: 
					System.out.println("Wrong Choice, Try again.");
					break;
		
				}
			}
			
		}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", password=" + password + ", accounts=" + accounts + "]";
	}
	
}
