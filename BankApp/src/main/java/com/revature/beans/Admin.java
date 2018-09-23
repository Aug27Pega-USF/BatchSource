package com.revature.beans;

public class Admin {
	private int admin_id;
	private User_Info user_id;
	private String admin_username;
	private String admin_password;
	
	public Admin() {}

	public Admin(int admin_id, User_Info user_id, String admin_username, String admin_password) {
		super();
		this.admin_id = admin_id;
		this.user_id = user_id;
		this.admin_username = admin_username;
		this.admin_password = admin_password;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", user_id=" + user_id + ", admin_username=" + admin_username
				+ ", admin_password=" + admin_password + "]";
	}

	
}
