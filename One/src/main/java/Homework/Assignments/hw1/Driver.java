package Homework.Assignments.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Q1BubbleSort q1bubble= new Q1BubbleSort();
		System.out.println("Q1: BubbleSort");
		int[] q1arr = {1,0,5,6,3,2,3,7,9,8,4};
		q1arr=q1bubble.bubblesort(q1arr);
		System.out.print("[");
		for (int i=0; i!=10;i++) {
			System.out.print(q1arr[i]+ ",");
		}
		System.out.print(q1arr[10]+"]");
		System.out.println();
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
		System.out.println("6!="+ q4fac.facto(6));
		System.out.println("10!="+ q4fac.facto(10));
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
		
		
		List<Q7Employee> q7arr= new ArrayList<Q7Employee>();
		System.out.println("Q7: Employees Comparator");
		q7arr.add(new Q7Employee("Frank", "Accounting", 36));
		q7arr.add(new Q7Employee("Alfred", "Manager", 45));
		q7arr.add(new Q7Employee("Balnor","Sandwich Protector",40));
		System.out.println("Unsorted");
        for (Q7Employee c: q7arr) {
        	System.out.println(c.toString());
        }
        Collections.sort(q7arr, new SortEmployeebyNameQ7());
        System.out.println();
        System.out.println("Soted by Name");
        for (Q7Employee c: q7arr) {
        	System.out.println(c.toString());
        }
        Collections.sort(q7arr, new SortEmployeebyDeptQ7());
        System.out.println();
        System.out.println("Sorted by Dept");
        for (Q7Employee c: q7arr) {
        	System.out.println(c.toString());
        }
        Collections.sort(q7arr, new SortEmployeebyAgeQ7());
        System.out.println();
        System.out.println("Sorted by Age");
        for (Q7Employee c: q7arr) {
        	System.out.println(c.toString());
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
		
		Q14Switch q14swi = new Q14Switch();
		System.out.println("Q14: Switch (Input 1 is sqrt, Input 2 is Date, Input 3 is String Array");
		for (int x=1; x < 10000; x+=1801) {
			System.out.println("Input: " + x +"->"+x+"%3+1=" +((x%3)+1));
			q14swi.q14switch(x);
			System.out.println();
		}
		
		System.out.println("Q15: Interface Operators. INPUT REQUIRED!");
		Q15Tester.main(null);
		System.out.println();
		
		System.out.println("Q16: String Length. (This test looks at String given to Driver Class.)");
		Q16StringLength.main(args);
		System.out.println();
		

		System.out.println("Q17: Interest. INPUT REQUIRED!");
		Q17Interest.main(null);
		System.out.println();
		
		System.out.println("Q18: Abstract Class and Concrete Subclass");
		Q18Abstractclass q18abs = new Q18subclass();
		System.out.println("Test Line 1: \"i am lowercase\"");
		System.out.println("Test Line 2: \"Abstract Class\"");
		System.out.println();
		System.out.println("Check Uppercase Function:");
		System.out.println(q18abs.uppercasecheck("i am lowercase"));
		System.out.println(q18abs.uppercasecheck("Abstract Class"));
		System.out.println();
		System.out.println("Set to Uppercase Function:");
		System.out.println(q18abs.makeUppercase("i am lowercase"));
		System.out.println(q18abs.makeUppercase("Abstract Class"));
		System.out.println();
		System.out.println("Input \"18\" to add10 function:");
		q18abs.add10("18");
		System.out.println();
		
		Q19ArrayListStuff q19arr=new Q19ArrayListStuff();
		System.out.println("Q19: Array List Manipulation");
		q19arr.Q19();
		System.out.println();
		
		Q20FileInterpreter q20fil= new Q20FileInterpreter();
		System.out.println("Q20: File Reader");
		q20fil.Q20();
		
		
	}

}
