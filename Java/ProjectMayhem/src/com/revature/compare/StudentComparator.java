package com.revature.compare;

import java.util.Comparator;

//Method2 of comparing
//External class that implements Comparator
public class StudentComparator implements Comparator<Student>{
	//implement this method from the Comparator Interface-Comparing GPAs
	@Override
	public int compare(Student arg0, Student arg1) {
		return (int)(arg0.getGpa() - arg1.getGpa());
	}

}
