package com.driver.questions;


import com.driver.abstractz.Subby;

public class Q18 {
	/*
	 * Q18: Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  
	 * Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
	 * 1.          	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	 * 2.          	Convert all of the lower case characters to uppercase in the input string, and return the result.
	 * 3.          	Convert the input string to integer and add 10, output the result to the console.
	 * Create an appropriate class having a main method to test the above setup.
	 */
	public static void question() {
		
		Subby sub = new Subby();
		
		//method 1
		System.out.println("Method 1");
		String str = "Yabbadabbadoo!";
		System.out.println("String " + str + " contains uppercase letters: " + sub.method1(str));
		
		str = "woo";
		System.out.println("String " + str + " contains uppercase letters: " + sub.method1(str));
		
		//method 2
		System.out.println("Method 2");
		str = "Yabbadabbadoo!";
		System.out.println("String " + str + " to all uppercase: " + sub.method2(str));
		
		//method 3
		System.out.println("Method 3");
		str = "100";
		System.out.println("String " + str + " to int + 10: " + sub.method3(str));
	}
}


