package proj.banking.user;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

import proj.banking.BankAccounts;
import proj.banking.BankMain;
import proj.banking.user.bean.UserAccountInfo;

public class EmployeeAccount extends UserAccount {
	UserLogin userService;
	List<UserAccountInfo> customerList;
	
	public EmployeeAccount (){
		super();
	}
	@Override
	public void userPage() {
		headerPage();
		printAllCustomerList();
		selectionMenu();
		bottomSelectMenu();
		selection();
	}

	@Override
	UserAccount loggingIn() {
		userService = UserLogin.getInstance(null, null);
		customerList = userService.getCustomerPersonalInfo("0","Customer");
		return this;
	}

	@Override
	void selectionMenu() {
		System.out.println("================================================");
		System.out.println("=                     Menu                     =");
		System.out.println("= 1. View Account Information                  =");
		System.out.println("= 2. View Customer Information                 =");
		System.out.println("= 3. Approve Accounts                          =");
		System.out.println("= 0. Logout                                    =");
	}

	public void approveRequest(String customerAccountNumber) {
		bankService.approvedAccount(customerAccountNumber);
	}
	
	public void printAllCustomerList() {
		int counter = 1;
		
		for(UserAccountInfo customer : customerList) {
			System.out.println(" " + counter + " \t" + 
					customer.getName() + " \t" + 
					customer.getAccountNumber());
			counter++;
		}
	}
	
	public void printCustomerBankAccountInfo(int customerSelection) {
		List<BankAccounts> customerAccountList = 
				bankService.getUserBankAccounts(customerList.get(customerSelection).getAccountNumber());
		int counter = 1;
		for(BankAccounts acc : customerAccountList) {
			System.out.println(" " + counter + ": " + acc.toString());
			counter++;
		}
		System.out.println();
	}
	
	public void printCustomerPersonalInfo(int customerSelection) {
		List<UserAccountInfo> customerInfo = 
				userService.getCustomerPersonalInfo(customerList.get(customerSelection).getAccountNumber(),"Customer");
		System.out.println(customerInfo.get(0).toString());
	}
	
	private void approveAccounts() {
		
	}
	
	@Override
	void selection() {
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		switch(selection) {
		case 0:
			logout();
			break;
		case 1:
		case 2:
			System.out.print("Enter the customer number: ");
			int customerSelection = scan.nextInt();
			if(selection == 1)
				printCustomerBankAccountInfo(customerSelection - 1);
			else if(selection == 2)
				printCustomerPersonalInfo(customerSelection - 1);
			break;
		case 3:
			break;
		default:
			break;
		}
		
	}
	@Override
	UserAccount logout() {
		accountInfo = null;
		return null;
	}
	
}
