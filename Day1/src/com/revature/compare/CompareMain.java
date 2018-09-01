package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student[] {
						new Student(10, "Matt", 6.7),
						new Student(7, "Julian", 0.3),
						new Student(3, "Vincent", 3.9),
						new Student(63, "Tony", 4.0)}));
		//System.out.println(studentList);
		for(Student s : studentList) {
			System.out.println(s);
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		Collections.sort(studentList);
		for(Student s : studentList) {
			System.out.println(s);
		}
		System.out.println("+++++++++===============================");
		Collections.sort(studentList, new StudentComparator());
		for(Student s : studentList) {
			System.out.println(s);
		}
		System.out.println("+++++++++++++++++======================");
		
		Collections.sort(studentList,(arg0,arg1)
				->{return arg0.getName().compareTo(arg1.getName());}
				);
		for(Student s : studentList) {
			System.out.println(s);
		}
		System.out.println("+++++++++++++++++++++++++++++++++++====");
	}

}
