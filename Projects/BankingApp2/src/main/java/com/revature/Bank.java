package com.revature;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.revature.accounts.Account;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
public class Bank implements Serializable {
  
  static File userFile = new File("UserData.txt");
  private static final long serialVersionUID = 1L;
  Serialize serializer = new Serialize();
  
  /*Find Employee by username*/
  public Employee findEmployeeByUSN(String username, HashMap<?,?> employeeMap) {
    for(Entry<?, ?> e: employeeMap.entrySet()) {
      if(((Employee) e.getValue()).getUsername().equals(username)){
        return (Employee) e.getValue();
      }
    }
    return null;
  }
  /*Find Customer by username */
  public Customer findCustomerByUSN(String username, HashMap<?, ?> customerMap) {
    for(Entry<?, ?> c: customerMap.entrySet()) {
      if(((Customer) c.getValue()).getUsername().equals(username)){
        return (Customer) c.getValue();
      }
    }
    return null;
  }
  /*Print neatly formatted accounts of specified customer */
  public void printFormattedAccounts(Customer C){
    ArrayList<Account> userAccounts = C.getCustomerAccounts();
    if(userAccounts.isEmpty()) {
      System.out.println("User has no accounts.\n******************");
    } else {
      userAccounts.forEach(a -> System.out.println("******************\n"+a.getType()+" | "+
      "\nAccountNumber: "+a.getAccountNumber()+"\nBalance: "+a.getBalance()+"\nHolders: " + 
      Arrays.toString(a.getaccountHolders())+ "\nStatus: "+a.getStatus()+"\n******************"));
    }
  }
  /*Print all accounts waiting to be approved or denied*/
  public void printPendingAccounts(HashMap<?,?> customerMap) {
    customerMap.values().forEach(c -> ((Customer)c).getCustomerAccounts().forEach(a-> 
    { if(a.getStatus().equals(Account.AccountStatus.PENDING)){ System.out.println(a);}}));
    System.out.println("********************************************************************************************");
  }
  /*Print all accounts*/
  public void printAllAccounts(HashMap<?,?> customerMap) {
    customerMap.values().forEach(c -> ((Customer)c).getCustomerAccounts().forEach(a-> System.out.println(a)));
    System.out.println("********************************************************************************************");
  }
  /*Find a customer by their id*/
  public Customer findCustomerByID(int userID, HashMap<Integer, Customer> customerMap) {
    return customerMap.get(userID);	
  }
  /*Find account in map by searching through customer*/
  public Account findAccountByID(int accountNum, HashMap<?, ?> customerMap) {
    for(Entry<?, ?> C: customerMap.entrySet()) {
      for(Account a : ((Customer) C.getValue()).getCustomerAccounts()) {
        if (a.getAccountNumber() == accountNum){
          return a;	
        }
      }
    }
    return null;
  }
  /*Print ID, Name, and Username for each customer*/
  public void printAllBasicCustomerInfo(HashMap<Integer, Customer> customerMap) {
    customerMap.values().forEach(c -> System.out.println(c.getIDNumber()+" "+c.getName()+" "+c.getUsername()));
    System.out.println("***********************************");
  }
  /*Print ID, Name, and social security number of each customer as well as their accounts*/
  public void printPersonalCustomerInfo(Customer C) {
    System.out.println("***********************************************************************");
    System.out.println("ID: "+C.getIDNumber()+" Name: "+C.getName()+" Social: "+C.getSocialNum());
    C.getCustomerAccounts().forEach(a ->System.out.println(a));
    System.out.println("***********************************************************************");
  }
  /*Make withdrawal on behalf of customer*/
  public void makeWithdrawal(HashMap<Integer,Customer> customerMap, File customerFile, Scanner keyboard) {
    System.out.println("Enter the account Number you would like to withdraw from.");
    String choice = keyboard.nextLine();
    while(!choice.matches("^\\d{8}$")) {
      System.out.println("Please pick a valid account number.\n*******************************");
      choice = keyboard.nextLine();
    }
    System.out.println("How much would you like to withdraw?");
    String amount = keyboard.nextLine();
    while(!amount.matches("\\d*\\.?\\d*")) { 
      System.out.println("Must be a valid number. Try again.\n*******************************");
      amount = keyboard.nextLine();
    }
    int i = Integer.parseInt(choice);
    int m = Integer.parseInt(amount);
    try {
      Account account = findAccountByID(i, customerMap);
      account.deposit(m);
    } catch(NullPointerException e) {
      System.out.println("Account does not exist.");
    }
    serializer.writeToFile(customerMap, customerFile);
  }
  /* Make Deposit on behalf of customer */
  public void makeDeposit(HashMap<Integer,Customer> customerMap, File customerFile, Scanner keyboard) {
    System.out.println("Enter the account Number you would like to Deposit to.");
    String choice = keyboard.nextLine();
    while(!choice.matches("^\\d{8}$")) {
      System.out.println("Please pick a valid account number.\n*******************************");
      choice = keyboard.nextLine();
    }
    System.out.println("How much would you like to Deposit?");
    String amount = keyboard.nextLine();
    while(!amount.matches("\\d*\\.?\\d*")) { 
      System.out.println("Must be a valid number. Try again.\n*******************************");
      amount = keyboard.nextLine();
    }
    int i = Integer.parseInt(choice);
    int m = Integer.parseInt(amount);
    try {
      Account account = findAccountByID(i, customerMap);
      account.deposit(m);
    } catch(NullPointerException e) {
      System.out.println("Account does not exist.");
    }
    serializer.writeToFile(customerMap, customerFile);
  }
  /* Transfer between accounts */
  public void makeTransfer(HashMap<Integer,Customer> customerMap, File customerFile, Scanner keyboard) {
    System.out.println("Enter the account Number you would like to withdraw from.");
    String choice = keyboard.nextLine();
    while(!choice.matches("^\\d{8}$")) {
      System.out.println("Please pick a valid account number.\n*******************************");
      choice = keyboard.nextLine();
    }
    System.out.println("Enter the account Number you would like to deposit to.");
    String choice2 = keyboard.nextLine();
    while(!choice2.matches("^\\d{8}$")) {
      System.out.println("Please pick a valid account number.\n*******************************");
      choice2 = keyboard.nextLine();
    }
    System.out.println("How much would you like to transfer?");
    String amount = keyboard.nextLine();
    while(!amount.matches("\\d*\\.?\\d*")) { 
      System.out.println("Must be a valid number greater than zero. Try again.\n*******************************");
      amount = keyboard.nextLine();
    }
    try {
      Account transferFrom = findAccountByID(Integer.parseInt(choice),customerMap);
      Account transferTo = findAccountByID(Integer.parseInt(choice2), customerMap);
      transferFrom.transfer(Integer.parseInt(amount), transferFrom, transferTo);
    } catch(NullPointerException e) {
      System.out.println("Account does not exist.");
    }
    serializer.writeToFile(customerMap, customerFile);  	  
  } 
}
