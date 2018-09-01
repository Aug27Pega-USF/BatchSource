package com.driver.questions;

public class Q11 {
	/*
	 * Q11: Write a program that would access two float-variables from a class that exists in another package. 
	 * Note, you will need to create two packages to demonstrate the solution.
	 */
	public static void question() {
		//accessing the variables from the package and class directly, 
		//rather than importing
		question.eleven.Floaters f = new question.eleven.Floaters();
		
		System.out.println("First floater variable imported: " + f.myFloat1);
		System.out.println("Second floater variable imported: " + f.myFloat2);
	}
}
