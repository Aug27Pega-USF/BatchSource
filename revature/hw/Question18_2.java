package com.revature.hw;

public class Question18_2 extends Question18 {
	public static void main(String[] args) {
		System.outln(part1.isUpper(false) + " " 
				+part1.toUpper("Get Money") + "  " + part1.addedResult("3"));
	}

	public boolean isUpper(String strA) {
		String a = "true";
		String b = "false";
		String strB = strA.toLowerCase();
		
		if(strA.equals(strB)) {
			return b;
		} else {
			return a;
		}
	}
	public String toUpper(String a) {
		return a.toUpperCase();
	}

	public String addedResult(String a) {
		int b = Integer.parseInt(a) + 10;
		String c = Integer.toString(b)
		return c;
	}
}
