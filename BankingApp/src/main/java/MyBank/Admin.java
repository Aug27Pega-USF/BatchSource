package MyBank;

import java.util.Scanner;

public class Admin extends Employee {

	public Admin(String password) {
		super(password);
		// TODO Auto-generated constructor stub
	}

	Customer person = new Customer(userName,password);
	int adminChoice;
	Scanner in = new Scanner(System.in);
    
    void adminOptions()
    {
    	System.out.println("1. View Account");
    	System.out.println("2. Change Account Status");
    	System.out.println("3.Cancel an Account");
    	adminChoice = in.nextInt();
    	
    	switch(adminChoice)
    	{
    	case 1:
    		person.displayInfo();
    		break;
    	case 2:
    		break;
    	case 3:
    		break;
    	
    	}
    }
	
}

