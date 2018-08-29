package core;

import java.util.Comparator;

class SortEmployeebyAgeQ7 implements Comparator<Q7Employee>{
    public int compare(Q7Employee a, Q7Employee b)
    {
    	return a.getAge()-b.getAge();
    }
}
