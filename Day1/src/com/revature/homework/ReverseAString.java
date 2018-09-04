package com.revature.homework;

public class ReverseAString {
	public void reverseString(String str) {
		for(int i = str.length()-1; i>=0;i--) {
			System.out.print(str.charAt(i));
		}
	}
}
