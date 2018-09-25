package com.revature.beans;

public class AccountLogin {
	
	public AccountLogin(String loginUser, String loginPassword) {
		super();
		LoginUser = loginUser;
		LoginPassword = loginPassword;
	}
	private String LoginUser;
	private String LoginPassword;
	public String getLoginUser() {
		return LoginUser;
	}
	public void setLoginUser(String loginUser) {
		LoginUser = loginUser;
	}
	public String getLoginPassword() {
		return LoginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		LoginPassword = loginPassword;
	}
	@Override
	public String toString() {
		return "AccountLogin [LoginUser=" + LoginUser + ", LoginPassword=" + LoginPassword + "]";
	}
	public AccountLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
}


