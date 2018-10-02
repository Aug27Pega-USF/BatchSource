package com.revature.beans;

public class LoginInfo {
	
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String roletype;
	
	public LoginInfo(int id, String first,String last, String uname, String pass, String role) {
		this.id = id;
		this.firstname = first;
		this.lastname = last;
		this.username = uname;
		this.password = pass;
		this.roletype = role;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	@Override
	public String toString() {
		return "Name: " + getFirstname() + " " + getLastname() + " | "+getRoletype()
		+ "\nUsername: "+ getUsername()
		+ "\nPassword: "+ getPassword() + "\n";
	}
}
