package com.revature.hw;

public class Q5SubString {
	String subString(String str, int idx) {
		//Checking to make sure the index doesn't go above tha main idex length of string
	       if (idx > str.length()) {    	   		
	             return str;
	             }
	       String sub = "";
	     //For loop to get position of subString
	       for (int i = 0; i < idx; i++) {          
	             sub += str.charAt(i);
	       }
	       return sub;
	 }
}
