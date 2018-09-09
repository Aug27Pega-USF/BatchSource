package com.revature.accounts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.accounts.Account;

public class CheckingAccount extends Account{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(SavingsAccount.class.getName());
	
	public CheckingAccount(String ...acctHolder) {
		super(acctHolder);
		this.type = Account.AccountType.CHECKING;
	}
	@Override
	public Logger getLogger() {
		return logger;
	}

	


}
