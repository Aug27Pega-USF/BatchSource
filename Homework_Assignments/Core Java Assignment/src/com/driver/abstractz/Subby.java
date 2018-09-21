package com.driver.abstractz;

public class Subby extends Abstractz {
	@Override
	public boolean method1(String s) {
		//check each character if it's upper case
		for (int i = 0; i < s.length(); i++) {
			
			if(Character.isUpperCase(s.charAt(i))) {
				return true;
			}
		}
		//has to be false if it reached this point
		return false;
	}

	@Override
	public String method2(String s) {
		//converts all characters to uppercase
		return s.toUpperCase();
	}

	@Override
	public int method3(String s) {
		//pass as an int, add 10
		return Integer.parseInt(s) + 10;
	}
}
