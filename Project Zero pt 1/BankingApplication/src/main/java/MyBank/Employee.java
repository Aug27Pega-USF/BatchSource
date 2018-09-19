package MyBank;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee
{
	protected String password;
	String userName;
	
	Customer cust = new Customer(userName,  password);
	int empChoice;
	Scanner in = new Scanner(System.in);
	public ArrayList <Customer> users;
	
	public Employee(String password)
	{
		super();
		this.password = password;
	}
	void lookUpInfo()
	{
		cust.displayInfo();
	}	
	
	void employeeOptions(ArrayList <Customer> users)
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
			cust.viewAccounts(users);
			break;	
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
