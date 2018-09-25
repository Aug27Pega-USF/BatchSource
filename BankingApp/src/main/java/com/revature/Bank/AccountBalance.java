package com.revature.Bank;

public class AccountBalance {

	public AccountBalance(double aCCbalance) {
		super();
		ACCbalance = aCCbalance;
	}

	private double ACCbalance;

	public double getACCbalance() {
		return ACCbalance;
	}

	public void setACCbalance(double aCCbalance) {
		ACCbalance = aCCbalance;
	}

	@Override
	public String toString() {
		return "AccountBalance [ACCbalance=" + ACCbalance + "]";
	}

	public AccountBalance() {
		super();
		// TODO Auto-generated constructor stub
	} 

}
