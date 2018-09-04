package com.revature.hw;

public class Q5 {

	 public static String findSubString(String str, int idx) {
		    String result ="";
		    try {
		      for(int x=0; x <= idx-1;x++) {
		        result += str.charAt(x);
		      }
		      return result;
		    } 
		    catch(StringIndexOutOfBoundsException e) {
		      System.out.println("Error: Nice Try Idiot. Returning String");
		    }
		    return result;
		  }
}
