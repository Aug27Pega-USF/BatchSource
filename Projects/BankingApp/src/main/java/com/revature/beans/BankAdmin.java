package com.revature.beans;

import com.revature.accounts.AbstractAccount;

public class BankAdmin extends BankUser{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAdmin(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
		this.status = BankUser.Status.ADMIN;
	}
	
	public void cancelAccount(AbstractAccount account) {
		account.status = AbstractAccount.AccountStatus.CLOSED;
	}
	
//	public AbstractAccount editAccount(AbstractAccount account) {
//		return account;
//	}

	@Override
	public String toString() {
		return "BankAdmin [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", status="
				+ status + ", password=" + password + ", IDNumber=" + IDNumber + "]";
	}

	
}
