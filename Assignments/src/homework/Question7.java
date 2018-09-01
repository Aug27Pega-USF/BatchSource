package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Question7{ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> emp = new ArrayList<Employee>();
		
		emp.addAll(Arrays.asList(
				new Employee[] {
					new Employee("Tim", 45, "Human Resources"), 
					new Employee("Audrey", 40, "Maintenance")}));
		System.out.println("Original");
		emp.forEach(System.out::println);
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println("Sort by age");
		Collections.sort(emp, new EmployeeComparator());
		for(Employee s : emp) {
			System.out.println(s);
		}
		System.out.println("Sort by Dept:");
		Comparator<Employee> empDeptComparator = (Employee emp1, Employee emp2) -> {
		      return (emp1.getDepartment().compareTo(emp2.getDepartment()));
		    };
		    Collections.sort(emp, empDeptComparator);
		    emp.forEach(System.out::println);
		System.out.println("Sort by name");
	    Comparator<Employee> empNameComparator = (Employee emp1, Employee emp2) -> {
		      return (emp1.getName().compareTo(emp2.getName()));
		    };
		    Collections.sort(emp, empNameComparator);
		    emp.forEach(System.out::println);
//		Comparator<Employee> empAgeComparator = (Employee emp1, Employee emp2) -> {
//		      return emp1.getAge()-emp2.getAge();
//		    };
//		    Collections.sort(emp, empAgeComparator);
//		    Collections.sort(emp);
//			for(Employee s : emp) {
//				System.out.println(s);
//			}
		   // emp.forEach(System.out::println);
	}

}
