package com.driver.transactions;

import java.util.ArrayList;
import java.util.Scanner;

import com.driver.accounts.Customer;


public interface Transaction {

	/*
	 * WITHDRAWALS
	 */
	public void withdrawFunds(ArrayList<Customer> customerList, Scanner s);
	
	public void withdrawFundsPersonal(ArrayList<Customer> customerList, Scanner s);
	
	public void withdrawFundsJoint(ArrayList<Customer> customerList, Scanner s);
	
	/*
	 * DEPOSITS
	 */
	public void depositFunds(ArrayList<Customer> customerList, Scanner s);
	
	public void depositFundsPersonal(ArrayList<Customer> customerList, Scanner s);
	
	public void depositFundsJoint(ArrayList<Customer> customerList, Scanner s);
	/*
	 * TRANSFERRALS
	 */
	public void transferFunds(ArrayList<Customer> customerList, Scanner s);
	
	public void transferFundsPersonal(ArrayList<Customer> customerList, Scanner s);
	
	public void transferFundsJoint(ArrayList<Customer> customerList, Scanner s);
	
	
	/*
	 * SELECTING AN ACCOUNT
	 */
	public int selectAccounts(ArrayList<Customer> customerList, Scanner s);
	
	public int selectJointAccounts(ArrayList<Customer> customerList, Scanner s);
}
