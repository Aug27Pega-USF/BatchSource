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
	private int areaCode;
	private int phone;
	private int ssn;
	private int lastFour;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userID, int clearanceID, String userName, String password, String firstName, String lastName,
			String address, String city, String state, int zip,int areaCode, int phone, int ssn, int lastFour) {
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
		this.areaCode = areaCode;
		this.phone = phone;
		this.ssn = ssn;
		this.lastFour = lastFour;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getLastFour() {
		return lastFour;
	}
	public void setLastFour(int lastFour) {
		this.lastFour = lastFour;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", clearanceID=" + clearanceID + ", userName=" + userName + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", ssn=" + ssn
				+ ", lastFour=" + lastFour + "]";
	}
	
	
	

}
