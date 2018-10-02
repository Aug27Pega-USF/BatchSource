/*
 * QUESTION 7
 * Employee Class for creating instances of employees to compare and sort in a collection
 * Comparator objects implemented as nested inner classes for access to private member variables
 * ageCompartor, nameComparator, departmentComparator
 * 
 *
 */
package com.revature.beans;
import java.util.Comparator;

public class Employee {

	private String department, name;
	private int age;
	
	//Compare Names
	public static final Comparator<Employee> NameComparator = new Comparator<Employee>(){
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareTo(o2.name); 
        }
       
    };

    //Compare Ages
	public static final Comparator<Employee> AgeComparator = new Comparator<Employee>(){
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.age - o2.age;  // This will work because age is positive integer
        }
       
    };
    
    //Compare Departments
    public static final Comparator<Employee> DepartmentComparator = new Comparator<Employee>() {
    	@Override
    	public int compare(Employee o1,Employee o2) {
    		return o1.department.compareTo(o2.department);
    	}
    };
	
	public Employee(String name, int age, String department){
		this.name = name;
		this.age = age;
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name= " + name + " age= " + age + " department= " + department + "]";
	}

}
	

