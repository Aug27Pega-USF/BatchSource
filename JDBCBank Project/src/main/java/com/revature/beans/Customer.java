package com.revature.beans;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userid;
	private String name;
	private String password;
	private String isadmin;

	public Customer(int user_id, String name, String password, String is_admin) {
		this.userid = user_id;
		this.name = name;
		this.password = password;
		this.isadmin = is_admin;
	}

	@Override
	public String toString() {
		return "User ID: " + userid + ", username: " + name + ", password: " + password + "\n";// getName()=" + getName() + ", getPassword()="+ getPassword() + "]";
	}
//	@Override
//	public String toString() {
//        return "Customer [UserID: " + userid + ", username: " + name + ", password: " + password + "]";
//    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userid;
	}
	public void setUserId(int user_id) {
		this.userid = user_id;
	}

	public String getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(String is_admin) {
		this.isadmin = is_admin;
	}
}
