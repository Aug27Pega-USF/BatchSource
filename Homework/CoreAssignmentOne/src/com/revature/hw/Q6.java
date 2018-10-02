package com.revature.hw;

public class Q6 {

	//binary number is odd if its last digit is 1 and even if its last digit is 0.
	  public static boolean isEven(int x) {
	    return ((x & 1) == 0)? true : false;
	  }
}
