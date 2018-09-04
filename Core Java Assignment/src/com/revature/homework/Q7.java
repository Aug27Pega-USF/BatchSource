package com.revature.homework;

import java.util.*;

public class Q7 {
	void compareEmployees() {
		
		System.out.println("Q7: Sorting employees by name, department, and age.");
		ArrayList<Employee> people = new ArrayList<Employee>();
		
		//Create new employees
		people.add(new Employee("Julian", "Human Resources", 24));
		people.add(new Employee("Peter", "Customer Service", 30));
		people.add(new Employee("Ananda", "Finance", 26));
		
		System.out.println("Unsorted employees.");
		for(int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		} // Show the employees as they were added

		Collections.sort(people, new Sortbyage());

		System.out.println("\nSorted by age.");
		for(int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		} // Show the employees sorted by age

		Collections.sort(people, new Sortbyname());

		System.out.println("\nSorted by name.");
		for(int i = 
				0; i < people.size(); i++) {
			System.out.println(people.get(i));
		} // Show the employees sorted by name
		
		Collections.sort(people, new Sortbydepartment());
		
		System.out.println("\nSorted by department.");
		for(int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		} // Show the employees sorted by department
		
		System.out.println();
	}

	class Employee {
		int age;
		String name, department;
	
		public Employee(String name, String department, int age) {
			this.name = name;
			this.department = department;
			this.age = age;
		}
	
		public String toString() {
			return this.name + " works in " + this.department + " and is " + this.age + " years old.";
		}
	}
	
	class Sortbyage implements Comparator<Employee>
	{
	    // Used for sorting in ascending order of age
	    public int compare(Employee a, Employee b)
	    {
	        return a.age - b.age;
	    }
	}
	 
	class Sortbyname implements Comparator<Employee>
	{
	    // Used for sorting in ascending order of name
	    public int compare(Employee a, Employee b)
	    {
	        return a.name.compareTo(b.name);
	    }
	}
	
	class Sortbydepartment implements Comparator<Employee>
	{
	    // Used for sorting in ascending order of name
	    public int compare(Employee a, Employee b)
	    {
	        return a.department.compareTo(b.department);
	    }
	}
}