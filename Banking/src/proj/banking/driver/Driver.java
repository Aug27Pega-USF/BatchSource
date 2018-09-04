package proj.banking.driver;

import java.util.Scanner;

import proj.banking.BankMain;
import proj.banking.user.CustomerAccount;
import proj.banking.user.EmployeeAccount;
import proj.banking.user.UserAccount;
import proj.banking.user.UserLogin;
import proj.banking.utils.DataFiles;

public class Driver {
	private final static String transactionFile = "mockData/transaction.txt";
	private final static String userFile = "mockData/userLogin.txt";
	private final static String userInfoFile = "mockData/userInformation.txt";
	private final static String bankAccountFile = "mockData/bankAccountList.txt";
	private static final String approvalList = "mockData/awaitingApproval.txt";
	
	private static DataFiles fileData = new DataFiles(transactionFile, userFile, userInfoFile, bankAccountFile);
	static BankMain bank = BankMain.getInstance(fileData);;
	static UserLogin userService = UserLogin.getInstance(fileData.getUserFile(), fileData.getUserInfoFile());
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Integer selection;
		UserAccount userAcc = null;
		
		boolean loggedIn;
		do {
			welcomeMenu();
			selection = scan.nextInt();
			if(selection >= 1 && selection <= 3) {
				String userID = "", password = "";
				do {
					loginMenu(selection);
					System.out.print("Login: ");
					userID = scan.next();
					System.out.print("Password: ");
					password = scan.next();
					userAcc = requestLogin(selection, userID, password);
					if(userAcc != null) {
						userID = "";
						password = "";
						while(userAcc.getAccountInfo() != null) {
							userAcc.userPage();
						}
						userAcc = null;
						break;
					}
				} while (userID.charAt(0) != '0' && password.charAt(0) != '0');
			}
		}while(selection >= 1 && selection <= 3);
	}
	
	static void welcomeMenu() {
		System.out.println("================================================");
		System.out.println("=                    WELCOME                   =");
		System.out.println("================================================");
		System.out.println("- Please choose your login                     -");
		System.out.println("------------------------------------------------");
		System.out.println("-  1. Customer                                 -");
		System.out.println("-  2. Employee                                 -");
		System.out.println("-  3. Admin                                    -");
		System.out.println("-  4. Register                                 -");
		System.out.println("-  0. Exit                                     -");
		System.out.println("================================================");
	}
	
	static void loginMenu(Integer selection) {
		System.out.println("================================================");
		switch(selection) {
		case 1:
			System.out.println("=  Customer Login                              =");
			break;
		case 2:
			System.out.println("=  Employee Login                              =");
			break;
		case 3:
			System.out.println("=  Admin Login                                 =");
			break;
		case 4:
			System.out.println("=  Customer Registration                       =");
			break;
		default:
			break;
		}
		System.out.println("================================================");
	}
	
	static UserAccount requestLogin(Integer selection, String userID, String password) throws Exception {
		switch(selection) {
		case 1:
			return new CustomerAccount().login(userID, password);
		case 2:
			return new EmployeeAccount().login(userID, password);
		case 3:
			return null;
		case 4:
			return null;
		default:
			return null;
		}
	}
}
