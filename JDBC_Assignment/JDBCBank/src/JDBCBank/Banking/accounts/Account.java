package JDBCBank.Banking.accounts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import JDBCBank.Banking.impl.AccountImpl;

//this is our class for all bank accounts
public class Account extends Serial {
	
	
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger(Account.class.getName());
	
	private int account_id;
	private String name;
	private int balance;
	private int user_id;
	
	//lite constructor
	public Account() {
		super();
	}
	
	//main constructor
	public Account(int account_id, String name, int balance, int user_id) {
		super();
		this.account_id = account_id;
		this.name = name;
		this.balance = balance;
		this.user_id = user_id;
	}
	
	

	//Getters/Setters
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", name=" + name + ", balance=" + balance + ", user_id=" + user_id
				+ "]";
	}

	public static void AddNewAccount(Scanner scan, String account_name, int current_user_id, AccountImpl a, ArrayList<Account> accountsList) {

		try {
			System.out.println("*Loading...*");
			a.create( account_name, current_user_id );
			accountsList.add(a.readOne(account_name, current_user_id));
			log.info( "Account Created - Name: " + account_name + ", User ID: " + current_user_id + ", Balance: 0");
			System.out.println("The account \"" + account_name + "\" has been created.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void DepositIntoAccount(Scanner scan, int acc_dbid, int acc_index, AccountImpl a, ArrayList<Account> accountsList, int current_user_id) {
		//ask how much to deposit into it
		System.out.print("How much would you like to deposit: $");
		int amount = 0;
		try{
			//get the amount
			amount = Integer.parseInt(scan.next());
			
			//adjust the balance in list 
			int balance = accountsList.get(acc_index).getBalance() + amount;
			accountsList.get(acc_index).setBalance(balance);
			
			//and update it in the database
			balance = accountsList.get(acc_index).getBalance();
			System.out.println("*Loading...*");
			a.update(acc_dbid, balance);
			
			String account_name = accountsList.get(acc_index).getName();
			log.info( "Account Updated - Name: " + account_name + ", User ID: " + current_user_id + ", New Balance: $" + balance);
			System.out.println("Deposited $" + amount + " into account \"" + account_name + "\".");
			
		}catch (NumberFormatException ex) {
			System.out.println("Please enter a valid number!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	public static void withdrawFromAccount(Scanner scan, int acc_dbid, int acc_index, AccountImpl a, ArrayList<Account> accountsList, int current_user_id) {
		
		ExcessWithdrawal ewe = new ExcessWithdrawal();
		
		//ask how much to deposit into it
		System.out.print("How much would you like to withdraw: $");
		int amount = 0;
		try{
			//get the amount
			amount = Integer.parseInt(scan.next());
			
			//adjust the balance in list 
			int balance = accountsList.get(acc_index).getBalance();
			
			//get name 
			String account_name = accountsList.get(acc_index).getName();
			
			
			//see if it's not greater than the balance
			if (ewe.checkBalance(amount, balance)) {
				balance = accountsList.get(acc_index).getBalance() - amount;
			
				accountsList.get(acc_index).setBalance(balance);
				
				//and update it in the database
				balance = accountsList.get(acc_index).getBalance();
				System.out.println("*Loading...*");
				a.update(acc_dbid, balance);
				
				
				log.info( "Account Updated - Name: " + account_name + ", User ID: " + current_user_id + ", New Balance: $" + balance);
				System.out.println("Withdrew $" + amount + " into account \"" + account_name + "\".");
			}
			
			else
				System.out.println("*Amount Requested Exceeds Balance*");
			
		}catch (NumberFormatException ex) {
			System.out.println("Please enter a valid number!");
		} catch (ExcessWithdrawalException e) {
			System.err.print(e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	public static void deleteAccount(int acc_dbid, int acc_index, AccountImpl a, ArrayList<Account> accountsList, int current_user_id) {
		
		BalanceNotEmpty bne = new BalanceNotEmpty();
		
		try{
			//get the balance in list 
			int balance = accountsList.get(acc_index).getBalance();
			//name for reference
			String account_name = accountsList.get(acc_index).getName();
			//see if the account is empty
			if (bne.checkBalance(balance)) {
				//remove from array
				accountsList.remove(acc_index);
				System.out.println("*Loading...*");
				//remove from DB
				a.delete(acc_dbid);		
				
				log.info( "Account Deleted - Name: " + account_name + ", User ID: " + current_user_id);
				System.out.println("Deleted account \"" + account_name + "\".");
			
			}
			
			//account is not empty
			//else
				//System.out.println("*Account \"" + account_name + "\" cannot be deleted, balance is not 0*");
		} catch (BalanceNotEmptyException e) {
			System.err.print(e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	
	
	
}

/*
 * EXCEPTIONS
 */
class BalanceNotEmptyException extends Exception {
	 
	private static final long serialVersionUID = 1L;

	public BalanceNotEmptyException(String message) {
        super(message);
    }
}

class BalanceNotEmpty {
	 
    public boolean checkBalance(int balance) throws BalanceNotEmptyException {
        if (balance == 0) {
            return true;
        } else {
            throw new BalanceNotEmptyException(
                "*Account not Deleted. Balance is not 0*"
            		);
        }
    }
}

class ExcessWithdrawalException extends Exception {
	 
	private static final long serialVersionUID = 1L;

	public ExcessWithdrawalException(String message) {
        super(message);
    }
}

class ExcessWithdrawal {
	 
    public boolean checkBalance(int request, int balance) throws ExcessWithdrawalException {
        if (request <= balance) {
            return true;
        } else {
            throw new ExcessWithdrawalException (
                "*Withdrawal denied. Exceeds balance*"
            		);
        }
    }
}
