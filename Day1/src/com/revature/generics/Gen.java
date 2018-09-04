package com.revature.generics;
/*
 * Using type as a parameter
 * Write code that can handle different types of objects
 * use angle brackets<> to denote that something is a generic
 * This allows us to ensure type safety 
 * use a placeholder (T,E,?,M, etc.)
 * Adds stability and reusability to your code
 * 		-At compile time, check whether that type of placeholder
 * 		is consistently used throughout your code
 * If we wanted code that could handle any type of object parameter
 * 		(without generics), we would have to pass in Object object as a parameter
 */
public class Gen<T> {
	T ob; // Declare and object of type T
	
	//pass the constructor a reference to an object of type T
	Gen(T o) {
		ob=o;
	}
	//return ob
	T getOb() {
		return ob;
	}
	//Show the type of T
	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}

}
