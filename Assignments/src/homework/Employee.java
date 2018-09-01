package homework;

import java.util.Comparator;

public class Employee {
	private String name;
	private int age;
	private String Department;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, int age, String department) {
		super();
		this.name = name;
		this.age = age;
		Department = department;
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

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", Department=" + Department + "]";
	}
}
