package com.revature.hw;

public class Question13 {
	  
	   public static void main(String[] args) {
	      
	       int count = 1;
	       for (int i=1;i<=4;i++){
	           for (int j=0;j<i;j++){
	               if (count%2!=0) {
	                   System.out.print("0");
	               }
	               else {
	                   System.out.print("1");
	               }
	               count++;
	           }
	           System.out.print("\n");
	       }  
	   }
	}