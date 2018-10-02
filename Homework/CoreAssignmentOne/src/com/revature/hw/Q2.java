package com.revature.hw;

public class Q2 {
	//Q2 Prints fibonacci array up to specified number
	  public static void fibonacci(int count) {
	    int n1 =0;
	    int n2 =1;
	    int n3;
	    System.out.print(n1 + " " + n2 + " ");
	    for(int x=2;x<count;x++) {
	      n3=n1+n2;
	      System.out.printf("%s ", n3);
	      n1=n2;
	      n2=n3;
	    }
	  }
}
