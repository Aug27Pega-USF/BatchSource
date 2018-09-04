package com.revature.homework;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{

	private String department;
	private String name;
	private int age;
	
	@Override
	public String toString() {
		return "Employee [department=" + department + ", name=" + name + ", age=" + age + "]";
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return arg0.getAge()- arg0.getAge();
	}

	public Employee(String department, String name, int age) {
		super();
		this.department = department;
		this.name = name;
		this.age = age;
	}

}
