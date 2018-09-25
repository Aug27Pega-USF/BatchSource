package coreJavaHomework;

import java.util.Comparator;

public class Q7EmployeeComparatorName implements Comparator<Q7Employee>{

	public int compare(Q7Employee arg0, Q7Employee arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}
}