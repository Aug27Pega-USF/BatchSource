package com.revature.accounts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SavingsAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(SavingsAccount.class.getName());
	
	
	public SavingsAccount(String ...acctHolder) {
		super(acctHolder);
		this.type = Account.AccountType.SAVINGS;
	}
	
	@Override
	public Logger getLogger() {
		
		return logger;
	}

		

}
