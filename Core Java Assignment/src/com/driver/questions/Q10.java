package com.driver.questions;

public class Q10 {
	/*
	 * Q10: Find the minimum of two numbers using ternary operators.
	 */
	public static void question(int a, int b) {
		int result = a <= b ? a : b;
		System.out.println("Minimum between " + a + " and " + b + " is " + result);
	}
}
