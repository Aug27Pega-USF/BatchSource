package com.revature.HW1;

import java.util.Scanner;

public class Question10 {
	 static int a,b,min;

	  public static void main(String[] args)
	  {
	      Scanner sc=new Scanner(System.in);
	      System.out.println("enter two nos");
	      a=sc.nextInt();
	      b=sc.nextInt();
	      min=a<b?a:b;
	      System.out.println("Min of two nos:");
	      System.out.println(min+" ");
	  }
}
