package com.revature.hw;

public class Driver {

	public static void main(String[] args) {
		
		Q1BubbleSort ob = new Q1BubbleSort();
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		ob.BubbleSort(arr);
		System.out.println("Q1 Bubble Sorting");
		System.out.println("-----------------");
		PrintArray(arr);
		
		Q2Fibonacci fb = new Q2Fibonacci();
		int[] farr = new int[25];
		farr[0]=0;
		farr[1]=1;
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
		int num1 =6;
		int num2 =7;
		int num3 =8;
		int num4 =9;
		int num5 =10;
		f.GetFactorial(num);
		f.GetFactorial(num1);
		f.GetFactorial(num2);
		f.GetFactorial(num3);
		f.GetFactorial(num4);
		f.GetFactorial(num5);
		System.out.println("========================================");
		
	}

	private static void PrintArray(int[] arr) {
		int l = arr.length;
		for(int i = 0; i < l;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("========================================");
		
	}

}
