package com.driver.questions;

import question.fifteen.Q15Maths;

public class Q15 {
	
	/*
	 * Q15: Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  
	 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
	 * Hard code two operands in a test class having a main method that calls the implementing class.
	 */
	
	public static void question() {
		//make a new instance
		Q15Maths q = new Q15Maths();
		
		//do the operations?
		System.out.println("Calling addition function of 8 and 4: " + q.addition(8,4));
		System.out.println("Calling subtraction function of 8 and 4: " +  q.subtraction(8,4));
		System.out.println("Calling multiplication function of 8 and 4: " +  q.multiplication(8,4));
		System.out.println("Calling division function of 8 and 4: " +  q.division(8,4));
	}
}



