package com.revature.beans;

public class Users {
	private int userID;
	private String username;
	private String password;
	private int admin;
	
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public Users(int userID, String username, String password, int admin) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", admin=" + admin
				+ "]";
	}
}
