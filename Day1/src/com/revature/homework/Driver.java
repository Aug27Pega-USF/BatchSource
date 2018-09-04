package com.revature.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.revature.homework.BasicMath.myMath;
import com.revature.homework.floats.Floats;

public class Driver {

	private static String[] s;

	public static void main(String[] args) {
		// Q1
		int arrayQ1[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		myBubbleSort bs = new myBubbleSort();
		bs.BubbleSort(arrayQ1);
		System.out.print("Q1 Bubblesorted array: ");
		bs.printArray(arrayQ1);

		// Q2 with 25 hard coded
		Fib fib = new Fib();
		System.out.print("Q2 First 25 Fibonacci: ");
		for (int i = 0; i < 25; i++) {
			System.out.print(fib.myFib(i) + ",");
		}
		// Q3
		System.out.print("\nQ3 Reverse a String: ");
		String reversed = "Hello";
		ReverseAString rev = new ReverseAString();
		rev.reverseString(reversed);

		// Q4 n factorial
		System.out.print("\nQ4 5!: ");
		Factorial factorial = new Factorial();
		int result = factorial.myFactorial(5);
		System.out.println(result);

		// Q5 Return substring from 0 to idx
		System.out.print("Q5 Return a substring: ");
		int idx = 5;// Expected return at idx =5: Omele
		Substring sub = new Substring();
		String str = "Omelette du fromage";
		sub.returnSubstring(str, idx);

		// Q6 Is an integer even?
		int n = 6;
		// I have not figured out why I don't need this constructor
		// IsEven isEven = new IsEven();
		if (IsEven.isEven(n) != false) {
			System.out.println(n + " is Even");
		} else
			System.out.print("Q6 Is your Integer " + n + " even?: " + n + " is Odd");

		// Q7 Comparator: Name, Department, Age
		System.out.print("\nQ7 Employee comparators: ");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(new Employee[] { 
				new Employee("Zuul", "Gatekeeping", 34),
				new Employee("Vinz Clortho", "Keymaster", 32), 
				new Employee("Gozer", "Destruction", 8000) }));
		
		Collections.sort(employeeList, (arg0, arg1)
				->{return arg0.getName().compareTo(arg1.getName());}
				);
		System.out.print("\nSorted by name: ");
		for(Employee s: employeeList) {
			System.out.print(s);
			}
		
		Collections.sort(employeeList, (arg0, arg1)
				->{return arg0.getDepartment().compareTo(arg1.getDepartment());}
				);
		System.out.print("\nSorted by department: ");
		for(Employee s: employeeList) {
			System.out.print(s);
			}
		System.out.print("\nSorted by Age: ");		
		Collections.sort(employeeList,  new EmployeeComparator());
		for(Employee s: employeeList) {
			System.out.print(s);
			}		

		//Q8 Store palindromes in another array
		//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”,“kayak”, “john”,  “refer”, “billy”, “did”
		System.out.print("\nQ8 : ");
		String[] stringList = {"karan", "madam", "tom", "civic", "radar", "jimmy","kayak", "john",  "refer", "billy", "did"};
		//List test = Arrays.asList(stringList); Could have used this
		ArrayList<String> originalList = new ArrayList<String>();
		Palindrome pal = new Palindrome();
		for (String palinstr:stringList) {
			originalList.add(palinstr);
		}
		System.out.print(pal.isPalindrome(originalList));
		
		//Q9 Prime numbers between 1-100
		ArrayList<Integer> prime = new ArrayList<Integer>();
		for (int i=1; i<101; i++) {
			prime.add(i);
		}
		Prime primes = new Prime();
		
		System.out.print("\nQ9 primes under 100: " +primes.myPrime(prime));
		
		//Q10 Get min value
		MinValue min = new MinValue();
		int myMinValue = min.getMinValue(5, 100);
		System.out.print("\nQ10 Minvalue is: " + myMinValue);
		
		//Q11 floats and packages
		System.out.print("\nQ11 Returning floats from another package:"+
				Floats.floatone + "," + Floats.floattwo);
		
		//Q12 1-100 Enhanced for loop
		Enhanced loop = new Enhanced();
		int arr [] = new int[100];
		for (int i=0; i<100; i++) {
			arr[i] = i+1;
		}
		System.out.print("\nQ12 Evens in 100:");
		loop.myLoop(arr);
		
		//Q13 Bit Triangle
		System.out.println("\nQ13 TRIANGLE: ");
		TriangleBits tri = new TriangleBits();
		tri.PrintTriangleBits();
		
		//Q14 Runs a few times to get different sqrt cases
		GrabASwitch switched = new GrabASwitch();
		System.out.println("Q14: Switch case:1 sqrt, case:2 Date, case:3 String split");
		for (int x=1; x < 10000; x+=1801) {			
			switched.smallSwitch(x);
			System.out.println();
			
		//Q15 Math
		myMath moth = new myMath();
		//I had to change myMath to static, not completely sure why yet
		System.out.println("Adding 10 and 20: " + moth.addition(10, 20));
		System.out.println("Subtracting 10 - 20: " + moth.subtraction(10, 20));
		System.out.println("Multiplying 10 and 20: " + moth.multiplication(10, 20));
		System.out.println("Dividing 10 by 20: " + moth.division(10, 20));
		
		//Q16 String length with main method

		StringLength.main(args);
		
		//Q17
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter principal, rate and time(years): ");
        double principal=sc.nextDouble();
        double rate=sc.nextDouble();
        double time=sc.nextDouble();
        SimpleInterest interest = new SimpleInterest();
        System.out.println("\n Q17" + interest.returnInterest(principal, rate, time));
        
        //Q18 
        Q18 q = new myQ18();
        String ucase = "UPPER";
        String lcase = "lower";
        String temp = q.makeUppercase(ucase);
        System.out.println(temp);
		}
		
	}
}
