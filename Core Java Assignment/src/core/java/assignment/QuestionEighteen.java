package core.java.assignment;

import core.java.assignment.utility.QuestionEighteenUtil;

public class QuestionEighteen extends QuestionEighteenUtil{
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
	
	public void printMenu() {
		System.out.println("\n=== Menu ===");
		System.out.println(" 1. Checks if an upper case exists");
		System.out.println(" 2. Converts all lower cases into an upper case");
		System.out.println(" 3. Adds 10 to an integer");
	}
}
