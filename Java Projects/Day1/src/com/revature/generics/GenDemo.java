package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		// Create a Gen reference for Integers
		Gen<Integer> iOb;
		// Create Gen<Integer> object and assign it
		// Reference to iOb
		iOb = new Gen<Integer>(88);	// Auto boxing occuring here because 88 is an int, NOT an Integer
		// Show the type of iOb
		iOb.showType();
		
		// Get the value in iOb
		int v = iOb.getOb();
		System.out.print("value: " + v);
		
		Gen<String> strOb = new Gen<String>("Generics Test");
		
		System.out.println(); // Makes new line
		strOb.showType();
		String str = strOb.getOb();
		System.out.println("value " + str);
	}
	
}