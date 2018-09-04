package com.revature.hw;

public class Q4 {
	
	public static long nFactorial(long n) {
	    long result=1;
	    for(int factor=1;factor <= n; factor++) {
	      result *= factor;
	    }
	    return result;
	  }
}
