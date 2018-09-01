package com.driver.questions;

public class Q5 {
	/*
	 * Q5: Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  
	 * Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
	 */
	public static void question(String str, int idx) {
		
		//print it normally
		System.out.println("String Entered: " + str);
		
		//print the string up to the index
		System.out.print("String at " + idx + ": ");
		for(int i = 0; i < idx; i++) {
			System.out.print(str.charAt(i));
		}

	}
}
