package com.revature.flows;

public class LoopyLoops {
	/*If statement
	 * for decision making
	 * provides multiple paths of execution
	 * 
	 * if (conditional) { <what to do if true>}
	 * else if( second conditional) {what to do if second conditional is true}
	 * else {what to do if false}
	 * 
	 * Switch cases
	 * provides multiple paths of execution based on some value 
	 * the "switch" is based on an integer numeric, a string, a char, a boolean, or enum
	 *  
	 * for(a;b;c){do something}
	 * a is our variable declaration
	 * b is the condition that controls how the far the loop will go
	 * c is the incrementor/decrementor
	 * 
	 * Enhanced for loops aka for each loops
	 * 
	 * for(x:<array or collection>){do thing}
	 * good for moving through collections, arrays and other iterables
	 * more CPU efficient 
	 * no issues with index out of bounds- not size dependent
	 * good for accessing elements in one collection
	 * bad for adding and removing
	 * 
	 * While loops
	 * while(<condition>){<do something>}
	 * 
	 * do while 
	 * do{<do thing>} while (<condition>)
	 * 
	 * 
	 */
	static String color;
	public static void whatColor(String color) {
		switch(color) {
		case "green":
			System.out.println(color);;
			break;
		case "purple":
			System.out.println(color);;
			break;
		case "red":
			System.out.println(color);;
			break;
			default:
				System.out.println("Good Job Idiot");;
		}
	}
	
	
	public static void forLoopFunness(int p)
	{
		
		for(int i=p; i>0;i--)
		{
			//System.out.println(i);
			//break or continue
			if(i==10) {//break;
				continue;}
			System.out.println(i);
			
		}
	}
	/*Conditionals 
	 * Logical Operators
	 * < > <= >= != ==
	 * OR 
	 * a|b - bitwise or if one is true, return true
	 * a||b- short circuit OR If a is true, returns true w/o checking b
	 * AND
	 * a&b a&&b checks both and evaluates true iff both are true
	 * EQUALS
	 * == 
	 * compare values of primitives.
	 * compare the reference for objects. NOT THE CONTENTS.
	 * != is good for checking nulls
	 * .equals()
	 * method that is inherited from our object class.
	 * All reference types have it.
	 * looking at content 
	 * 
	 * 
	 */
	
	static int[] myArray={41,21,33,14,25,37,58,29};
	
	public static void forEachFun(int[] a) {
		for(int i:a ) {
			System.out.println(i);
		}
	}
	
	public static void wileyWhile(int i) 
	{
		while(i++<10) 
		{
			System.out.println("this sucks");
			
		}
	}
	
	
	public static void doWileyWhile(int i) 
	{
		do {System.out.println("this suscks less");
		i++;}
		while(i<10);
		
	}
	
	public static void main(String[] args) {
		//whatColor("purple");
		//whatColor("football");
		//forLoopFunness(20);
		//forEachFun(myArray);
		wileyWhile(1);
		doWileyWhile(3);
	}
}
