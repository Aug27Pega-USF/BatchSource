/*
 *  Write a substring method that accepts a string str and an integer idx 
 *  and returns the substring contained between 0 and idx-1 inclusive.  
 *  Do NOT use any of the existing substring methods in the String, 
 *  StringBuilder, or StringBuffer APIs.
    method("hello", 3) ---> h e l l o ===> hel
    						0 1 2 3 4 ===> [0, 2]
 */
package com.revature.substring;

public class Substring {

	public static void main(String[] args) {
		
		subMethod("revature", 5);
	
	}
	public static void subMethod(String str, int idx) {
		String myst[] = str.split("");
		for (int i = 0; i <= idx-1; i++) {
			System.out.print(" " +myst[i]);
		}
	}
}
