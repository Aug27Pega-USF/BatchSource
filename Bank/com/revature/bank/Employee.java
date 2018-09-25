package com.revature.bank;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1339765_1L;
	private String name;
	private String password;
	private String UserID;



	public Employee(String name, String password, String userID) {
		super();
		this.name = name;
		this.password = password;
		UserID = userID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", password=" + password + ", UserID=" + UserID + ", getName()=" + getName()
				+ ", getPassword()=" + getPassword() + ", getUserID()=" + getUserID() + "]";
	}
}
