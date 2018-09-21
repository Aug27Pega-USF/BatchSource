package com.driver.questions;

import java.util.ArrayList;

import com.driver.functions.Functions;

public class Q19 {
	/*
	 * Q19: Create an ArrayList and insert integers 1 through 10. 
	 * Display the ArrayList. Add all the even numbers up and display the result. 
	 * Add all the odd numbers up and display the result. 
	 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	 */
	public static void question() {
		//new array list
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		//add 1-10
		for(int i = 1; i <= 10; i++) {
			intList.add(i);
		}
		//display it
		System.out.println("Array list created: ");
		System.out.println(intList);
		
		//add all the even numbers up and all the odd numbers up
		int evenResult = getEvensTotal(intList);
		int oddResult = getOddsTotal(intList);

		//display result
		System.out.println("Result of all even numbers: " + evenResult);
		System.out.println("Result of all odd numbers: " + oddResult);
		
		//remove all prime numberinos
		for(int i = 0; i < intList.size(); i++) {
			if (Functions.isPrime(intList.get(i))) {
				intList.remove(i);
				i--;
			}
		}
		
		//display the new list
		System.out.println("Array list with no Prime Numbers: ");
		System.out.println(intList);
	}
	
	public static int getEvensTotal(ArrayList<Integer> intList) {
		int res = 0;
		for(int i = 0; i < intList.size(); i++) {
			if (intList.get(i) % 2 == 0)
				res += intList.get(i);
		}
		return res;
	}
	
	public static int getOddsTotal(ArrayList<Integer> intList) {
		int res = 0;
		for(int i = 0; i < intList.size(); i++) {
			if (intList.get(i) % 2 == 1)
				res += intList.get(i);
		}
		return res;
	}
}
