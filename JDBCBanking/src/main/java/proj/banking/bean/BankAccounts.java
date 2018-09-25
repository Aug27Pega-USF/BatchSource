package proj.banking.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccounts {
	private int primaryAccountHolderID; //to be changed to int
	private int jointHolderID; //to be changed to int
	private int accountNumber; //to be changed to int
	private double amount;
	
	public BankAccounts(int primaryAccountHolderID, int accountNumber) {
		this(primaryAccountHolderID, 0, accountNumber, 0);
	}
	
	public BankAccounts(int primaryAccountHolderID, int jointHolderID, int accountNumber) {
		this(primaryAccountHolderID, jointHolderID, accountNumber, 0);
	}
	
	public BankAccounts(int primaryAccountHolderID, int accountNumber, double amount) {
		this(primaryAccountHolderID, 0, accountNumber, amount);
	}

	
	public BankAccounts(int primaryAccountHolderID, int jointHolderID, int accountNumber, double amount) {
		this.primaryAccountHolderID = primaryAccountHolderID;
		this.jointHolderID = jointHolderID;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
	public BankAccounts(String ...args) {
		int counter = 0;
		for(String s : args) {
			switch(counter) {
			case 0:
				this.accountNumber = Integer.parseInt(s);
				break;
			case 1:
				this.primaryAccountHolderID = Integer.parseInt(s);
				break;
			case 2:
				if(s.equals("")) {
					this.jointHolderID = 0;
				} else {
					this.jointHolderID = Integer.parseInt(s);
				}
				break;
			case 3:
				this.amount = Double.parseDouble(s);
				break;
			}
			counter++;
		}
	}
	
	public BankAccounts(ResultSet bankAccountResults) throws SQLException {
		for(int i = 1; i <= bankAccountResults.getMetaData().getColumnCount(); i++) {
			switch(i) {
			case 1:
				this.accountNumber = bankAccountResults.getInt(i);
				break;
			case 2:
				this.primaryAccountHolderID = bankAccountResults.getInt(i);
				break;
			case 3:
				this.jointHolderID = bankAccountResults.getInt(i);
				break;
			case 4:
				this.amount = bankAccountResults.getDouble(i);
				break;
			}
		}
	}

	public int getJointHolderID() {
		return jointHolderID;
	}
	public int getAccountHolderID() {
		return primaryAccountHolderID;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public double getAmount() {
		return amount;
	}

	public String toString() {
		return primaryAccountHolderID + " " + accountNumber + " " + amount + " " + jointHolderID;
	}
}
