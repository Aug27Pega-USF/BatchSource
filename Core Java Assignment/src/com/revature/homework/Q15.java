package com.revature.homework;

public class Q15 implements calc{
	@Override
	public void addition() {
		int result = a + b;
		System.out.println("The addition of " + a + " and " + b + " is " + result + ".");
	}
	@Override
	public void subtraction() {
		int result = a - b;
		System.out.println("The subtraction of " + a + " and " + b + " is " + result + ".");
	}
	@Override
	public void multiplication() {
		int result = a * b;
		System.out.println("The multiplication of " + a + " and " + b + " is " + result + ".");
	}
	@Override
	public void division() {
		int result = a / b;
		System.out.println("The division of "  + a + " and " + b + " is " + result + ".");
	}
}

interface calc {
	final int a = 12;
	final int b = 4;
	
	void addition();
	void subtraction();
	void multiplication();
	void division();
	
}
