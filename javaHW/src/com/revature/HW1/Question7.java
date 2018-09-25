package com.revature.HW1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question7 {
//Learned from student comparator
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(
				new Employee [] {
						new Employee("Matt", "Designer",38),
						new Employee("Kevin", "Programmer", 52)
				}));
		
		System.out.println("Original List");
		for (Employee e:employeeList){
			System.out.println(e);
		}
		System.out.println("=============");
		Collections.sort(employeeList);
		System.out.println("Sorted by Age");
		for (Employee e:employeeList){
			System.out.println(e);
		}
		System.out.println("=============");
		Collections.sort(employeeList, new EmployeeComparator());
		System.out.println("Sorted by Name");
		for (Employee e:employeeList){
			System.out.println(e);
		}
		System.out.println("=============");
		System.out.println("Sort by department with lambda");
		//Sort by label with lambda
		Collections.sort(employeeList,(arg0,arg1)
                ->{return arg0.getDepartment().compareTo(arg1.getDepartment());}
                );
		for (Employee e: employeeList){
			System.out.println(e);
		}

	}
}

class Employee implements Comparable<Employee>{
	//1st method of comparing: Implement Comparable
	private String name;
	private String department;
	private int age;

	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Employee arg0) {
		
		return this.getAge() - arg0.getAge();
	}


}

class EmployeeComparator implements Comparator<Employee>{

	public int compare(Employee arg0, Employee arg1){
		return arg0.getName().compareTo(arg1.getName());
	}
}