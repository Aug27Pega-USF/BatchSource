package MyBank;

import java.util.Scanner;

public class Employee
{
	Customer cust = new Customer();
	int empChoice;
	Scanner in = new Scanner(System.in);
	
	void lookUpInfo()
	{
		cust.displayInfo();
	}	
	
	void employeeOptions()
	{
		System.out.println("1. Veiw Account Details");
		System.out.println("2.Change account status");
		empChoice = in.nextInt();
		
		switch(empChoice)
		{
		case 1:
			System.out.println("Displaying Customer Info: \n");
			lookUpInfo();
			break;
			
		case 2:
			break;	
		}
	}
}
