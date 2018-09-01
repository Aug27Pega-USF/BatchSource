package com.driver.employee;

public class Employee {
	//fields
	private String name;
	private String department;
	private int age;
	
	//constructor
	public Employee (String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	//getters/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}



