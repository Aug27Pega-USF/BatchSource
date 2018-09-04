package proj.banking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import proj.banking.utils.Enums.*;
import proj.banking.user.LoginInfo;
import proj.banking.user.UserAccount;
import proj.banking.user.UserLogin;
import proj.banking.user.bean.UserAccountInfo;
import proj.banking.utils.DataFiles;

public class BankMain{
	private static BankMain instance;
	protected DataFiles files;
	private UserLogin userLogin;
	List<String> userAccounts;
	List<BankAccounts> bankAccountList, approvalWaitingList, canceledAccount;
	
	private BankMain(DataFiles fileLoc) {
		if(fileLoc != null && this.files == null && instance == null) {
			this.files = fileLoc;
			userLogin = UserLogin.getInstance(files.getUserFile(), files.getUserInfoFile());
			bankAccountList = new ArrayList<BankAccounts>();
			approvalWaitingList = new ArrayList<BankAccounts>();
			loadBankAccounts();
		}
	}
	
	public static synchronized BankMain getInstance(DataFiles fileLoc) {
		if(instance == null) {
			instance = new BankMain(fileLoc);
		}
		return instance;
	}
	
	public void loadBankAccounts() {
		try {
			File file = new File(files.getBankAccountFile());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String str;
			
			while((str = reader.readLine()) != null) {
				BankAccounts acc = new BankAccounts(str.split(","));
				if(acc.getWaitingApproval() == true) {
					approvalWaitingList.add(acc);
				} else {
					bankAccountList.add(acc);
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void approvedAccount(String accountNumber) {
		BankAccounts approvedAccount = null;
		
		for(BankAccounts acc : approvalWaitingList) {
			if(acc.getAccountNumber().equals(accountNumber)) {
				acc.setWaitingApproval (false);
				approvedAccount = acc;
				break;
			}
		}
		if(approvedAccount != null) {
			bankAccountList.add(approvedAccount);
			approvalWaitingList.remove(approvedAccount);
		}
	}
	
	public boolean getApprovalStatus(String bankAccountNumber) {
		for(BankAccounts acc : approvalWaitingList) {
			if(acc.getAccountNumber().equals(bankAccountNumber)) {
				return true;
			}
		}
		return false;
	}
	
	public BankAccounts getBankAccount(String userAccNum, String bankAccNum) {
		for(BankAccounts acc : getUserBankAccounts(userAccNum)) {
			if(acc.getAccountNumber().equals(bankAccNum)) {
				return acc;
			}
		}
		return null;
	}
	
	public ArrayList<BankAccounts> getUserBankAccounts(String userAccountNumber){
		ArrayList<BankAccounts> accountList = new ArrayList<BankAccounts>();
		for(BankAccounts acc : bankAccountList) {
			if(acc.getAccountHolderID().equals(userAccountNumber) || acc.getJointHolderID().equals(userAccountNumber)) {
				accountList.add(acc);
			}
		}
		return accountList;
	}
	
	transactionStatus withdraw(BankAccounts account, double amount) {
		double newBalance = account.getAmount() - amount;
		if(newBalance >= 0) {
			account.setAmount(newBalance);
			return transactionStatus.SUCCESS;
		} else {
			return transactionStatus.NOT_ENOUGH_FUNDS;
		}
	}
	
	transactionStatus deposit(BankAccounts account, double amount) {
		account.setAmount(account.getAmount() + amount);
		return transactionStatus.SUCCESS;
	}
	
	public transactionStatus transaction(transactionType transaction, String userAccNum, String bankAccNum1, String bankAccNum2, double amount) {
		if(amount > 0) {
			BankAccounts transactionAccount = getBankAccount(userAccNum, bankAccNum1);
			if(transactionAccount != null) {
				switch(transaction) {
				case DEPOSIT:
					return deposit(transactionAccount, amount);
				case WITHDRAW:
					return withdraw(transactionAccount, amount);
				case TRANSFER:
					BankAccounts transferToAcc = getBankAccount(userAccNum, bankAccNum2);
					if(withdraw(transactionAccount, amount) == transactionStatus.SUCCESS) {
						return deposit(transferToAcc, amount);
					} else {
						return transactionStatus.NOT_ENOUGH_FUNDS;
					}
				}
			}
		} else {
			return transactionStatus.INVALID_AMOUNT;
		}
		return transactionStatus.FAILED;
	}
	
	public UserAccountInfo login(String userID, String password) throws Exception {
		String acc = userLogin.checkLogin(userID,password);
		if(acc != null) {
			return getUserInfo(acc);
		} else return null;
	}
	
	public UserAccountInfo getUserInfo(String accountNumber) throws Exception{
		UserAccountInfo user = null;
		BufferedReader reader = null;
		File file = new File(files.getUserInfoFile());
		String str;

		reader = new BufferedReader(new FileReader(file));
		while((str = reader.readLine()) != null) {
			if(str.startsWith(accountNumber)) {
				user = new UserAccountInfo(str.split(","));

				break;
			}
		}
		reader.close();
		
		return user;
	}
	
	public newLogin createUser(String userID, String userPassword) {
		return userLogin.createUser(userID, userPassword);
	}
	
	public String newBankAccount(String accountHolderID, String jointAccountHolderID, double initialDeposit) {
		BankAccounts newAccount = new BankAccounts(accountHolderID, jointAccountHolderID, generateAccountNumbers(), initialDeposit, true);
		approvalWaitingList.add(newAccount);
		return newAccount.getAccountNumber();
	}
	
	public boolean logout(UserAccountInfo user) {
		try {
			switch(user.getAccountType()) {
			case "CustomerAccount":
				ObjectOutputStream objectOut = 
				new ObjectOutputStream(
						new FileOutputStream(files.getUserInfoFile() + user.getAccountNumber() + ".txt"
								));
				try {
					objectOut.writeObject(user.getClass().getMethod("getBankAccounts"));
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				objectOut.close();
				break;
			case "EmployeeAccount":
				break;
			case "AdminAccount":
				break;
			default:
				break;
			};
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	private String generateAccountNumbers() {
		Random rand = new Random();
		int randNum;
		String bankAccountNumber = "";
		
		while(bankAccountNumber.length() < 10) {
			randNum = rand.nextInt(10);
			if(bankAccountNumber.length() != 0 || randNum != 0) {
				bankAccountNumber += Integer.toString(randNum);
			}
		}
		return bankAccountNumber;
	}
	/*
	public boolean findUserExists(String userAccountNumber) {
		if(new File(files.getAccountLocation() + userAccountNumber + ".txt").exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean findAccountExists(String userAccountNumber, String bankAccountNumber) {
		if(findUserExists(userAccountNumber)) {
			File file = new File(files.getAccountLocation() + userAccountNumber + ".txt");
			try {
				if(file.exists()) {
					Scanner scan = new Scanner(file);
					if(scan.findInLine(bankAccountNumber) != null) {
						scan.close();
						return true;
					}
					scan.close();
				}
				return false;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	*/
}
