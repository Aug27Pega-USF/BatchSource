package myBankingApp.userInterface;

import java.io.Serializable;
import java.util.Scanner;

import myBankingApp.Bank.Bank;
import myBankingApp.Bank.BankAdmin;
import myBankingApp.Bank.Customer;
import myBankingApp.Bank.Employee;
import myBankingApp.Bank.BankLogger;


public class UserInterface implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6568791252752683877L;
	
	public static IOBankUI ioBankUI = new IOBankUI();

	// Fields
	public Bank myBank;
	private int customerID = 0;
	
	// CONSTRUCTOR
	public UserInterface() {
		super();
		myBank = new Bank();
		
		myBank.bankAdminList.add(new BankAdmin("Luis","Doi","luisdoi","111"));
		myBank.bankAdminList.add(new BankAdmin("Matt", "Knighten","MK","111"));
		
		myBank.employeeList.add(new Employee("Luis","doi", "ldoi","111"));
/*		
		myBank.customerList.add(new Customer("Vincent", "Rogers", "vRogers", "111", customerID));
		customerID++;
		myBank.customerList.add(new Customer("Kevin","Medara","kMedara", "111", customerID));
		customerID++;
		myBank.customerList.add(new Customer("Kai","Ito","kIto", "111", customerID));
		customerID++;
		myBank.customerList.add(new Customer("Sean","Robinson","sRob", "111", customerID));
		customerID++;
*/
	}
	
