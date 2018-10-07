package com.runtime.bean;

public class User {
	private int userId;
	private String jobType;
	private String jobPos;
	private String reportsTo;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phoneNum;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String jobType, String jobPos, String reportsTo, String userName, String passWord,
			String firstName, String lastName, String address, String email, String phoneNum) {
		super();
		this.userId = userId;
		this.jobType = jobType;
		this.jobPos = jobPos;
		this.reportsTo = reportsTo;
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNum = phoneNum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobPos() {
		return jobPos;
	}

	public void setJobPos(String jobPos) {
		this.jobPos = jobPos;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", jobType=" + jobType + ", jobPos=" + jobPos + ", reportsTo=" + reportsTo
				+ ", userName=" + userName + ", passWord=" + passWord + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", email=" + email + ", phoneNum=" + phoneNum + "]";

	}
}
