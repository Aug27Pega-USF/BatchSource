package com.PrestonL.javabank;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Bank {
	ArrayList<User> userList = new ArrayList<User>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	ArrayList<Admin> adminList = new ArrayList<Admin>();
	ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
	ArrayList<Application> applicationList = new ArrayList<Application>();

	public Bank(ArrayList<User> userList, ArrayList<Customer> customerList, ArrayList<Employee> employeeList,
			ArrayList<Admin> adminList, ArrayList<BankAccount> accountList,
			ArrayList<Application> applicationList) {
		super();
		this.userList = userList;
		this.customerList = customerList;
		this.employeeList = employeeList;
		this.adminList = adminList;
		this.accountList = accountList;
		this.applicationList = applicationList;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void getUser() {
		System.out.println("Users:");
		for (int i=0; i!=userList.size();i++) {
			System.out.println(userList.get(i).toString());
		}
	}

	public boolean usernamecheck(String username) {
		for(int i=0; i!=this.userList.size();i++) {
			if(this.userList.get(i).doesUsernameEqual(username)) {
				return false;
			}
		}	
		return true;
	}

	public void registerCustomer(String username, String password, String name) {
		Customer temp= new Customer(username, password, name);
		userList.add(temp);
		customerList.add(temp);
	}

	public User login(String username, String password) {
		for(int i=0; i!=this.userList.size();i++) {
			if(this.userList.get(i).doesEqual(password, username)) {
				return this.userList.get(i);
			}
		}
		return null;
	}

	public Application matchApplication(int accountid) {
		for(int i=0; i!=this.applicationList.size();i++) {
			if(accountid==this.applicationList.get(i).getAccountid()) {
				return this.applicationList.get(i);
			}
		}
		return null;
	}

	public BankAccount matchAccount(int accountid) {
		for(int i=0; i!=this.accountList.size();i++) {
			if(accountid==this.accountList.get(i).getAccountid()) {
				return this.accountList.get(i);
			}
		}
		return null;
	}

	public String getPendingList(Customer customer) {
		String temp="";
		ArrayList<Integer> tempPending= customer.getPending();
		for(int i=0; i!=tempPending.size();i++) {
			temp+= (i+1)+ ". " + matchApplication(tempPending.get(i)).toString() + "\n";
		}
		return temp;
	}

	public String viewApplications() {
		String temp="";
		for(int i=0;i!=applicationList.size();i++) {
			temp+= (i+1)+". " + applicationList.get(i).toString() + "\n";
		}
		temp+= (applicationList.size()+1) + ". Back";
		return temp;
	}

	public String viewCustomers() {
		String temp="";
		for(int i=0;i!=customerList.size();i++) {
			temp+= (i+1)+". " + customerList.get(i).toString() + "\n";
		}
		temp+= (customerList.size()+1) + ". Back";
		return temp;
	}

	public String getAccountList(Customer customer) {
		String temp="";
		ArrayList<Integer> tempAccount = customer.getAccountList();
		for(int i=0; i!=tempAccount.size();i++) {
			temp+= (i+1)+ ". " + matchAccount(tempAccount.get(i)).toString() + "\n";
		}
		temp+= (tempAccount.size()+1) + ". Back";
		return temp;
	}

	public boolean depositInto(int accountid, double amount) {
		return matchAccount(accountid).deposit(amount);
	}

	public boolean withdrawFrom(int accountid, double amount) {
		return matchAccount(accountid).withdraw(amount);
	}

	public String returnaccountInfo(int accountid) {
		return matchAccount(accountid).toString();
	}

	public void serialize() {
		// Serialization
		try {

			// Saving of object in a file
			FileOutputStream file = new FileOutputStream
					("Bank.txt");
			ObjectOutputStream out = new ObjectOutputStream
					(file);

			// Method for serialization of object
			out.writeObject(userList);

			out.close();
			file.close();
			// Saving of object in a file
			file = new FileOutputStream("Bankaccount.txt");
			out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(accountList);

			out.close();
			file.close();

			file = new FileOutputStream("Application.txt");
			out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(applicationList);

			out.close();
			file.close();            
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

}
