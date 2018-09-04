package com.revature.homework;

public class Q5 {
	String substring(String str, int idx) {
		System.out.println("Q5: Printing only part of a whole string.");
		String partial = "";
		
		for(int i = 0; i < idx; i++) {
			partial += str.charAt(i);
		}
		
		return partial;
	}
}
