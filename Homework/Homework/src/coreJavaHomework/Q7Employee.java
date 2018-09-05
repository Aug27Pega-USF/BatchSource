package coreJavaHomework;

import java.util.Comparator;

public class Q7Employee{
	private String name;
	private String dept;
	private int age;
	
	public Q7Employee(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}
	public int Q7EmployeeComparator(Q7Employee arg0, Q7Employee arg1) {
		return arg0.getAge() - arg1.getAge();
	}
	
}
class SortByName implements Comparator <Q7Employee>{
	public int compare (Q7Employee arg0, Q7Employee arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}
}
class SortByDept implements Comparator <Q7Employee>{
	public int compare (Q7Employee arg0, Q7Employee arg1) {
		return arg0.getDept().compareTo(arg1.getDept());
	}
}
class SortByAge implements Comparator <Q7Employee>{
	public int compare (Q7Employee arg0, Q7Employee arg1) {
		return (int) (arg0.getAge() - arg1.getAge());
	}
}
