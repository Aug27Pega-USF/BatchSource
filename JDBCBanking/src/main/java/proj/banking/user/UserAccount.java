package proj.banking.user;

import java.sql.SQLException;
import java.util.Scanner;

import proj.banking.BankMain;
import proj.banking.bean.UserAccountInfo;
import proj.banking.utils.Enums.NewUser;

public abstract class UserAccount {
	protected UserAccountInfo userAccInfo;
	public BankMain bankService; //to be removed
	protected int accountLevel;
	
	public abstract void userPage();
	abstract UserAccount loggingIn();
	abstract void selectionMenu();
	abstract void logout();
	
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
		int userAccNum = BankMain.getInstance().login(accountLevel, userID, password);
		if(userAccNum > 0) {
			userAccInfo = BankMain.getInstance().getUserInfo(userAccNum);
		} else {
			return null;
		}
		bankService = BankMain.getInstance();
		return loggingIn();
	}
	public NewUser registerUserLogin(String userID, String userPassword){
		return registerUserLogin(userID, userPassword, 1);
	}
	
	NewUser registerUserLogin(String userID, String userPassword, int userLevel){
		UserAccountInfo newUser = new UserAccountInfo();
		setNewUserInfo(newUser, 1);
		setNewUserInfo(newUser, 2);
		setNewUserInfo(newUser, 3);
		setNewUserInfo(newUser, 4);
		setNewUserInfo(newUser, 5);
		setNewUserInfo(newUser, 6);
		setNewUserInfo(newUser, 7);
		setNewUserInfo(newUser, 8);
		
		try {
			return BankMain.getInstance().createUserID(0, userID, userPassword, newUser, userLevel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NewUser.FAILED;
	}
	
	public void setNewUserInfo(UserAccountInfo userInfo, int selection) {
		Scanner scan = new Scanner(System.in);
		switch(selection) {
		case 1:
			System.out.print("Enter your first name: ");
			userInfo.setFirstName(scan.nextLine());
			break;
		case 2:
			System.out.print("Enter your last name: ");
			userInfo.setLastName(scan.nextLine());
			break;
		case 3:
			System.out.print("Enter your e-mail address: ");
			userInfo.setEmail(scan.nextLine());
			break;
		case 4:
			System.out.print("Enter your date of birth (YYYY-MM-DD): ");
			userInfo.setDob(scan.nextLine());
			break;
		case 5:
			System.out.print("Enter your phone number: ");
			userInfo.setPhone(scan.nextLine());
			break;
		case 6:
			System.out.print("Enter your street address: ");
			userInfo.setStreetAddress(scan.nextLine());
			break;
		case 7:
			System.out.print("Enter the State for the address: ");
			userInfo.setState(scan.nextLine());
			break;
		case 8:
			System.out.print("Enter the zip code for your address: ");
			userInfo.setZip(scan.nextLine());
			break;
		}
	}
	
	public UserAccountInfo getAccountInfo() {
		return userAccInfo;
	}
}
