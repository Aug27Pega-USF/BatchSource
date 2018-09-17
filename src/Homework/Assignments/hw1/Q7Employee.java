package Homework.Assignments.hw1;

import java.util.Comparator;

public class Q7Employee {

	private String name;
	private String department;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Q7Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
	

}


class SortEmployeebyAgeQ7 implements Comparator<Q7Employee>{
    public int compare(Q7Employee a, Q7Employee b)
    {
    	return a.getAge()-b.getAge();
    }
}

class SortEmployeebyDeptQ7 implements Comparator<Q7Employee>{
    public int compare(Q7Employee a, Q7Employee b)
    {
    	return a.getDepartment().compareTo(b.getDepartment());
    }
}

class SortEmployeebyNameQ7 implements Comparator<Q7Employee>{
    public int compare(Q7Employee a, Q7Employee b)
    {
    	return a.getName().compareTo(b.getName());
    }
}
