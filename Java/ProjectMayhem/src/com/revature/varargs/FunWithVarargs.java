package com.revature.varargs;

public class FunWithVarargs {
/*
 * Variable Length Arguments
 * a method will take in a variable number of arguments
 * Can be of any type
 * VarArg must be the last argument 
 */
	static void vaTest(int ... v) {
		System.out.println("Number of args: " + v.length+ " Contents");
		for(int x:v) {
			System.out.println( x+ " ");
		}
	}
	public static void main(String[] args) {
		vaTest(10);
		System.out.println("===================");
		vaTest(1,2,3,4,5);
		System.out.println("===================");
		vaTest();

	}

}
