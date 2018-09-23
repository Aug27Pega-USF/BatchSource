package com.revature.javahomework;

public class QuestionThirteen {
	public String printBinaryTriangle(boolean startingBinary, int tiers) {
		String triangleString = "";
		for(int i = 1; i <= tiers; i++) {
			for(int j = 0; j < i; j++) {
				triangleString += (startingBinary ? 1 : 0 )+ " ";
				startingBinary = !startingBinary;
			}
			triangleString += "\n";
		}
		return triangleString;
	}
}
