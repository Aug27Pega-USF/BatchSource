package com.revature.hw;

public class Q13 {

	//Q13 Use to print triangle with specified amount of lines
	  public static void printTriangle(int n) {
	    int track = 1;
	    //String str="";
	    for (int i =0;i<= n; i++) {
	      for (int j = 1; j <= i; j++) {
	        //			  if(track%2!=0) {
	        System.out.print((track%2 ==0) ? "1":"0");
	        track++;
	        
	      }
	      System.out.print("\n");
	    }
	  }
}
