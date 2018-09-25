package com.revature.users;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.DAOimpl.AccountDaoImpl;
import com.revature.account.Account;

public class Employee
{
	protected String password;
	protected String userName;
	protected int acc_num;
	
	static AccountDaoImpl accountimpl = new AccountDaoImpl();

	String pick;
	public ArrayList <Customer> users;
	
	Customer cust = new Customer(userName,  password, acc_num, users);
	Account acct = new Account(userName, password, acc_num, users);
	int empChoice;
	Scanner in = new Scanner(System.in);
	
	
	public Employee(String password)
	{
		super();
		this.password = password;
	}
		
	void ChangeStatus(ArrayList<Customer> users)
	{
		
	}
	public void employeeOptions(ArrayList <Customer> users)
	{
		System.out.println("1. Veiw Account Details");
		System.out.println("2.Change account status");
		empChoice = in.nextInt();
		
		switch(empChoice)
		{
		case 1:
			acct.display();
			break;
			
		case 2:
			accountimpl.approveAccount();
			System.out.println("all accounts have been approved!");
			break;	
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
