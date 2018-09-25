package com.revature.accounts;

public class Admin{

	private String username;
	private String password;
	private String fname;
	private String lname;
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	@Override
	public String toString() {
		return "UserAccount [username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname
				+ ", id=" + id + "]";
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

}
