package com.revature.utility;

public class Wrapperz {

	static int myInt = 5;
	static Integer myInteger = 5;
	static Integer yourInteger = 6;
	static Double myDouble = 4.5431;
	static Boolean myBool =true;
	

	
	public static void main (String[] args) {
		funky(myInt,myInteger);
		funky2(myInteger, yourInteger);
		
		foo(10,10);
	}
	
	static public void funky(int a, int b) {
		
		if(a==b) {
			System.out.println("Roll Tide");;
		}
		else {
			System.out.println("Well darn");
		}
	}
	
	static public void funky2(Integer a, Integer b) {
		if(a.equals(b)) {
			System.out.println("Roll Tide");;
		}
		else {
			System.out.println("Well darn");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	// SHOWS ORDER OF OPERATION IN OVERLOADING
	// Exact Match
	static public void foo(int a, int b) {
		System.out.println("int");
	}
	// Boxing
	static public void foo(Integer a, Integer b) {
		System.out.println("Integer");
	}
	// Conversion
	static public void foo(double a, double b) {
		System.out.println("Double");
	}
	//Variable args
	static public void foo(double ... a) {
		System.out.println("Variable arguments");
	}
	

	
	
	
}
