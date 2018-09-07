package com.revature.compare;

import java.util.Comparator;

//Method 2 of Comparing
// External class than implements Comparator

public class StudentComparator implements Comparator<Student> {
	
	// Implement compare() from the Comparator interface
	// Comparing GPAs
	public int compare(Student arg0, Student arg1) {
		return(int)(arg0.getGpa() - arg1.getGpa());
	}
}
