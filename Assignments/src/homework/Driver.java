package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public static String evenNoMod(int n) {
		
		if(((n / 2) *2) == n)
			//System.out.println("even");
			return "even";
		else
			//System.out.println("odd");
			return "odd";
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
		System.out.println("Question 1:");
		int[] q1 = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(q1);
		for(int i: q1)
			System.out.print(q1[i] + " ");
		System.out.println();
		System.out.println("Question 2:");
		List<Integer> q2ar = new ArrayList<Integer>();
		int q2 = 25;
		for(int i = q2; i>=0; i--)
		{
			q2ar.add(fibo(i));
			//System.out.print(fibo(i) + " ");
		}
		for (Integer i : q2ar)
			System.out.print(i);
		System.out.println();
		System.out.println("Question 3:");
		String q3 = "dlroW olleH"; 
		System.out.println(flipIt(q3));
		System.out.println("Question 4:");
		int q4 = 10;
		System.out.println(factorial(q4));
		System.out.println("Question 5:");
		String q5 = "We'll go together!";
		System.out.println(subStr(q5, 8));
		System.out.println("Question 6:");
		int q6 = 46;
		System.out.println(evenNoMod(q6));
		System.out.println("Question 8:");
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
		System.out.println("Question 9:");
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
		
		System.out.println("Question 10:");
		int a = 10;
		int b = 15;
		int q10 = (b<a) ? b:a;
		System.out.println(q10);
		System.out.println("Question 12:");
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
		System.out.println("\n");
		System.out.println("Question 19:");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(Integer i=1; i<=10; i++) {
			arr.add(i);
		}
		for(Integer j:arr)
			System.out.print(j + " ");
		Integer evensum = 0;
		Integer oddsum = 0;
		for(int i = 0; i<arr.size(); i++) {
			if(arr.get(i) % 2 == 0)
				evensum+=arr.get(i);
			else oddsum+=arr.get(i);
		}
		System.out.println("\n");
		System.out.println("All evens equal "+ evensum + " and all odds equal " + oddsum);
		System.out.println("\n");
		
		for(int i = 0; i<arr.size(); i++) {
			if(isPrime(arr.get(i)))
				arr.remove(i);
		}
		for(Integer j:arr)
			System.out.print(j);
		System.out.println("\n");
	}
}
