package com.revature.interfaceaccount;

public interface AccountsDAO {

	public String findUserInfo();
	
	public String findAccountInfo();
		
	public Double accountBalance();
	
	public Double withdrawBalance();
	
	public Double depositToBalance();
	
	
}
