package com.revature.users;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.DAOimpl.AccountDaoImpl;
import com.revature.account.Account;

public class Employee
{
	protected String password;
	protected String userName;
	public int balance;
	protected int acc_num;
	
	static AccountDaoImpl accountimpl = new AccountDaoImpl();

	String pick;
	public ArrayList <Customer> users;
	
	Customer cust = new Customer(userName,  password, acc_num, users);
	Account acct = new Account(userName, acc_num, users);
	int empChoice;
	int userID;
	boolean quit = false;
	Scanner in = new Scanner(System.in);
	
	
	public Employee(String password)
	{
		super();
		this.password = password;
	}
		
	void ChangeStatus(ArrayList<Customer> users)
	{
		
	}
	public void employeeOptions(ArrayList <Customer> users) throws SQLException
	{
		while (quit != true)
		{
			System.out.println("1. Veiw Users Details");
			System.out.println("2. Veiw Account Details");
			System.out.println("3. Delete Account");
			System.out.println("0. Go back to main menu");
			
			empChoice = in.nextInt();
			
			switch(empChoice)
			{
			case 1:
				accountimpl.getAllAccounts();
				break;
				
			case 2:
				acct.display(userName,acc_num,balance);
				break;	
				
			case 3:
				System.out.println("Enter a userID number to delete account");
				userID = in.nextInt();
				accountimpl.doDelete(userID);
				System.out.println("Account has been deleted");
				break;
			case 0:
				System.out.println("logging out");
				quit = true;
				break;
			}
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [password=" + password + "]";
	}
	
	
}
