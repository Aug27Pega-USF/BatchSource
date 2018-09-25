import java.util.Comparator;
/*
 * Q7. Sort two employees based on their name, department, and age using the Comparator interface.
 */
public class Q7 {

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
		
		public Q7(String name, String department, int age) {
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


	class SortQ7 implements Comparator<Q7Employee>{
	    public int compare(Q7Employee a, Q7Employee b)
	    {
	    	return a.getAge()-b.getAge();
	    }
	}

	class SortQ7 implements Comparator<Q7Employee>{
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

