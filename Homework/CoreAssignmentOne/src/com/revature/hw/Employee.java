/*
 * Created 3 Different nested static classes for access to private member variables
 * ageCompartor, nameComparator, departmentComparator
 * using generics to avoid casting
 */
package com.revature.hw;
import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	private String department, name;
	private int age;
	
	//Compare Names
	public static final Comparator<Employee> nameComparator = new Comparator<Employee>(){

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareTo(o2.name); 
        }
       
    };

    //Compare Ages
	public static final Comparator<Employee> ageComparator = new Comparator<Employee>(){

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.age - o2.age;  // This will work because age is positive integer
        }
       
    };
    
    //Compare Departments
    public static final Comparator<Employee> departmentComparator = new Comparator<Employee>() {
    	@Override
    	public int compare(Employee o1,Employee o2) {
    		return o1.department.compareTo(o2.department);
    	}
    };
	Employee(String name, int age, String department){
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
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public int compare(Employee o1, Employee o2) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
	

