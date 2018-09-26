package com.revature.bean;

public class User {
	private int userID;
	private int clearanceID;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userID, int clearanceID, String userName, String password, String firstName, String lastName,
			String address, String city, String state, int zip) {
		super();
		this.userID = userID;
		this.clearanceID = clearanceID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getClearanceID() {
		return clearanceID;
	}
	public void setClearanceID(int clearanceID) {
		this.clearanceID = clearanceID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", clearanceID=" + clearanceID + ", userName=" + userName + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
	
	

}
