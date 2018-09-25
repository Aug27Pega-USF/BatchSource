package com.revature;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.CheckingAccount;
import com.revature.beans.LoginInfo;
import com.revature.beans.SavingsAccount;
import com.revature.beans.User;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.LoginInfoDaoImpl;
import com.revature.daoimpl.UserDaoImpl;
import com.revature.exceptions.InvalidTransactionException;
import com.revature.login.Login;
import com.revature.util.ConnectionFactory;

public class BankDriver {
	static Scanner keyboard = new Scanner(System.in);

	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	private static User currentUser;
	private static UserDaoImpl udi = new UserDaoImpl();
	private static AccountDaoImpl adi = new AccountDaoImpl();
	private static LoginInfoDaoImpl lidi = new LoginInfoDaoImpl();
	private static HashMap<Integer,User> userMap = new HashMap<Integer,User>();
	private static HashMap<Integer,Account> accountMap = new HashMap<Integer,Account>();
	private static HashMap<Integer, LoginInfo> loginMap = new HashMap<Integer,LoginInfo>();
	private static final Logger logger = LogManager.getLogger("Stanley");
	
	public static void main(String[] args) {
		udi.getAll().forEach(u -> userMap.put(u.getId(), u));
		adi.getAll().forEach(a -> accountMap.put(a.getId(), a));
		lidi.getAll().forEach(li -> loginMap.put(li.getId(), li));
		loginMap.entrySet().forEach(e -> System.out.println(e.getValue()));

		Initialize();
	}
	
