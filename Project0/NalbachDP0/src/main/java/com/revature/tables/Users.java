package com.revature.tables;

public class Users {
	private int UserID;
	private String Ssn;
	private String username; 
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String address; 
	private String state;
	private String country;
	private String email;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int UserID, String Ssn, String firstName, String username, String password, String lastName, String phone, String address, String state, String country, String email) {
		super();
		this.UserID = UserID;
		this.Ssn = Ssn; 
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int UserID) {
		this.UserID = UserID;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSsn() {
		return Ssn;
	}
	public void setSsn(String ssn) {
		this.Ssn = ssn;
	}
	@Override
	public String toString() {
		return "Account_Types [UserID=" + UserID + ", Ssn="+ Ssn + ", username"+ username+ ", password"+ password+
				", firstName=" + firstName + ", lastName"+ lastName+ ", phone"+ phone + ", address"+ address+
				", state"+ state + ", country"+ country + ", email"+ email+"]";
	}
	
}

