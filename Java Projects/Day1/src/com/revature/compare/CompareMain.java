package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List <Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student [] {
						new Student(4,"Matt",6.7),
						new Student(7,"Julian",0.3),
						new Student(63,"Tony",4.0),
						new Student(8,"Vincent",3.9),
						
				} ));
		// Print out
		for(Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("============================");
		System.out.println("Sort by studentID");
		// Sort it using compareTo function // compared by studentID
		Collections.sort(studentList);
		for(Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("============================");
		
		
		
		
		// Sort it using COMPARATOR // compared by GPA
		// Print out
		System.out.println("============================");
		System.out.println("Sort by GPA");
		Collections.sort(studentList,  new StudentComparator());
		
		for(Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("============================");
		
		
		
		// Sort with a Lambda - Sort by name
		Collections.sort(studentList, (arg0,arg1)
			->{ return arg0.getName().compareTo(arg1.getName()); }	// Implementing Comparable method from Student.java	
				);
		System.out.println("============================");
		System.out.println("Sort by name w/ use of Lambda expression");
		for(Student s:studentList) {
			System.out.println(s);
		}

		
	}

}
