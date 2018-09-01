package homework;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{
	public int compare(Employee arg0, Employee arg1) {
		return (arg0.getAge() - arg1.getAge());
	}
}
