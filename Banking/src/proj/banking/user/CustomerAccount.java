package proj.banking.user;

import java.util.List;
import java.util.Scanner;

import proj.banking.BankAccounts;
import proj.banking.BankMain;
import proj.banking.user.UserAccount;
import proj.banking.user.bean.UserAccountInfo;
import proj.banking.utils.Enums.transactionType;

public class CustomerAccount extends UserAccount{
	private List<BankAccounts> bankAccounts;
	
	public CustomerAccount () throws Exception{
		super();
	}
	
	@Override
	public void userPage() {
		headerPage();
		displayAccounts();
		selectionMenu();
		bottomSelectMenu();
		selection();
	}

	@Override
	UserAccount loggingIn() {
		// TODO Auto-generated method stub
		try {
			bankAccounts = bankService.getUserBankAccounts(accountInfo.getAccountNumber());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	@Override
	void selectionMenu() {
		System.out.println("================================================");
		System.out.println("=                     Menu                     =");
		System.out.println("= 1. Withdraw                                  =");
		System.out.println("= 2. Deposit                                   =");
		System.out.println("= 3. Transfer                                  =");
		System.out.println("= 4. Open new account                          =");
		System.out.println("= 0. Logout                                    =");
	}
	
	private void displayAccounts() {
		int counter = 1;
		System.out.println("Acc #: \t| Account Number | Amount");
		for(BankAccounts acc : bankAccounts) {
			System.out.println(counter + " \t| " + acc.getAccountNumber() + " \t | $" + acc.getAmount());
			counter++;
		}
	}
	
	void selection() {
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		switch(selection) {
		case 0:
			logout();
			break;
		case 1:
		case 2:
		case 3:
			transactions(selection);
			break;
		case 4:
			break;
		default:
			break;
		}
	}
	
	void transactions(int selection) {
		Scanner scan = new Scanner(System.in);
		int inputOption, transferOption;
		double amount;
		displayAccounts();
		System.out.print("Enter account option: ");
		inputOption = scan.nextInt();
		System.out.print("Enter the amount: ");
		amount = scan.nextDouble();
		switch(selection) {
		case 1:
			bankService.transaction(transactionType.WITHDRAW, 
					accountInfo.getAccountNumber(), bankAccounts.get(inputOption - 1).getAccountNumber(), "", amount);
			break;
		case 2:
			bankService.transaction(transactionType.DEPOSIT, 
					accountInfo.getAccountNumber(), bankAccounts.get(inputOption - 1).getAccountNumber(), "", amount);
			break;
		case 3:
			System.out.print("Enter transfer account option: ");
			transferOption = scan.nextInt();
			bankService.transaction(
					transactionType.TRANSFER, 
					accountInfo.getAccountNumber(), 
					bankAccounts.get(inputOption - 1).getAccountNumber(), 
					bankAccounts.get(transferOption - 1).getAccountNumber(), 
					amount);
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
