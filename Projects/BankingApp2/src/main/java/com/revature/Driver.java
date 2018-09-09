package com.revature;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.User;
import com.revature.beans.User.Status;

public class Driver {
  
  static Serialize serializer = new Serialize();
  static File customerFile = new File("BankCustomers.txt");//File with bank user info
  static File employeeFile = new File("BankEmployees.txt");
  static File userFile = new File("UserData.txt");
  static Scanner keyboard = new Scanner(System.in);
  private static User currentUser;
  private static Employee currentEmployee;
  private static Customer currentCustomer;
  private static Bank theBank = new Bank();
  public static void main(String[] args) {
    
    /*
    * Displays available users to log in too
    * Any admins or employees must be explicitly created
    * Users should not be able to sign up for as admins or employees
    */
    HashMap <Integer, Customer> customerMap = new HashMap<Integer, Customer>();
    HashMap <Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
    customerMap = serializer.readFromFile(customerFile);
    employeeMap = serializer.readFromFile(employeeFile);
    System.out.println("\t\t\t\t\t\t\t\tAVAILABLE USERS\n\t\t\t\t\t\t\t\t****************");
    employeeMap.entrySet().forEach(a -> System.out.println("\t\t\t\t\t\t\t"+a.getValue().getStatus()+": "+a.getValue().getUsername()
    +" "+ a.getValue().getPassword()+" "));
    customerMap.entrySet().forEach(a -> System.out.println("\t\t\t\t\t\t\t"+a.getValue().getStatus()+": "+a.getValue().getUsername()
    +" "+ a.getValue().getPassword()+" "));
    System.out.println("******************************************************************"
    + "****************************************************************************");
    Initialize(customerMap, employeeMap);
  }
  protected static void Initialize(HashMap<Integer, Customer> customerMap, HashMap<Integer,Employee> employeeMap) {
    boolean exit = false;
    String choice = "";
    while(!exit) {
      System.out.println("Would you Like to:\n1) Login to an existing account\n2) Create An account\n3) Exit Program");
      choice = keyboard.nextLine();
      switch(choice) {
        case "1":
        currentUser = Login.run();
        exit = true;
        presentOptions(currentUser.getStatus(), customerMap);
        break;
        case "2": 
        Login.createAccount(customerMap, employeeMap);
        break;
        case "3":
        exit = true;
        break;
        default:
        System.out.println("Invalid Input");
      }
    }
  }
  private static void presentOptions(Status status, HashMap<Integer, Customer> customerMap){
    switch(status) {
      case CUSTOMER:
      customerOptions(customerMap);
      break;
      case EMPLOYEE:
      employeeOptions(customerMap);	
      break;
      case ADMIN: 
      adminOptions(customerMap);
      break;
      default:
      System.out.println("Invalid Inuput.");
    }
  }
  private static void customerOptions(HashMap<Integer, Customer> customerMap) {
    String choice = "";
    currentCustomer = ((Customer)currentUser);
    boolean exit = false;
    System.out.println("Hello "+currentUser.getFirstName()+"! What would you like to do today?");
    while(!exit) {
      System.out.println("CUSTOMER OPTIONS: ");
      System.out.println("1) Check Balance\n"
      + "2) Apply To Open Account\n"
      + "3) Apply For A Joint Account\n"
      + "4) Withdraw Money\n"
      + "5) Deposit Money\n"
      + "6) Transfer\n"
      + "7) Logout\n");
      choice = keyboard.nextLine();
      switch(choice) {
        case "1":
        	theBank.printFormattedAccounts(currentCustomer);
        	break;
        case "2": 
        	currentCustomer.applyForAccount(customerMap, customerFile,keyboard);
        	break;
        case "3":
        	theBank.printAllBasicCustomerInfo(customerMap);
        	currentCustomer.applyForJointAccount(customerMap, customerFile,keyboard);
        	break;
        case "4":
        	theBank.printFormattedAccounts(currentCustomer);
        	theBank.makeWithdrawal(customerMap, customerFile, keyboard);
        	break;
        case "5":
        	theBank.printFormattedAccounts(currentCustomer);
        	theBank.makeDeposit(customerMap,customerFile, keyboard);
        	break;
        case "6":
        	theBank.printFormattedAccounts(currentCustomer);
        	theBank.makeTransfer(customerMap,customerFile,keyboard);
        	break;
        case "7":
        exit = true;
        default:
        	System.out.println("Invalid Input. Expecting integer.\n*********************************");
        	break;
      }     
    }
  }
  private static void employeeOptions(HashMap<Integer, Customer> customerMap) {
    String choice = "";
    currentEmployee = ((Employee)currentUser);
    boolean exit = false;
    System.out.println("Hello "+currentUser.getFirstName()+"! What would you like to do today?");
    while(!exit) {
      System.out.println("EMPLOYEE OPTIONS: ");
      System.out.println("1) View Customer Info\n"
      + "2) Approve Or Deny Accounts\n"
      + "3) Logout\n");
      choice = keyboard.nextLine();
      switch(choice) {
        case "1":
        	theBank.printAllBasicCustomerInfo(customerMap);
        	currentEmployee.chooseCustomerToView(customerMap, keyboard);
        	break;
        case "2": 
        	theBank.printPendingAccounts(customerMap);
        	currentEmployee.approveOrDenyAccount(keyboard, customerMap);
        	break;
        case "3":
        	exit = true;
        	break;
        default:
        	System.out.println("Invalid Input. Expecting integer\\n*********************************");
        	break;
      }     
    }
    
  }
  /*Admin options*/
  private static void adminOptions(HashMap<Integer, Customer> customerMap) {
    String choice = "";
    currentEmployee = ((Admin)currentUser);
    boolean exit = false;
    System.out.println("Hello "+currentUser.getFirstName()+"! What would you like to do today?");
    while(!exit) {
      System.out.println("ADMINISTRATOR OPTIONS: ");
      System.out.println("1) View Customer Info\n"
      + "2) Approve Or Deny Accounts\n"
      + "3) Make A Deposit To An Account\n"
      + "4) Make A Withdrawal From An Account\n"
      + "5) Transfer Between Accounts\n"
      + "6) Delete An Account Permenantly"
      + "7) Logout\n");
      choice = keyboard.nextLine();
      switch(choice) {
        case "1":
        	theBank.printAllBasicCustomerInfo(customerMap);
        	currentEmployee.chooseCustomerToView(customerMap, keyboard);
        	break;
        case "2": 
        	theBank.printPendingAccounts(customerMap);
        	currentEmployee.approveOrDenyAccount(keyboard, customerMap);
        	break;
        case "3":
        	theBank.printAllAccounts(customerMap);
        	theBank.makeDeposit(customerMap, customerFile, keyboard);
        	break;
        case "4":
        	theBank.printAllAccounts(customerMap);
        	theBank.makeWithdrawal(customerMap, customerFile, keyboard);
        	break;
        case "5":
        	theBank.printAllAccounts(customerMap);
        	theBank.makeTransfer(customerMap, customerFile, keyboard);
        	break;
        case "6":
        	theBank.printAllAccounts(customerMap);
        	((Admin) currentEmployee).deleteAccount(customerMap, customerFile, keyboard);
        	break;
        case "7":
        	System.out.println("Goodbye "+ currentUser.getFirstName()+"!");
        	exit = true;
        	break;
        default:
        System.out.println("Invalid Input. Expecting integer\\n*********************************");
        break;
      }     
    }
  }
}
