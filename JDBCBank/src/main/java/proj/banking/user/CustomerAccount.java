package proj.banking.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import proj.banking.bean.BankAccounts;
import proj.banking.bean.UserAccountInfo;
import proj.banking.user.UserAccount;
import proj.banking.utils.Banking;
import proj.banking.utils.Enums.CloseStatus;
import proj.banking.utils.Enums.NewBankAccountStatus;
import proj.banking.utils.Enums.NewUser;
import proj.banking.utils.Enums.TransactionStatus;
import proj.banking.utils.Enums.TransactionType;

public class CustomerAccount extends UserAccount{
	//private List<BankAccounts> bankAccounts;
	
	CustomerAccount() {};
	
	public CustomerAccount (Connection dbConnection, Banking bankService, UserAccountInfo userAccInfo){
		this.dbConnection = dbConnection;
		this.bankService = bankService;
		this.userAccInfo = userAccInfo;
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

	UserAccount loggingIn() {
		return this;
	}
	
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
				try {
					logout();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		TransactionStatus status = null;
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
				status = bankService.transaction(TransactionType.WITHDRAW, 
						transactionAccNum, userBankAccounts.get(inputOption - 1).getAccountNumber(), 0, amount);
				
				break;
			case 2:
				status = bankService.transaction(TransactionType.DEPOSIT, 
						transactionAccNum, userBankAccounts.get(inputOption - 1).getAccountNumber(), 0, amount);
				break;
			case 3:
				System.out.print("Enter transfer account option: ");
				transferOption = scan.nextInt();
				//TODO: implement check to see if select is higher than actual bank accounts
				status = bankService.transaction(
						TransactionType.TRANSFER, 
						transactionAccNum, 
						userBankAccounts.get(inputOption - 1).getAccountNumber(), 
						userBankAccounts.get(transferOption - 1).getAccountNumber(), 
						amount);
				break;
			}
			if(status != null) {
				switch(status) {
				case SUCCESS:
					System.out.println("\tTransaction Successful");
					break;
				case FAILED:
					System.out.println("\tTransaction Unsucessful");
					break;
				}
			}
		} else {
			System.out.println("\nNo accounts to perform transactions on\n");
		}
	}
	
	void openNewBankAccount(int userAccNum) {
		int jointHolderID;
		double initialDeposit;
		NewBankAccountStatus newBankStatus;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Joint account holder ID: ");
		scan.nextLine();
		jointHolderID = scan.match().group().equals("\r\n") ? 0 : Integer.parseInt(scan.match().group());
		System.out.print("Enter an initial deposit: ");
		initialDeposit = scan.nextDouble();
		try {
			newBankStatus = bankService.newBankAccount(0, userAccNum, jointHolderID, initialDeposit);
			switch(newBankStatus) {
			case SUCCESS:
				System.out.println("\tNew account was successfuly created");
				break;
			case INVALID_DEPOSIT:
				System.out.println("\tInvalid deposit amount");
				break;
			default:
				System.out.println("\tError creating new bank account");
				break;
			}
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
				System.out.println("\tBank account has been closed.");
				break;
			case ACTIVE_FUNDS:
				System.out.println("\tFunds are still available. \nPlease withdraw or transfer all funds before closing the account.");
				break;
			default:
				System.out.println("\tThere was a problem with closing the account.");
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void changePersonalInfo(UserAccountInfo userInfo) {
		NewUser updateStatus;
		Scanner scan = new Scanner(System.in);
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
				updateStatus = bankService.updatePersonalInfo(userInfo, selection);
				switch(updateStatus) {
				case SUCCESS:
					System.out.println("\tUpdate Successful");
					break;
				case NO_FIRST:
					System.out.println("\tInvalid first name");
					break;
				case NO_LAST:
					System.out.println("\tInvalid last name");
					break;
				default:
					System.out.println("\tError while updating information");
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void changeLoginInfo(int userAccNum) {
		NewUser updateStatus;
		Scanner scan = new Scanner(System.in);
		String newUserName, newPassword;
		
		System.out.print("Enter new username: ");
		newUserName = scan.nextLine();
		System.out.print("Enter new password: ");
		newPassword = scan.nextLine();
		
		try {
			updateStatus = bankService.updateLoginInfo(userAccNum, newUserName, newPassword);
			switch(updateStatus) {
			case SUCCESS:
				System.out.println("\tUpdate Successful");
				break;
			case INVALID_USERNAME:
				System.out.println("\tInvalid username");
				break;
			case INVALID_PASSWORD:
				System.out.println("\tInvalid password");
				break;
			default:
				System.out.println("\tError while updating login");
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void logout() throws SQLException {
		System.out.println("\tLogging out");
		userAccInfo = null;
		bankService = null;
		dbConnection.close();
		dbConnection = null;
	}
}
