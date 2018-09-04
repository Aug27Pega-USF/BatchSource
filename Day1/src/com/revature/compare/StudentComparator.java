package com.revature.compare;

import java.util.Comparator;
//Method 2
//External class than implements Comparator

public class StudentComparator implements Comparator<Student> {
	//implement compare() from the Compare interface 
	//Comparing the GPA
	public int compare(Student arg0, Student arg1) {
		return (int)(arg0.getGpa() - arg1.getGpa());
	}

}
