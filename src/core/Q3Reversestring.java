package core;

public class Q3Reversestring {
	void reversal(String s) {
		int len= s.length();
		String reverse = "";
		for (int i=len-1; i!=-1; i--) {
			reverse+=s.charAt(i);
		}
		System.out.println(reverse);
	}
}
