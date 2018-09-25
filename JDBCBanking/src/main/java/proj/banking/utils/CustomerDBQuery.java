package proj.banking.utils;

import java.util.ArrayList;

import proj.banking.bean.BankAccounts;
import proj.banking.utils.Enums.TransactionStatus;

public interface CustomerDBQuery {
	public abstract ArrayList<BankAccounts> getExistingAccounts();
	public abstract int createNewBankAccount();
	public abstract boolean closeAccount();
	public abstract TransactionStatus updateAccountBalance();
}
