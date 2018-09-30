package com.revature.hw;

public class Q8Palidrome {
	

    public static boolean isPalindrome(String str) {
    String reverse = "";
    for (int i = str.length() - 1; i >= 0; i--) {
    reverse = reverse + str.charAt(i);
    }
    return str.equals(reverse);
    }
}
