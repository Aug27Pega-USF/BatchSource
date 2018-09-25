
/*
	 * =====MENU:=====
	 * 1-LOGIN
	 * 2-REGIGISTER
	 * 3-CHECK BALANCE
	 * 4-DEPOSIT
	 * 5-WITHDRAWAL
	 * 6-EXI/LOGOUT
	 */
package com.revature.runtime;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Admin;
import com.revature.beans.Bank_Account;
import com.revature.beans.Deposit;
import com.revature.beans.User_Info;
import com.revature.dao.User_Info_Dao;
import com.revature.daoImpl.Admin_DAOImpl;
import com.revature.daoImpl.Bank_Account_DAOImpl;
import com.revature.daoImpl.User_Info_DAOImpl;
import com.revature.util.ConnFactory;
//import org.mindrot.jbcrypt.BCrypt;

public class Front {
	
	private User_Info usd;
	public boolean isAuthenticated;
	
	
	
	public Front() {}
	
	
	public Front(User_Info usd, boolean isAuthenticated) {
		super();
		this.usd = usd;
		isAuthenticated = false;
	}
	
	public void display() {
		Scanner sca = new Scanner(System.in);
		System.out.println("Enter your username");
		String username=sca.nextLine();
		System.out.println("Enter your password");
		String password = sca.nextLine();
		int selection = displayMenu();
		if(selection == 0) {
			try {
				loginAdmin(username);
			} catch (AdmAuthenticationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
		{
			try {
				checkLogin(username);
			} catch (AuthenticationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

										
											/* WELCOME SCREEN FOR USERS */
	public int displayMenu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("|********************************|");
		System.out.println("|           Welcome              |");
		System.out.println("|********************************|");
		System.out.println("|        0- Admin login          |");
		System.out.println("|        1- Users Login          |");
		System.out.println("|********************************|");
		int screeninput = sc.nextInt();
		
		return screeninput;
		
		}
		
		
		
													/* USERS   UI */
	 User_Info checkLogin(String username) throws AuthenticationException, SQLException 
     {
		 
  	   User_Info_DAOImpl usidi = new User_Info_DAOImpl();
       User_Info user = usidi.getUserByUsername(username);
       
		  if(user != null){
				//logged success message
				System.out.println("login success");
				// direct user to menu choice
				performTransaction();
				return user;
		}else {
			//logged error message
			System.out.println("Unable to log you in Please register");
			registerUser();
			throw new AuthenticationException();
			//prompt user to register	
		}
    
     }//creating user
	public void registerUser() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username");
		String uname=scan.nextLine();
		System.out.println("Enter your password");
		String pwd = scan.nextLine();
		System.out.println("Enter your  first name");
		String fN=scan.nextLine();
		System.out.println("Enter your last name");
		String lN = scan.nextLine();
		
		User_Info_DAOImpl usidi = new User_Info_DAOImpl();
		try {
			usidi.createUser(uname, pwd, fN, lN);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int UsersOption(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("|********************************|");
		System.out.println("|what would you like to do today |");
		System.out.println("|********************************|");
		System.out.println("|     1- View Balance            |");
		System.out.println("|     2- Make a Deposit          |");
		System.out.println("|     3- Make a Withdrawal       |");
		System.out.println("|     4- Create a Bank Account   |");
		System.out.println("|     5- Delete a Bank Account   |");
		System.out.println("|     6- Logout                  |");
		System.out.println("|********************************|");

		int userinput = sc.nextInt();
		
		return userinput;
	}
	
	public void createMyAccount() {
		System.out.println("Fill in to create an account");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your account number");
		int anum=scan.nextInt();
		System.out.println("what is your user ID");
		int uid = scan.nextInt();
		System.out.println("Enter your initial saving balance");
		double savi=scan.nextDouble();
		System.out.println("Enter your initial checking balance");
		double check = scan.nextDouble();
		
		Bank_Account_DAOImpl badi = new Bank_Account_DAOImpl();
		try {
			badi.createAccount(anum, uid, savi, check);
			System.out.print(" " +badi.getBank_AccountList());
			System.out.println();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void viewBank_Account() {
		Bank_Account_DAOImpl bada = new Bank_Account_DAOImpl();
		try {
			System.out.println(" " +bada.getBank_AccountList());
			System.out.println("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void performTransaction() {
		
		boolean isExited = false;
		
		while(!isExited) {
			int selection = UsersOption();

		switch(selection) {
		case 1:
			viewBank_Account();
		break;
		case 2:
			try {
				Deposit.performDeposit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		break;
		case 3:
			//makeWithdrawal();
		break;
		case 4:
			createMyAccount();
		break;
		case 5:
			removeBankAccount();
		break;
		case 6: 
			isExited = true;
			System.out.println("Thank you");
		break;
		default:
			System.out.println("not an option");
		break;
		}
		}
	}
	
	public void removeBankAccount() {
	Bank_Account_DAOImpl bak = new Bank_Account_DAOImpl();
	Scanner sc = new Scanner(System.in);
	System.out.println("account to delete?");
	int id = sc.nextInt();
	try {
		bak.removeBank_Account(id);
		System.out.println( " account after deletion:");
		System.out.print( " " +bak.getBank_AccountList());
	} catch (SQLException e) {
		e.printStackTrace();
	}
}	
	
	
													/* ADMIN UI */
	
	 Admin loginAdmin(String username) throws AdmAuthenticationException, SQLException {
		 Admin_DAOImpl adi = new Admin_DAOImpl();
		 Admin admin = adi.getAdminByUsername(username);
		 if(admin != null) {
			// AdminOptions();
			 manageUsers();
			 return admin;
		 }else {
			 System.out.println("you have entered wrond username");
			 registerAdmin();
			 throw new AdmAuthenticationException();
		 }
	 }
	
	// creating admin
public void registerAdmin() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username");
		String auname=scan.nextLine();
		System.out.println("Enter your password");
		String apwd = scan.nextLine();
		System.out.println("Enter your  first name");
		String afN=scan.nextLine();
		
		
		Admin_DAOImpl aidi = new Admin_DAOImpl();
		try {
			aidi.createAdmin(auname, apwd, afN);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public int  AdminOptions() {
	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	System.out.println("|***************************************|");
	System.out.println("|Admin, what would you like to do today |");
	System.out.println("|***************************************|");
	System.out.println("|         1- view all users             |");
	System.out.println("|         2- register a user            |");
	System.out.println("|         3- update a user              |");
	System.out.println("|         4- remove a user              |");
	System.out.println("|         5- exit                       |");
	System.out.println("|***************************************|");

	int admininput = scan.nextInt();
	
	return admininput; 
}

public void manageUsers() {
	
	boolean isExited = false;
	
	while(!isExited) {
		int selection = AdminOptions();

	switch(selection) {
	
	case 1:
		viewUsers();
	break;
	case 2:
		registerUser();
	break;
	case 3:
		updateUser();
	break;
	case 4:
		removeUser();
	break;
	case 5: 
		isExited = true;
		System.out.println("Thank you");
	break;
	default:
		System.out.println("not an option");
	break;
	}
	}
}

public void viewUsers() {
	User_Info_DAOImpl use = new User_Info_DAOImpl();
	try {
		System.out.print( " " +use.getUser_InfoList() );
		System.out.println("");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

//registerUser as above

public void updateUser() { //not working so far
	User_Info_DAOImpl use = new User_Info_DAOImpl();
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the user id");
	int id = sc.nextInt();
	
	System.out.println("update your username or reenter it");
	String username = sc.nextLine();

	System.out.println("update your password or reenter it");
	String password = sc.nextLine();
	
	System.out.println("update your firstname or reenter it");
	String firstname = sc.nextLine();
	
	System.out.println("update your lastname or reenter it");
	String lastname = sc.nextLine();
			
	try {
		use.updateUser_Info(id,username,password,firstname,lastname);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void removeUser() {
	User_Info_DAOImpl use = new User_Info_DAOImpl();
	Scanner sc = new Scanner(System.in);
	System.out.println("user to delete?");
	int id = sc.nextInt();
	try {
		use.removeUser_Info(id);
		System.out.println( " users after deletion:");
		System.out.print( " " +use.getUser_InfoList());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
