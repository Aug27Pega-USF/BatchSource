package com.PrestonL.javabank;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankingStructure 
{	
	private static final Logger LOGGER = LogManager.getLogger(BankingStructure.class.getName());
	static Scanner scanner;
	@SuppressWarnings("unchecked")
	public static void main( String[] args )
	{
		scanner = new Scanner(System.in);
		Bank bank;
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
		ArrayList<Application> applicationList = new ArrayList<Application>();

		// Deserialization

		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream
					("Bank.txt");
			ObjectInputStream in = new ObjectInputStream
					(file);

			// Method for deserialization of object
			userList = (ArrayList<User>)in.readObject();

			in.close();
			file.close();

			for (int i=0; i!=userList.size();i++) {
				switch(userList.get(i).returnClass()){
				case "Employee":
					employeeList.add((Employee) userList.get(i));
					break;
				case "Customer":
					customerList.add((Customer) userList.get(i));
					break;
				case "Admin":
					adminList.add((Admin) userList.get(i));
					break;
				default:    		
				}
			}   
			file = new FileInputStream
					("Bankaccount.txt");
			in = new ObjectInputStream
					(file);           

			accountList=(ArrayList<BankAccount>)in.readObject();
			in.close();
			file.close();
			file = new FileInputStream
					("Application.txt");
			in = new ObjectInputStream
					(file);           

			applicationList=(ArrayList<Application>)in.readObject();
			in.close();
			file.close();
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" +
					" is caught");
		}


		//Creation of Bank Class
		bank=new Bank(userList, customerList, employeeList, adminList, accountList, applicationList);
		System.out.println("This is a list of users for convenience.");
		bank.getUser();
		System.out.println("Welcome to Java Bank Interface.");


		//THIS IS THE SCANNER INTERFACE.
		boolean check = false, login=false, register = false, iscustomer=false, isemployee=false, isadmin=false;
		User currentuser=null;
		Customer currentcustomer=null;
		Employee currentemployee=null;
		Admin currentadmin=null;

		do {
			do {
				do {
					register = false;
					System.out.println("'Login' , 'Register', or 'Exit'?");
					if (scanner.hasNextLine()) {
						switch (scanner.nextLine()) {
						case "l":
						case "L":
						case "login":
						case "Login":
							login = true;
							check = true;
							break;
						case "r":
						case "R":
						case "register":
						case "Register":
							register = true;
							check = true;
							break;
						case "e":
						case "E":
						case "exit":
						case "Exit":
							System.exit(0);
							break;
						default:
							System.out.println("Please input exactly or use the first letter.");
						}
					}
				} while (!check);

				check = false;
				String username = "";
				String password = "";

				//BEGINNING OF LOGIN STRUCTURE.
				if (login) {
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
					currentuser=null;
					currentuser = bank.login(username, password);
					if (currentuser != null) {
						login = true;
						switch (currentuser.returnClass()) {
						case "Customer":
							currentcustomer = (Customer) currentuser;
							iscustomer = true;
							System.out.println("Welcome Customer " + currentcustomer.name + ".");
							break;
						case "Employee":
							currentemployee = (Employee) currentuser;
							isemployee = true;
							System.out.println("Welcome Employee " + currentemployee.name + ".");
							break;
						case "Admin":
							currentadmin = (Admin) currentuser;
							isadmin = true;
							System.out.println("Welcome Admin " + currentadmin.name + ".");
							break;
						default:
						}
					} else {
						login = false;
						System.out.println("Username or password is incorrect.");
					}
				}
				//END OF LOGIN STRUCTURE
				//BEGINNING OF REGISTER STRUCTURE
				check = false;
				if (register) {
					String registerusername = "";
					String registerpassword = "";
					String registername = "";
					System.out.println(
							"Welcome customer. Please input your desired username. Must be between 5 and 15 characters long "
									+ "containing only alphanumeric characters. Must start with a letter.");
					do {
						System.out.println("Input Username:");
						Pattern pattern = Pattern.compile("(?=.{5,15}$)[a-zA-Z][a-zA-Z\\d]*");
						if (scanner.hasNext(pattern)) {
							registerusername = scanner.nextLine();
							if (bank.usernamecheck(registerusername)) {
								check = true;
							} else {
								System.out.println("Sorry. Username is already taken.");
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
						Pattern pattern = Pattern.compile("(?=.{8,32}$).*");
						if (scanner.hasNext(pattern)) {
							registerpassword = scanner.nextLine();
							check = true;
						} else {
							scanner.nextLine();
							System.out.println("Not a valid password.");
						}
						if (check) {
							System.out.println("Type in password again:");
							if (scanner.hasNext(pattern)) {
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
					System.out.println("Please enter your first name.");
					do {
						Pattern pattern = Pattern.compile("(?=.{2,50}$)[A-Z][a-zA-z]*");
						if (scanner.hasNext(pattern)) {
							registername = scanner.nextLine();
							check = true;
						} else {
							scanner.nextLine();
							System.out.println(
									"Valid names start with a capital letter and only contain alphabet characters.");
						}
						if (check) {
							do {
								check = false;
								System.out.println("Please enter your last name:");
								if (scanner.hasNext(pattern)) {
									registername += " " + scanner.nextLine();
									check = true;
								} else {
									scanner.nextLine();
									System.out.println(
											"Valid names start with a capital letter and only contain alphabet characters.");
								}
							} while (!check);
						}

					} while (!check);
					bank.registerCustomer(registerusername, registerpassword, registername);
					register = false;
					System.out.println("Registration complete! Please login.");
					bank.serialize();
					//End of Register Structure.
				}
			} while (login == false && register == false);
			//THIS IS BEGINNING OF CUSTOMER STUFF.
			boolean menucheck = false;
			if (iscustomer) {
				boolean accountempty = currentcustomer.getAccountList().isEmpty();
				boolean pendingempty = currentcustomer.getPending().isEmpty();
				check = false;
				do {
					System.out.println(
							"Please enter the number for the desired action.\n1. Access/View Accounts\n2. View Pending Applications\n3. Apply for Account\n4. Logout");
					do {
						if (scanner.hasNextInt()) {
							switch (scanner.nextLine()) {
							case "1":
								if (accountempty) {
									System.out.println("No accounts found.\n");
								} else {
									boolean accountcheck = false;
									do {
										System.out.println("Current accounts:");
										System.out.println(bank.getAccountList(currentcustomer));
										System.out.println(
												"Please enter the number next to the account you want to access.");
										if (scanner.hasNextInt()) {
											int temp = Integer.parseInt(scanner.nextLine());
											int accessaccountid;
											if (temp > 0 && temp <= (currentcustomer.getAccountList().size())) {
												check = false;
												accessaccountid = currentcustomer.getAccountList().get(temp - 1);
												do {
													System.out.println("Account " + accessaccountid
															+ ":\nPlease enter the number for the desired action.\n1. Deposit\n2. Withdraw\n3. Transfer\n4. All Account Information\n5. Back");
													if (scanner.hasNextInt()) {
														switch (Integer.parseInt(scanner.nextLine())) {
														case 1:
															boolean depositcheck = false;
															do {
																System.out.println("Deposit amount $:");
																if (scanner.hasNextDouble()) {
																	double amount = Double
																			.parseDouble(scanner.nextLine());
																	if (bank.depositInto(accessaccountid, amount)) {
																		LOGGER.info("Customer "
																				+ currentcustomer.getUsername()
																				+ " deposited "
																				+ String.format("$%.2f to Account ",
																						amount)
																				+ accessaccountid + ".");
																		depositcheck = true;
																		bank.serialize();
																	}
																} else {
																	scanner.nextLine();
																	System.out
																			.println("Please enter a valid $ amount.");
																}
															} while (!depositcheck);
															break;
														case 2:
															boolean withdrawcheck = false;
															do {
																System.out.println("Withdraw amount $:");
																if (scanner.hasNextDouble()) {
																	double amount = Double
																			.parseDouble(scanner.nextLine());
																	if (bank.withdrawFrom(accessaccountid, amount)) {
																		withdrawcheck = true;
																		LOGGER.info("Customer "
																				+ currentcustomer.getUsername()
																				+ " withdrew "
																				+ String.format("$%.2f from Account ",
																						amount)
																				+ accessaccountid + ".");
																		bank.serialize();
																	}
																} else {
																	scanner.nextLine();
																	System.out
																			.println("Please enter a valid $ amount.");
																}
															} while (!withdrawcheck);
															break;
														case 3:
															int transferid = 0;
															boolean transfercheck = false;
															do {
																System.out.println("Transfer to account(id):");
																Pattern pattern = Pattern
																		.compile("(?=.{5}$)[1-9][0-9]*");
																if (scanner.hasNext(pattern)) {
																	transferid = Integer.parseInt(scanner.nextLine());
																	if (bank.matchAccount(transferid) != null) {
																		if (accessaccountid == transferid) {
																			System.out.println(
																					"You cannot transfer to your own account.");
																		} else {
																			transfercheck = true;
																		}
																	} else {
																		System.out.println(
																				"Could not find an account with the given acccountid.");
																	}
																} else {
																	scanner.nextLine();
																	System.out
																			.println("Please enter a valid accountid.");
																}
															} while (!transfercheck);
															withdrawcheck = false;
															do {
																System.out.println("Transfer amount $:");
																if (scanner.hasNextDouble()) {
																	double amount = Double
																			.parseDouble(scanner.nextLine());
																	if (bank.withdrawFrom(accessaccountid, amount)) {
																		bank.depositInto(transferid, amount);
																		LOGGER.info("Customer "
																				+ currentcustomer.getUsername()
																				+ " transferred "
																				+ String.format("$%.2f from Account ",
																						amount)
																				+ accessaccountid + " to Account "
																				+ transferid + ".");
																		System.out.println(
																				"Money has been successfully transferred.");
																		withdrawcheck = true;
																		bank.serialize();
																	}
																} else {
																	scanner.nextLine();
																	System.out
																			.println("Please enter a valid $ amount.");
																}
															} while (!withdrawcheck);
															break;
														case 4:
															System.out.println("Account Info:");
															System.out.println(
																	bank.returnaccountInfo(accessaccountid) + "\n");
															break;
														case 5:
															check = true;
															break;
														default:
															break;
														}
													} else {
														scanner.nextLine();
														System.out.println("Please enter a valid number");
													}
												} while (!check);
											} else if (temp == currentcustomer.getAccountList().size() + 1) {
												accountcheck = true;
											} else {
												System.out.println("Please enter a valid number.");
											}
										} else {
											scanner.nextLine();
											System.out.println("Please enter a number.");
										}
									} while (!accountcheck);
								}
								check = true;
								break;
							case "2":
								check = true;
								if (pendingempty) {
									System.out.println("No pending applications.\n");
								} else {
									System.out.println("Current applications:");
									System.out.println(bank.getPendingList(currentcustomer));
								}
								break;
							case "3":
								System.out.println("Applying for Account.");
								do {
									System.out.println(
											"Please enter the number for the desired action.\n1. Apply for normal checking account.\n2. Apply for joint account to existing account.\n3. Apply for joint account to existing application.\n4. Back");
									check = false;
									if (scanner.hasNextInt()) {
										int accountid;
										Pattern pattern = Pattern.compile("(?=.{5}$)[1-9][0-9]*");
										switch (scanner.nextLine()) {
										case "1":
											currentcustomer.apply(accountList, applicationList);
											System.out
													.println(
															"Applied! Your application accountid number is: "
																	+ currentcustomer.getPending().get(
																			currentcustomer.getPending().size() - 1)
																	+ ".");
											check = true;
											break;
										case "2": // applying to existing account.
											accountid = 0;
											do {
												System.out.println("Input accountid for existing account:");

												if (scanner.hasNext(pattern)) {
													accountid = Integer.parseInt(scanner.nextLine());
													if (currentcustomer.applyjoint(accountid, accountList,
															applicationList)) {
														System.out.println(
																"Applied for joint account to account " + accountid);
														check = true;
													} else {
														check = true;
														System.out.println(
																"Error. Account with that accountid does not exist. Or you are attempting to reapply to the same account. Or you are attempting to apply to your own account.\n");
													}
												} else {
													scanner.nextLine();
													System.out.println(
															"Enter a valid accountid. Id's are between 10000 and 99999.");
												}
											} while (!check);
											break;
										case "3":
											accountid = 0;
											do {
												System.out.println("Input accountid for existing application:");
												if (scanner.hasNext(pattern)) {
													accountid = Integer.parseInt(scanner.nextLine());
													if (currentcustomer.applicationjoint(accountid, accountList,
															applicationList)) {
														System.out.println("Applied for joint account to application "
																+ accountid);
														check = true;
													} else {
														System.out.println(
																"Error. Application with that accountid does not exist. Or you are attempting to reapply to the same application. Or you are attempting to apply to your own application.\n");
														check = true;
													}
												} else {
													scanner.nextLine();
													System.out.println(
															"Enter a valid accountid. Id's are between 10000 and 99999.");
												}
											} while (!check);
											break;
										case "4":
											check = true;
										default:
											System.out.println("Please enter a valid number.");
										}
									} else {
										scanner.nextLine();
										System.out.println("Please input a number.");
									}
								} while (!check);
								bank.serialize();
								break;
							case "4":
								System.out.println("Logging out.");
								menucheck = true;
								check = true;
								iscustomer=false;
								break;
							default:
								System.out.println("Please enter a valid number.");
							}
						} else {
							scanner.nextLine();
							System.out.println("Please input a number.");
						}
					} while (!check);
				} while (!menucheck);

			}
			//THIS IS BEGINNING OF EMPLOYEE STUFF.
			if (isemployee) {
				check = false;
				do {
					System.out.println(
							"Please enter the number for the desired action.\n1. View Customers\n2. Approve/Deny Pending Applications\n3. Logout");
					do {
						if (scanner.hasNextInt()) {
							switch (scanner.nextLine()) {
							case "1":
								check = false;
								do {
									System.out.println("Current customers:");
									System.out.println(bank.viewCustomers());
									System.out.println(
											"Please enter the number next to the customer you want to see the information of.");
									if (scanner.hasNextInt()) {
										int temp = Integer.parseInt(scanner.nextLine());
										if (temp > 0 && temp <= (bank.customerList.size())) {
											System.out.println(
													bank.customerList.get(temp - 1).customerInfo(bank.accountList));
										} else if (temp == bank.customerList.size() + 1) {
											check = true;
										} else {
											System.out.println("Please give a number.");
										}
									} else {
										scanner.nextLine();
										System.out.println("Please give a number.");
									}
								} while (!check);
								break;
							case "2":
								check = true;
								if (bank.applicationList.isEmpty()) {
									System.out.println("No pending applications.\n");
								} else {
									System.out.println("Current applications:");
									System.out.println(bank.viewApplications());
									System.out.println(
											"Please enter the number next to the application you want to approve or deny.");
									boolean approvecheck = false;
									if (scanner.hasNextInt()) {
										int temp = Integer.parseInt(scanner.nextLine());
										if (temp > 0 && temp <= (bank.applicationList.size())) {
											System.out.println("1. Approve\n2. Deny");
											do {
												if (scanner.hasNextInt()) {
													switch (Integer.parseInt(scanner.nextLine())) {
													case 1:
														currentemployee.approve(
																bank.applicationList.get(temp - 1).getAccountid(),
																applicationList, customerList, accountList);
														System.out.println("Application approved.");
														approvecheck = true;
														bank.serialize();
														break;
													case 2:
														currentemployee.deny(
																bank.applicationList.get(temp - 1).getAccountid(),
																applicationList, customerList, accountList);
														System.out.println("Application denied.");
														approvecheck = true;
														bank.serialize();
														break;
													default:
														System.out.println("Please enter a valid number.");
														break;
													}
												} else {
													scanner.nextLine();
													System.out.println("Please give a number.");
												}
											} while (!approvecheck);
										} else if (temp == bank.applicationList.size() + 1) {
											check = true;
										} else {
											System.out.println("Please give a number.");
										}
									} else {
										scanner.nextLine();
										System.out.println("Please give a number.");
									}
								}
								break;
							case "3":
								System.out.println("Logging out.");
								menucheck = true;
								check = true;
								isemployee=false;
								break;
							default:
								System.out.println("Please enter a valid number.");
							}
						} else {
							scanner.nextLine();
							System.out.println("Please input a number.");
						}
					} while (!check);
				} while (!menucheck);

			}
			//THIS IS BEGINNING OF ADMIN STUFF.
			if (isadmin) {
				check = false;
				do {
					System.out.println(
							"Please enter the number for the desired action.\n1. View/Access Customer Accounts\n2. Approve/Deny Pending Applications\n3. Logout");
					do {
						if (scanner.hasNextInt()) {
							switch (scanner.nextLine()) {
							case "1":
								check = false;
								do {
									System.out.println("Current customers:");
									System.out.println(bank.viewCustomers());
									System.out.println(
											"Please enter the number next to the customer you want to access.");
									if (scanner.hasNextInt()) {
										int temp = Integer.parseInt(scanner.nextLine());
										boolean customercheck = false;
										if (temp > 0 && temp <= (bank.customerList.size())) {//This is where we want accountinfo, accountstuff
											currentcustomer = bank.customerList.get(temp - 1);
											do {
												System.out.println(
														"Please enter the number for the desired action.\n1. View customer information\n2. Edit Accounts \n3. Back");
												if (scanner.hasNextInt()) {
													customercheck = false;
													switch (Integer.parseInt(scanner.nextLine())) {
													case 1:
														System.out.println(
																currentcustomer.customerInfo(bank.accountList));
														break;
													case 2:
														if (currentcustomer.getAccountList().size() == 0) {
															System.out.println("No accounts found.\n");
														} else {
															boolean accountcheck = false;
															do {
																System.out.println("Current accounts:");
																System.out
																		.println(bank.getAccountList(currentcustomer));
																System.out.println(
																		"Please enter the number next to the account you want to access.");
																if (scanner.hasNextInt()) {
																	int temp2 = Integer.parseInt(scanner.nextLine());
																	int accessaccountid;
																	if (temp2 > 0 && temp2 <= (currentcustomer
																			.getAccountList().size())) {
																		check = false;
																		accessaccountid = currentcustomer
																				.getAccountList().get(temp2 - 1);
																		do {
																			System.out.println("Account "
																					+ accessaccountid
																					+ ":\nPlease enter the number for the desired action.\n1. Deposit\n2. Withdraw\n3. Transfer\n4. All Account Information\n5. Delete Account\n6. Back");
																			if (scanner.hasNextInt()) {
																				switch (Integer
																						.parseInt(scanner.nextLine())) {
																				case 1:
																					boolean depositcheck = false;
																					do {
																						System.out.println(
																								"Deposit amount $:");
																						if (scanner.hasNextDouble()) {
																							double amount = Double
																									.parseDouble(scanner
																											.nextLine());
																							if (bank.depositInto(
																									accessaccountid,
																									amount)) {
																								depositcheck = true;
																								LOGGER.info("Admin "
																										+ currentadmin
																												.getUsername()
																										+ " deposited "
																										+ String.format(
																												"$%.2f ",
																												amount)
																										+ "to account "
																										+ accessaccountid
																										+ ".");
																								bank.serialize();
																							}
																						} else {
																							scanner.nextLine();
																							System.out.println(
																									"Please enter a valid $ amount.");
																						}
																					} while (!depositcheck);
																					break;
																				case 2:
																					boolean withdrawcheck = false;
																					do {
																						System.out.println(
																								"Withdraw amount $:");
																						if (scanner.hasNextDouble()) {
																							double amount = Double
																									.parseDouble(scanner
																											.nextLine());
																							if (bank.withdrawFrom(
																									accessaccountid,
																									amount)) {
																								withdrawcheck = true;
																								LOGGER.info("Admin "
																										+ currentadmin
																												.getUsername()
																										+ " withdrew "
																										+ String.format(
																												"$%.2f ",
																												amount)
																										+ "from account "
																										+ accessaccountid
																										+ ".");
																								bank.serialize();
																							}
																						} else {
																							scanner.nextLine();
																							System.out.println(
																									"Please enter a valid $ amount.");
																						}
																					} while (!withdrawcheck);
																					break;
																				case 3:
																					int transferid = 0;
																					boolean transfercheck = false;
																					do {
																						System.out.println(
																								"Transfer to account(id):");
																						Pattern pattern = Pattern
																								.compile(
																										"(?=.{5}$)[1-9][0-9]*");
																						if (scanner.hasNext(pattern)) {
																							transferid = Integer
																									.parseInt(scanner
																											.nextLine());
																							if (bank.matchAccount(
																									transferid) != null) {
																								if (accessaccountid == transferid) {
																									System.out.println(
																											"You cannot transfer to the same account.");
																								} else {
																									transfercheck = true;
																								}
																							} else {
																								System.out.println(
																										"Could not find an account with the given acccountid.");
																							}
																						} else {
																							scanner.nextLine();
																							System.out.println(
																									"Please enter a valid accountid.");
																						}
																					} while (!transfercheck);
																					withdrawcheck = false;
																					do {
																						System.out.println(
																								"Transfer amount $:");
																						if (scanner.hasNextDouble()) {
																							double amount = Double
																									.parseDouble(scanner
																											.nextLine());
																							if (bank.withdrawFrom(
																									accessaccountid,
																									amount)) {
																								bank.depositInto(
																										transferid,
																										amount);
																								System.out.println(
																										"Money has been successfully transferred.");
																								LOGGER.info("Admin "
																										+ currentadmin
																												.getUsername()
																										+ " transferred "
																										+ String.format(
																												"$%.2f from Account ",
																												amount)
																										+ accessaccountid
																										+ " to Account "
																										+ transferid
																										+ ".");
																								withdrawcheck = true;
																								bank.serialize();
																							}
																						} else {
																							scanner.nextLine();
																							System.out.println(
																									"Please enter a valid $ amount.");
																						}
																					} while (!withdrawcheck);
																					break;
																				case 4:
																					System.out.println("Account Info:");
																					System.out.println(
																							bank.returnaccountInfo(
																									accessaccountid)
																									+ "\n");
																					break;
																				case 5:
																					System.out.println(
																							"ARE YOU SURE YOU WANT TO DELETE THIS ACCOUNT? Y/N.");
																					boolean deletecheck = false;
																					do {
																						Pattern pattern = Pattern
																								.compile(
																										"(?=.{1}$)[yYnN]");
																						if (scanner.hasNext(pattern)) {
																							switch (scanner
																									.nextLine()) {
																							case "y":
																							case "Y":
																								currentadmin.delete(
																										accessaccountid,
																										bank.customerList,
																										bank.accountList);
																								bank.serialize();
																								deletecheck = true;
																								check = true;
																								break;
																							case "n":
																							case "N":
																								deletecheck = true;
																								break;
																							default:
																							}
																						} else {
																							System.out.println(
																									"DELETE? Y/N.");
																						}
																					} while (!deletecheck);
																					break;
																				case 6:
																					check = true;
																					break;
																				default:
																					break;
																				}
																			} else {
																				System.out.println(
																						"Please enter a number.");
																				scanner.nextLine();
																			}
																		} while (!check);
																	} else if (temp2 == currentcustomer.getAccountList()
																			.size() + 1) {
																		accountcheck = true;
																	} else {
																		System.out.println(
																				"Please enter a valid number.");
																	}
																} else {
																	scanner.nextLine();
																	System.out.println("Please enter a number.");
																}
															} while (!accountcheck);
														}
														check = true;
														break;

													case 3:
														customercheck = true;
														break;
													default:
														System.out.println("Please enter a valid number");
													}
												} else {
													scanner.nextLine();
													System.out.println("Please enter a number.");
												}
											} while (!customercheck);

										} else if (temp == bank.customerList.size() + 1) {
											check = true;
										} else {
											System.out.println("Please give a number.");
										}
									} else {
										scanner.nextLine();
										System.out.println("Please give a number.");
									}
								} while (!check);
								break;
							case "2":
								check = true;
								if (bank.applicationList.isEmpty()) {
									System.out.println("No pending applications.\n");
								} else {
									System.out.println("Current applications:");
									System.out.println(bank.viewApplications());
									System.out.println(
											"Please enter the number next to the application you want to approve or deny.");
									boolean approvecheck = false;
									if (scanner.hasNextInt()) {
										int temp = Integer.parseInt(scanner.nextLine());
										if (temp > 0 && temp <= (bank.applicationList.size())) {
											System.out.println("1. Approve\n2. Deny");
											do {
												if (scanner.hasNextInt()) {
													switch (Integer.parseInt(scanner.nextLine())) {
													case 1:
														currentadmin.approve(
																bank.applicationList.get(temp - 1).getAccountid(),
																applicationList, customerList, accountList);
														System.out.println("Application approved.");
														approvecheck = true;
														bank.serialize();
														break;
													case 2:
														currentadmin.deny(
																bank.applicationList.get(temp - 1).getAccountid(),
																applicationList, customerList, accountList);
														System.out.println("Application denied.");
														approvecheck = true;
														bank.serialize();
														break;
													default:
														System.out.println("Please enter a valid number.");
														break;
													}
												} else {
													scanner.nextLine();
													System.out.println("Please give a number.");
												}
											} while (!approvecheck);
										} else if (temp == bank.applicationList.size() + 1) {
											check = true;
										} else {
											System.out.println("Please give a number.");
										}
									} else {
										scanner.nextLine();
										System.out.println("Please give a number.");
									}
								}
								break;
							case "3":
								System.out.println("Logging out.");
								menucheck = true;
								check = true;
								isadmin=false;
								break;
							default:
								System.out.println("Please enter a valid number.");
							}
						} else {
							scanner.nextLine();
							System.out.println("Please input a number.");
						}
					} while (!check);
				} while (!menucheck);
			}
			login=false;
			bank.serialize();
		} while (true);
		

	}

}
