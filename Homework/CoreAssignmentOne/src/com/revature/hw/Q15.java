package com.revature.hw;

public class Q15 implements Q15Interface {

	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		return b - a;
	}

	@Override
	public int multiplication(int a, int b) {
		return a * b;
	}

	@Override
	public double division(double a, double b) {
		return a/b;
	}

}
