package com.revature.hw;

public class Q12 {

	//Q12 Create int array 
	  public static int[] fillIntArray(int i, int j) {
	    int thisArr[] = new int[j];
	    for(int x=i;x <=j; x++) {
	      thisArr[x-1] = x;
	    }
	    return thisArr; 
	  }
	  
	  public static void printWithAdvancedFor(int[] a){
		  for(int x : a) { 
		    	if(Q6.isEven(x)) { 
		    		System.out.print(x + " "); 
		    		} 
		    	}
	  }
	  
}
