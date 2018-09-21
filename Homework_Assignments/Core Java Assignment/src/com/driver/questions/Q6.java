package com.driver.questions;

public class Q6 {
	/*
	 * Q6: Write a program to determine if an integer is even without using the modulus operator (%)
	 */
	public static void question(int i) {
		//print number
		System.out.print(i);
		
		//add/subtract 2 until we get near 1
		
		i = toOddEven(i);
		
		//print the result
		if(i == 1 || i == -1)
			System.out.println(" is not Even");
		else 
			System.out.println(" is Even");
	}
	
	public static int toOddEven(int i) {
		while(i > 1)
			i -= 2;
		while(i < -1)
			i += 2;
		
		return i;
	}
}
