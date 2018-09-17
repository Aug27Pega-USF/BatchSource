package com.revature.flows;

public class LoopyLoops {
	static String color;
	
	
	public static String whatColor(String color) {
		switch(color) {
		default:
			return "not a color";
		case "green":
			return color;
		case "purple":
			return color;
		case "red":
			return color;
		}

	}
	
	
	static int [] myArray= {11,2,3,4,5,6,7,8,9};
	public static void forEachFun(int [] a) {
		
		for(int i:a) {
			System.out.println(i);
			
		}
	}
	public static void main(String[] args) {
	forEachFun(myArray);
	}
}

/*
 * for(a;b;c;){do something}
 * a is variable declaration
 * b is condition to stop
 * c is incrementer or decrementer.

*/