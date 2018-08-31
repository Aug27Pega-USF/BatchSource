package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.revature.beans.Employee;
//import com.revature.beans.Student;

public class CompareMain {

	public static void main(String[] args) {
//		List <Student> studentList = new ArrayList<Student>();
//		studentList.addAll(Arrays.asList(
//				new Student [] {
//						new Student (14, "Matt",6.7),
//						new Student (12, "Julian",0.3),
//						new Student(80,"Vincent",2.0),
//						new Student (63, "Tony", 4.0)}));
//		//System.out.println(studentList);
//		for(Student s:studentList) {
//			System.out.println(s);
//		}
//		System.out.println("============================");
//		Collections.sort(studentList);
//		System.out.println("SOrt by studentID:");
//		for(Student s:studentList) {
//			System.out.println(s);
//		}
//		System.out.println("============================");
//		Collections.sort(studentList,new StudentComparator());
//		System.out.println("Sort by GPA:");
//		for(Student s:studentList) {
//			System.out.println(s);
//		}
//		
//		//Sort by Name w/ Lambda
//		Collections.sort(studentList, (o1,o2)
//				->{return o1.getName().compareTo(o2.getName());}
//				);
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(
				new Employee[] {
						new Employee(1,"Kevin",23,"HealthScience"),
						new Employee(24, "zhawn", 21, "Human Resources"),
						new Employee(56, "Jorge", 22, "Sanitation"),
						new Employee(45, "Shakur", 24,"CEO")
				}
				
				
				));
		System.out.println("============================");
		Collections.sort(employeeList);
		System.out.println("Sort by Id");
		for(Employee e:employeeList) {
			System.out.println(e);
		}
		System.out.println("============================");
		Collections.sort(employeeList, Employee.AgeComparator);
		System.out.println("Sort by Age:");
		for(Employee s:employeeList) {
			System.out.println(s);
		}
		System.out.println("*===================================*");
		System.out.println("Sort Employees by Department w/ Lambda");
		Collections.sort(employeeList, (o1,o2)
				->{return o1.getDepartment().compareTo(o2.getDepartment());}
				);
		for(Employee e : employeeList) {
			System.out.println(e);
		}
	}

}