	public static void Initialize() {
		
		Login login = new Login();
		    boolean exit = false;
		    String choice = "";
		    while(!exit) {
		      System.out.println("Would you Like to:\n1) Login to an existing account\n2) Create An account\n3) Exit Program");
		      choice = keyboard.nextLine();
		      switch(choice) {
		        case "1":
		            currentUser = login.run();
		        	exit = true;
		        	presentOptions(currentUser.getRoleTypeName());
		        break;
		        case "2": 
		        login.createAccount();
		        break;
		        case "3":
		        exit = true;
		        break;
		        default:
		        System.out.println("Invalid Input\n*************");
		      }
		    }	
	}
	private static void presentOptions(String rollTypeName) {	
		    switch(rollTypeName) {
		      case "CUSTOMER":
		      customerOptions();
		      break;
		      case "EMPLOYEE":
		      employeeOptions();	
		      break;
		      case "ADMIN": 
		      adminOptions();
		      break;
		      default:
		      System.out.println("Invalid Inuput.");
	}

}
	private static void adminOptions() {
		Login login = new Login();
		String choice = "";
	    boolean exit = false;
	    System.out.println("Hello "+currentUser.getFirst()+"! What would you like to do today?");
	    while(!exit) {
	      System.out.println("ADMINISTRATOR OPTIONS: ");
	      System.out.println("1) View Customer Info\n"
	      + "2) Create A New Customer Account\n"
	      + "3) Update A User Account\n"
	      + "4) Delete A User\n"
	      + "5) Create An Account\n"
	      + "6) Update An Account\n"
	      + "7) Delete An Account\n"
	      + "8) Logout\n");
	      choice = keyboard.nextLine();
	      switch(choice) {
	        case "1":
			userMap.entrySet().forEach(e -> System.out.println(e.getValue().toBasicString()));
			System.out.println("Enter the id of the customer you would like to view.");
			int uid = keyboard.nextInt();
			System.out.println(udi.get(uid));
			
	        	break;
	        case "2": 
	        	login.createAccount();
	        	break;
	        case "3":
	        	User toEdit = null;
	        	while(toEdit == null) {
	        		try {
			        	userMap.entrySet().forEach(e -> System.out.println(e.toString()));
	        			System.out.println("Choose A User To Update By Entering Their ID Number.");
			        	String id = keyboard.nextLine();
			        	toEdit = udi.get(Integer.parseInt(id));
			        	toEdit.setAccounts(adi.getAccountsByUser(toEdit.getId()));
			        	System.out.println(toEdit.toString());
			        	HashMap<String, String> params = udi.chooseUpdateFields(toEdit);
			        	udi.update(toEdit, params);
	        		} catch(NullPointerException e) {
	        			System.out.println("User does not exist in the system.");
	        		} catch (SQLException e1) {
						e1.printStackTrace();
					}
	        	}
	        	updateHashMap(userMap, "user");
	        	break;
	        case "4":
	        	User toDelete = null;
	        	while(toDelete == null) {
	        		try {
	        			userMap.entrySet().forEach(e -> System.out.println(e.getValue().toBasicString()));
	        			System.out.println("Choose a user to delete by entering their id number.");
			        	String id = keyboard.nextLine();
			        	toDelete = udi.get(Integer.parseInt(id));
			        	toDelete.setAccounts(adi.getAccountsByUser(toDelete.getId()));
			        	udi.delete(toDelete);
	        		} catch(NullPointerException e) {
	        			System.out.println("User does not exist in the system.");
	        		} catch (SQLException e1) {
						e1.printStackTrace();
					}
	        	}
	        	updateHashMap(userMap, "user");
	        	break;
	        case "5":
	        	Account a = null;
	        	String owner = null;
	        	try {
	        		exit=false;
		        	userMap.entrySet().forEach(e -> System.out.println(e.getValue().toBasicString()));
		        	while(!exit) {
		        		System.out.println("Choose who this account belongs to by entering a user's id.");
		        		 owner = keyboard.nextLine();
		        		if(!userMap.keySet().contains(Integer.parseInt(owner))) {
		        			System.out.println("User does not exist.");
		        			continue;
		        		}	
		        		System.out.println("What type of account would you like to create, Checking or Savings?");
			        	String ac = keyboard.nextLine();
			        	if(ac.equalsIgnoreCase("CHECKING")) {
			        		  a = new CheckingAccount();
			        		  exit = true;
			        	} else if(ac.equalsIgnoreCase("SAVINGS")) {
			        		  a = new SavingsAccount();
			        		  exit = true;
			        	} else {
			        		System.out.println("Invalid option.");
			        		continue;
			        	}
		        	}	
		        	int id = Integer.parseInt(owner);
		        	User u = udi.get(id);
		        	List<Integer> holders = new ArrayList<Integer>();
		        	holders.add(u.getId());
		        	a.setaccountHolders(holders);
	    			adi.create(a);
	        	} catch (NumberFormatException e){
	        		System.out.println("Input must be a valid user id.");
	        	} catch (SQLException e1) {
					e1.printStackTrace();
				}	
	        	break;
	        case "6":
	        	Account edit = null;
	        	while(edit == null) {
	        		try {
			        	accountMap.entrySet().forEach(e -> System.out.println(e.getValue().toString()));
	        			System.out.println("Choose an account to update by entering the account number.");
			        	String id = keyboard.nextLine();
			        	edit = adi.get(Integer.parseInt(id));
			        	HashMap<String, String> params = adi.chooseUpdateFields(edit);
			        	System.out.println(params);
			        	adi.update(edit, params);
	        		} catch(NullPointerException e) {
	        			System.out.println("Account does not exist in the system.");
	        		} catch (SQLException e1) {
						e1.printStackTrace();
					}
	        	}
	        	updateHashMap(accountMap, "account");
	        	break;
	        case "7":
	        	Account delete = null;
	        	while(delete == null) {
	        		try {
	        			accountMap.entrySet().forEach(e -> System.out.println(e.getValue().toString()));
	        			System.out.println("Choose an account to delete by entering the account number.");
			        	String id = keyboard.nextLine();
			        	delete = adi.get(Integer.parseInt(id));
			        	adi.delete(delete);
	        		} catch(NullPointerException e) {
	        			System.out.println("Account does not exist in the system.");
	        		} catch (SQLException e1) {
						e1.printStackTrace();
					}
	        	}
	        	updateHashMap(accountMap, "account");
	        	break;
	        case "8":
	        	System.out.println("Goodbye "+ currentUser.getFirst()+"!");
	        	currentUser = null;
	        	exit = true;
	        	Initialize();
	        default:
	        System.out.println("Invalid Input. Expecting integer\\n*********************************");
	        break;
	      }     
	    }
	}
	
