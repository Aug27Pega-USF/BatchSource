package com.revature.hw;

public class Question6 {     
	    // Returns true if n 
	    // is even, else odd
	    static boolean isEven(int n) {
	        boolean isEven = true; 
	        for (int i = 1; i <= n; i++) 
	            isEven = !isEven;             
	        return isEven;
	    }
 
	    // Driver Code
	    public static void main(String args[]) {    
	        int n = 100; //You can put any number into here and it will read back either even or odd
	        if(isEven(n))
	            System.out.println("Even");
	        else
	            System.out.println("Odd");	         
	    }
	}