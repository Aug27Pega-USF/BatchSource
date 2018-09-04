package com.revature.homework;

public class Fib {
	public int myFib(int n) {
		if (n == 0) return 0;
		else if (n <= 1) return 1;
	      else
	            return myFib(n - 2) + myFib(n -1);
	}
}