package com.revature.hw;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Q14 {

	static int myInt = 0;
	static Scanner keyboard = new Scanner(System.in);
	//Q14 Display Case based on number
	  public static void displayCase(int num) {
	    try {
	      switch(num) {
	        case 1:
	        System.out.println("Enter an integer to find the square root");
	        myInt = keyboard.nextInt();
	        System.out.println("Case 1: Square Root of "+myInt+" is " + Math.sqrt(myInt));
	        break;
	        case 2: 
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	        Date date = new Date();
	        System.out.println("Case 2: Todays Date is " + dateFormat.format(date));
	        break;
	        case 3:
	        String str = "I am learning core java";
	        String[] strArray = str.split(" ");
	        System.out.println("Case 3: Split '" + str + "' --> " + Arrays.toString(strArray));
	        break;
	        default: 
	        System.out.println("Case does not exist");
	        break;
	      }
	    }catch(InputMismatchException e) {
	      System.out.println("Error: Input was not an Integer");
	    }
	    
	  }
}
