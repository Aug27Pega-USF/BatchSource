package com.PrestonL.sqlBank;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daoimpl.*;


public class Driver {
	private static final Logger LOGGER = LogManager.getLogger(Driver.class.getName());
	enum MENU_STATE {
		BASIC ,ADMIN, CUSTOMER, LOGIN, REGISTER, ADMINCREATE, ADMINUPDATE, ADMINDELETE,
		CUSTOMERCREATE, CUSTOMERDELETE, DEPOSIT, WITHDRAW;
	}
	
	static Scanner scanner;
	
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		AccountDAOImpl acdi = new AccountDAOImpl();
		AdminDAOImpl adi = new AdminDAOImpl();
		CustomerDAOImpl cdi= new CustomerDAOImpl();
		MENU_STATE menu_check = MENU_STATE.BASIC;
		boolean check=false;
		int current_user=0;
		
		while(true) {
		if(menu_check==MENU_STATE.BASIC) {
		do {
			System.out.println("\nWelcome to SQL BANK");
			System.out.println("1. Login\n2. Register\n3. Exit");
			if (scanner.hasNextLine()) {
				switch (scanner.nextLine()) {
				case "1":
					menu_check=MENU_STATE.LOGIN;
					check=true;
					break;
				case "2":
					menu_check=MENU_STATE.REGISTER;
					check=true;
					break;
				case "3":
					System.out.println("Exiting. Good Bye.");
					System.exit(0);
					break;
				default:
					System.out.println("Please input the number.");
				}
			}
		} while (!check);
		}
		
		if(menu_check==MENU_STATE.LOGIN) {
			String username="";
			String password="";
			check=false;
			do {
				System.out.println("Username:");
				if (scanner.hasNextLine()) {
					switch (username = scanner.nextLine()) {
					case "":
					case "\n":
						break;
					default:
						check = true;
					}
				}
			} while (!check);
			check = false;
			do {
				System.out.println("Password:");
				if (scanner.hasNextLine()) {
					switch (password = scanner.nextLine()) {
					case "":
					case "\n":
						break;
					default:
						check = true;
					}
				}
			} while (!check);
			try {
				current_user= cdi.login(username, password);
			} catch (SQLException e) {
			}
			if (current_user==0) {
				System.out.println("Login failed.");
				menu_check=MENU_STATE.BASIC;
			}
			else if (current_user==1){ /*cheating a little*/
				System.out.println("Welcome Admin " + username + ".");
				menu_check=MENU_STATE.ADMIN;
			}
			else {
				System.out.println("Welcome Customer " + username + ".");
				menu_check=MENU_STATE.CUSTOMER;
			}
		}
			
		if(menu_check==MENU_STATE.REGISTER) {
			String registerusername = "";
			String registerpassword = "";
			check=false;
			System.out.println("Welcome new customer.");
			do {
				System.out.println("Input Username. It must be between 5-15 alphanumeric characters and start with a letter:");
				if (scanner.hasNextLine()) {
					registerusername = scanner.nextLine();
					if (registerusername.matches("(?=.{5,15}$)[a-zA-Z][a-zA-Z\\d]*")) {
						check=true;
						}
						else {
							System.out.println("Not a valid username.");
						}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid username.");
				}

			} while (!check);
			check = false;
			System.out.println("Please input desired password. It must be between 8 and 32 characters long.");
			do {
				System.out.println("Input password:");
				if (scanner.hasNextLine()) {
					registerpassword = scanner.nextLine();
					if (registerpassword.matches("(?=.{8,32}$).*")) {
						check=true;
						}
						else {
							System.out.println("Not a valid password.");
						}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid password.");
				}
				if (check) {
					System.out.println("Type in password again:");
					if (scanner.hasNextLine()) {
						if (registerpassword == scanner.nextLine()) {
							check = true;
						}
					} else {
						scanner.nextLine();
						check = false;
						System.out.println("Passwords didn't match.");
					}
				}

			} while (!check);
			try {
				cdi.registerAccount(registerusername, registerpassword);
			} catch (SQLException e) {
			}
			System.out.println("Registration complete! Please login.");
			menu_check=MENU_STATE.BASIC;
		}	
		
		if(menu_check==MENU_STATE.ADMIN) {
			check=false;
			do {
			System.out.println("\n1. View All Users\n2. Create User\n3. Update User\n4. Delete User\n5. Logout");
			if (scanner.hasNextLine()) {
				switch (scanner.nextLine()) {
				case "1":
					try {
						adi.viewUsers();
					} catch (SQLException e) {
					}
					break;
				case "2":
					menu_check=MENU_STATE.ADMINCREATE; //done
					check=true;
					break;
				case "3":
					menu_check=MENU_STATE.ADMINUPDATE; //done
					check=true;
					break;
				case "4":
					menu_check=MENU_STATE.ADMINDELETE; //done
					check=true;
					break;
				case "5":
					menu_check=MENU_STATE.BASIC;
					System.out.println("Logging out.");
					check=true;
					break;
				default:
					System.out.println("Please input the number.");
					}
				}
			}while(!check);	
		}
		
		if(menu_check==MENU_STATE.CUSTOMER) {
			check=false;
			do {
			System.out.println("\n1. View All Accounts\n2. Create Account\n3. Deposit\n4. Withdraw\n5. Delete Account\n6. View Transaction History\n7. Logout");
			if (scanner.hasNextLine()) {
				switch (scanner.nextLine()) {
				case "1":
					try {
						cdi.listAccounts(current_user);
					} catch (SQLException e) {
					}
					break;
				case "2":
					menu_check=MENU_STATE.CUSTOMERCREATE; //done
					check=true;
					break;
				case "3":
					menu_check=MENU_STATE.DEPOSIT; //done
					check=true;
					break;
				case "4":
					menu_check=MENU_STATE.WITHDRAW; //done
					check=true;
					break;
				case "5":
					menu_check=MENU_STATE.CUSTOMERDELETE; //done
					check=true;
					break;
				case "6":
					try {
						cdi.viewTransactionHistory(current_user);
					} catch (SQLException e) {
					}
					break;
				case "7":
					menu_check=MENU_STATE.BASIC;
					System.out.println("Logging out.");
					check=true;
					break;
				default:
					System.out.println("Please input the number.");
					}
				}
			}while(!check);	
		}
		if (menu_check==MENU_STATE.ADMINCREATE) {
			String newusername = "";
			String newpassword = "";
			check=false;
			do {
				System.out.println("Input Username. It must be between 5-15 alphanumeric characters and start with a letter:");
				if (scanner.hasNextLine()) {
					newusername = scanner.nextLine();
					if (newusername.matches("(?=.{5,15}$)[a-zA-Z][a-zA-Z\\d]*")) {
						check=true;
						}
						else {
							System.out.println("Not a valid username.");
						}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid username.");
				}

			} while (!check);
			check = false;
			System.out.println("Input updated Password. It must be between 8 and 32 characters long.");
			do {
				System.out.println("Input new password:");
				if (scanner.hasNextLine()) {
					newpassword = scanner.nextLine();
					if (newpassword.matches("(?=.{8,32}$).*")) {
						check=true;
						}
						else {
							System.out.println("Not a valid password.");
						}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid password.");
				}
			} while (!check);
			try {
				adi.createUser(newusername, newpassword);
			} catch (Exception e) {
			}
			menu_check=MENU_STATE.ADMIN;
		}
		if (menu_check==MENU_STATE.ADMINUPDATE) {
			int user_id=0;
			String user_id_string="";
			String updateusername = "";
			String updatepassword = "";
			check=false;
			do {
				System.out.println("Input User ID:");
				if (scanner.hasNextLine()) {
					user_id_string = scanner.nextLine();
					if(user_id_string.matches("\\d+")) {
						check=true;
						user_id=Integer.parseInt(user_id_string);
					}
					else {
						System.out.println("Not a valid id.");
					}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid id.");
				}

			} while (!check);
			check=false;
			do {
				System.out.println("Input new Username. It must be between 5-15 alphanumeric characters and start with a letter:");
				if (scanner.hasNextLine()) {
					updateusername = scanner.nextLine();
					if (updateusername.matches("(?=.{5,15}$)[a-zA-Z][a-zA-Z\\d]*")) {
					check=true;
					}
					else {
						System.out.println("Not a valid username.");
					}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid username.");
				}

			} while (!check);
			check = false;
			System.out.println("Input updated Password. It must be between 8 and 32 characters long.");
			do {
				System.out.println("Input new password:");
				if (scanner.hasNextLine()) {
					updatepassword = scanner.nextLine();
					if (updatepassword.matches("(?=.{8,32}$).*")) {
						check=true;
						}
						else {
							System.out.println("Not a valid password.");
						}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid password.");
				}
			} while (!check);
			try {
				adi.updateUser(user_id, updateusername, updatepassword);
			} catch (SQLException e) {
			}
			menu_check=MENU_STATE.ADMIN;
		}
		
		if (menu_check==MENU_STATE.ADMINDELETE) {
			int user_id=0;
			String user_id_string="";
			check=false;
			do {
				System.out.println("Input User ID:");
				if (scanner.hasNextLine()) {
					user_id_string = scanner.nextLine();
					if(user_id_string.matches("\\d+")) {
						check=true;
						user_id=Integer.parseInt(user_id_string);
					}
					else {
						System.out.println("Not a valid id.");
					}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid id.");
				}
			} while (!check);
			try {
				adi.deleteUser(user_id);
				
			} catch (SQLException e) {
			}
			menu_check=MENU_STATE.ADMIN;
		}
		
		if (menu_check==MENU_STATE.CUSTOMERDELETE) {
			int account_id=0;
			String account_id_string="";
			check=false;
			do {
				System.out.println("Input Account ID:");
				if (scanner.hasNextLine()) {
					account_id_string = scanner.nextLine();
					if(account_id_string.matches("\\d+")) {
						check=true;
						account_id=Integer.parseInt(account_id_string);
					}
					else {
						System.out.println("Not a valid id.");
					}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid id.");
				}
			} while (!check);
			try {
				acdi.deleteAccount(account_id,current_user);
			} catch (Exception e) {
			}
			menu_check=MENU_STATE.CUSTOMER;
		}
		if (menu_check==MENU_STATE.CUSTOMERCREATE) {
			try {
				acdi.createAccount(current_user);
			} catch (Exception e) {
			}
			menu_check=MENU_STATE.CUSTOMER;
		}
		
		if (menu_check==MENU_STATE.DEPOSIT) {
			int account_id=0;
			String account_id_string;
			double amount=0;
			check=false;
			do {
				System.out.println("Input Account ID:");
				if (scanner.hasNextLine()) {
					account_id_string = scanner.nextLine();
					if(account_id_string.matches("\\d+")) {
						check=true;
						account_id=Integer.parseInt(account_id_string);
					}
					else {
						System.out.println("Not a valid id.");
					}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid id.");
				}
			} while (!check);
			check=false;
			do {
				System.out.println("Input Amount you want to deposit:");
				if (scanner.hasNextLine()) {
					account_id_string = scanner.nextLine();
					if(account_id_string.matches("\\d+.?\\d?\\d?")) {
						check=true;
						amount=Double.parseDouble(account_id_string);
					}
					else {
						System.out.println("Not a valid amount.");
					}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid amount.");
				}
			} while (!check);
			try {
				if (acdi.deposit(amount, account_id, current_user))
					{
					LOGGER.info("Customer "
							+ current_user
							+ " deposited "
							+ String.format("$%.2f to Account ",
									amount)
							+ account_id + ".");
					};
			}catch (Exception e) {}
			menu_check=MENU_STATE.CUSTOMER;
		}
		
		if (menu_check==MENU_STATE.WITHDRAW) {
			int account_id=0;
			String account_id_string;
			double amount=0;
			check=false;
			do {
				System.out.println("Input Account ID:");
				if (scanner.hasNextLine()) {
					account_id_string = scanner.nextLine();
					if(account_id_string.matches("\\d+")) {
						check=true;
						account_id=Integer.parseInt(account_id_string);
					}
					else {
						System.out.println("Not a valid id.");
					}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid id.");
				}
			} while (!check);
			check=false;
			do {
				System.out.println("Input Amount you want to withdraw:");
				if (scanner.hasNextLine()) {
					account_id_string = scanner.nextLine();
					if(account_id_string.matches("\\d+.?\\d?\\d?")) {
						check=true;
						amount=Double.parseDouble(account_id_string);
					}
					else {
						System.out.println("Not a valid amount.");
					}
				} else {
					scanner.nextLine();
					System.out.println("Not a valid amount.");
				}
			} while (!check);
			try {
				if(acdi.withdraw(amount, account_id, current_user))
				{
					LOGGER.info("Customer "
							+ current_user
							+ " withdrew "
							+ String.format("$%.2f from Account ",
									amount)
							+ account_id + ".");
					};
			}catch (Exception e) {}
			menu_check=MENU_STATE.CUSTOMER;
		}
		
		
		} /*end of while loop*/
		
		
	}
}




