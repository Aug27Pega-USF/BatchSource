/*
 * write a program to display the number of character for a string input. the string should
 * be entered as a command line argument using (String [] args).
 */

package com.revature.numChar;

public class NumberChar {

	public static void main(String[] args) {
		if(args.length < 0) {
			System.out.println("your need at least one arguments to run a program");
		}else {
			System.out.println(args.length);
		}
	}

}
