package com.revature.homework;

public class IsEven {
	static boolean isEven (int n) {
		return ((n / 2) * n == n);
		//Due to rounding this returns true if evenly divisible by two
		// otherwise n is odd and rounding has taken place
	}
}
