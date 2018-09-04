package com.PrestonL.javabank;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 3230509083821409926L;
	private String password;
	private String username;

	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}


	public boolean doesEqual(String password, String username) {
		return this.password.equals(password) & this.username.equals(username);
	}

	public boolean doesUsernameEqual(String username) {
		return this.username.equals(username);
	}

	public void setPassword(String password) {this.password=password;}
	public void setUsername(String username) {this.username=username;}
	//comment out below maybe.
	public String getPassword() {return this.password;}
	public String getUsername() {return this.username;}	 

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	public String returnClass() {
		return "User(Should not show)";
	}

}
