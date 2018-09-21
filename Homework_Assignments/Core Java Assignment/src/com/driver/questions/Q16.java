package com.driver.questions;

public class Q16 {
	/*
	 * Q16: Write a program to display the number of characters for a string input. 
	 * The string should be entered as a command line argument using (String [ ] args).
	 */
	
	public static int question(String s) {
		//Run > Run Configuration > [main driver class] > Arguments
		//print results
		System.out.println("String entered: " + s);
		System.out.println("The number of characters in the string is " + s.length());
		return s.length();
	}
}
