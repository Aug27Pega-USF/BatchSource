package com.revature.HW1;

import java.util.Date;
import java.util.Scanner;

public class Question14 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	      System.out.println("Enter Number between 1 to 3");
	      int number = sc.nextInt();
	      double mathNumber = 10;
	      switch (number) {
	          case 1:

	              mathNumber = Math.sqrt(mathNumber);
	              System.out.println("Sqare Root: "+mathNumber);
	              break;
	          case 2:
	              Date date = new Date();
	              System.out.println("Todays Date: "+date);
	              break;
	          case 3:
	              String s = "I am Learning Core Java";
	              String sArray [] = s.split(" ");
	              for (String token:sArray) {
	                  System.out.println("String Array Value: "+token);
	              }
	              break;
	          default:
	              break;
	      }
	}

}
