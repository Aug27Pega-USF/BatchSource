/**
 * @author Kevin Medara
 * @since 2018-08-31
 * @version 1.0
 * 
 * @description Program Simulates the running of an online banking application.
 * User is able to login or create a new account. 
 * Upon login user is able to
 * 		- Check Account Information(balance, status, holders, etc)
 * 		- Apply To Open Accounts
 * 		- 
 */

package com.revature;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.revature.accounts.*;
import com.revature.accounts.AbstractAccount.AccountStatus;
import com.revature.beans.*;
import com.revature.beans.BankUser.Status;

public class Driver {
  
  protected static Login login = new Login();
  private static File userFile = new File("BankUsers.txt");//File with bank user info
  private static Scanner keyboard = new Scanner(System.in);
  private static Serialize serializer = new Serialize();
  private static BankUser currentUser;
  public static void main(String[] args) {
    /**
    * Added For Initial Testing. Users will not be able to register as Employees or Admin
    */
    //		ArrayList<BankUser> list = new ArrayList<BankUser>();
    //		list.addAll(Arrays.asList(
    //				new BankAdmin("Kevin","Medara","MedaraK","f04b2klr9"),
    //				new Employee("Matthew","Knighten","KnightenM","f04b2klr9"),
    //				new Customer ("Shawn", "Palmer", "PalmerS", "f04b2klr9")
    //				));
    //		
    //		serializer.writeToFile(list, userFile);
    //		
    //		System.out.println(list);
    Initialize(); 
  }
  
  public static void Initialize(){
    boolean exit = false;
    int choice = 0;
    while(!exit) {
      System.out.println("Would you Like to:\n1) Login to an existing account\n2) Create An account\n3 Exit Program");
      choice=keyboard.nextInt();   
      switch(choice) {
        case 1:
        currentUser = Login.run();
        presentOptions(currentUser.getStatus());
        break;
        case 2: 
        Login.createAccount();
        break;
        case 3:
        exit=true;
        default:
        System.out.println("Invalid Input");
      }
    }
    
  }
  
  public static void presentOptions(Status status){
    switch(status) {
      case CUSTOMER:
      customerOptions();
      break;
      case EMPLOYEE:
      employeeOptions();	
      break;
      case ADMIN: 
      adminOptions();
      break;
      default:
      System.out.println("Invalid Inuput.");
    }
  }
  
