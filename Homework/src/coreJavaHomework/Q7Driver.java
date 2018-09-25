package coreJavaHomework;

import java.util.ArrayList;
import java.util.Collections;

public class Q7Driver {
	public static void main(String[] args) {
		ArrayList<Q7Employee> empList = new ArrayList<Q7Employee>();
		empList.add(new Q7Employee ("Andrew Jackson","History",57));
		empList.add(new Q7Employee("Ben Franklin","Astronomy",63));	
		System.out.println("Unsorted");
		for (int i=0;i<empList.size();i++)
			System.out.println(empList.get(i));
		System.out.println("===========================================");
		Collections.sort(empList, new Q7EmployeeComparatorName());
		System.out.println("Sorted by Name");
		for (Q7Employee s:empList) {
			System.out.println(s);
		System.out.println("===========================================");
		Collections.sort(empList, new Q7EmployeeComparatorDept());
		System.out.println("Sorted by Dept");
		for (Q7Employee s:empList) 
			System.out.println(s);
		}
	}
}

