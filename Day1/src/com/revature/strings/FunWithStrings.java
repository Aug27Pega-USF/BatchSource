package com.revature.strings;

public class FunWithStrings {
/*
 * Strings
 * NOT char or Character
 * Fully Qualified class name: java.lang.String
 * String literal is 0+ characters ex. "" or "Are you not entertained?!"
 * concatenate strings w/ +
 * ex. "good" + "bye" == "goodbye"
 * Strings are immutable
 * String pool - collection of unique String literals stored in heap memory
 * Some strings are common and used in multiple places in app
 * ex. String str = "dog"; compiler searches string pool for dog
 * if it exists, it will create a reference to, if not create, a new string literal
 * String string - "dog"; same reference as str
 * str = str+"house";
 * String API(Application Programming Interface) gives us utility methods
 * 
 * String - Immutable, String Pool, Threadsafe, Fast
 * StringBuilder - Mutable sequence of characters, not threadsafe, Faster
 * StringBuffer - Mutable, synchronized(thread-safe), Slower  
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "dog";
		String str2 = "dog";
		System.out.println(str);
		System.out.println(str.hashCode());
		System.out.println(str.equals(str2));
		System.out.println(str2);
		System.out.println(str2.hashCode());
	}

}
