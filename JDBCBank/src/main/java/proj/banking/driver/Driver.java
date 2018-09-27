package proj.banking.driver;

import java.util.Scanner;

import proj.banking.BankMain;
import proj.banking.user.Login;
import proj.banking.user.UserAccount;
import proj.banking.utils.DB_ConnectionFactory;
import proj.banking.utils.Enums.NewUser;

public class Driver {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BankMain.getInstance();
		DB_ConnectionFactory.getInstance();
		Integer selection;
		UserAccount userAcc = null;
		String userID = "", password = "";
		
		do {
			welcomeMenu();
			selection = scan.nextInt();
			if(selection >= 1 && selection <= 4) {
				loginMenu(selection);
				switch(selection) {
					case 1:
					case 2:
					case 3:
						System.out.print("Login: ");
						userID = scan.next();
						System.out.print("Password: ");
						password = scan.next();
						break;
					case 4:
						System.out.print("Register a login: ");
						userID = scan.next();
						System.out.print("Register a password: ");
						password = scan.next();
						break;
				}
				userAcc = requestLogin(selection, userID, password);
				if(userAcc == null) {
					System.out.println("\tLogin/password invalid");
				}
			}
			userID = password = "";
			if(selection == 0) {
				System.out.println("================================================");
				System.out.println("\tThank you for banking with us");
			} else if(userAcc == null && selection != 4) {
				System.out.println("================================================");
				System.out.println("\tInvalid login information");
			}
			if(userAcc != null) {
				while(userAcc.userAccInfo != null) {
					userAcc.userPage();
				}
				userAcc = null;
			}
		}while(selection >= 1 && selection <= 4);
		scan.close();
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
		System.out.print(" Selection: ");
	}
	
	static void loginMenu(Integer selection) {
		System.out.println("\n================================================");
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
			return new Login().checkLogin(1, userID, password);
		case 2:
			return new Login().checkLogin(2, userID, password);
		case 3:
			return new Login().checkLogin(3, userID, password);
		case 4:
			if((new Login().registerUserLogin(userID, password)) == NewUser.SUCCESS) {
				System.out.println("Login was successfully created");
			} else {
				System.out.println("Error creating new login");
			}
			return null;
		default:
			return null;
		}
	}
}
