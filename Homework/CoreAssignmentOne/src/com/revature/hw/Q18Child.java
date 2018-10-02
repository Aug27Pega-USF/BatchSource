package com.revature.hw;

public class Q18Child extends Q18Parent {

	/*
	 * Pass in a string
	 * "if string does NOT equal lowercase version of itself it contains a capital and returns true"
	 * 
	 */
	@Override
	protected boolean checkUpper(String str) {
		return !str.equals(str.toLowerCase());
	}

	/*
	 * Pass in a string
	 * create string builder and append string 
	 * iterate throught StringBuilder because it is mutable
	 * convert any lower case to upper case in StringBuiler
	 * set original string to toString value of StringBuilder and return
	 */
	@Override
	protected String convertLowerToUpper(String str) {
		StringBuilder mutable = new StringBuilder();
		mutable.append(str);
		for(int x=0;x<str.length();x++) {
			char c = str.charAt(x);
			if(Character.isLowerCase(c)) {
				mutable.setCharAt(x, Character.toUpperCase(c));
			}
		}
		str = mutable.toString();
		return str;
	}

	@Override
	protected int convertStringToInt(String str) {
		int newLong= 0;
		newLong = Integer.parseInt(str);
		newLong += 10;
		return newLong;
	}
}
