import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	Scanner keyboard = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit;
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.runMenu();
	}
	
	public void runMenu() {
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}

	private int getInput() {
		int choice = -1;
		do {
			System.out.println("Enter your choice: ");
			try {
				choice = Integer.parseInt(keyboard.nextLine());
				
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid Selection. Numbers only. Please check your input.");
			}
			if(choice < 0 || choice > 5 ) {
				System.out.println("Choice outside of range. Try again!");
			}
			
		}while (choice < 0 || choice > 5);
		return choice;
		
	}

	private void performAction(int choice) {
		switch(choice) {
			case 0:
				System.out.println("Thank you for using an application. Hope to see you soon.");
				System.exit(0);
				break;
			case 1:
				createAccount();
				break;
				
			case 2:
				makeDeposit();
				break;
			case 3:
				withdrawMoney();
				break;
			case 4:
				checkBalance();
				break;
			case 5:
				createAccount();
				break;
			
				default:
					System.out.println("Unknown error has occured.");
		}
	}

	private void checkBalance() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.println(bank.getCustomer(account).getAccount());
		}
		
	}

	private void withdrawMoney() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.print("How much would you like to withdraw?: ");
			double amount = 0;
			try {
				amount = Double.parseDouble(keyboard.nextLine());
			}
			catch(NumberFormatException e){
				amount = 0;
			}
			bank.getCustomer(account).getAccount().withdraw(amount);
		}
		
	}

	private void makeDeposit() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.print("How much would you like to deposit?: ");
			double amount = 0;
			try {
				amount = Double.parseDouble(keyboard.nextLine());
			}
			catch(NumberFormatException e){
				amount = 0;
			}
			bank.getCustomer(account).getAccount().deposit(amount);
		}
	}

	private int selectAccount() {
		ArrayList<Customer> customers = bank.getCustomers();
		if(customers.size() <= 0) {
			System.out.println("No customers at your bank. Bring customers or advertise.");
			return -1;
		}
		System.out.println("Select an account: ");
		for(int i = 0; i < customers.size(); i++ ) {
			System.out.println((i+1) + " " + customers.get(i).basicInfo());
		}
		
		int account = 0;
		System.out.print("Please enter your selection: ");
		try {
			account = Integer.parseInt(keyboard.nextLine()) -1;
		}
		catch(NumberFormatException e){
			account = -1;
		}
		if(account < 0 || account > customers.size()) {
			System.out.println("Invalid account selected.");
			account = -1;
		}
		return account;	
		}

	private void createAccount() {
		String firstName, lastName, accountType = "";
		double initialDeposit = 0;
		boolean valid = false;
		while(!valid) {
			System.out.println("Please enter an account type (Checking/Saving): ");
			accountType = keyboard.nextLine();
			if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("saving")) {
				valid = true;
			}
			else {
				System.out.println("Invalid account type. Please enter checking or saving.");
			}
		}
		System.out.println("Please enter your first name: ");
		firstName = keyboard.nextLine();	
		
		System.out.println("Please enter your last name: ");
		lastName = keyboard.nextLine();
		
		valid = false;
		while(!valid) {
			System.out.print("Please enter an initial deposit: ");
			try {
				initialDeposit = Double.parseDouble(keyboard.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Deposit must be a number: ");
			}
			if(accountType.equalsIgnoreCase("checking")) {
				if(initialDeposit < 100) {
					System.out.println("Checking account required minimum $100 dollars to open.");
				} else {
					valid = true;
				}
			} else if(accountType.equalsIgnoreCase("saving")) {
				if(initialDeposit < 50) {
					System.out.println("Saving account required minimum $50 dollars to open.");
				} else {
					valid = true;
				}
			}
		}
		//We can create an account
		Account account;
		if(accountType.equalsIgnoreCase("checking")) {
			account = new Checking(initialDeposit);
		}else {
			account = new Savings(initialDeposit);
			
		}
		Customer customer = new Customer(firstName, lastName, account);
		bank.addCustomer(customer);
	}

	private void printMenu() {
		System.out.println("Please make a selection:");
		System.out.println(" 1) Create a new Account");
		System.out.println(" 2) Make a Deposit");
		System.out.println(" 3) Withdraw Money");
		System.out.println(" 4) Check Balance");
		System.out.println(" 5) Delete an Acoount");
		System.out.println(" 0) Logout");
	}

	private void printHeader() {
		System.out.println("+==================================+");
		System.out.println("|                                  |");
		System.out.println("|         Welome To Soffle         |");
		System.out.println("|          Banking App             |");
		System.out.println("|     Created By Sufiyan Desai     |");
		System.out.println("|                                  |");
		System.out.println("+==================================+");	
	}
	
}
