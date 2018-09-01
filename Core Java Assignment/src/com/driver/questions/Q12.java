package com.driver.questions;

import java.util.ArrayList;

public class Q12 {
	/*
	 * Q12: Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	 */
	public static void question() {
		//create that array
		ArrayList<Integer> primePrep = new ArrayList<Integer>();
		
		//put numbers 1-100 in it
		for (int i = 1; i <= 100; i++) {
			primePrep.add(i);
		}
		
		//loop through the array, printing only the even numbers
		System.out.print("Printing out Even Numbers from 100: ");
		for (int i:primePrep) {
			if(primePrep.get(i-1) % 2 == 0) {
				System.out.print(primePrep.get(i-1) + ", ");
			}
		}
	}
}
