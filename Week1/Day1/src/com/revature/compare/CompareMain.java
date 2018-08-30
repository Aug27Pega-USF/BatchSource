package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List <Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student [] {
						new Student (14, "Matt",6.7),
						new Student (12, "Julian",0.3),
						new Student(80,"Vincent",3.9),
						new Student (63, "Tony", 4.0)}));
		//System.out.println(studentList);
		for(Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("============================");
		Collections.sort(studentList);
		System.out.println("SOrt by studentID:");
		for(Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("============================");
		Collections.sort(studentList,new StudentComparator());
		System.out.println("Sort by GPA:");
		for(Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("============================");
		System.out.println("Sort by name w/ lambda");
		//Sort with a Lambda- Sort by name
		Collections.sort(studentList,(arg0,arg1)
			->{	return arg0.getName().compareTo(arg1.getName());}
				);
		for(Student s:studentList) {
			System.out.println(s);
		}
	}

}
