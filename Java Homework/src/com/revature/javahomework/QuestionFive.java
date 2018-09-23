package com.revature.javahomework;

public class QuestionFive {
	class StringEditor{
		public String substring(String str, int idx) {
			char [] subString =  new char[idx-1];
			for(int i = 0; i < idx - 1; i++) {
				subString[i] = str.charAt(i);
			}
			return String.copyValueOf(subString);
		}
	}
	
	StringEditor se;
	
	public QuestionFive() {
		se = new StringEditor();
	}
	
	public String getSubString(String str, int idx) {
		return se.substring(str, idx);
	}
}
