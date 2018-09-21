package com.driver.questions;

public class Q2 {
	/*
	 * Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
	 */
	public static void question (int steps) {

		String str = "";
		
		str = fibonacci(steps);
		
		System.out.println(str);
	}
	
	public static String fibonacci(int steps) {
		StringBuilder strb = new StringBuilder();
		//prep first and second numbers
		int num1 = 0;
		int num2 = 1;
		//display starting number
		strb.append(num1 + ", ");
		//display and then add out each number in sequence
		while (steps > 0){
			//print current number
			strb.append(num2);
			//don't tack on comma to last one
			if(steps != 1)
				strb.append(", ");
			
			int temp = num2;
			num2 += num1;
			num1 = temp;
			steps--;
		}
		
		return strb.toString();
	}
}
