package com.revature.compare;

import java.util.Comparator;

public class Employee implements Comparable <Employee>, Comparator <Employee> {
	private int age;
	private String name;
	private String department;
	
	public Employee() {}
	
	public Employee(String name, String dep, int age) {
		this.name = name;
		this.department = dep;
		this.age = age;
	}
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

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

	
	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", department=" + department + "]";
	}

	@Override
	public int compare(Employee o1, Employee o2) { //for comparator interface
		// compare ages of employee
		return o1.getName().compareTo(o2.getName());
	}

	@Override
	public int compareTo(Employee o) { //for comparable interface
		// TODO Auto-generated method stub
		return this.getAge() - o.getAge();
	}
	
	

}
