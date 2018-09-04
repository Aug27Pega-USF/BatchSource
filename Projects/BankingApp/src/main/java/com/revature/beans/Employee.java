package com.revature.beans;

import com.revature.accounts.AbstractAccount;

public class Employee extends BankUser {

	private static final long serialVersionUID = 1L;

	public Employee(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password);
		this.status = BankUser.Status.EMPLOYEE;
		
	}
	
	public void judgeAccount(AbstractAccount.AccountStatus status, AbstractAccount account) {
		account.setStatus(status);
	}
	
	public String viewAccount(AbstractAccount account) {
		return account.toString();
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", status="
				+ status + ", password=" + password + ", IDNumber=" + IDNumber + "]";
	}
}
