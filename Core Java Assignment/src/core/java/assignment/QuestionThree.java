package core.java.assignment;

public class QuestionThree {

	public String reverseString(String theString) {
		for(int i = theString.length() - 1; i >= 0; i--) {
			theString += theString.charAt(i);
		}
		return theString.substring(theString.length() / 2);
	}
	
	public void printReverseString(String theString) {
		System.out.println("Before: " + theString + ", After: " + reverseString(theString));
	}
}
