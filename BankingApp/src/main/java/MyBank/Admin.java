package MyBank;

import java.util.Scanner;

public class Admin extends Employee {

	Customer person = new Customer();
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

