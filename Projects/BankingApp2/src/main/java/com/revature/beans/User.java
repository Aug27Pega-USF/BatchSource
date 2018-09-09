package com.revature.beans;
/**
 * @author Kevin Medara
 * 
 * Parent Bean for all bank users
 * All users will have an ID number, first and last name, social security number, username, password, and status
 * 
 */
import java.io.File;
import java.io.Serializable;
import java.util.Map;
import java.util.Random;
import com.revature.Bank;
import com.revature.Serialize;

public class User implements Serializable, Map.Entry<Integer,User>{
	
	protected static Bank theBank = new Bank();
	private static final long serialVersionUID = 1L;
	protected Serialize serializer = new Serialize();
	protected static File accountFile = new File("Accounts.txt");
	protected static File userFile = new File("UserData.txt");
	/* Each user has an ID, a name, social security number, username, password, and status, IDs are set to a 7 digit random number*/
	private String firstName;
	private String lastName;
	private String socialNum;
	private String username; 
	protected Status status;
    private String password;
	private int IDNumber;
	private static Random rand = new Random();
	
	public enum Status {
		CUSTOMER,
		EMPLOYEE,
		ADMIN
	}
	public User() {
		super();
	}
	public User(String firstName,String lastName, String username, String password, String social) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.IDNumber = rand.nextInt(9000000) + 1000000;
		this.socialNum = social;
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
	public String getName() {
		return this.getFirstName()+" "+ this.getLastName();
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
	public String getSocialNum() {
		return socialNum;
	}
//	public void setSocialNum(String socialNum) { //passed into constructor, changing is not allowed. proper validation is done when user is created anyway
//		this.socialNum = socialNum;
//	}
	public Status getStatus() {
		return status;
	}
	public int getIDNumber() {
		return IDNumber;
	}
//	public void setIDNumber(int iDNumber) { //setting ID number is not allowed, set automatically when constructor is called
//		IDNumber = iDNumber;
//	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return " "+this.getClass().getSimpleName() + " [IDNumber: " + IDNumber + " First Name: " + firstName + " Last Name: " + lastName + " Username: " + username + " Status: "
				+ status + " Password: " + password + " SSN: " + socialNum + "]\n";
	}
	//Below are the methods for the Map.Entry interface
	public Integer getKey() {
		
		return this.getIDNumber();
	}

	public User getValue() {
		// TODO Auto-generated method stub
		return this;
	}

	public User setValue(User value) {
		// TODO Auto-generated method stub
		return value;
	}
}
