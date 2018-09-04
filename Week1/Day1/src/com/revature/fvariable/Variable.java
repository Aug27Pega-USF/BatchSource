package com.revature.fvariable;

public class Variable {

	private static float one=1;
	private static float two=2;
	
	public static float getOne() {
		return one;
	}
	public static void setOne(float one) {
		Variable.one = one;
	}
	public static float getTwo() {
		return two;
	}
	public static void setTwo(float two) {
		Variable.two = two;
	}
	
}
