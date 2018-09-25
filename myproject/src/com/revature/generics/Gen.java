package com.revature.generics;
/*
 * Generics:
 * 		using type as parameter
 * 		write code that can handle different types of objects
 * 		use angel brackets <> denote that something is a generic
 * 		allows us to ensure type saftey
 * 		add stability and reusability to your code
 * 			at compile time, check whther that type of place holder is consistently used throughout 
 * 			our code
 * 	Placeholder: (T,E,?,M, etc..) use this instead of an explicit type
 * 
 */

public class Gen<T> {
	T ob; //declare an object of type T
	
	//pass the constructor a reference to an object of type T
	Gen(T o){
		ob=o;
	}
	
	//return ob
	T getOb() {
		return ob;
	}
	//Show type of T
	
	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}

}
