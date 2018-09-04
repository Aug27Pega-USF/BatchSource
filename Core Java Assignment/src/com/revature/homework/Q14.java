package com.revature.homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q14 {
	void switchCases(int x) {
		System.out.println("\nQ14: Examples of switch case usage.");
		String str = "I am learning Core Java";
		String[] sentence = new String[5];
		int count = 0;
		
		switch(x) {
		case 1:
			//Find the square root of a number using the Math class method
			int num = 9;
			System.out.println("The square root of " + num + " is " + (int) Math.sqrt(num) + ".");
			break;
		case 2:
			//Display today's date
			//Using the line below to easily read date in a conventional format
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date today = new Date();
			System.out.println("Today's date and time is: " + dateFormat.format(today));
			break;
		case 3:
			//Split a string and store it in a string array
			for(String word: str.split(" ")) {
				sentence[count] = word;
				count++;
				}
			for(int i = 0; i < sentence.length; i++) {
				System.out.println("The word \'" + sentence[i] + "\' is at index " + i + ".");
			}
			break;
		}
	}
}
