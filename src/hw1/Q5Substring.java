package hw1;

public class Q5Substring {
	public String substr(String s, int idx) {
		if(idx>s.length()) {
			System.out.println("Given integer is larger than the length of the string.");
			return s;
		}
		else if(idx<1){
			System.out.println("Given integer is not a positive integer.");
			return "";
		}
		else {
			String sub="";
			for (int i=0; i!=idx; i++) {
				sub+=s.charAt(i);
			}
			return sub;
		}
		
	}
	
}
