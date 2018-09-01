package homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	//Q1) bubble sort
	public static void bubbleSort(int[] a) {
		int len = a.length;
		for(int i = 0; i<len-1; i++){
			for(int j = 0; j<len-i-1; j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
				}
			}
		}
	}
	//Q2) Fibonacci
	public static int fibo(int n) {
		if(n<=1)
			return n;
		else return fibo(n-1) + fibo(n-2);
	}
	//Q3) String Reversal
	public static String flipIt(String n) {
		if (n.length() == 0) 
	         return n;

	    return flipIt(n.substring(1)) + n.charAt(0);
	}
	//Q4) Factorial
	public static int factorial(int n) {
		int i = 1;
		int prod = 1;
		for(i = 1; i<=n; i++) {
			prod = prod*i;
		}
		return prod;
	}
	
	//Q5) Substring without using it
	public static String subStr(String s, int index) {
		String news = "";
		for(int i = 0; i<index-1; i++) {
			news += s.charAt(i);
		}
		return news;
	}
	//Q6) Even, No Mod!
	public static void evenNoMod(int n) {
		
		if(((n / 2) *2) == n)
			System.out.println("even");
		else
			System.out.println("odd");
	}
	//Q8) Palendrome ArrayList
	public static boolean isPalindrome(String s) {
		String rev = "";
		for(int i = s.length()-1; i>=0; i--) {
			rev = rev + s.charAt(i);
		}
		if(s.equals(rev))
			return true;
		else return false;
	}
	
	//Q9) Prime number
	public static boolean isPrime(int n) {
		for(int i = 2; i <= n/2; ++i) {
			
			if(n % i == 0)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] q1 = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(q1);
		for(int i: q1)
			System.out.print(q1[i] + " ");
		System.out.println();
		
		int q2 = 25;
		for(int i = q2; i>=0; i--)
		{
			System.out.print(fibo(i) + " ");
		}
		System.out.println();
		
		String q3 = "dlroW olleH"; 
		System.out.println(flipIt(q3));
		
		int q4 = 10;
		System.out.println(factorial(q4));
		
		String q5 = "We'll go together!";
		System.out.println(subStr(q5, 8));
		
		int q6 = 46;
		evenNoMod(q6);
		
		ArrayList<String> q8v1 = new ArrayList<String>();
		q8v1.add("karan");
		q8v1.add("madam");
		q8v1.add("tom");
		q8v1.add("civic");
		q8v1.add("radar");
		q8v1.add("jimmy");
		q8v1.add("kayak");
		q8v1.add("john");
		q8v1.add("refer");
		q8v1.add("billy");
		q8v1.add("did");
		
		ArrayList<String> q8v2 = new ArrayList<String>();
		
		for(String i: q8v1) {
			if(isPalindrome(i)) {
				q8v2.add(i);
			}
				
		}
		System.out.println(Arrays.toString(q8v2.toArray()));
		
		ArrayList<Integer> q9 = new ArrayList<Integer>();
		for(int i = 0; i<=100; i++)
		{
			q9.add(i);
			//System.out.print(q9.get(i));
		}
		for(int x : q9) {
			if(!isPrime(x))
				System.out.print(x + " ");
		}
		System.out.println();
		
		//Q10 Ternary Operator
		int a = 10;
		int b = 15;
		int q10 = (b<a) ? b:a;
		System.out.println(q10);
		//Q12 Even Number
		int[] q12 = new int[100]; 
		for(int i = 0; i<100; i++)
		{
			q12[i] = (i+1);
			//q9.add(i);
			//System.out.print(q12[i]);
		}
		for(int x : q12) {
			if(x % 2 == 0)
				System.out.print(x + " ");
		}
		//Question 16: command line string length
		System.out.println("Question 16: String basketball length: " + args[0].length());
	}
}
