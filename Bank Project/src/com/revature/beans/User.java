package com.revature.beans;

public class User {
	private int userID;
	private String userName;
	private String pWord;
	private String firstName;
	private String lastName;
	private int adminFlag;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userID, String userName, String pWord, String firstName, String lastName, int adminFlag) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.pWord = pWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminFlag = adminFlag;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPWord() {
		return pWord;
	}
	public void setPWord(String pWord) {
		this.pWord = pWord;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAdminFlag() {
		return adminFlag;
	}
	public void setAdminFlag(int adminFlag) {
		this.adminFlag = adminFlag;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", PWord=" + pWord + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", adminFlag=" + adminFlag + "]";
	}
	public void setUserName() {
		// TODO Auto-generated method stub
		
	}
}
