package com.revature.javahomework;

import utility.QEighteenUtility;

public class QEighteen extends QEighteenUtility{
	@Override
	public boolean checkUppercase() {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				return true;
		}
		return false;
	}

	@Override
	public String toUppercase() {
		char[] newString = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				newString[i] = (char)(str.charAt(i) - 32);
			} else {
				newString[i] = str.charAt(i);
			}
		}
		return String.copyValueOf(newString);
	}

	@Override
	public int toIntegerAndAdd() {
		return Integer.parseInt(str) + 10;
	}
}

