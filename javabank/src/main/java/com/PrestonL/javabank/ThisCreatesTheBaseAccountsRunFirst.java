package com.PrestonL.javabank;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ThisCreatesTheBaseAccountsRunFirst 
{
	static Scanner scanner;
	@SuppressWarnings("unchecked")
	public static void main( String[] args )
	{
		scanner = new Scanner(System.in);
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
		ArrayList<Integer> bankaccountidList = new ArrayList<Integer>();
		ArrayList<Application> applicationList = new ArrayList<Application>();


		accountList.add(new BankAccount("Joe Schmoe", 12345));
		accountList.add(new BankAccount("Jane Schmee", 12346));
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("Joe Schmoe");
		nameList.add("Jane Schmee");
		accountList.add(new BankAccount(nameList, 12348));
		Customer customer1= new Customer("Joe4", "password", "Joe Schmoe");
		ArrayList<Integer> customer1accountList= new ArrayList<Integer>();
		customer1accountList.add(12345);
		customer1accountList.add(12348);
		customer1.addAccountList(customer1accountList);
		ArrayList<Integer> customer2accountList= new ArrayList<Integer>();
		Customer customer2=	new Customer("Jane5", "pa$$word", "Jane Schmee");
		customer2accountList.add(12346);
		customer2accountList.add(12348);
		customer2.addAccountList(customer2accountList);
		userList.add(customer1);
		userList.add(customer2);
		userList.add(new Employee("Employee1","Employeepassword", "Cist Heffer"));
		userList.add(new Employee("Employee2","1234567", "Stefan Job"));
		userList.add(new Employee("Employee3","bobkemp64", "Bob Kemp"));
		userList.add(new Admin("AdamOverlord", "Adminpassword", "Adam Hawk"));
		userList.add(new Admin("SeanB", "v3nd%^f2!SYd", "Sean Bishop"));


		for (int i=0;i!=accountList.size();i++) {
			bankaccountidList.add(accountList.get(i).getAccountid());
		}

		for (int i=0; i!=userList.size();i++) {
			switch(userList.get(i).returnClass()){
			case "Employee":
				employeeList.add((Employee) userList.get(i));
				break;
			case "Customer":
				customerList.add((Customer) userList.get(i));
				break;
			case "Admin":
				adminList.add((Admin) userList.get(i));
				break;
			default:    		
			}
		}   	

		//more stuff here

		customerList.get(0).apply(accountList, applicationList);

		System.out.println("Bank Account:");
		for (int i=0; i!=accountList.size();i++) {
			System.out.println(accountList.get(i).toString());
		}
		adminList.get(0).approve(applicationList.get(0).getAccountid(), applicationList, customerList, accountList);
		customerList.get(1).applyjoint(12345, accountList, applicationList);
		customerList.get(0).apply(accountList, applicationList);
		customerList.get(1).applicationjoint(customerList.get(0).getPending().get(0), accountList, applicationList);

		//Serialization

		Bank bank=new Bank(userList, customerList, employeeList, adminList, accountList, applicationList);
		bank.serialize();
	}

}
