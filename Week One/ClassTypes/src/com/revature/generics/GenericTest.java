package com.revature.generics;
/*
 * Using Type as a parameter
 * write code that can handle different types of objects
 * use angle brackets <> to denote that something is a generic 
 * allows us to ensure type safety
 * use a placeholder (T,E,?,M, etc.) instead of explicit type
 * Adds stability and re-usability to your code
 * 			-@ compile time check whether that type of 
 * 				placeholder is consistently used throught code
 * If we wanted that code to handle any type of object parameter w/o generics we would need 
 */
public class GenericTest<T> {
	 T ob; //object of Type T
	//pass the constructor a reference to an object of type T
	public GenericTest(T o){
		ob = o;
	}
	
	public T getOb() {
		return ob;
	}
	
	T setOb() {
		return this.ob;
		
	}
	public void showType() {
		System.out.println("Type is of: " + ob.getClass().getName());
	}
	
}
