package com.revature.beans;

public class Admin {
	private int admin_id;
	private String admin_username;
	private String admin_password;
	private String admin_name;
	
	public Admin() {}

	public Admin(int admin_id, String admin_username, String admin_password, String admin_name) {
		super();
		this.admin_id = admin_id;
		this.admin_username = admin_username;
		this.admin_password = admin_password;
		this.admin_name = admin_name;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_username=" + admin_username + ", admin_password="
				+ admin_password + ", admin_name=" + admin_name + "]";
	}

	

	
	
}
