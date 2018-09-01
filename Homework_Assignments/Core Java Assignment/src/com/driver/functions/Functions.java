package com.driver.functions;

import java.util.Scanner;

/*
 * This class is for all functions used between one or more questions
 */
public class Functions {
	
	//displays each element of an array in one line
	public static void displayArray ( int arr[] ) {
		for (int i:arr) {
			System.out.print(i + ", ");
		}
	}
	
	//recursive function?
	public static int fibonacci(int i) {
		if (i == 0 || i == 1) {
			return i;
		}
		
		else {
			return fibonacci(i-1) + fibonacci(i-2);
		}
	}
	
	//factorial?
	public static int factorial(int i) {
		if (i == 1) {
			return i;
		}
		
		else
			return factorial(i-1) * i;
	}

	//check if it's a palindrome
	public static boolean isPalindrome(String s) {
		
		int endString = s.length()-1;
		int length = Math.floorDiv(s.length(), 2);
		
		for (int j = 0; j < length; j++) {
			if (s.charAt(j) != s.charAt(endString - j)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPrime(int number) {
		//let's only get integers over 1
		if (number <= 1)
			return false;
		else {
			//start dividing by each number until we get to half, 
			//if any of them have a non-zero remainder then pass fail
			for(int iter = 2; iter < number*0.5; iter++) {
				if (number % iter == 0) {
					return false;
				}
			}
		}
		//must be prime if it made it this far
		return true;
	}
	
	public static int getNumberFromInput(Scanner s) {

		//loop until we get what we want
		//a has to be 0 or less
		int a = 0;
		
		while (a <= 0) {
			//get what the user entered
			String temp = s.next();
			//check that it's a number
			if( temp.matches("[0-9]+") ) {
				//parse the string as an integer
				//less than zero...
				if (Integer.parseInt(temp) <= 0)
					System.out.println("Please enter a number greater than 0: ");
				//if the number is valid, pass it in and move on
				else
					a = Integer.parseInt(temp);
			}
			//if it's not a number...
			else {
				System.out.println("Please enter a number only: ");
			}
		}
		
		return a;
	}
	
	public static float getFloatFromInput(Scanner s) {
		
		//loop until we get what we want
		//a has to be 0 or less
		float a = 0f;
		
		while (a <= 0f) {
			//get what the user entered
			String temp = s.next();
			//check that it's a number
			if( temp.matches("[0-9]+\\.[0-9]+") ) {
				//parse the string as an integer
				//less than zero...
				if (Float.parseFloat(temp) <= 0)
					System.out.println("Please enter a number greater than 0: ");
				//if the number is valid, pass it in and move on
				else
					a = Float.parseFloat(temp);
			}
			//if it's not a number...
			else {
				System.out.println("Please enter a decimal value (ex. 1.0): ");
			}
		}
		
		
		return a;
	}
}