  public static void customerOptions(){
    List<BankUser> list = serializer.readFromFile(userFile);
    List<AbstractAccount> accounts = new ArrayList<AbstractAccount>();
    List<Customer> customers = getAllCustomers();
    if(((Customer)currentUser).getCustomerAccounts() != null) {
      accounts = ((Customer)currentUser).getCustomerAccounts();
    }
    boolean exit = false;
    String name = (currentUser.getFirstName()+" "+currentUser.getLastName());
    int choice = 0;
    while(!exit) {
      System.out.println("CUSTOMER OPTIONS: ");
      System.out.println("1) Check Balance\n"
      + "2) Apply To Open Account\n"
      + "3) Apply For A Joint Account\n"
      + "4) Withdraw Money\n"
      + "5) Deposit Money\n"
      + "6) Transfer\n"
      + "7) Logout\n");
      choice = keyboard.nextInt();
      switch(choice) {
        case 1:
        if(accounts.isEmpty()) {
          System.out.println("User Has No Accounts");
        }
        else {
          accounts.forEach(a -> System.out.println(a.getType()+" ID: "+ a.getAccountNumber()
          +" Balance: "+a.getBalance()+" Holders: "+Arrays.toString(a.getAccounttHolders())+" Status: "+ a.getStatus()));
        }
        break;
        case 2: 
        System.out.println("What Type Of Account Are You Applying For?\n1)Checking\n2)Savings");
        choice = keyboard.nextInt();
        if(choice == 1) {
          CheckingAccount account = new CheckingAccount(name);
          account.setAccounttHolders(name);
          accounts.add(account);
          
        } else if (choice == 2) {
          SavingsAccount account = new SavingsAccount(name);
          account.setAccounttHolders(name);
          accounts.add(account);
        }  
        list = setList(list, accounts);
        serializer.writeToFile(list, userFile);
        break;
        case 3:
        customers.forEach(c -> System.out.println(c.getIDNumber()+" "+c.getFirstName()+" "+c.getLastName()));
        System.out.println("Enter The ID Of The the Joint User.");
        int id = keyboard.nextInt();
        if( currentUser.getIDNumber() == id) {
          System.out.println("Cannot Open An Account With Yourself.");
          break;
        }
        for(BankUser l : list) {
          if(l.getIDNumber()==id) {
            String jointName = (l.getFirstName()+" "+l.getLastName());
            System.out.println("What Type Of Account Is This?\n Checking\n Savings");
            choice = keyboard.nextInt();
            if(choice ==1) {
              CheckingAccount account = new CheckingAccount(name,jointName);
              account.setAccounttHolders(name,jointName);
              accounts.add(account);
              ((Customer)l).getCustomerAccounts().add(account);
            } else if (choice == 2) {
              SavingsAccount account = new SavingsAccount(name,jointName);
              account.setAccounttHolders(name,jointName);
              accounts.add(account);
              ((Customer)l).getCustomerAccounts().add(account);
            }
            
          }
        }
        list = setList(list, accounts);
        serializer.writeToFile(list, userFile);
        break;
        case 4:
        if(accounts.isEmpty()) {
          System.out.println("User Has No Accounts.");
          break;
        } else {
          accounts.forEach(a -> System.out.println(a.getType()+" ID: "+ a.getAccountNumber()+" Balance: "+a.getBalance()+" Status: "+ a.getStatus()));
          System.out.println("Enter The Account ID For The Account You Would Like To Withdraw From.");
          choice =keyboard.nextInt();
          for(AbstractAccount a : accounts) {
            if(a.getAccountNumber() == choice) {
              System.out.println("How Much would you like to withdraw?");
              double amount = keyboard.nextDouble();
              if(a.getStatus().equals(AbstractAccount.AccountStatus.OPEN)) {
                a.withdraw(amount);
              } else {
                System.out.println("Account Is Not Open For Transactions");
                break;
              }
              
            }
          } 
        }
        list = setList(list,accounts);
        serializer.writeToFile(list, userFile);
        break;
        case 5:
        if(accounts.isEmpty()) {
          System.out.println("User Has No Accounts");
          break;
        } else {
          accounts.forEach(a -> System.out.println(a.getType()+" ID: "+ a.getAccountNumber()+" Balance: "+a.getBalance()+" Status: "+ a.getStatus()));
          System.out.println("Enter The Account ID For The Account You Would Like To Deposit To.");
          choice =keyboard.nextInt();
          for(AbstractAccount a : accounts) {
            if(a.getAccountNumber() == choice) {
              System.out.println("How Much would you like to Deposit?");
              double amount = keyboard.nextDouble();
              if(a.getStatus().equals(AbstractAccount.AccountStatus.OPEN)) {
                a.deposit(amount);
              } else {
                System.out.println("Account Is Not Open For Transactions");
                break;
              }            
            }
          } 
        }
        list = setList(list,accounts);
        serializer.writeToFile(list, userFile);
        break;
        case 6:
        if(accounts.isEmpty()) {
          System.out.println("User Has No Accounts");
          break;
        } else if(accounts.size() == 1) {
          System.out.println("You Only Have One Account.");
          break;
        }
        accounts.forEach(a -> System.out.println(a.getType()+" ID: "+ a.getAccountNumber()+" Balance: "+a.getBalance()+" Status: "+ a.getStatus()));
        System.out.println("Enter the account number of the account you will transfer from");
        choice = keyboard.nextInt();
        System.out.println("Enter the account number of the account you will transfer to");
        int choice2 = keyboard.nextInt();
        for(AbstractAccount a : accounts) {
          if(a.getAccountNumber()==choice) {
            for(AbstractAccount b : accounts) {
              if(b.getAccountNumber() == choice2) {
                System.out.println("How Much Would You Like To Transfer?");
                double amount = keyboard.nextDouble();
                if(a.getStatus()==AbstractAccount.AccountStatus.OPEN && b.getStatus()==AbstractAccount.AccountStatus.OPEN) {
                  a.transfer(amount, a, b);
                }else {
                  System.out.println("One Of The Accounts Is Not Open Or Account Number Is Wrong");
                }
              } 
            }			
          } 
        }
        list = setList(list,accounts);
        serializer.writeToFile(list, userFile);
        break;
        case 7:
        System.out.println("Logging Out");
        exit = true;
        currentUser = null;
        Initialize();  
      }
    }   
  }
  
  
  public static void employeeOptions() {
    boolean exit = false;
    List<BankUser> list = serializer.readFromFile(userFile);
    List<Customer> customers = getAllCustomers();
    List<AbstractAccount> pendingAccounts = new ArrayList<AbstractAccount>();
    customers = getAllCustomers();
    AccountStatus status = null;
    int choice = 0;
    while(!exit) {
      System.out.println("EMPLOYEE OPTIONS: ");
      System.out.println("1) View Customer Info\n"
      +"2) Approve Or Deny Pending Accounts\n"
      +"3) Logout");
      
      choice = keyboard.nextInt();
      switch(choice) {
        case 1: 
        System.out.println("Whose Account Would You Like To View?: ");
        //customers.forEach();
        customers.forEach(c -> {System.out.println("Name: "+c.getFirstName()+" "+ c.getLastName()+" ID: " 
        + c.getIDNumber());});//print only customers
        System.out.println("Enter the Customer ID");
        int id = keyboard.nextInt();
        for(Customer c:customers) {
          if(c.getIDNumber() == id) {
            System.out.println(c);
            break;
          } 
        }
        break;
        case 2:
        System.out.println("All Pending Accounts.");
        for(Customer c: customers) {
          for( AbstractAccount a : c.getCustomerAccounts()) {
            if(a.getStatus().equals(AbstractAccount.AccountStatus.PENDING)) {
              System.out.println(a);
              pendingAccounts.add(a);
            }
          }         
        }
        if(pendingAccounts.isEmpty()) {
          System.out.println("No Accounts Pending");
          break;
        }
        System.out.println("Enter the Account Number Of The Account you would like to Approve or Deny");
        choice = keyboard.nextInt();
        System.out.println("Choose An Option\n1) Approve\n2) Deny\n");
        int opt = keyboard.nextInt();
        if(opt ==1) {
          status = AbstractAccount.AccountStatus.OPEN;
        } else if (opt == 2) {
          status = AbstractAccount.AccountStatus.CLOSED; 
        }
        for(BankUser u : list) {
          if(u.getStatus() == BankUser.Status.CUSTOMER) {
            for(AbstractAccount a : ((Customer)u).getCustomerAccounts()) {
              if(a.getAccountNumber() == choice) {
                ((Employee)currentUser).judgeAccount(status, a);            
              }
            }
          }
        }
        serializer.writeToFile(list, userFile);
        break;
        case 3:
        System.out.println("Logging Out");
        exit = true;
        currentUser = null;
        Initialize();     
      }
    }
  }
  public static void adminOptions() {
    List<BankUser> list = serializer.readFromFile(userFile);
    List<Customer> customers = getAllCustomers();
    int choice = 0;
    double amount = 0;
    boolean exit = false;
    while(!exit) {
      System.out.println("ADMIN OPTIONS");
      System.out.println("1) View Customer Info\n"
      +"2) Edit Customer Accounts\n"
      +"3) Cancel Customer Accounts\n");
      choice = keyboard.nextInt();
      
      switch(choice) {
        case 1:
        customers = getAllCustomers();
        customers.forEach(c -> {System.out.println("Name: "+c.getFirstName()+" "+ c.getLastName()+" ID: " 
        + c.getIDNumber());});//print only customers
        System.out.println("Enter The ID For The Account You'd Like To View: ");
        int id = keyboard.nextInt();
        for(Customer c:customers) {
          if(c.getIDNumber() == id) {
            System.out.println(c);
            break;
          } 
        }
        break;
        case 2:
        System.out.println("ALL ACCOUNTS");
        System.out.println(getAllAccounts());
        System.out.println("Enter The ID Of The Account You Would Like To Edit");
        id = keyboard.nextInt();
        System.out.println("Choose An Option\n1) Withdraw\n2) Deposit\n3) Transfer");
        choice = keyboard.nextInt();
        for(BankUser u : list) {
          if(u.getStatus() == BankUser.Status.CUSTOMER) {
            for(AbstractAccount a : ((Customer)u).getCustomerAccounts()) {
              if(a.getAccountNumber() == id) {
                //System.out.println(a);
                switch(choice) {
                  case 1:
                  System.out.println("How Much Would You Like To Withdraw?");
                  amount = keyboard.nextDouble();
                  if(a.getStatus().equals(AbstractAccount.AccountStatus.OPEN)) {
                    a.withdraw(amount);
                  } else {
                    System.out.println("Account Is Not Open For Transactions");
                    break;
                  }               
                  serializer.writeToFile(list, userFile);
                  break;
                  case 2:
                  System.out.println("How Much Would You Like To Deposit?");
                  amount = keyboard.nextDouble();
                  if(a.getStatus().equals(AbstractAccount.AccountStatus.OPEN)) {
                    a.deposit(amount);
                  } else {
                    System.out.println("Account Is Not Open For Transactions");
                    break;
                  }
                  break;
                  case 3: 
                  System.out.println("Which Account Would You Like To Transfer To?");
                  choice = keyboard.nextInt();
                  System.out.println("How Much Would You Like To Transfer?");
                  amount = keyboard.nextDouble();
                  for(BankUser t: list) {
                    if(t.getStatus() == BankUser.Status.CUSTOMER) {
                      for( AbstractAccount i : ((Customer)t).getCustomerAccounts()) {
                        if (i.getAccountNumber() == choice) {
                          a.transfer(amount , a, i);
                        }
                      }
                    }
                  }
                  serializer.writeToFile(list, userFile);
                  break;       
                }
              }
            }
          }
        }
        serializer.writeToFile(list, userFile);
        break;
        case 3:
        System.out.println("Which Account Would You Like To Delete");
        System.out.println(getAllAccounts());
        choice = keyboard.nextInt();
        for(BankUser i : list) {
          if(i.getStatus() == BankUser.Status.CUSTOMER) {
            for( AbstractAccount r : ((Customer)i).getCustomerAccounts()) {
              if (r.getAccountNumber() == choice) {
                r.setStatus(AbstractAccount.AccountStatus.CLOSED);
                r.setBalance(0.0);
                System.out.println("Account Closed");
              }
            }
          }
        }
        serializer.writeToFile(list, userFile);
        break;
      }
    }
  }
  
  protected static ArrayList<Customer> getAllCustomers(){
    List<BankUser> list = serializer.readFromFile(userFile);
    ArrayList<Customer> customers =  new ArrayList<Customer>();
    list.forEach(u -> {if(u.getStatus().equals(BankUser.Status.CUSTOMER)) {customers.add((Customer) u);}});
    return customers;   
  }
  
  protected static List<AbstractAccount> getAllAccounts() {
    List<BankUser> list = serializer.readFromFile(userFile);
    List<AbstractAccount> accounts = new ArrayList<AbstractAccount>();
    for(BankUser u : list) {
      if(u.getStatus() == BankUser.Status.CUSTOMER) {
        for (AbstractAccount a : ((Customer)u).getCustomerAccounts()) {
          accounts.add(a);
        }
      }
    }
    return accounts;    
  } 
  
  private static List<BankUser> setList(List<BankUser> list, List<AbstractAccount> accounts) {
    for(BankUser u :list) {
      if(u.getIDNumber() == currentUser.getIDNumber()) {
        ((Customer)currentUser).setCustomerAccounts((ArrayList<AbstractAccount>) accounts);
        ((Customer)u).setCustomerAccounts((ArrayList<AbstractAccount>) accounts);
      }					 
    }
    return list;
  }
}