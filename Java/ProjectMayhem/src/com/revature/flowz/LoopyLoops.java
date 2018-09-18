package com.revature.flowz;

import java.util.Scanner;

import com.revature.beans.Person;

public class LoopyLoops {
	static Scanner sc= new Scanner(System.in);
	/*
	 * if statement
	 * for decision making
	 * provide multiple paths of execution
	 * 
	 * if(<conditional>){
	 * <what to do if true>
	 * }else if(<2nd conditional>){
	 * <what to do if second conditional is true>
	 * }else {
	 * <what to if false>
	 * }
	 * 
	 * Switch case
	 * provide multiple paths of execution based on a value
	 * the "switch" is based on an integer, string, char, boolean, or enum
	 * 	enum- special kind of class that only contains a list of constants 
	 */
	public enum Days{ MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY};
	static String color;
	public static void whatColor(String color) {
		switch(color) {
		case "green":
			System.out.println("this color is grrrreeeeen");
			//break;
		case "red":
			System.out.println("Roll Tide");
			//break;
		case "purple":
			System.out.println("ZEEEEEEEEE");
			//break;
			default:
				System.out.println("You have either not picked a good color, or you're an idiot");
		}
	}
	public static void main(String[] args) {
		/*System.out.println("Please enter in a color");
		String input=sc.nextLine();
		whatColor(input);*/
		//forLoopFreaky(15);
		//forEachFun(myArray);
		//doWileyWhile(21);
		Person a = new Person();
		a.setName("Matt");
		Person b =new Person();
		b.setName("Jim");
		Person c = new Person();
		c.setName("Matt");
		if(a.equals(c)) {
			System.out.println("match");
		}else {
			System.out.println("fail");
		}
	}
 /*
  * For loops 
  * for(a;b;c){
  * do something
  * }
  * a- variable declaration (counter)
  * b- is the conditon that controls how far the loop will go
  * c is the incrementor/decrementor
  *
  */
	public static void forLoopFreaky(int p) {
		for(int i=p; i>0;i--) {
			if(i==10) {
				continue;
			}
			System.out.println(i);
		}
	}
	/*
	 * for-each( augmented for, enhanced for)
	 * good for moving thru collections, arrays and oher iterables
	 * more CPU efficient
	 * not issues w/index out of bounds- not size dependent
	 * good for accessing elements, bad for adding or removing
	 * 
	 * for (x:Collection){ <- x is the type stored in the collection
	 * do thing
	 * }
	 */
	static int [] myArray= {11,45,61,89,73,14,9};
	public static void forEachFun(int[] a) {
		for(int i:a) {
			System.out.println(i);
		}
	}
	/*While loop
	 * while(<condition>) {
	 * do something
	 * }
	 *  do while
	 *  do{<do thing>
	 *  }while(<condtion>)
	 *  }
	 */
	public static void wileyWhile(int i) {
		while(i++<10) {
			System.out.println("Blah");
		}
	}
	public static void doWileyWhile(int i) {
		do {System.out.println("bleh");
		i++;
		}
		while(i<10);
	}
	/*
	 * COnditionals
	 * Logical Operators
	 * <><=>= != ==
	 * OR
	 * a||b- if a or b is true, returns true
	 * AND
	 * a&&b- a and b must be true to return true
	 * EQUALS
	 * ==
	 * compare values of primitives
	 * compare the reference for objects 
	 * -return true if they are the same object, not just objects
	 *   w/ same fields/values
	 *   good for checking nulls
	 *   .equals()
	 *   -method inherited from object
	 *   all reference types have it
	 *   looking at content of object
	 * 
	 */
}
