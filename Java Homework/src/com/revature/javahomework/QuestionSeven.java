package com.revature.javahomework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

	public class QuestionSeven {
		public List<Employee> empList = new ArrayList<Employee>();
		
		public void addEmp(String name, String department, int age) {
			empList.add(new Employee(name, department, age));
		}
		
		public List<Employee> printList() {
			return empList;
		}
		
		public List<Employee> SortName() {
			Collections.sort(empList, new SortByName());
			return empList;
		}
		
		public List<Employee> SortDepartment() {
			Collections.sort(empList, new SortByDepartment());
			return empList;
		}
		
		public List<Employee> SortAge() {
			Collections.sort(empList, new SortByAge());
			return empList;
		}
		
		public static class Employee{
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
