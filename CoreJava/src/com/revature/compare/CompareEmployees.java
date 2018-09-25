package com.revature.compare;

import java.util.ArrayList;
import java.util.Collections;

public class CompareEmployees {

	public static void main(String[] args) {
		ArrayList<Employee> my_employee_list = new ArrayList<Employee>();
		my_employee_list.add(new Employee("Eddy", "Finance", 36));
		my_employee_list.add(new Employee("Bel", "Sales", 62));
		my_employee_list.add(new Employee("Al", "IT", 30));
		
		System.out.println("Original list: ");
		for(Employee e : my_employee_list) {
			System.out.println(e);
		}
		System.out.println("=====================");
		
		System.out.println("Sorted by age: ");
		Collections.sort(my_employee_list);
		for(Employee e : my_employee_list) {
			System.out.println(e);
		}
		

		System.out.println("Sorted by name: ");
		Collections.sort(my_employee_list, new Employee());
		for(Employee e : my_employee_list) {
			System.out.println(e);
		}
	}

}
