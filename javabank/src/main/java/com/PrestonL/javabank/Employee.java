package com.PrestonL.javabank;

import java.util.ArrayList;

public class Employee extends Customer {

	private static final long serialVersionUID = 5286670470382563398L;
	
	public Employee(String username, String password, String name) {
		super(username, password, name);
	}

	public void approve(int accountid, ArrayList<Application> applicationList, ArrayList<Customer> customerList, ArrayList<BankAccount> accountList) {
		for (int i=0; i!=applicationList.size(); i++) {
			if(accountid==applicationList.get(i).getAccountid()) {
				for (int j=0; j<accountList.size();j++) {
					if(accountid==accountList.get(j).getAccountid()) {
						if(accountList.get(j).getNameList().equals("()")) {
							accountList.remove(j);
							accountList.add(new BankAccount(applicationList.get(i).getNames(), applicationList.get(i).getAccountid()));
							break;
						}
						else {
							accountList.get(j).addNameList(applicationList.get(i).getNames());
							break;
						}
					}
				}
				for (int j=0; j!=customerList.size();j++) {
					if(customerList.get(j).hasPendingAccount(accountid)) {
						customerList.get(j).addAccount(accountid);
					}
				}
				applicationList.remove(i);
				break;
			}
		}
	}

	public void deny(int accountid, ArrayList<Application> applicationList, ArrayList<Customer> customerList, ArrayList<BankAccount> accountList) {
		for (int i=0; i<applicationList.size(); i++) {
			if(accountid==applicationList.get(i).getAccountid()) {
				applicationList.remove(i);
			}
		}
		for (int i=0; i<accountList.size(); i++) {
			if(accountid==accountList.get(i).getAccountid()) {
				accountList.remove(i);
				i--;
			}
		}
		for (int i=0; i<customerList.size();i++) {
			customerList.get(i).removeAccount(this, accountid, true);
		}
	}

	public void viewcustomerList(ArrayList<Customer> customerList) {
		for(int i=0; i!=customerList.size();i++) {
			System.out.println(i+". "+customerList.get(i).name);
		}
	}

	public void viewapplicationList(ArrayList<Application> applicationList) {
		for (int i=0; i!=applicationList.size();i++) {
			System.out.println(i+". " + applicationList.get(i).getAccountid() + " " + applicationList.get(i).getNameList() + " " + applicationList.get(i).getAccountid());
		}
	}

	public String viewcustomerinfo(String username, ArrayList<Customer> customerList, ArrayList<BankAccount> bankaccountlist){
		for(int i=0; i!=customerList.size();i++) {
			if(customerList.get(i).getUsername()==username){
				return customerList.get(i).customerInfo(bankaccountlist);
			}
		}
		return "Error. No customer with that username found.";
	}

	public String toString() {
		return "Employee [username="+ super.getUsername() +", password="+super.getPassword()
		+ "]";
	}

	public String returnClass() {
		return "Employee";
	}

}
