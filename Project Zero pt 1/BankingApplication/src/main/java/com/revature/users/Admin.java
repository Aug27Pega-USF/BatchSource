package com.revature.users;

import java.util.Scanner;

public class Admin extends Employee {

	public Admin(String password) {
		super(password);
		// TODO Auto-generated constructor stub
	}

	Customer person = new Customer(userName,password, acc_num, users);
	int adminChoice;
	Scanner in = new Scanner(System.in);
    
    public void adminOptions()
    {
    	System.out.println("1. View Account");
    	System.out.println("2. Change Account Status");
    	System.out.println("3.Cancel an Account");
    	adminChoice = in.nextInt();
    	
    	switch(adminChoice)
    	{
    	case 1:
    		
    		break;
    	case 2:
    		person.getAccounts();
    		
    		
    		break;
    	case 3:
    		break;
    	
    	}
    }
	
}

