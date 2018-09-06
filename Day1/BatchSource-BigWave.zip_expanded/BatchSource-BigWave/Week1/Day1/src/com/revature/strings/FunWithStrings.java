package com.revature.strings;

public class FunWithStrings {
/*
 * STrings!
 * NOT char or Character
 * Fully Qualified class name:java.lang.String
 * String literal is 0+ characters ex. "" or "I love talking about Strings"
 * concatenate strings w/ +
 * "goodbye" + " earth"
 * String str= "blah";
 * Strings are immutable
 * String pool- collection of unique string literals stored in heap memory
 * some string are cpmmon and used in multiple places in app
 * String str= "dog"; COmpiler searches string pool for "dog". 
 * if it exists, it will create a reference to, if not creates new literal
 * String string = "dog"; same reference as str
 * str= str+"house";
 * String API gives us utility methods!
 * 
 * String- Immutable, String Pool,Thread safe, fast
 * StringBuilder- Mutable sequence of characters, not threadsafe, Fast
 * StringBuffer- Also mutable, synchronized or threadsafe, slow 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "dog";
		System.out.println(str);
		System.out.println(str.hashCode());
		String str2 = "dog";
		System.out.println(str2);
		System.out.println(str2.hashCode());
		 str = str+"house";
		System.out.println(str);
		System.out.println(str.hashCode());
	}

}
