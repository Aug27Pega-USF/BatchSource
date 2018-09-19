package MyBank;

import java.util.ArrayList;

enum Status
{
	PENDING, ACTIVE, DENY, CLOSED;
}
public class Account {
	//variables
	public String user;
	public String acc_type;
	public int acc_num;
	public float acc_balance;
	public Status stat;
	public ArrayList <String> userAccounts;
	
	//constructor
	public Account(String user, String acc_type, int acc_num)
	{
		this.userAccounts = new ArrayList<String>();
		this.userAccounts.add(user);
		this.acc_type = acc_type;
		this.acc_num = acc_num;
		this.acc_balance = 0.00f;
		this.stat = Status.PENDING;
	}
	
	void createAcc()
	{
		acc_num = (int)((Math.random() * 900000000)+ 10000000);
		System.out.println("Your Account number is: " + acc_num);
	}
	
	public void deposit (int money)
	{
		if(this.stat != Status.ACTIVE)
		{
			System.out.println("This accout has not yet been activated");
		}
		else 
		{
			if (money >=0)
			acc_balance = acc_balance + money;
		}
	}
	int withdraw(int take)
	{
		if (acc_balance != 0)
		acc_balance = acc_balance - take;
		System.out.println("Current Balance is: "+ acc_balance);

		return take;
	}
	//transfer between accounts
	int transfer(int amount)
	{
		withdraw(amount);
		deposit(amount);
		return amount;
	}
	void checkBal()
	{
		System.out.println("got this far");
		//System.out.println("Your Balance is:" + acc_balance);
	}
	void display()
	{
		System.out.println("Acount User: " + user);
		System.out.println("Account Number: " + acc_num);
		System.out.println("Account Balance: " + acc_balance);
		System.out.println("Account Type: " + acc_type);
	}
	public boolean activeStatus()
	{
		this.stat = Status.ACTIVE;
		return true;
	}
	public boolean denyStatus()
	{
		this.stat = Status.DENY;
		return true;
	}
	public boolean closeStatus()
	{
		this.stat = Status.CLOSED;
		return true;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public int getAcc_num() {
		return acc_num;
	}

	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
	}

	public float getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(float acc_balance) {
		this.acc_balance = acc_balance;
	}

	public Status getStat() {
		return stat;
	}

	public void setStat(Status stat) {
		this.stat = stat;
	}

	public ArrayList<String> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(ArrayList<String> userAccounts) {
		this.userAccounts = userAccounts;
	}

	@Override
	public String toString() {
		return "Account [user=" + user + ", acc_type=" + acc_type + ", acc_num=" + acc_num + ", acc_balance="
				+ acc_balance + ", stat=" + stat + ", userAccounts=" + userAccounts + "]";
	}
	
}
