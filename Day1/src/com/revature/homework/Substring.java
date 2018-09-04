package com.revature.homework;

public class Substring {
	
	public void returnSubstring(String str, int idx) {
		if(idx > str.length()) {
			System.out.println("idx index too large");			
		}
		else if(idx < 1){
			System.out.println("");
		}
		else {
			String result="";
			for (int i = 0; i != idx; i++) {
				result += str.charAt(i);
			}
			System.out.println("" + result);
		}
		
	}
}
