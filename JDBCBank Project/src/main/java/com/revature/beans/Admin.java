package com.revature.beans;

import java.io.Serializable;

public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	private int userid;
	private String name;
	private String password;
	private String isadmin;

	@Override
	public String toString() {
		return " your name, " + password + ": your password.";
		//"Admin [name=" + name + ", password=" + password + ", getName()=" + getName() + ", getPassword()=" + getPassword() + "]";
	}
	public Admin(int user_id, String name, String password, String is_admin) {
		super();
		this.userid = user_id;
		this.name = name;
		this.password = password;
		this.isadmin = is_admin;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getIsAdmin() {
		return isadmin;
	}
	public void setIsAdmin(String is_admin) {
		this.isadmin = is_admin;
	}
}
