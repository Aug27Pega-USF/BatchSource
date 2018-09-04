package com.revature.homework;

public class Q4 {
	void factorial(int n) {
		System.out.println("Q4: Computing N factorial.");
		long sum = 1;
		for(int i = 1; i <= n; i++) {
			sum *= i;
		}
		System.out.println(sum);
		System.out.println();
	}
}
