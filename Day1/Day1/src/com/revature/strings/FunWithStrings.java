package com.revature.strings;

public class FunWithStrings {

/*
 * Strings!
 * NOT char or Character
 * Fully Qualified class name:java.lang.String
 * String literal is 0+ characters ex. "" or "hello"
 * Concatenate strings w/ +
 * "goodbye" + " earth"
 * String str = "blah";
 * Strings are immutable
 * String pool - collection of unique string literals stored in head memory
 * some strings are common and used in multiple places in app
 * String str = "dog"; compiler searches string pool for "dog"
 * if it exists, it will create a reference to, if not creates new literal
 * String string = "dog"; same reference as str
 * str = str + "house";
 * String API gives us utility methods!
 * 
 * String - immutable, String Pool, Thread safe, fast (because of immutable and string pool)
 * StringBuilder - Mutable sequence of characters, not threadsafe, Faster because it's not threadsafe
 * StringBuffer - Also mutable, synchronized or threadsafe, slow
 * 
 * Errors vs Checked Exceptions, Unchecked Exceptions...
 * 
 * 
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "dog";
		String str2 = "cat";
		System.out.println(str);
		System.out.println(str.hashCode());
		System.out.println(str2);
		System.out.println(str2.hashCode());
		
		
		
	}

}
