package com.revature.beans;

import java.io.Serializable;

public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;

	@Override
	public String toString() {
		return " your name, " + password + ": your password.";
		//"Employee [name=" + name + ", password=" + password + ", getName()=" + getName() + ", getPassword()=" + getPassword() + "]";
	}
	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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
}
