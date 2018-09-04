package com.revature.bank;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1339765_1L;
	private String name;
	private String password;




	@Override
	public String toString() {
		return "Employee [name=" + name + ", password=" + password + ", getName()=" + getName() + ", getPassword()="
				+ getPassword() + "]";
	}
	public Employee(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public Employee() {
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
