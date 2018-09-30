package com.revature.hw;

public class Q15Math implements Q15Interface {

	@Override
	public void addition(int num1, int num2) {
		int num3 = num1 + num2;
		System.out.println("Adding Together: " + num3);
	}

	@Override
	public void subtraction(int num1, int num2) {
		int num3 = num1 - num2;
		System.out.println("Subtraction: " + num3);
	}

	@Override
	public void multiplication(int num1, int num2) {
		int num3 = num1 * num2;
		System.out.println("Multiplication: " + num3);
		
	}

	@Override
	public void division(int num1, int num2) {
		int num3 = num1 / num2;
		System.out.println("Dividing: " + num3);
	}

}
