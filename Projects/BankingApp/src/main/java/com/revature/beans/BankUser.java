package com.revature.beans;

import java.io.Serializable;
import java.util.Random;

public class BankUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String firstName;
	protected String lastName;
	protected String username; 
	protected Status status;
	protected String password;
	protected int IDNumber;
	protected static Random rand = new Random();
	//protected static int num = rand.nextInt(9000000) + 1000000;// random 7 digit ID number
	
	public enum Status {
		CUSTOMER,
		EMPLOYEE,
		ADMIN
	}
	public BankUser(String firstName,String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.IDNumber = rand.nextInt(9000000) + 1000000;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public int getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(int iDNumber) {
		IDNumber = iDNumber;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return status +" firstName: " + firstName + ", lastName: " + lastName + ", username: " + username
				 + ", password=" + password + ", IDNumber=" + IDNumber;
	}
	
	
	
}
