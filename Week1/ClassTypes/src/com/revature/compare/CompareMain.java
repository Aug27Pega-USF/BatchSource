package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		
		List<Student> studentList= new ArrayList <Student>();
		
		studentList.addAll(Arrays.asList(
				new Student[] { 
							new Student(4,"Matt",6.7),
							new Student(97,"Julian", .3),
							new Student(78, "Vincent",3.9),
							new Student(63, "Tony", 4.0)
							}));
		//System.out.println(studentList);
		System.out.println("Original List");
		for(Student s: studentList)
		{
			System.out.println(s);
			
		}
		System.out.println("================================");
		System.out.println("Sorted by StudentID:");
		Collections.sort(studentList);
		for(Student s: studentList)
		{
			System.out.println(s);
			
		}
		System.out.println("================================");
		Collections.sort(studentList, new StudentComparator());
		System.out.println("Sort by GPA: ");
		for(Student s: studentList)
		{
			System.out.println(s);
			
		}
		
		//Sort with a Lambda- sort by name
		Collections.sort(studentList, (arg0,arg1)
				->{ return arg0.getName().compareTo(arg1.getName());}
				);
		System.out.println("Sort by Lambda: ");
		for(Student s: studentList)
		{
			System.out.println(s);
			
		}
	
			

		
		
	}

}
