package MyBank;

import java.util.Scanner;

public class Employee
{
	protected String password;
	String userName;
	
	Customer cust = new Customer(userName,  password);
	int empChoice;
	Scanner in = new Scanner(System.in);
	
	public Employee(String password)
	{
		super();
		this.password = password;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
