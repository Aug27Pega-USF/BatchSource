package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student [] {
						new Student(15,"Matt", 9.51),
						new Student(67,"Kevin",1.4),
						new Student(3,"Haramb$",4.0),
						new Student(16,"Miguelh",1.3),
						new Student(24, "Jesush", 4.1),
						new Student(8, "Luciferh",6.66),
						new Student(45, "Raleigh$Z",3.9),
						new Student(51,"President Barack Obama",3.0),
						new Student(52,"DB",0.0)
				}));
			System.out.println("Original List");
			for (Student s:studentList) {
				System.out.println(s);
			}
			System.out.println("================");
			Collections.sort(studentList);
			System.out.println("Sorted by StudentID");
			for (Student s:studentList) {
				System.out.println(s);
			}
			System.out.println("================");
			Collections.sort(studentList, new StudentComparator());
			System.out.println("Sorted by GPA:");
			for (Student s:studentList) {
				System.out.println(s);
			}
			System.out.println("================");
			System.out.println("Sort by Label w/ lambda");
			//Sort by Label with lambda
			Collections.sort(studentList,(arg0,arg1)
					->{return arg0.getLabel().compareTo(arg1.getLabel());}
					);
			for (Student s:studentList) {
				System.out.println(s);
			}
	}

}
