package JDBCBank.Banking;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import JDBCBank.Banking.accounts.Account;
import JDBCBank.Banking.accounts.Users;
import JDBCBank.Banking.impl.AccountImpl;
import JDBCBank.Banking.impl.UserImpl;


public class Driver 
{
    public static void main( String[] args )
    {
    	//open input stream
		Scanner scan = new Scanner(System.in);
		//taking in input for menu selections
		String option = "";
		
		//state control
		boolean quit = false;
		MenuStates menuState = MenuStates.MAIN_MENU;

		String user_entered = "";
		int current_user_id = 0;
		
		int acc_dbid = 0;
		int acc_index = 0;
		
		boolean is_admin = false;
		
		//admin info
		Properties p = new Properties();
		String admin_info ="";
		String admin_password = "";
		
		//load our file
		try {
			p.load(new FileReader("Database.properties"));
			admin_info = p.getProperty("admin_name");
			admin_password = p.getProperty("admin_password");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//SQL command objects
		UserImpl u = new UserImpl();
		AccountImpl a = new AccountImpl();
		
		//data for our objects
		ArrayList<Users> usersList = new ArrayList<Users>();
		ArrayList<Account> accountsList = new ArrayList<Account>();
		
		//load in data from the server
		try {
			//u.create("test1", "123", "zach", "rudolph");
			//u.delete(2);
			System.out.println("*Loading...*");
			usersList = u.read();
			accountsList = a.read();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		/*
		 * MAIN PROGRAM
		 */
		System.out.println("Welcome to the Revature Banking App!");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		
		while(!quit) {
				
			switch(menuState) {
				
				/*
				 * 
				 */
				//log in or exit
				case MAIN_MENU:
					
					System.out.println();
					System.out.println("How can we help you today?");
					//get selection from user
					option = Functions.GetMenuSelection(scan, "Log In", "Quit");
					
					switch (option) {
						case "Log In":
							menuState = MenuStates.LOGIN;
							break;
						case "Quit":
							quit = true;
							break;
					}
					break;
					
				/*
				 * 
				 */
				//type in name
				//ask to register if not found
				//go to entering a password
				case LOGIN:
					
					//get the login name from the user
					System.out.print("Type in your login name: ");
					user_entered = scan.next();
					System.out.println();
					
					//keep track if they're logging in as admin
					if(user_entered.equals(admin_info))
						is_admin = true;
					else {
						is_admin = false;
						//return the id number of the username entered
						current_user_id = CheckUserName(usersList, user_entered);
					}
					
					//TESTING
					System.out.println("User Id: " + current_user_id);
					
					//existing account
					if(is_admin || current_user_id != 0)
						menuState = MenuStates.PASSWORD;
					//new user
					else
						menuState = MenuStates.NEW_USER_MENU;
					break;
					
				/*
				 * 
				 */
				//check for the password
				//take them to the corresponding menu
				case PASSWORD:
					
					//get password now
					System.out.print("Type in password for account \"" + user_entered + "\": ");
					user_entered = scan.next();
					System.out.println();
					
					//account was admin
					if(is_admin) {
						//correct password
						if(user_entered.equals(admin_password)) {
							System.out.println("Password Correct! Welcome!");
							System.out.println("-------------------------");
							menuState = MenuStates.ADMIN_MENU;
						}
						//incorrect
						else {
							System.out.println("Password Incorrect!");
							System.out.println("-------------------------");
							menuState = MenuStates.MAIN_MENU;
						}
					}
					
					//user account
					else {
						//password is correct
						if(CheckPassword(usersList, current_user_id, user_entered)) {
							System.out.println("Password Correct! Welcome!");
							System.out.println("-------------------------");
							menuState = MenuStates.USER_MENU;
						}
						//password is incorrect
						else {
							System.out.println("Password Incorrect!");
							System.out.println("-------------------------");
							menuState = MenuStates.MAIN_MENU;
						}
					}
							
					break;
					
				/*
				 * 
				 */
				//setting a password for the new username
				case NEW_USER_MENU:
					System.out.println("The username \"" + user_entered + "\" does not exist.");
					System.out.println("Would you like to create an account for this username?");
					
					//get selection from user
					option = Functions.GetMenuSelection(scan, "Create Account", "Return To Menu");
					
					switch (option) {
						//ask for password
						case "Create Account":
							
							//enter it once
							System.out.print("Enter password please: ");
							String password_entered = scan.next();
							System.out.println();
							
							//enter it again
							System.out.print("Verify password please: ");
							String password_verified = scan.next();
							System.out.println();
							
							//verify that it matches
							if(password_entered.equals(password_verified)) {

								System.out.println("-------------------------");
								System.out.println("Password verified.");
								System.out.print("Please enter your first name: ");
								String first_name = scan.next();
								
								System.out.println();
								System.out.print("Please enter your last name: ");
								String last_name = scan.next();
								System.out.println();
								
								current_user_id = JDBCBank.Banking.accounts.Users.AddNewUsers(scan, user_entered, password_entered, first_name, last_name, u, usersList);

								System.out.println("The username \"" + user_entered + "\" has been created! Welcome!");
								System.out.println("-------------------------");
								menuState = MenuStates.USER_MENU;
							}
							else {
								
								System.out.println("Passwords do not match!");
								System.out.println("-------------------------");
							}
							
							break;
							
						//go back to menu
						case "Return To Menu":
							menuState = MenuStates.MAIN_MENU;
							break;
					}
					break;
				
					
				//menu for user
				//view existing accounts and their balances
				//can create a new account
				//delete an account if empty
				//can deposit/withdraw from an account
				//log out
				case USER_MENU:
					
					System.out.println("(USER MENU)");
					System.out.println("-------------------------");
					System.out.println();
					
					//get selection from user
					option = Functions.GetMenuSelection(scan, "View Accounts", "Create New Account", "Deposit Funds", "Withdraw Funds", "Delete Account", "Return To Menu");
					
					System.out.println("-------------------------");
					System.out.println();
					
					switch(option) {
					
						case "View Accounts":
							ViewAccounts(accountsList, current_user_id);
							break;
							
						case "Create New Account":
							//get name of account
							System.out.print("Type a name for the new Account: ");
							String account_name = scan.next();
							System.out.println();
							
							//check if the account already exists
							if (CheckAccountNameExists( accountsList, account_name, current_user_id ) ) {
								System.out.print("Sorry, but you already have an account called '" + account_name + "'");
								System.out.println();
							}
							//add account to DB,
							//add account to list
							else {
								JDBCBank.Banking.accounts.Account.AddNewAccount(scan, account_name, current_user_id, a, accountsList);
							}
							break;
							
						case "Deposit Funds":

							System.out.println("-Select account to deposit into-");
							//pick an account - get the account_id
							//need this for the database
							acc_dbid = AccountMenu(scan, accountsList, current_user_id);
							
							if(acc_dbid != -1){
								//then use it to get the index by ref
								//need this for the arraylist
								acc_index = GetAccountIndexById(accountsList, acc_dbid);
								
								JDBCBank.Banking.accounts.Account.DepositIntoAccount(scan, acc_dbid, acc_index, a, accountsList, current_user_id);
							}
							break;
							
						case "Withdraw Funds":

							System.out.println("-Select account to withdraw from-");
							//pick an account - get the account_id
							//need this for the database
							acc_dbid = AccountMenu(scan, accountsList, current_user_id);
							
							if(acc_dbid != -1){
								//then use it to get the index by ref
								//need this for the arraylist
								acc_index = GetAccountIndexById(accountsList, acc_dbid);
								
								JDBCBank.Banking.accounts.Account.withdrawFromAccount(scan, acc_dbid, acc_index, a, accountsList, current_user_id);
							}	
							break;
							
						case "Delete Account":

							System.out.println("-Select account to remove-");
							System.out.println("*Must Have A Balance Of $0*");
							//pick an account - get the account_id
							//need this for the database
							acc_dbid = AccountMenu(scan, accountsList, current_user_id);
							
							if(acc_dbid != -1){
								//then use it to get the index by ref
								//need this for the arraylist
								acc_index = GetAccountIndexById(accountsList, acc_dbid);
								
								JDBCBank.Banking.accounts.Account.deleteAccount(acc_dbid, acc_index, a, accountsList, current_user_id);
							}	
							
							break;
							
						//go back to menu
						case "Return To Menu":
							menuState = MenuStates.MAIN_MENU;
							break;
					}
					
					break;
				
				//menu for admin
				//view all user accounts
				//creating a user
				//updating a user account
				//deleting a user account
				case ADMIN_MENU:
					System.out.println("(ADMIN MENU)");
					System.out.println("-------------------------");
					System.out.println();
					
					//get selection from user
					option = Functions.GetMenuSelection(scan, "View All Users", "View All Accounts", "Create New User", "Update User", "Delete User", "Return To Menu");
					
					System.out.println("-------------------------");
					System.out.println();
					
					switch(option) {
					
						case "View All Users":
							ViewAllUsers(usersList);
							break;
					
						case "View All Accounts":
							ViewAccounts(accountsList);
							break;

						case "Create New User":
							//set user name
							System.out.print("Type in the new username: ");
							user_entered = scan.next();
							System.out.println();
							
							//check that the name doesn't already exist
							if(CheckUserName(usersList, user_entered) == 0) {
								
								//set their password
								System.out.print("Type in their password: ");
								String pw = scan.next();
								System.out.println();
								
								//set their first name
								System.out.print("Type in their first name: ");
								String fn = scan.next();
								System.out.println();
								
								//set their last name
								System.out.print("Type in their last name: ");
								String ln = scan.next();
								System.out.println();
								
								//create account
								JDBCBank.Banking.accounts.Users.AddNewUsers(scan, user_entered, pw, fn, ln, u, usersList);
								System.out.println("-------------------------");
							}
							else 
								System.out.print("User account \"" + user_entered + "\" already exists.");
							
							break;
						
							
						case "Update User":
							
							//select user to update
							System.out.println("-Select user to update-");
							
							//pick an account - get the account_id
							//need this for the database
							acc_dbid = UserMenu(scan, usersList);
							
							if(acc_dbid != -1){
								//then use it to get the index by ref
								//need this for the arraylist
								acc_index = GetUserIndexById(usersList, acc_dbid);
								
								//get username
								String user_name = usersList.get(acc_index).getUsername();
								System.out.println("Editing Info for user \"" + user_name + "\"");
								
								//edit their first name
								System.out.println("First name = \"" + usersList.get(acc_index).getFirstname() + "\"");
								System.out.print("Type in their new first name: ");
								String fn = scan.next();
								System.out.println();
								
								//edit their last name
								System.out.println("Last name = \"" + usersList.get(acc_index).getLastname() + "\"");
								System.out.print("Type in their new last name: ");
								String ln = scan.next();
								System.out.println();
								
								JDBCBank.Banking.accounts.Users.updateUser(acc_dbid, acc_index, u, usersList, fn, ln);
							}
								
							break;
							
							
						case "Delete User":
							
							System.out.println("-Select user to remove-");
							System.out.println("*This will remove all their accounts*");
							//pick an account - get the account_id
							//need this for the database
							acc_dbid = UserMenu(scan, usersList);
							
							if(acc_dbid != -1){
								//then use it to get the index by ref
								//need this for the arraylist
								acc_index = GetUserIndexById(usersList, acc_dbid);
								
								JDBCBank.Banking.accounts.Users.deleteUser(acc_dbid, acc_index, u, usersList, accountsList);
							}
							break;
							
							
						//go back to menu
						case "Return To Menu":
							menuState = MenuStates.MAIN_MENU;
							break;
					}
					break;
			}
		}
		
		System.out.println();
		System.out.println("Thank you for using the Revature Banking App");
		System.out.println("Good bye!");
    }
    
    /*
     * METHODS
     */
    public static int CheckUserName(ArrayList<Users> usersList, String user_entered) {
		for(int i = 0; i < usersList.size(); i++) {
			//if name matches an entry
			if(usersList.get(i).getUsername().equals(user_entered)) {
				return usersList.get(i).getId();
			}
		}
		//no user found, return this
		return 0;
    }
    
    public static boolean CheckPassword(ArrayList<Users> usersList, int current_user_id, String user_entered) {
		//if the password matches
		if(usersList.get(current_user_id).getPassword().equals(user_entered)) 
			return true;
		else
			return false;
    }
    
    public static boolean CheckAccountNameExists(ArrayList<Account> accountList, String name_entered, int current_user_id) {
		for(int i = 0; i < accountList.size(); i++) {
			//if the account is tied to the user
			if(accountList.get(i).getUser_id() == current_user_id) {
				if(accountList.get(i).getName() == name_entered) 
					return true;				
			}
		}
		//no account found, return this
		return false;
    }
    
    public static void ViewAccounts(ArrayList<Account> accountsList, int current_user_id) {
    	
    	System.out.println("---------------------------------");
    	System.out.println("Accounts owned by you: ");
    	
    	for(int i = 0; i < accountsList.size(); i++) {
    		//if the account is part of our user 
    		//display their balance and name
    		if(accountsList.get(i).getUser_id() == current_user_id) {
    			System.out.println("	-" + accountsList.get(i).getName() + ", Balance: $" + accountsList.get(i).getBalance());
    		}
    	}
    	System.out.println("---------------------------------");
    }
    
	//admin version
	public static void ViewAccounts(ArrayList<Account> accountsList) {
	    	
    	System.out.println("---------------------------------");
    	System.out.println("All Accounts: ");
    	System.out.println();
    	
    	for (Account a: accountsList) {
    		System.out.println(a);
    	}
    	
    	System.out.println("---------------------------------");
    }
	
	//admin command
	public static void ViewAllUsers(ArrayList<Users> usersList) {
    	
    	System.out.println("---------------------------------");
    	System.out.println("All Users: ");
    	System.out.println();
    	
    	for (Users u: usersList) {
    		System.out.println(u);
    	}
    	
    	System.out.println("---------------------------------");
    }
    
    public static int AccountMenu(Scanner scan, ArrayList<Account> accountsList, int current_user_id) {
    	//prepping for a menu
		ArrayList<String> accountMenuName = new ArrayList<String>();
		ArrayList<Integer> accountMenuID = new ArrayList<Integer>();
		ArrayList<Integer> accountMenuBalance = new ArrayList<Integer>();
		
		//get all accounts tied to this user and their current balance
		for(int i = 0; i < accountsList.size(); i++) {
			//if the account is tied to the user
			if(accountsList.get(i).getUser_id() == current_user_id) {
				//add their name and ids to an array for the menu
				accountMenuName.add(accountsList.get(i).getName());
				accountMenuID.add(accountsList.get(i).getAccount_id());
				accountMenuBalance.add(accountsList.get(i).getBalance());
			}
		}
		
		return Functions.GetAccountSelection(scan, accountMenuName, accountMenuID, accountMenuBalance);
    }
    
    //admin version
    public static int UserMenu(Scanner scan, ArrayList<Users> usersList) {
    	//prepping for a menu
		ArrayList<String> userMenuName = new ArrayList<String>();
		ArrayList<Integer> userMenuID = new ArrayList<Integer>();

		//get all accounts tied to this user and their current balance
		for(int i = 0; i < usersList.size(); i++) {
			//add their name and ids to an array for the menu
			userMenuName.add(usersList.get(i).getUsername());
			userMenuID.add(usersList.get(i).getId());
		}
		
		return Functions.GetUserSelection(scan, userMenuName, userMenuID);
    }
    
    
    public static int GetAccountIndexById(ArrayList<Account> accountsList, int acc_dbid) {
    	//loop until we get the database id
    	for(int i = 0; i < accountsList.size(); i++) {
    		if(accountsList.get(i).getAccount_id() == acc_dbid) {
    			//return the index
				return i;
			}
    		
    	}
    	//uh oh spaghettios
    	return -1;
    }
    
    //admin
    public static int GetUserIndexById(ArrayList<Users> usersList, int use_dbid) {
    	//loop until we get the database id
    	for(int i = 0; i < usersList.size(); i++) {
    		if(usersList.get(i).getId() == use_dbid) {
    			//return the index
				return i;
			}
    		
    	}
    	//uh oh spaghettios
    	return -1;
    }
}


