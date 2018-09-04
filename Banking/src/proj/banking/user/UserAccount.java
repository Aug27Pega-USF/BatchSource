package proj.banking.user;

import org.junit.Ignore;
import org.junit.Test;

import proj.banking.BankMain;
import proj.banking.user.bean.UserAccountInfo;

public abstract class UserAccount {
	protected UserAccountInfo accountInfo;
	BankMain bankService;
	
	public abstract void userPage();
	abstract UserAccount loggingIn();
	abstract void selectionMenu();
	abstract void selection();
	abstract UserAccount logout();
	public UserAccount(){
		bankService = BankMain.getInstance(null);
	}
	
	protected void headerPage() {
		System.out.println("================================================");
		System.out.println("=                    WELCOME                   =");
		System.out.println("=----------------------------------------------=");
		System.out.println("=          IQ Finanical Mobile Bank            =");
		System.out.println("=                   est. 2018                  =");
		System.out.println("================================================");
	}
	
	protected void bottomSelectMenu() {
		System.out.println("================================================");
		System.out.print(" Selection: ");
	}
	
	public UserAccount login(String userID, String password) throws Exception {
		accountInfo = bankService.login(userID, password);
		if(accountInfo == null) {
			return null;
		} else {
			return loggingIn();
		}
	}
	public UserAccountInfo getAccountInfo() {
		return accountInfo;
	}
}
