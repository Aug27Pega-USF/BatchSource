package core;

public class Q3Reversestring {
	void reversal(String s) {
		int len= s.length();
		for (int i=len-1; i!=-1; i--) {
			s+=s.charAt(i);
		}
		s=s.substring(len, len*2);
		System.out.println(s);
	}
}
