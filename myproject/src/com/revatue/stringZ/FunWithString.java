package com.revatue.stringZ;

public class FunWithString {
	
	/*
	* Strings! - 
	* It is an object.
	* NOT char or Character
	* Fully Qualified class name:java.lang.String
	* String literal is 0+ characters ex. "" or "I love talking about Strings"
	* concatenate strings w/ +
	* "goodbye" + " earth"
	* String str= "blah";
	* Strings are immutable.
	* String pool- collection of unique string literals stored in heap memory
	* some string are common and used in multiple places in app
	* String str= "dog"; Compiler searches string pool for "dog".
	* if it exists, it will create a reference to, if not creates new literal
	* String string = "dog"; same reference as str
	* str= str+"house";
	* String API gives us utility methods! Ex: str.length
	*
	* String- Immutable, String Pool,Thread safe, fast
	* Thread- is a separate execution going on. Ex: multiple thread running on same time in video game.
	* Thread Safe: only one thread can access at a time
	* Fast- a lot more efficient for CPU
	* StringBuilder- Mutable sequence of characters, not threadsafe, Fast
	* StringBuffer- Also mutable, synchronized or threadsafe, slow
	*/

	public static void main(String[] args) {
		String str = "dog";
		String str2 = "dog";
		str = str + "house";
		String a = "DogHouse";
		System.out.println(str.length());
		System.out.println(str.charAt(5));
		System.out.println(str.equalsIgnoreCase(a));
		System.out.println(str.toUpperCase());
		}

}
