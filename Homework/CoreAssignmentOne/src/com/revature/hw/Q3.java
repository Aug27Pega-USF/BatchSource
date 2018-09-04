package com.revature.hw;

public class Q3 {

	public static String reverseString(String str) {
	    String reversed="";
	    //iterate through string backwards
	    for(int i = str.length()-1;i>=0;i--) {
	      reversed += str.charAt(i);
	    }
	    return reversed;
	  }
}
