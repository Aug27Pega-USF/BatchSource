package com.driver.questions;

public class Q3 {
	/*
	 * Q3: Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	 */
	public static void question(String str) {
		
		//print it forwards normally
		System.out.println("String going forward: " + str);

		//now store it backwards
		for(int i = 0; i < str.length(); i++) {
				/*
				 * Abcdefg
					bcdefg + A + 
					bcdefgA
					cdefg + b + A
					cdefgbA...
				 */
			str = str.substring(1, str.length() - i) + str.substring(0, 1) + str.substring(str.length() - i, str.length());
		}
		System.out.println("String going backward: " + str);
	}
}
