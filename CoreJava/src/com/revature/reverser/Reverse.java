package com.revature.reverser;

public class Reverse {

	public static void main(String[] args) {
		reverse("revature");

	}
	public static void reverse(String str) {
		for(int i = str.length() -1; (i < str.length() && i >= 0); i-- ) {
			System.out.print(str.charAt(i));
		}
	}

}
