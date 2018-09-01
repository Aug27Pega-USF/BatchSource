package com.driver.questions;

import java.util.ArrayList;

import com.driver.functions.Functions;

public class Q8 {
	/*
	 * Q8: Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
	 */
	public static void question() {
		//new array
		ArrayList<String> words = new ArrayList<String>();
		//populate with entries
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		//display all the entries
		System.out.println("All words: " + words);
		
		//this array is going to contain only palindromes
		ArrayList<String> palindromes = new ArrayList<String>();
		
		//loop through the words
		for (int i = 0; i < words.size(); i++) {	
			//check if they're a palindrome
			if (Functions.isPalindrome(words.get(i))) {
				//add them to the palindrome array
				palindromes.add(words.get(i));
			}
		}
		
		//display all the new entries
		System.out.println("All palindromes: " + palindromes);
	}
}
