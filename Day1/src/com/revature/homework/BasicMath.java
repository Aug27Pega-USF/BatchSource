package com.revature.homework;

public class BasicMath {
	interface myOperators {
		public abstract int addition(int a, int b);
		public abstract double subtraction(double a, double b);
		public abstract int multiplication(int a, int b);
		public abstract double division(double a, double b);
	}

	static class myMath implements myOperators {

		public int addition(int a, int b) {
			return a + b;
		}

		public double subtraction(double a, double b) {
//			if (a > b) 
//				System.out.println("Negative result");
//			else
//				int int x = a-b;
//			return x;
			return a-b;
		}

		public int multiplication(int a, int b) {
			return a * b;
		}

		public double division(double a, double b) {
			return a / b;
		}
	}
}
