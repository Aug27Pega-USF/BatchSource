package com.revature.strings;

public class FunWithStrings {
/*
 * Strings
 * Not char or Char
 * Fully Qualified class name: java.lang.String;
 * String literal is 0+ characters ex/ "" or "I Love Strings"
 * concat w/ +
 * Strings are immutable(can't set it to something else)
 * String pool: Collection of unique String literals stored in heap memory
 * some strings are common and used in multiple places
 * String str ='dog'; //Compiler searches pool for 'dog'
 * if exists, it will create a reference, if not creates new literal
 * String str2 = 'dog'; same reference as str
 * str = str + "house"; conc
 * 
 * String = Immutable, String Pool, Thread Safe, fast (utilizes string pool and is immutable)
 * StringBuilder = Mutable sequence of characters, not thread safe, faster
 * StringBuffer = Also mutable, synchronized (thread safe)
 */ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Dog";
		String str2 = "Dog";
		System.out.println(str + str2);

	}

}
