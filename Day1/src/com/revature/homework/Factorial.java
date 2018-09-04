package com.revature.homework;

public class Factorial {
	int myFactorial(int n) {
		if (n==0) return 1;
		else
			return (n * myFactorial(n-1));
		
	}
}