// ORDER OF OPERATIONS
	// verify the person is in the bank system by signing in
	// get reference to entity
	// cast it 
	// use it

	
	public void showCustomerMenu(Scanner SC, Customer C) {
		// customer can deposit, withdraw, apply for another account, apply for joint account, view account status, transfer
		while(true) {
			System.out.println("As a customer, would you like to: \n '1' Withdraw \n '2' Deposit \n '3' Apply for an account\n"+
			" '4' Apply for joint account\n '5' View Account Status\n '6' Transfer to Account\n 'Q' Log Off\n" + 
			" Please enter choice:");
			String x = SC.nextLine();
			
			if(x.length() == 1) {
				if(x.equals("Q"))
					break;
				try {
					int X = Integer.valueOf(x);
					switch(X) {
					case 1:
						C.withdraw(SC);
						ioBankUI.writeSerializedBankUIFile();	
						break;
					case 2:
						C.deposit(SC);
						ioBankUI.writeSerializedBankUIFile();	
						break;
					case 3:
						C.applyForAccount(SC, myBank.openAccountApplications);
						ioBankUI.writeSerializedBankUIFile();	
						break;
					case 4:
						System.out.println("Please have the second customer log in to continue applying for a joint account.");
						System.out.println("Second user, please enter your username: ");
						String username = SC.nextLine();
						System.out.println("Second user, please enter your password: ");
						String password = SC.nextLine();
						
						Customer C2 = myBank.getCustomer(username, password);
						if(C2 != null) {
							C.applyForJointAccount(SC, myBank.openAccountApplications, C2);
							ioBankUI.writeSerializedBankUIFile();	
						}
						break;
					case 5:
						C.viewAccountStatus(SC);
						break;
					case 6:
						C.transfer(SC);
						ioBankUI.writeSerializedBankUIFile();	
						break;
					default:
						break;
						
					}
				} catch (NumberFormatException e) {
						System.out.println("ERROR - Your input was invalid. Please try again");
						System.out.println();					
				}
			}
		}
	}	
	
	public void showEmployeeMenu(Scanner SC, Employee E) {
		// employee can approve/deny applications for accounts, can view customer info
		while(true) {
			System.out.println("As an employee, would you like to: \n '1' View customer info \n " +
					"'2' Approve/Deny open applications for accounts\n 'Q' Log Off\n" + 
					" Please enter choice:");
			String x = SC.nextLine();
			
			if(x.length() == 1) {
				if(x.equals("Q"))
					break;
				try {
					int X = Integer.valueOf(x);
					switch(X) {
					case 1:
						E.viewCustomerInfo(SC, myBank.customerList);
						break;
					case 2:
						E.manageOpenAppsForAccounts(SC, myBank.openAccountApplications);
						myBank.updateOpenAccApps();
						ioBankUI.writeSerializedBankUIFile();	
						break;
					default:
						break;
						
					}
				} catch (NumberFormatException e) {
						System.out.println("ERROR - Your input was invalid. Please try again");
						System.out.println();					
				}
			}

		}
	}
	
	public void showBankAdminMenu(Scanner SC, BankAdmin BA) {
		// bank admin can view/edit accounts (withdraw,deposit,cancel,transferring, approve/deny accounts)
		while(true) {
			System.out.println("As an bank administrator, would you like to: \n '1' View customer info \n" +
					" '2' Approve/Deny open applications for accounts\n '3' Withdraw from Customer Account\n" +
					" '4' Deposit to Customer Account\n '5' Transfer to/from Customer Accounts\n" + 
					" '6' Cancel Customer Account\n 'Q' Log Off\n Please Enter Choice:\n");
			String x = SC.nextLine();
			
			if(x.length() == 1) {
				if(x.equals("Q"))
					break;
				try {
					int X = Integer.valueOf(x);
					switch(X) {
					case 1:
						BA.viewCustomerInfo(SC, myBank.customerList);
						break;
					case 2:
						BA.manageOpenAppsForAccounts(SC, myBank.openAccountApplications);
						myBank.updateOpenAccApps();
						ioBankUI.writeSerializedBankUIFile();	
						break;
					case 3:
						BA.withdraw(SC, myBank.customerList);
						ioBankUI.writeSerializedBankUIFile();	
						break;
					case 4:
						BA.deposit(SC, myBank.customerList);
						ioBankUI.writeSerializedBankUIFile();	
						break;
					case 5:
						BA.transfer(SC, myBank.customerList);
						ioBankUI.writeSerializedBankUIFile();	
						break;
					case 6:
						BA.cancelAccount(SC, myBank.customerList);
						ioBankUI.writeSerializedBankUIFile();	
						break;
					default:
						break;
						
					}
				} catch (NumberFormatException e) {
						System.out.println("ERROR - Your input was invalid. Please try again");
						System.out.println();					
				}
			}
	
		}
	}
	
	public void loginToSystem(Scanner SC) {
		while(true) {
			// TODO - remove customer print statement
			//System.out.println(myBank.customerList);
			System.out.println("LOGIN - Who are you?\n Enter '1' for CUSTOMER.\n Enter '2' for EMPLOYEE.\n"
					+ " Enter '3' for BANK ADMINISTRATOR.\n Enter 'Q' to quit.");
			
			String x = SC.nextLine();
			String username;
			String password;
			
			if(x.length() == 1) {
				if(x.equals("Q")) {
					break;
				}
				try {
					int X = Integer.valueOf(x);
					switch(X) {
					case 1:
						System.out.println("Enter CUSTOMER username:");		
						username = SC.nextLine();
						System.out.println("Enter CUSTOMER password:");		
						password = SC.nextLine();
						Customer C = myBank.getCustomer(username, password);
						if(C != null) {
							System.out.println("Welcome! You have successfully signed in as customer: " + username);
							showCustomerMenu(SC,C);
						}
						else
							System.out.println("ERROR - Customer does not exist! Invalid username and password. Try again.");
						break;
					case 2:
						System.out.println("Enter EMPLOYEE username:");		
						username = SC.nextLine();
						System.out.println("Enter EMPLOYEE password:");		
						password = SC.nextLine();
						Employee E = myBank.getEmployee(username, password);
						if(E != null) {
							System.out.println("Welcome! You have successfully signed in as employee: " + username);
							showEmployeeMenu(SC,E);
						}
						else
							System.out.println("ERROR - Employee does not exist! Invalid username and password. Try again.");
						break;
					case 3:
						System.out.println("Enter BANK ADMIN username:");		
						username = SC.nextLine();
						System.out.println("Enter BANK ADMIN password:");		
						password = SC.nextLine();
						BankAdmin BA = myBank.getBankAdmin(username, password);
						if(BA != null) {
							System.out.println("Welcome! You have successfully signed in as bank admin: " + username);
							showBankAdminMenu(SC,BA);
						}
						else
							System.out.println("ERROR - Bank Admin does not exist! Invalid username and password. Try again.");
						break;
					default:
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("ERROR - Your input was invalid. Please try again");
					System.out.println();			
				}
			}
		}
		
	}

	public void createCustomerAccount(Scanner SC) {
		String fName = null;
		String lName = null;
		String uName = null;
		String pWord = null;
		// create customer!
		while(true) {
					
			System.out.println("You are now creating a customer account!");
			if(fName == null) {
				System.out.println("Please enter your first name.");
				fName = SC.nextLine();
			}
			if(lName == null) {
				System.out.println("Please enter your last name.");
				lName = SC.nextLine();
			}
			if(uName == null) {
				System.out.println("Please enter your new username");
				uName = SC.nextLine();
				Customer c = myBank.getCustomer(uName);
				if(c != null) {
					uName = null;
					System.out.println("Sorry, but username is TAKEN! Please enter a different username.");
				}
			}
			if(pWord == null) {
				System.out.println("Please enter your new password");
				pWord = SC.nextLine();
			}
			if(fName != null && lName != null && uName != null && pWord != null) {
				Customer C = new Customer(fName, lName, uName, pWord, customerID);
				myBank.customerList.add(C);
				System.out.println("Congratulations " + fName + " " + lName + " you have created a new customer account. " +
				"Your username is: " + uName + " and your password is: " + pWord);
				System.out.println("Your customerID is:      " + customerID);
				customerID++;
				ioBankUI.writeSerializedBankUIFile();	
				break;
			}
		}
	}

	public void initialize(Scanner SC) {
		
		while(true) {
			System.out.println("Hello and welcome to Red Feather Bank!\n" + "Please enter '1' if you would like to " 
		+ "log into an account in our system.\n" + "Enter '2' if you would like to register a customer account.");
			String x = SC.nextLine();

			try {
				int X = Integer.valueOf(x);
				switch(X) {
				case 1:
					loginToSystem(SC);
					break;
				case 2:
					createCustomerAccount(SC);
					break;
				default:
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("ERROR - Your input was invalid. Please try again");
				System.out.println();
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		

		// Declare reference to UI
		UserInterface UI;
		
		// Read serialized object from file
		ioBankUI.readSerializedBankUIFile();
		// Assign reference to stored bankUI from text file
		UI = IOBankUI.serializedBankUI;

		// Initialize scanner
		Scanner SC = new Scanner(System.in);
		
		// Initialize user interface and pass in scanner object
		UI.initialize(SC);
		
		//ioBankUI.serializedBankUI.initialize(SC);;
	}
}
