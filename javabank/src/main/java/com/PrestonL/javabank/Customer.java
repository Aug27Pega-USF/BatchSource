package com.PrestonL.javabank;

import java.util.ArrayList;
import java.util.Random;

public class Customer extends User{
	private static final long serialVersionUID = -8379833379579096834L;
	private ArrayList<Integer> accountList;
	private ArrayList<Integer> pendingList;
	public String name;

	public Customer(String username, String password, String name) {
		super(username, password);
		this.name=name;
		accountList=new ArrayList<Integer>();
		pendingList=new ArrayList<Integer>();
	}

	public void apply(ArrayList<BankAccount> accountList, ArrayList<Application> applicationList) {
		Random ran = new Random();
		boolean check=false;
		int id;
		do{
			check=true;
			id=10000+ran.nextInt(89999);
			for(int i=0; i!=accountList.size();i++) {
				if (id==accountList.get(i).getAccountid()) {
					check=false;
					break;
				}
			}
		}while(!check);
		pendingList.add(id);
		applicationList.add(new Application(this.getUsername(),id,this.name));
		accountList.add(new BankAccount(id));
	}

	public boolean applyjoint(int accountid, ArrayList<BankAccount> accountList, ArrayList<Application> applicationList) {
		boolean check=false;
		if (this.pendingList.contains(accountid)) {
			return false;
		}
		if (this.accountList.contains(accountid)) {
			return false;
		}
		if (!applicationjoint(accountid, accountList, applicationList)) { //basically if an application already exists to an existing account, then we assume that the customer will be added onto that application.
			for (int i = 0; i != accountList.size(); i++) {
				if (accountList.get(i).getAccountid() == accountid) {
					check = true;
					pendingList.add(accountid);
					applicationList.add(new Application(this.getUsername(), accountid, this.name, true, true));
				}
			} 
		}
		return check;
	}

	public boolean applicationjoint(int accountid, ArrayList<BankAccount> accountList, ArrayList<Application> applicationList) {
		boolean check=false;
		if (this.pendingList.contains(accountid)) {
			return false;
		}
		if (this.accountList.contains(accountid)) {
			return false;
		}
		for (int i=0; i!=applicationList.size();i++) {
			if (applicationList.get(i).getAccountid()==accountid) {
				applicationList.get(i).addName(this.name);
				pendingList.add(accountid);
				check=true;
			}
		}
		return check;
	}

	public ArrayList<Integer> getPending() {
		return pendingList;
	}

	public boolean hasPendingAccount(Integer accountid) {
		if(pendingList.contains(accountid)) {
			return true;
		}
		else return false;
	}
	public void addAccount(Integer accountid) {
		pendingList.remove(accountid);
		accountList.add(accountid);
	}

	public ArrayList<Integer> getAccountList() {
		return accountList;
	}

	public void setAccountList(ArrayList<Integer> accountList) {
		this.accountList = accountList;
	}

	public void addAccountList(ArrayList<Integer> accountList) {
		for(int i=0; i!=accountList.size();i++) {
			this.accountList.add(accountList.get(i));
		}
	}

	public void removeAccount(Admin admin, int accountid) {
		for(int i=0; i!=accountList.size();i++) {
			if(accountList.get(i)==accountid) {
				accountList.remove(i);
				break;
			}
		}
	}

	public void removeAccount(Employee employee, int accountid, boolean app) {
		for(int i=0; i<accountList.size();i++) {
			if(accountList.get(i)==accountid) {
				accountList.remove(i);
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Customer [username="+ super.getUsername() +", password="+super.getPassword()
		+ "]";
	}

	public String customerInfo(ArrayList<BankAccount> bankaccountlist) {
		String accountinfo="";
		if (accountList.isEmpty()) {
			accountinfo+="No accounts found.";
		}
		else {
			for(int i=0; i!=accountList.size();i++) {
				int accountid=accountList.get(i);
				for (int j=0; j!=bankaccountlist.size();j++) {
					if(accountid==bankaccountlist.get(j).getAccountid()) {
						BankAccount info=bankaccountlist.get(j);
						accountinfo+="Account "+ accountid + ":\nOwners: "+ info.getNameList()+"\nBalance:" +
								String.format("$%.2f", info.getBalance()) + "\nDate Opened: " + info.getCreationDate()+"\n"
								+"--------------------\n";
					}
				}
			}
		}
		String pendinginfo="";
		if (!pendingList.isEmpty()) {
			pendinginfo="Pending Account Applications:\n";
			for(int i=0; i!=pendingList.size();i++) {
				pendinginfo+= "Account "+ pendingList.get(i) + "\n";
			}
		}
		return "====================\nCustomer Information:\nUsername: " + super.getUsername() + "\nName: " + name + "\nAssociated Accounts:\n--------------------\n" + accountinfo
				+ pendinginfo; 
	}

	public String returnClass() {
		return "Customer";
	}

}
