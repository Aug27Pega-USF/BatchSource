package com.driver.questions;


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

interface Maths {
	public abstract int addition(int a, int b);
	public abstract int subtraction(int a, int b);
	public abstract int multiplication(int a, int b);
	public abstract int division(int a, int b);
}

class Q15Maths implements Maths {

	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a * b;
	}

	@Override
	public int division(int a, int b) {
		return a / b;
	}

}
