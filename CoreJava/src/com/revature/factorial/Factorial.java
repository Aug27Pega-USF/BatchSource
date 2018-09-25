package com.revature.factorial;

public class Factorial {

	public static void main(String[] args) {
		//f(n) = n * (n-1) * (n-2) * (n-3)
		System.out.println(factorial(5));
		

	}
	public static int factorial(int n) {
		if(n == 1) {
			return 1;
		}
		else {
			return n  * (n-1) * factorial(n-2);
		}
		
	}
	

}
