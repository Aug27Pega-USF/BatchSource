package com.revature.beans;

import java.util.Comparator;

public class Employee implements Comparator<Employee>, Comparable<Employee> {
	
	public static final Comparator<Employee> AgeComparator = new Comparator<Employee>(){

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.age - o2.age;  // This will work because age is positive integer
        }
       
    };
    
	private String department, name;
	private int id, age;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee(int id, String name, int age, String department){
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
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

//	@Override
//	public String toString() {
//		return "Employee [name= " + name + " age= " + age + " department= " + department + "]";
//	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return (o1.getAge() - o2.getAge());
	}

	@Override
	public String toString() {
		return "Employee [department=" + department + ", name=" + name + ", id=" + id + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.getId() - o.getId();
	}

}
