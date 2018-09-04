package com.reavature.strings;

public class FunWithStrings {
	/*
	 * Strings!
	 * NOT char or Character
	 * Fully Qualified class name: java.lang.String
	 * String literal is 0 + character ex. "" or " I love talking about Strings"
	 * concatenate strings w/ +
	 * "goodbye" + " earth" 
	 * String str= "blah";
	 * Strings are immutable
	 * String pool- Collections of unique string literals that are stored in heap memory.
	 * some strings are common and used in multiple places in app.
	 * String str= "dog"; Compiler searches string pool for "dog".
	 * if it exists creates a reference to, if not creates a new literal.
	 * String string = "dog"; same as str 
	 * str= str+"house"; "doghouse"
	 * String API give us utility methods! ex. .substring, .length, .touppercase, .toequals, and etc.
	 * 
	 * String immutable, String pool, thread safe, fast
	 * String Builder- Mutable sequence of characters, not thread safe faster
	 * StringBuffer- Also mutable, synchronized or  thread safe slower
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "dog";
		
		System.out.println(str);
		System.out.println(str.hashCode());
		String str2= "dog";
		System.out.println(str2);
		System.out.println(str2.hashCode());
		str= str+"house";
		System.out.println(str);
		System.out.println(str.hashCode());
	}

}
