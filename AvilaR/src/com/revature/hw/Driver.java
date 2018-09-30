package com.revature.hw;

import java.util.ArrayList;

import com.revature.hw2.Q11NameSpaceFloats;

public class Driver {

	public static void main(String[] args) {

		Q1BubbleSort ob = new Q1BubbleSort();
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		ob.BubbleSort(arr);
		System.out.println("Q1 Bubble Sorting");
		System.out.println("-----------------");
		PrintArray(arr);

		Q2Fibonacci fb = new Q2Fibonacci();
		int[] farr = new int[25];
		farr[0] = 0;
		farr[1] = 1;
		fb.Fibonacci(farr);
		System.out.println("Q2 Fibonacci Numbers");
		System.out.println("--------------------");
		PrintArray(farr);

		System.out.println("Q3 Reversing a String");
		Q3StringReverse sr = new Q3StringReverse();
		String str = "friends";
		System.out.println("--------------------");
		System.out.println(str);
		str = sr.StringReverse(str);
		System.out.println("--------------------");
		System.out.println(str);
		System.out.println("========================================");

		System.out.println("Q4 N Factorial");
		System.out.println("--------------------");
		Q4Factorial f = new Q4Factorial();
		int num = 5;
		int num1 = 6;
		int num2 = 7;
		int num3 = 8;
		int num4 = 9;
		int num5 = 10;
		f.GetFactorial(num);
		f.GetFactorial(num1);
		f.GetFactorial(num2);
		f.GetFactorial(num3);
		f.GetFactorial(num4);
		f.GetFactorial(num5);
		System.out.println("========================================");

		System.out.println("Q5 SubString Method");
		System.out.println("--------------------");
		Q5SubString sub = new Q5SubString();
		String string = "This is how we do it, it is friday night";
		System.out.println("String being passed in: " + string);
		System.out.println("substring at 4: " + sub.subString(string, 4));
		System.out.println("substring at 10: " + sub.subString(string, 10));
		System.out.println("substring at 5: " + sub.subString(string, 5));
		System.out.println("substring at 25: " + sub.subString(string, 25));
		System.out.println("========================================");

		System.out.println("Q6 Is Even Method");
		System.out.println("--------------------");
		Q6Even eve = new Q6Even();
		int n = 100;
		if (eve.Even(n)) {
			System.out.println(n + " is Even");
		} else {
			System.out.println(n + " is Odd");
		}
		int n1 = 55;
		if (eve.Even(n1)) {
			System.out.println(n1 + " is Even");
		} else {
			System.out.println(n1 + " is Odd");
		}
		int n2 = 20;
		if (eve.Even(n2)) {
			System.out.println(n2 + " is Even");
		} else {
			System.out.println(n2 + " is Odd");
		}
		System.out.println("========================================");

		System.out.println("Q7 Comparator");
		System.out.println("--------------------");

		System.out.println("========================================");

		System.out.println("Q8 Palidrome");
		Q8Palidrome pal = new Q8Palidrome();
		System.out.println("--------------------");
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		arr1.add("karan");
		arr1.add("madam");
		arr1.add("tom");
		arr1.add("civic");
		arr1.add("radar");
		arr1.add("jimmy");
		arr1.add("kayak");
		arr1.add("john");
		arr1.add("refer");
		arr1.add("billy");
		arr1.add("did");

		for (int i = 0; i < arr1.size(); i++) {
			if (pal.isPalindrome((String) arr1.get(i))) {
				arr2.add((String) arr1.get(i));
			}
		}
		System.out.println("Palindrome : " + arr2);
		System.out.println("========================================");
		
		
		System.out.println("Q9 Prime");
		System.out.println("--------------------");
		Q9PrimeNumbers pm = new Q9PrimeNumbers();
		pm.prime();
		System.out.println("========================================");
		
		
		System.out.println("Q10 Minimum");
		System.out.println("--------------------");
		Q10Minimum min = new Q10Minimum();
		min.minimum(5, 9);
		min.minimum(15, 36);
		min.minimum(50, 15);
		min.minimum(14, 9);

		System.out.println("========================================");
		
		System.out.println("Q11 NameSpaces");
		System.out.println("--------------------");
		float a = Q11NameSpaceFloats.Float();
		float b = Q11NameSpaceFloats.Float2();
		System.out.println("Float a: " + a + " Float b: " + b);

		System.out.println("========================================");
		
		System.out.println("Q12 Array of Ints");
		System.out.println("--------------------");
		Q12OneHundredPrint one = new Q12OneHundredPrint();
		one.storeNumber();

		System.out.println("========================================");

		System.out.println("Q13 Triangle of numbers");
		System.out.println("--------------------");
		Q13Triangle tri = new Q13Triangle();
		tri.triangle();

		System.out.println("========================================");
		
		System.out.println("Q14 Case Statements");
		System.out.println("--------------------");
		Q14Case c = new Q14Case();
		c.caseProb(1);
		c.caseProb(2);
		c.caseProb(3);
		
		System.out.println("========================================");
		
		System.out.println("Q15 Interfacing");
		System.out.println("--------------------");
		Q15Math inter = new Q15Math();
		inter.addition(5,5);
		inter.subtraction(5, 5);
		inter.multiplication(5, 5);
		inter.division(5, 5);
		
		System.out.println("========================================");

	}

	private static void PrintArray(int[] arr) {
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("========================================");

	}

}

