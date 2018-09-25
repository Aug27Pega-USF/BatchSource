package com.revatue.flowz;

import com.revature.beans.Person;

public class LoopyLoops {
	
	//static Scanner sc = new Scanner(System.in);

	/*
	 * If statement
	 *     For Decision making
	 *     Provide  multiple paths of execution
	 *     
	 *     Example:
	 *     
	 *     if(<conditional>){
	 *     		//it must be boolean value...true or false value..
	 *     	<what to do if true>
	 *     } else if (<2nd conditional>){
	 *     		<what to do if 2ns conditional is true>
	 *     } else {
	 *     	<what to if false>
	 *     }
	 *     
	 *     
	 *  Switch Case:
	 *  	Provide multiple paths of execution based on a value
	 *  	the "switch" is based on an integer, string, char, boolean, or enum
	 *  		enum: special kind of class that only contains a list of constants  		
	 */
	
	public enum Days{ MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};
	static String color;
	public static void whatColor(String color) {
		switch(color) {
		case "green":
			System.out.println("This color is greeeennnnn");
			break; //used to breakout conditional statement like loop or switch or any other. if we do not break than it will print out everything.
		case "red":
			System.out.println("Roll tide");
			break;
		case "purple":
			System.out.println("ZEEEEE");
			break;
			default:
				System.out.println("You have either not pick a good color, or you're an idiot.");
		}
	}
	
	public static void main(String[] args) {
		/*System.out.println("Please enter in a color");
		String input = sc.nextLine();
		whatColor(input);*/
		//forLoopFreaky(15);
		//forEachFun(myArray);
		//wileyWhile(2);
		//doWileyWhile(21);
		
		Person a = new Person();
		a.setName("Matt");
		Person b = new Person();
		b.setName("Jim");
		Person c = new Person();
		c.setName("Matt");
		if (a.equals(c)) {
			System.out.println("Match");
		}else {
			System.out.println("Fail");
		}
		
		
	}
	
	/*
	 * For loops:
	 * 		for(a; b; c){
	 * 		do something
	 * 		}
	 * 		a- variable declaration (counter)
	 * 		b- is the condition that controls how far the loop will go
	 * 		c- is the incrementor or decrementor
	 */
	
	public static void forLoopFreaky(int p) {
		for(int i = p; i > 0; i--) {
			if(i==10) {
				continue;
			}
			System.out.println(i);
		}
			
	}
	
	/*
	 * for-each: (argmented for,enhanced for)
	 * 		good for moving thru collections, arrays and other iterables
	 * 		more CPU efficient
	 * 		not issues with index out of bounds - not size dependent
	 * 		good for accessing elements, bad for adding or removing
	 * 
	 * 	for(x:Collection) {<-x is the type stored in the collection
	 * 	do thing
	 * }
	 */
	
	static int[] myArray = {11,45,61,86,73,14,9};
	public static void forEachFun(int[] a) {
		for(int i:a) {
			System.out.println(i);
		}
		
	}
	
	/*
	 * While Loop
	 * 		while(<condition>){
	 * 			do something
	 * 		}
	 * 	do something till condition is true.
	 * check condition first than do
	 * 
	 * Do While Loop
	 * 		do{<do thing>
	 * 		}while (<condition>){
	 * 		}
	 * 	first do and than check condition
	 */
	
	public static void wileyWhile(int i) {
		while(i++<10) {
			System.out.println("Blah");	
		}
	}
	
	public static void doWileyWhile(int i) {
			do {System.out.println("Blah");	
			i++;
			}
			while(i<10);
		}
	
	/*Conditionals
	 * 
	 * 	Logical Operators
	 * 	<  >   <=  >= !=  ==
	 * 	
	 * 	OR
	 * 	a||b - if a or b is true, returns true
	 * 	
	 * 	AND
	 * 	a&&b - a and b must be true to return true
	 * 	
	 * 	EQUALS
	 * 	==  compare values of primitives
	 * 		compare true reference for objects
	 * 		return true if they are the same object, not just the objects
	 * 		with same field or values
	 * 		good for checking nulls
	 * 
	 *	.equal
	 *		-method innherited from object
	 *		all reference types have it
	 *		looking at content of object
	 */

}
