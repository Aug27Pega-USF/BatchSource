package com.revature.homework;

public class StringLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    	if(args.length == 0) {
	    		System.out.println("No string entered");
	    	}
	    	else if (args.length > 1) {
	    		System.out.println("More than one input.");
	    	}
	    	else System.out.println("The number of characters in the string is: " + args[0].length() + ".");
	            
	    }
}