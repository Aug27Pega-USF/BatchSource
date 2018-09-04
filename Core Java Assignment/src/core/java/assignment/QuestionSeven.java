package core.java.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuestionSeven {
	public ArrayList<Employee> empList = new ArrayList<Employee>();
	
	public void addEmp(String name, String department, int age) {
		empList.add(new Employee(name, department, age));
	}
	
	public void printList() {
		for(int i = 0; i < empList.size(); i++) {
			System.out.println(empList.get(i));
		}
	}
	
	public void SortName() {
		Collections.sort(empList, new SortByName());
	}
	
	public void SortDepartment() {
		Collections.sort(empList, new SortByDepartment());
	}
	
	public void SortAge() {
		Collections.sort(empList, new SortByAge());
	}
	
	class Employee{
		String name;
		String department;
		int age;
		
		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		public String toString() {
			return this.name + "\t\t " + this.department + "\t\t " + this.age;
		}
	}
	
	class SortByName implements Comparator<Employee>
	{
	    public int compare(Employee a, Employee b)
	    {
	        return a.name.compareTo(b.name);
	    }
	}
	
	class SortByDepartment implements Comparator<Employee>
	{
	    public int compare(Employee a, Employee b)
	    {
	        return a.department.compareTo(b.department);
	    }
	}
	
	class SortByAge implements Comparator<Employee>
	{
	    public int compare(Employee a, Employee b)
	    {
	        return a.age - b.age;
	    }
	}
}
