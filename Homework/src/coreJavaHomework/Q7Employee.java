package coreJavaHomework;

public class Q7Employee{
	private String name;
	private String dept;
	private int age;

	public Q7Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
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
}

