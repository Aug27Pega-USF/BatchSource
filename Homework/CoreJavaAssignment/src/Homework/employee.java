package Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class employee {
	
	void comparison()
	{
	 ArrayList<Employee> emp = new ArrayList<Employee>();
	 emp.add(new Employee(25,"Bob","Math"));
	 emp.add(new Employee(27, "Jim", "Soccer"));
	 emp.add(new Employee(28, "Alice", "Technology"));
	 
	 //sort by name
	 Collections.sort(emp, new Sortbyname());
     System.out.println("\nSorted by Name");
     for (int i=0; i<emp.size(); i++)
         System.out.println(emp.get(i));
     
     //sort by dept
	 Collections.sort(emp, new Sortbydepartment());
     System.out.println("\nSorted by Department");
     for (int i=0; i<emp.size(); i++)
         System.out.println(emp.get(i));
     
     //sort by age
	 Collections.sort(emp, new Sortbyage());
     System.out.println("\nSorted by Age");
     for (int i=0; i<emp.size(); i++)
         System.out.println(emp.get(i));
     
     System.out.println();
     
	 
	}
	class Employee
	{
		String name;
		String department;
		int age;
		public Employee(int age, String name, String department)
		{
			this.age = age;
			this.name = name;
			this.department = department;
		}
		public String toString()
	    {
	        return this.name + " " + this.age +
	                           " " + this.department;
	    }
	}
	
    // Used to print student details in main()
    
    class Sortbyname implements Comparator<Employee>
    {
    	//compare the names 
    	public int compare(Employee a, Employee b)
    	{
    		return a.name.compareTo(b.name);
    	}
    }
    class Sortbydepartment implements Comparator<Employee>
    {
    	//compare the departments
    	public int compare(Employee a, Employee b)
    	{
    		return a.department.compareTo(b.department);
    	}
    }
    class Sortbyage implements Comparator<Employee>
    {
    	public int compare(Employee a, Employee b)
    	{
    		return a.age - b.age;
    	}
    }

}
