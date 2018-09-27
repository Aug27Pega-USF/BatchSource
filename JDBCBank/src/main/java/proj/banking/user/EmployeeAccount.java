package proj.banking.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import proj.banking.bean.BankAccounts;
import proj.banking.bean.UserAccountInfo;
import proj.banking.utils.Banking;
import proj.banking.utils.Enums.NewUser;

public class EmployeeAccount extends CustomerAccount {
	//BankLogin userService;
	EmployeeAccount() {};
	
	public EmployeeAccount (Connection dbConnection, Banking bankService, UserAccountInfo userAccInfo){
		this.dbConnection = dbConnection;
		this.bankService = bankService;
		this.userAccInfo = userAccInfo;
		this.accountLevel = 2;
	}
	
	@Override
	public void userPage() {
		headerPage();
		selectionMenu();
		bottomSelectMenu();
		selection();
	}

	@Override
	UserAccount loggingIn() {
		//userService = BankLogin.getInstance(null, null);
		//customerList = userService.getUserPersonalInfo("0","Customer");
		return this;
	}

	@Override
	void selectionMenu() {
		System.out.println("================================================");
		System.out.println("=                     Menu                     =");
		System.out.println("=----------------------------------------------=");
		System.out.println("= 1. Customer Transactions                     =");
		System.out.println("= 2. Update Personal Information               =");
		System.out.println("= 3. Update Login Information                  =");
		System.out.println("= 4. Create New User                           =");
		System.out.println("= 5. View All Customer Accounts                =");
		System.out.println("= 6. View Waiting Approvals                    =");
		System.out.println("= 7. Approval Accounts                         =");
		System.out.println("= 0. Logout                                    =");
	}
	
	void selection() {
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		System.out.println();
		switch(selection) {
		case 0:
			if(this.getClass().getSimpleName().equals("EmployeeAccount")) {
				try {
					logout();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		case 1:
			performUserTransactions();
			break;
		case 2:
			/*
			System.out.print("Enter the customer number: ");
			int customerSelection = scan.nextInt();
			if(selection == 1)
				try {
					printCustomerBankAccountInfo(customerSelection - 1);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else if(selection == 2)
				printCustomerPersonalInfo(customerSelection - 1);
			*/
			changePersonalInfo(userAccInfo);
			break;
		case 3:
			changeLoginInfo(userAccInfo.getUserAccNum());
			break;
		case 4:
			if(createNewUser() == NewUser.SUCCESS) {
				System.out.println("\tNew user successfully created");
			} else {
				System.out.println("\tError creating new user");
			}
			break;
		case 5:
			printAllCustomerList(1);
			break;
		case 6:
			viewWaitingApprovals();
			scan.nextLine();
			break;
		case 7:
			approveAccount();
			scan.nextLine();
			break;
		default:
			break;
		}
	}
	
	void viewWaitingApprovals() {
		List<String[]> approvalList = null;
		
		try {
			approvalList = bankService.getWaitingApproval();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(approvalList != null) {
			System.out.println("\tWaiting Approval List");
			System.out.println("------------------------------------------------");
			System.out.println("Account# \t| Init. Bal.\t| Name");
			for(String s[] : approvalList) {
				System.out.println(s[0] + " \t| $" + String.format("%.2f", Double.parseDouble(s[2])) + "\t| " + s[1]);
			} 
		}
	}
	
	void approveAccount() {
		Scanner scan = new Scanner(System.in);
		int bankAccountNumber;
		
		viewWaitingApprovals();
		bankAccountNumber = scan.nextInt();
		try {
			if( bankService.approveAccount(bankAccountNumber) == true) {
				System.out.println("Account " + bankAccountNumber + " was approved");
			} else {
				System.out.println("Account " + bankAccountNumber + " was invalid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void printAllCustomerList(int getUserLevels) {
		Scanner scan = new Scanner(System.in);
		List<UserAccountInfo> userList = null;
		
		try {
			userList = bankService.getUserList(getUserLevels);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(userList != null) {
			System.out.println("\tCustomer List");
			System.out.println("------------------------------------------------");
			System.out.println("Acct. #\t | Name \t\t| DOB");
			for(UserAccountInfo user : userList) {
				System.out.println(user.getUserAccNum() + "| " + String.format("%1$-" + 20 + "s", user.getFirstName() 
						+ " " + user.getLastName() + "\t\t| " + user.getDob().substring(0, 10)));
			} 
			scan.nextLine();
		}
	}
	
	void performUserTransactions() {
		int selection = 0, customerAccNum = 0;
		Scanner scan = new Scanner(System.in);
		UserAccountInfo customerInfo;
		List<BankAccounts> customerBankAccounts;
		
		System.out.print("Enter customer account number: ");
		customerAccNum = scan.nextInt();
		
		try {
			customerInfo = bankService.getUserInfo(customerAccNum);
			if(customerInfo != null) {
				do {
					customerTransactionMenu();
					selection = scan.nextInt();
					switch(selection) {
					case 0:
						customerAccNum = 0;
						break;
					case 1:
						customerBankAccounts = bankService.getUserBankAccounts(customerAccNum);
						super.displayAccounts(customerBankAccounts);
						super.selectionMenu();
						super.bottomSelectMenu();
						super.selection(customerInfo.getUserAccNum(), customerBankAccounts);
						break;
					case 2:
						super.changePersonalInfo(customerInfo);
						break;
					case 3:
						super.changeLoginInfo(customerAccNum);
						break;
					}
				} while(customerAccNum != 0);
			} else {
				System.out.println("--Customer Account Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void customerTransactionMenu() {
		System.out.println("================================================");
		System.out.println("=                     Menu                     =");
		System.out.println("= 1. Bank Transactions                         =");
		System.out.println("= 2. Update Customer Information               =");
		System.out.println("= 3. Change Login Information                  =");
		System.out.println("= 0. Finished Customer Transactions            =");
		bottomSelectMenu();
	}
	
	NewUser createNewUser() {
		String newUserID, newUserPassword;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Register a login: ");
		newUserID = scan.next();
		System.out.print("Register a password: ");
		newUserPassword = scan.next();
		return registerUserLogin(newUserID, newUserPassword);
	}
	
	/*
	public void printCustomerBankAccountInfo(int customerSelection) throws NumberFormatException, SQLException {
		List<BankAccounts> customerAccountList = 
				bankService.getUserBankAccounts(customerList.get(customerSelection).getUserAccNum());
		int counter = 1;
		for(BankAccounts acc : customerAccountList) {
			System.out.println(" " + counter + ": " + acc.toString());
			counter++;
		}
		System.out.println();
	}
	*/
	
}
