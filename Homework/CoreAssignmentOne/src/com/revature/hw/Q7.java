package com.revature.hw;

import java.util.ArrayList;
import java.util.Collections;

import com.revature.beans.Employee;

public class Q7 {

	static Employee emp1 = new Employee("David",36, "Human Resources");
	static Employee emp2 = new Employee("Matt", 32, "Training");
	static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	
    public static void sortAndPrint(){
    	employeeList.add(emp1);
        employeeList.add(emp2);
    	System.out.println("Sorted By Name: "+ "\n***************");
        Collections.sort(employeeList, Employee.NameComparator);
        Driver.printArrayList(employeeList);
        System.out.println("Sorted By Age: " + "\n***************");
        Collections.sort(employeeList, Employee.AgeComparator);
        Driver.printArrayList(employeeList);
        System.out.println("Sorted By Department: "+ "\n***************");
        Collections.sort(employeeList, Employee.DepartmentComparator);
        Driver.printArrayList(employeeList);
    }
    
	 
	    
}
