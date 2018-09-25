package coreJavaHomework;

import java.util.Comparator;

public class Q7EmployeeComparatorDept implements Comparator<Q7Employee>{
	public int compare(Q7Employee arg0, Q7Employee arg1) {
	return arg0.getDept().compareTo(arg1.getDept());
	}
}
