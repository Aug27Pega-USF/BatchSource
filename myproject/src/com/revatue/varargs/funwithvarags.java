package com.revatue.varargs;

public class funwithvarags {
	/*
	 * Variable Length Arguments
	 * A method will take in a variable number of arguments
	 * can be of any type
	 * VarArg must be the last argument
	 * varArg input zero to many 
	 */

	static void vaTest(int ... v) {
		System.out.println("Number of args: " + v.length + " Contents");
		for(int x:v) {
			System.out.println(x + " ");
		}
	}
	public static void main(String[] args) {
		vaTest(10);
		System.out.println("=================");
		vaTest(1,2,3,4,5);
		System.out.println("=================");
		vaTest();
	}

}
