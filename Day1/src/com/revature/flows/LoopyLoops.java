package com.revature.flows;

public class LoopyLoops {
//	If statement for decision making
//	provides multiple paths of execution
	
//	Switch Cases:
//	provides multiple paths of execution based on some value
//	the "switch" is based on an integer numeric, a string,
//	a char, a boolean, or enum
	
	static String color;
	public static String whatColor(String color) {
		switch(color) {
		
		case "green":
			return color;
		case "red":
			return color;
		case "purple":
			return color;
		default:
			return "no valid color...";
		}
	}
//	For Loops
//	for(a;b;c){
//  dosomething
//  }
//	a is the variable counter
//	b is the range, where to stop
//	c is the increment
	public static void forLoopFunness(int p) {
		for(int i=p; i > 0; i--) {
			if((i*2)==24) {
				continue;
			}
			System.out.println(i*2);
		}
	}
	/*Enhanced for loops(aka for each loop)
	 * for(x: array/collection) {do this}
	 * good for moving through collections, arrays, etc.
	 * more CPU efficient
	 * not size dependent
	 * bad for add/remove
	 * good to element access
	 * 
	 * While loops
	 * while(condition){do something}
	 * 
	 * do while
	 * do{do thing} while (condition)
	 */
	
	
	static int[] myArray = {1,2,3,4,5,6,7,8,9};
	public static void forEachFun(int[] a)
	{
		for(int i:a) {
			System.out.println(i);
		}
	}
	
	public static void doWilyWhile(int b) {
		do {
			System.out.println("WRONG!!!!");
			b++;
		}
		while (b<10);
	}
	/*
	 * Conditionals
	 * Logical Operators
	 * < > <= >= != ==
	 * OR
	 * a|b - bitwise OR if one is true, return true
	 * a||b - short circuit OR if a is true, return true w/o checking b
	 * AND
	 * a&b - bitwise        both; checks bot and evaluates true iff both are true
	 * a&&b - short circuit-^
	 * EQUALS
	 * == - compares primitive values and the reference objects, NOT THE CONTENTS
	 * != - good for checking nulls
	 * .equals():
	 * inherited from Object
	 * All reference types have it
	 * looks at content
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(whatColor("blue"));
//		System.out.println(whatColor("pink"));
//		System.out.println(whatColor("red"));
		//forLoopFunness(15);
		//forEachFun(myArray);
		doWilyWhile(4);
	}

}
