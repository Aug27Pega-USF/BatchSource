package com.driver.questions;

import java.util.Scanner;

import com.driver.functions.Functions;

public class Q17 {
	/*
	 * Q17: Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
	 * Enter principal, rate and time through the console using the Scanner class.
		Interest = Principal* Rate* Time
	 */
	public static void question() {
		//open input stream
		Scanner s = new Scanner(System.in);
		//prep our fields
		int principal;
		float interestRate;
		int years;
		
		//prompts
		System.out.println("What is the principal (initial sum of money) to be entered?");
		System.out.println("Click and type a number here: ");
		
		//get fields
		principal = Functions.getNumberFromInput(s);
		System.out.println("Enter an interest rate: ");
		interestRate = Functions.getFloatFromInput(s);
		System.out.println("Enter number of years: ");
		years = Functions.getNumberFromInput(s);
		
		System.out.println("Interest is: " + (principal * interestRate * years));
		
		//close the input stream
		s.close();
	}
}
