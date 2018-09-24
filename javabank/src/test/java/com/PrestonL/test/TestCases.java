package com.PrestonL.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.PrestonL.javabank.Admin;
import com.PrestonL.javabank.Application;
import com.PrestonL.javabank.Bank;
import com.PrestonL.javabank.BankAccount;
import com.PrestonL.javabank.Customer;
import com.PrestonL.javabank.Employee;
import com.PrestonL.javabank.ThisCreatesTheBaseAccountsRunFirst;
import com.PrestonL.javabank.User;
import com.PrestonL.sqlbank.*;

public class TestCases {
	public ThisCreatesTheBaseAccountsRunFirst myBase;
	public Bank bank;
	ArrayList<User> userList;
	ArrayList<Customer> customerList; 
	ArrayList<Employee> employeeList;
	ArrayList<Admin> adminList; 
	ArrayList<BankAccount> accountList; 
	ArrayList<Application> applicationList; 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		userList = new ArrayList<User>();
		customerList = new ArrayList<Customer>();
		employeeList = new ArrayList<Employee>();
		adminList = new ArrayList<Admin>();
		accountList = new ArrayList<BankAccount>();
		applicationList = new ArrayList<Application>();
		myBase =new ThisCreatesTheBaseAccountsRunFirst();
		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream
					("Bank.txt");
			ObjectInputStream in = new ObjectInputStream
					(file);

			// Method for deserialization of object
			userList = (ArrayList<User>)in.readObject();

			in.close();
			file.close();

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
			file = new FileInputStream
					("Bankaccount.txt");
			in = new ObjectInputStream
					(file);           

			accountList=(ArrayList<BankAccount>)in.readObject();
			in.close();
			file.close();
			file = new FileInputStream
					("Application.txt");
			in = new ObjectInputStream
					(file);           

			applicationList=(ArrayList<Application>)in.readObject();
			in.close();
			file.close();
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" +
					" is caught");
		}


		//Creation of Bank Class
		bank=new Bank(userList, customerList, employeeList, adminList, accountList, applicationList);




	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void register() {
		bank.registerCustomer("username", "password", "name");
		User temp= bank.login("username", "password");
		assertTrue(bank.getUserList().get(bank.getUserList().size()-1).equals(temp));

	}
	@Test
	public void testdepositwithdrawal() {
		assertTrue(bank.matchAccount(12345).getBalance()==0);
		bank.depositInto(12345, 23.00);
		assertTrue(bank.matchAccount(12345).getBalance()==23);
		bank.withdrawFrom(12345, 11);
		assertTrue(bank.matchAccount(12345).getBalance()==12);
		assertTrue(accountList.get(1).deposit(111));
		assertTrue(accountList.get(1).withdraw(11));
		assertTrue(!accountList.get(1).deposit(11.11111));
		assertTrue(!accountList.get(1).deposit(-1));
		assertTrue(!accountList.get(1).withdraw(-111));
		assertTrue(!accountList.get(1).withdraw(1111111));
		assertTrue(!accountList.get(1).withdraw(1.111));

	}

	@Test
	public void testadmindelete() {
		int size= accountList.size();
		adminList.get(0).delete(12345, customerList, accountList);
		assertTrue(accountList.size()==size-1);
	}
	@Test
	public void applyingforaccounts() {
		customerList.get(0).apply(accountList, applicationList);
		customerList.get(0).applyjoint(12345, accountList, applicationList);
	}

	@Test
	public void testemployeeandadminapprovedenyapplication() {
		int appsize = applicationList.size();
		int accountsize= accountList.size();
		assertTrue(applicationList.get(0).isExisting());
		employeeList.get(0).approve(applicationList.get(0).getAccountid(), applicationList, customerList, accountList);
		assertTrue(applicationList.size()==appsize-1);
		assertTrue(accountList.size()==accountsize);
		assertTrue(!applicationList.get(0).isExisting());
		adminList.get(0).deny(applicationList.get(0).getAccountid(), applicationList, customerList, accountList);
		assertTrue(applicationList.size()==appsize-2);
	}






}
