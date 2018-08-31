package com.revature.hw;

public abstract class MyAbstractClass {

	//returns true if string contains capital
	//"if string does not equal lowercase version of itself it contains a capital and returns true"
	protected abstract boolean checkUpper(String str);
	
	//Convert all of the lower case characters to uppercase in the input string, and return the result.
	protected abstract String convertLowerToUpper(String str);
	
	//Convert the input string to integer, output the result to the console.
	protected abstract int convertStringToInt(String str);
}
