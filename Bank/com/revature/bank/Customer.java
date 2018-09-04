package com.revature.bank;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1339765_1L;
	private String name;
	private String password;

	public Customer(String name, String password) {
		this.name = name;
		this.password = password;
	}



	@Override
	public String toString() {
		return "Customer [name=" + name + ", password=" + password + ", getName()=" + getName() + ", getPassword()="
				+ getPassword() + "]";
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
