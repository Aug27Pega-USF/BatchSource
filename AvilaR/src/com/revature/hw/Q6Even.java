package com.revature.hw;

public class Q6Even {
	
	 boolean Even(int n) {
	       boolean Even = true;
	       for (int i = 1; i <= n; i++)
	           Even = !Even;
	       return Even;
	 }
}
