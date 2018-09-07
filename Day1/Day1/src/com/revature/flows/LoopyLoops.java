package com.revature.flows;

public class LoopyLoops {
/*	If statement
 *  For decision making
 *  provides multiple paths of execution
 *  
 *  
 
if(<conditional>) {
<what to do if true> }
else if (<second conditional>) { <what to do if second conditional is true>}
else {<what to do if false>}


Switch Cases
provides multiple paths of execution based on some value
the "switch" is based on an integer numeric, a string,
a char, a boolean, or enum.


For Loops
for(a; b; c) {do something}
a is the variable declaration (counter)
b is the condition that controls how long the loop will run for
c is the incrementor/decrementor


Enhanced for loop (AKA for each)
for (x: <Array or Collection>) {do thing}
This is good for moving through collections, arrays and other iterables
More CPU efficient
No issues w/ index out of bounds - not size dependent
Good for accessing elements in one collection
Bad for adding and removing


While Loops
while(<conditional>) {<do something>}

do while	// will do something at least once
do{<do thing>} while (<conditional>)


Conditionals 
Logical Operators < > <= >= != ==
OR 
a|b - bitwise OR if one is true, return true
a||b - short circuit OR if a is true, return true w/o b
AND
a&b a&&b checks both and evaluates true iff (if and only if) both are true
EQUALS
==
compares values of primitives
compare the reference for objects. NOT THE CONTENTS
!= is good for checking nulls
.equals()
method inherited from object class
All reference types have it
Looking at content




 *  
 */
	static String color;
	public static void whatColor(String color) {
		switch(color) {
		case "green":
			System.out.println(color);
			break;	
		case "purple":
			System.out.println(color);
			break;
		case "red":
			System.out.println(color);
			break;
		default:
			System.out.println("Good job scrub");
		}
	}
	
	public static void forLoopFunness(int i) {
		for(; i>0; i--) {
			// break or continue
			if(i == 10) {
				//break;
				continue;	// this will skip this (the current) iteration
			}
			System.out.println(i);
		}
	}
	
	static int [] myArray = {11,12,31,14,51,16,17,18,19};
	
	public static void forEachFun(int [] a) {
		for(int i: a) {
			System.out.println(i);
		}
	}
	
	
	public static void wileyWhile(int i) {
		while(i<10) { 
			System.out.println("This sucks");
			i++;
		}
	}
	
	public static void doWileyWhile(int i) {
		do {System.out.println("this sucks less");
		i++;
		}
		while(i<10);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		whatColor("green");
		whatColor("football");
		
		//forLoopFunness(20);
		//forEachFun(myArray);
		wileyWhile(1);
		doWileyWhile(1);
		
	}

}
