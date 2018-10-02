package com.revature.hw;

public class Question12 {
	  
	   public static void main(String[] args) {
	      
	       int number [] = new int[100];
	      
	       //Storing 1 to 100 in Array
	       for (int i=1;i<=100;i++) {
	           number [i-1] = i;
	       }
	      
	       //Showing Even Number using For Each Loop
	       for (int j:number) {
	           if(j%2==0)
	               System.out.println(j);
	       }
	   }
}