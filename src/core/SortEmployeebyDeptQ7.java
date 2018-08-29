package core;

import java.util.Comparator;

class SortEmployeebyDeptQ7 implements Comparator<Q7Employee>{
    public int compare(Q7Employee a, Q7Employee b)
    {
    	return a.getDepartment().compareTo(b.getDepartment());
    }
}
