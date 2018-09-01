package com.driver.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import com.driver.employee.Employee;

public class Q7 {
	/*
	 * Q7: Sort two employees based on their name, department, and age using the Comparator interface.
	 */
	public static void question() {
		
		ArrayList<Employee> e = new ArrayList<Employee>();
        e.add(new Employee("Steve", "HR", 28));
        e.add(new Employee("Roger", "IT", 20));
        
        //show unsorted employees
        System.out.println("Employees: ");
        for(int i = 0; i < e.size(); i++) {
        	System.out.println(e.get(i).getName() + ", " + e.get(i).getDepartment() + ", " + e.get(i).getAge());
        }
        
		//do collection sorts
        Collections.sort(e, new SortByName());
        System.out.println("");
        System.out.println("Sorted by Name: ");
        for(Employee employee: e) {
        	System.out.println(employee);
        }
        
        Collections.sort(e, new SortByDept());
        System.out.println("");
        System.out.println("Sorted by Department: ");
        for(Employee employee: e) {
        	System.out.println(employee);
        }
        
        Collections.sort(e, new SortByAge());
        System.out.println("");
        System.out.println("Sorted by Age: ");
        for(Employee employee: e) {
        	System.out.println(employee);
        }
	}
}

//Comparators
class SortByName implements Comparator<Employee>
{
  // Used for sorting in ascending order of
  // roll name
  public int compare(Employee e1, Employee e2)
  {
      return e1.getName().compareTo(e2.getName());
  }
}

class SortByDept implements Comparator<Employee>
{
  // Used for sorting in ascending order of
  // roll name
  public int compare(Employee e1, Employee e2)
  {
      return e1.getDepartment().compareTo(e2.getDepartment());
  }
}

class SortByAge implements Comparator<Employee>{
	public int compare(Employee e1, Employee e2) {
		return e1.getAge() - e2.getAge();
	}
}
