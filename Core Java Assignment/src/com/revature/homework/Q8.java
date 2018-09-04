package com.revature.homework;

import java.util.*;

public class Q8 {
	void sortPalin(ArrayList<String> words) {
		//create the ArrayList for the palindromes
		ArrayList<String> palinlist = new ArrayList<String>();
		
		System.out.println("Q8: Saving palindromes to a separate ArrayList.");
		System.out.println("\nFull array of words:");
		for(int i = 0; i < words.size(); i++) {
			System.out.print(words.get(i) + " ");
		}
		System.out.println(); //skipping line for readability
		
		for(int i = 0; i < words.size(); i++) {
			if(isPalin(words.get(i))) {
				palinlist.add(words.get(i));
			}
			else {
				continue;
			}
		}
		
		System.out.println("\nArray of only palindromes:");
		for(int i = 0; i < palinlist.size(); i++) {
			System.out.print(palinlist.get(i) + " ");
		}
		System.out.println(); //skipping line for readability
	}
	
	public boolean isPalin(String str) {
		String reversed = "";
		for(int i = str.length()-1; i >= 0; i--) {
			reversed = reversed + str.charAt(i);
		}
		if(str.equals(reversed)) {
			return true;
		}
		else {
			return false;
		}
	}
}
