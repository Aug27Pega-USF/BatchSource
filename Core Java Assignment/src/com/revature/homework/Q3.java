package com.revature.homework;

public class Q3 {
	void reverseString(String word) {
		System.out.println("Q3: Reversing a string.");
		String reversed = "";
		
		//start from the last char and go backward to the first char
		for(int i = word.length()-1; i >= 0; i--) {
			reversed += word.charAt(i);
		}
		System.out.println(reversed);
		System.out.println();
	}
}
