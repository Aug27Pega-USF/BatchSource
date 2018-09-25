package com.revature.beans;

public class USERS {
	public USERS(String uSER_NAME, String uSER_PASSWORD) {
		super();
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
	}
	private String USER_NAME;
	private String USER_PASSWORD;
	@Override
	public String toString() {
		return "USERS [USER_NAME=" + USER_NAME + ", USER_PASSWORD=" + USER_PASSWORD + "]";
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public USERS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
