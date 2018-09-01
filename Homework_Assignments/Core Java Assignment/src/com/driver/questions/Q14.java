package com.driver.questions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Q14 {
	/*
	 * Q14: Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
	 *		Case 1: Find the square root of a number using the Math class method.
	 *		Case 2: Display today’s date.
	 *		Case 3: Split the following string and store it in a string array:
     *  	 			“I am learning Core Java”
	 */
	public static void question(int c) {
		
		System.out.println();
		System.out.println("Drawing from switch case " + c + ": ");
		
		switch(c) {
			default:
			case 1:
				int num = 16;
				System.out.println("The square root of " + num + " is " + Math.sqrt(num));
				break;
				
			case 2:
				DateTimeFormatter form = DateTimeFormatter.ofPattern("MM/dd");  
				LocalDateTime currentDate = LocalDateTime.now();  
				System.out.println("Current month and day: " + form.format(currentDate));  
				break;
				
			case 3:
				//base string to split up
				String str = "I am learning Core Java";
				
				//array to store each word
				ArrayList<String> sList = new ArrayList<String>();
				
				//temp var to store each letter until we add it to the array
				String temp = "";
				
				for ( int i = 0; i < str.length(); i++) {
					//if we reach a space, add the whole word to the arrayList
					if(str.charAt(i) == ' ') {
						sList.add(temp); //add temp
						temp = ""; //clear temp
					}
					
					//exception for the last index, if it's not an empty space
					//add the next char and then add to the arrayList
					else if(i == str.length() - 1) {
						temp += str.charAt(i); //add char to temp
						sList.add(temp); //add temp
						temp = ""; //clear temp
					}
					
					//add char to temp
					else {
						temp += str.charAt(i);
					}
				}
				
				for (String s: sList) {
					System.out.println(s);
				}
				break;
		}
	}
}
