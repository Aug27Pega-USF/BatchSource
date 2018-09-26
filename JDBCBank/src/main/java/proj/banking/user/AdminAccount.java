package proj.banking.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import proj.banking.bean.UserAccountInfo;
import proj.banking.utils.Banking;
import proj.banking.utils.Enums.NewUser;

public class AdminAccount extends EmployeeAccount{

	public AdminAccount (Connection dbConnection, Banking bankService, UserAccountInfo userAccInfo){
		this.dbConnection = dbConnection;
		this.bankService = bankService;
		this.userAccInfo = userAccInfo;
		this.accountLevel = 3;
		// TODO Auto-generated constructor stub
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
		System.out.println("= 1. View User Accounts                        =");
		System.out.println("= 2. Create New User Account                   =");
		System.out.println("= 3. Update User Information                   =");
		System.out.println("= 4. Delete User                               =");
		System.out.println("= 0. Logout                                    =");
	}
	
	void selection() {
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		System.out.println();
		switch(selection) {
		case 0:
			if(this.getClass().getSimpleName().equals("AdminAccount")) {
				try {
					logout();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		case 1:
			printAllCustomerList(3);
			break;
		case 2:
			createNewUser();
			break;
		case 3:
			performUserTransactions();
			break;
		case 4:
			if(deleteAccount()) {
				System.out.println("--User Deleted");
			} else {
				System.out.println("--User Not Found");
			}
			break;
		default:
			break;
		}
	}
	
	NewUser createNewUser() {
		String newUserID, newUserPassword;
		int newUserAccLevel;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Register a login: ");
		newUserID = scan.next();
		System.out.print("Register a password: ");
		newUserPassword = scan.next();
		System.out.print("User Account Level: ");
		System.out.println("\t1. Customer");
		System.out.println("\t2. Employee");
		System.out.println("\t3. Admin");
		System.out.println(" Selection: ");
		newUserAccLevel = scan.nextInt();
		return registerUserLogin(newUserID, newUserPassword, newUserAccLevel);
	}
	
	boolean deleteAccount() {
		Scanner scan = new Scanner(System.in);
		int customerAccNum;
		
		System.out.print("Enter customer account number: ");
		customerAccNum = scan.nextInt();
		try {
			return bankService.deleteUserAccount(customerAccNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
