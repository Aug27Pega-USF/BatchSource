package com.revature.flows;

public class LoopyLoops {
	/* If statement
	 * For decision making
	 * provides multiple paths of execution
	 * 
	 * 

if (<conditional>) { 
<what to do if true> }
else if (<second conditional>) {<what to do if second conditional is true>} 
else {<what to do if false>}

	 * 
	 * Switch Cases
	 * provides multiple paths of execution based on some value
	 * the "switch"  is based on an integer numeric, a string
	 * a char, a boolean, or enum.
	 * 
	 * For Loops
	 * for(a;b;c;){do something}
	 * a is variable declaration (counter
	 * b is the condition that controls how far the loop will go
	 * c is the incrementor/decrementor
	 * 
	 * Enhanced for loop aka for each
	 * for (x:<Array or Collection>){do thing}
	 * good for moving through collections, arrays and other iterables
	 * more CPU efficient
	 * no issues w/ index out of bounds- not size dependent
	 * good for access elements in one collection
	 * bad for adding and removing
	 * 
	 * While loops
	 * while(<condition>){<do something>}
	 * 
	 * do while
	 * do {<do thing>} while (<condition)
	 * 
	 */
	static String color;
	public static void whatColor(String color) {
		switch(color) {
		case "green":
			System.out.println(color);
			//break;
		case "purple":
			System.out.println(color);
			//break;
		case "red" :
			System.out.println(color);	
			//break;
		default:
			System.out.println("Good job idiot");
		}
	}
	public static void forLoopFunness(int p) {
		
		for (int i=p; i>0;i--) {
			
			//break or continue
			if(i==10) {
				//break;
				continue;
				
			}
		System.out.println(i);
		}
	}
	static int [] myArray= {11,21,31,14,51,16,17,18,19};
	public static void forEachFun(int [] a) {
		for(int i:a) {
			System.out.println(i);
		}
	}
	public static void wileyWhile(int i) {
		while(i++<10) {
			System.out.println("This sucks.");
		}
	}
	public static void doWileyWhile(int i) {
		do {System.out.println("This sucks less.");
		i++;
		}
		while(i<10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//whatColor("purple");
		//whatColor("football");
		//forLoopFunness(20);
		//forEachFun(myArray);
		wileyWhile(1);
		doWileyWhile(1);
	}
	
}
