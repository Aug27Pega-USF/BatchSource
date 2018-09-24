package com.revature.beans;

public class Admin {
	private int user_id;
	private String username;
	@Override
	public String toString() {
		return "Admin [user_id=" + user_id + ", username=" + username + "]";
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Admin(int user_id, String username) {
		super();
		this.user_id = user_id;
		this.username = username;
	}
	
}
