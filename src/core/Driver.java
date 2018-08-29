package core;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {
		Q1BubbleSort q1bubble= new Q1BubbleSort();
		System.out.println("Q1: BubbleSort");
		int[] q1arr = {1,0,5,6,3,2,3,7,9,8,4};
		q1bubble.bubblesort(q1arr);
		System.out.println();
		
		Q2Fibonacci q2fib= new Q2Fibonacci();
		System.out.println("Q2: Fibonacci");
		q2fib.Fib(25);
		System.out.println();
		
		Q3Reversestring q3rev = new Q3Reversestring();
		System.out.println("Q3: Reverse String");
		q3rev.reversal("Q3: Reverse string");
		System.out.println();
		
		Q4Factorial q4fac = new Q4Factorial();
		System.out.println("Q4: Factorial");
		q4fac.facto(6);
		q4fac.facto(10);
		System.out.println();
		
		Q5Substring q5sub= new Q5Substring();
		System.out.println("Q5: Substring");
		String sub= q5sub.substr("Substring",3);
		System.out.println("Substring is: \""+sub+"\"");
		String sub2= q5sub.substr("Short string",15);
		System.out.println("Substring is: \""+sub2+"\"");
		System.out.println();
		
		Q6DetermineEven q6even= new Q6DetermineEven();
		System.out.println("Q6: Modulus Free Even");
		q6even.modulofree(3535257);
		q6even.modulofree(257341156);
		System.out.println();
		
		
		ArrayList<Q7Employee> q7arr= new ArrayList<Q7Employee>();
		System.out.println("Q7: Employees Comparator");
		q7arr.add(new Q7Employee("Frank", "Accounting", 36));
		q7arr.add(new Q7Employee("Alfred", "Manager", 45));
		System.out.println("Unsorted");
        for (int i=0; i<q7arr.size(); i++) {
            System.out.println(q7arr.get(i).getName()+" "+ q7arr.get(i).getDepartment()+ " " +q7arr.get(i).getAge());
            }
        Collections.sort(q7arr, new SortEmployeebyNameQ7());
        System.out.println();
        System.out.println("Soted by Name");
        for (int i=0; i<q7arr.size(); i++) {
        	System.out.println(q7arr.get(i).getName()+" "+ q7arr.get(i).getDepartment()+ " " +q7arr.get(i).getAge());
            }            
        Collections.sort(q7arr, new SortEmployeebyDeptQ7());
        System.out.println();
        System.out.println("Sorted by Dept");
        for (int i=0; i<q7arr.size(); i++) {
        	System.out.println(q7arr.get(i).getName()+" "+ q7arr.get(i).getDepartment()+ " " +q7arr.get(i).getAge());
            } 
        Collections.sort(q7arr, new SortEmployeebyAgeQ7());
        System.out.println();
        System.out.println("Sorted by Age");
        for (int i=0; i<q7arr.size(); i++) {
        	System.out.println(q7arr.get(i).getName()+" "+ q7arr.get(i).getDepartment()+ " " +q7arr.get(i).getAge());
            }       
		System.out.println();
		
		Q8Palindrome q8pal=new Q8Palindrome();
		System.out.println("Q8: Palindrome");
		q8pal.Q8();
		System.out.println();
		
		Q9PrimeNumbers q9pri=new Q9PrimeNumbers();
		System.out.println("Q9: Prime Numbers");
		q9pri.Q9();
		System.out.println();
		
		Q10TernaryLess q10les=new Q10TernaryLess();
		System.out.println("Q10: Ternary Less");
		System.out.println("Minimum of 10 and 12:");	
		System.out.println(q10les.minimum(10, 12));
		System.out.println("Minimum of -5 and -8");
		System.out.println(q10les.minimum(-5, -8));
		System.out.println(); 
		
		Q11PackageAccessor q11pac=new Q11PackageAccessor();
		System.out.println("Q11: Access Floats in another Package");
		System.out.println(q11pac.floatadd());
		System.out.println();
		
		Q12EvenNumbers q12eve=new Q12EvenNumbers();
		System.out.println("Q12: Even Numbers via Enhanced For Loop");
		q12eve.Q12();
		System.out.println();
		
		Q13TriangleLoop q13tri=new Q13TriangleLoop();
		System.out.println("Q13: Triangle Loop");
		q13tri.Q13();
		System.out.println();
		
		
		
		
		Q19ArrayListStuff q19arr=new Q19ArrayListStuff();
		System.out.println("Q19: Array List Manipulation");
		q19arr.Q19();
		System.out.println();
		
	}

}
