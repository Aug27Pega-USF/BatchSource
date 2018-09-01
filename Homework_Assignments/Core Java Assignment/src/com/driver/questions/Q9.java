package com.driver.questions;

import java.util.ArrayList;

import com.driver.functions.Functions;

public class Q9 {
	/*
	 * Q9: Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console. 
	 */
	public static void question() {
		//create that array
		ArrayList<Integer> primePrep = new ArrayList<Integer>();
		
		//put numbers 1-100 in it
		for (int i = 1; i <= 100; i++) {
			primePrep.add(i);
		}
		
		//loop through the array, printing only the prime numbers
		System.out.print("Printing out Prime Numbers from 100: ");
		for (int i:primePrep) {
			if(Functions.isPrime(primePrep.get(i-1))) {
				System.out.print(primePrep.get(i-1) + ", ");
			}
		}
	}
}
