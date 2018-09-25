package com.revature.hw;

public class Q3StringReverse {

	String StringReverse(String str) {
	int n = str.length();
	for(int i=0;i<n;i++) {
		str = str.substring(1, str.length() -i) +str.substring(0,1) + str.substring(str.length()-i, str.length());		
		}
	return str;		
	}
}
