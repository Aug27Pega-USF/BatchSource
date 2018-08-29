package core;

import java.util.Comparator;

class SortEmployeebyNameQ7 implements Comparator<Q7Employee>{
    public int compare(Q7Employee a, Q7Employee b)
    {
    	return a.getName().compareTo(b.getName());
    }
}