	/*Customer Options*/
	private static void customerOptions() {
		String choice = "";
	    boolean exit = false;
	    System.out.println("Hello "+currentUser.getFirst()+"! What would you like to do today?");
	    while(!exit) {
	      System.out.println("CUSTOMER OPTIONS: ");
	      System.out.println("1) View Your Accounts\n"
	      + "2) Make A Deposit\n"
	      + "3) Make A Withdrawal\n"
	      + "4) Delete An Empty Account\n"
	      + "5) View Transaction History\n"
	      + "6) Logout\n");
	      choice = keyboard.nextLine();
	      switch(choice) {
	        case "1":
	        	System.out.println("Your Current Accounts\n******************************************");
	        	currentUser.getAccounts().forEach(a -> System.out.println(a));
	        	 adi.getAccountsByUser(currentUser.getId());
	        	break;
	        case "2": /*Deposit*/
	        	Account acc = null;
	        	Double amount = 0.0;
	        	try{	
	        		adi.getAccountsByUser(currentUser.getId());
	        		System.out.println("Select an account to deposit to by entering the account number.\n************************************************");
	        		Integer ac = keyboard.nextInt();
	        	    acc = adi.get(ac);
	        		System.out.println("How much would you like to deposit?\n***************************************");
	        	    amount = keyboard.nextDouble();
	        	    if(amount < 0 ) throw new InvalidTransactionException("Attempted deposit of negative number.");
	        		adi.deposit(amount, acc);
	        		acc.setBalance(acc.getBalance() + amount);
		        	updateHashMap(accountMap,"account");
		        	logger.info("Deposit of $"+amount+" made to account #"+acc.getAccountNumber()+" by "+currentUser.getFirst()+" "+currentUser.getLast()
		        	             +" New Balance is"+acc.getBalance());
	        	} catch(InputMismatchException e) {
	        	System.out.println("Invalid account number.");
	        	} catch (InvalidTransactionException e) {
	        		logger.error("Attempted Deposit of $"+amount+" made to account #"+acc.getAccountNumber()+" by "+currentUser.getFirst()+" "+currentUser.getLast());
	        		e.getMessage();
	        	}
	        	currentUser.setAccounts(adi.getAccountsByUser(currentUser.getId()));
	        	break;
	        case "3": /*Withdrawal*/
	        	Account acc2 = null;
	        	double amount2 = 0;
	        	try{
	        	currentUser.getAccounts().forEach(a -> System.out.println(a));
	        	System.out.println("Select an account to withdraw from by entering the account number.\n************************************************");
	        		int ac = keyboard.nextInt();
	        	    acc2 = adi.get(ac);
	        		System.out.println("How much would you like to deposit?\n***************************************");
	        	    amount2 = keyboard.nextDouble();
	        	    if(amount2 > acc2.getBalance() ) throw new InvalidTransactionException("Cannot withdraw more than your available funds.");
	        		adi.withdraw(amount2, acc2);
	        		acc2.setBalance(acc2.getBalance() - amount2);
		        	updateHashMap(accountMap,"account");
		        	logger.info("Withdrawal of $"+amount2+" from account #"+acc2.getAccountNumber()+" by "+currentUser.getFirst()+" "+currentUser.getLast());
	        	} catch(InputMismatchException e) {
	        	System.out.println("Invalid account number.");
	        	} catch (InvalidTransactionException e) {
	        		logger.error("Attempted to withdraw"+amount2+"  from account #"+acc2.getAccountNumber()+" by "+currentUser.getFirst()+" "+currentUser.getLast());
	        		e.getMessage();
	        	}
	        	currentUser.setAccounts(adi.getAccountsByUser(currentUser.getId()));
	        	break;
	        case "4": /*Delete Empty Account*/
	        	try{
		        	Account acc3;
	        	currentUser.getAccounts().forEach(a -> System.out.println(a));
	        	System.out.println("Select an account to delete by entering the account number. The account must have a balance of 0.");
	        	int ac = keyboard.nextInt();
        	    acc3 = adi.get(ac);
        	    if(acc3.getBalance() > 0) throw new InvalidTransactionException("Unable to delete, there is still money in this account.");
        		adi.delete(acc3);
	        	updateHashMap(accountMap,"account");
	        	logger.info("Account "+acc3.getAccountNumber()+" has been deleted.");
        	} catch(InputMismatchException e) {
        	System.out.println("Invalid account number.");
        	} catch (InvalidTransactionException e) {
        		e.getMessage();
        	} catch (SQLException e) {
				e.printStackTrace();
			}
	        	currentUser.setAccounts(adi.getAccountsByUser(currentUser.getId()));
	        	break;
	        case "5":
	        	System.out.println();
	        	break;
	        case "6":
	        	System.out.println("Goodbye "+ currentUser.getFirst()+"!");
	        	currentUser = null;
	        	exit = true;
	        	break;
	        	default:
	        		System.out.println("Invalid Input.\n****************");
	        		break;
	      }
	    }
	}
	/*For Updating user fields, user can select as many fields as they want */
	
	private static void updateHashMap(HashMap<Integer,?> Map, String type){	
		if(type.equalsIgnoreCase("user"))
		udi.getAll().forEach(u -> userMap.put(u.getId(), u));
		else if (type.equalsIgnoreCase("login"))
		lidi.getAll().forEach(li -> loginMap.put(li.getId(), li));
		else if(type.equalsIgnoreCase("account"));
		adi.getAll().forEach(a -> accountMap.put(a.getId(), a));
			
	}
	private static void employeeOptions() {
		// TODO Auto-generated method stub
		
	}
	
}
