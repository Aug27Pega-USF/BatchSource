package com.revature.tables;

public class Users {
	//private variables are only visible in the class they belong to which is why we use getters and setters to obtain the data 
	private int UserID;
	private String username; 
	private String password;
	private String firstName;
	private String lastName;
	private int userType;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int UserID, String Ssn, String username, String password, String firstName, String lastName, int userType) {
		super();
		//this keyword defines an instance of a variable 
		this.UserID = UserID; 
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = 0;
	}
	//all the getters and setters 
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
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "Users [UserID=" + UserID + ", username="+ username+ ", password="+ password+
				", firstName=" + firstName + ", lastName="+ lastName+ ", userType="+ userType +"]";
	
	}
	public void add(Users users) {
		// TODO Auto-generated method stub
		
	}
	
}

