package proj.banking.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import proj.banking.BankMain;
import proj.banking.bean.BankAccounts;
import proj.banking.bean.UserAccountInfo;
import proj.banking.user.UserAccount;
import proj.banking.utils.Enums.CloseStatus;
import proj.banking.utils.Enums.TransactionType;

public class CustomerAccount extends UserAccount{
	//private List<BankAccounts> bankAccounts;
	
	public CustomerAccount () throws Exception{
		super();
		accountLevel = 1;
	}
	
	@Override
	public void userPage() {
		List<BankAccounts> bankAccounts = null;
		headerPage();
		try {
			bankAccounts = bankService.getUserBankAccounts(userAccInfo.getUserAccNum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displayAccounts(bankAccounts);
		selectionMenu();
		bottomSelectMenu();
		selection(userAccInfo.getUserAccNum(), bankAccounts);
	}

	@Override
	UserAccount loggingIn() {
		return this;
	}
	
	@Override
	void selectionMenu() {
		System.out.println("================================================");
		System.out.println("=                     Menu                     =");
		System.out.println("=----------------------------------------------=");
		System.out.println("= 1. Withdraw                                  =");
		System.out.println("= 2. Deposit                                   =");
		System.out.println("= 3. Transfer                                  =");
		System.out.println("= 4. Open new account                          =");
		System.out.println("= 5. Close Account                             =");
		System.out.println("= 6. Update Personal Information               =");
		System.out.println("= 7. Update Login                              =");
		System.out.println("= 0. Logout                                    =");
	}

	void selection(int userAccNum, List<BankAccounts> userBankAccounts) throws NumberFormatException {
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		System.out.println();
		
		switch(selection) {
		case 0:
			if(this.getClass().getSimpleName().equals("CustomerAccount")) {
				logout();
			}
			break;
		case 1:
		case 2:
		case 3:
			if(userBankAccounts != null) {
				try {
					transactions(selection, userAccNum, userBankAccounts);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("\nNo accounts to preform the transaction\n");
			}
			break;
		case 4:
			openNewBankAccount(userAccInfo.getUserAccNum());
			break;
		case 5:
			int inputOption;
			displayAccounts(userBankAccounts);
			bottomSelectMenu();
			inputOption = scan.nextInt();
			closeBankAccount(inputOption, userAccNum, userBankAccounts);
			break;
		case 6:
			changePersonalInfo(userAccInfo);
			break;
		case 7:
			changeLoginInfo(userAccInfo.getUserAccNum());
			break;
		}
	}
	
	void displayAccounts(List<BankAccounts> userBankAccounts) {
		int counter = 1;
		/*
		try {
			bankAccounts = bankService.getUserBankAccounts(userAccNum);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		if(userBankAccounts != null) {
			System.out.println("\nSelect#\t| Account Number \t| Amount");
			for(BankAccounts acc : userBankAccounts) {
				System.out.println(counter + " \t| " + acc.getAccountNumber() + " \t\t| $" + acc.getAmount());
				counter++;
			}
		}
	}
	
	void transactions(int selection, int transactionAccNum, List<BankAccounts> userBankAccounts) throws NumberFormatException, SQLException {
		Scanner scan = new Scanner(System.in);
		int inputOption, transferOption;
		double amount;
		
		if(userBankAccounts != null) {
			displayAccounts(userBankAccounts);
			System.out.print("Enter account option: ");
			inputOption = scan.nextInt();
			//TODO: implement check to see if select is higher than actual bank accounts
			System.out.print("Enter the amount: ");
			amount = scan.nextDouble();
			switch(selection) {
			case 1:
				bankService.transaction(TransactionType.WITHDRAW, 
						transactionAccNum, userBankAccounts.get(inputOption - 1).getAccountNumber(), 0, amount);
				break;
			case 2:
				bankService.transaction(TransactionType.DEPOSIT, 
						transactionAccNum, userBankAccounts.get(inputOption - 1).getAccountNumber(), 0, amount);
				break;
			case 3:
				System.out.print("Enter transfer account option: ");
				transferOption = scan.nextInt();
				//TODO: implement check to see if select is higher than actual bank accounts
				bankService.transaction(
						TransactionType.TRANSFER, 
						transactionAccNum, 
						userBankAccounts.get(inputOption - 1).getAccountNumber(), 
						userBankAccounts.get(transferOption - 1).getAccountNumber(), 
						amount);
				break;
			}
		} else {
			System.out.println("\nNo accounts to perform transactions on\n");
		}
	}
	
	void openNewBankAccount(int userAccNum) {
		int jointHolderID;
		double initialDeposit;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Joint account holder ID: ");
		scan.nextLine();
		jointHolderID = scan.match().group().equals("\r\n") ? 0 : Integer.parseInt(scan.match().group());
		System.out.print("Enter an initial deposit: ");
		initialDeposit = scan.nextDouble();
		try {
			bankService.newBankAccount(0, userAccNum, jointHolderID, initialDeposit);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void closeBankAccount(int selection, int userAccNumber, List<BankAccounts> userBankAccounts) {
		CloseStatus status;
		try {
			status = bankService.closeUserBankAccount(userAccNumber, userBankAccounts.get(selection - 1).getAccountNumber());
			switch(status) {
			case SUCCESS:
				System.out.println("Bank account has been closed.");
				break;
			case ACTIVE_FUNDS:
				System.out.println("Funds are still available. Please withdraw or transfer all funds before closing the account.");
				break;
			default:
				System.out.println("There was a problem with closing the account.");
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void changePersonalInfo(UserAccountInfo userInfo) {
		Scanner scan = new Scanner(System.in);
		String newEntry;
		int selection;
		
		System.out.println("Update: ");
		System.out.println(" 1. First Name     " + userInfo.getFirstName());
		System.out.println(" 2. Last Name      " + userInfo.getLastName());
		System.out.println(" 3. E-mail         " + userInfo.getEmail());
		System.out.println(" 4. Phone          " + userInfo.getPhone());
		System.out.println(" 5. Date of Birth  " + userInfo.getDob().substring(0, 10));
		System.out.println(" 6. Street Address " + userInfo.getStreetAddress());
		System.out.println(" 7. State          " + userInfo.getState());
		System.out.println(" 8. Zip            " + userInfo.getZip());
		System.out.print("Selection: ");
		selection = scan.nextInt();		
		setNewUserInfo(userInfo, selection);
		
		if(selection >= 1 && selection <= 8) {
			try {
				bankService.updatePersonalInfo(userInfo, selection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void changeLoginInfo(int userAccNum) {
		Scanner scan = new Scanner(System.in);
		String newUserName, newPassword;
		
		System.out.print("Enter new username: ");
		newUserName = scan.next();
		System.out.print("Enter new password: ");
		newPassword = scan.next();
		
		try {
			bankService.updateLoginInfo(userAccNum, newUserName, newPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void logout() {
		userAccInfo = null;
	}
}
