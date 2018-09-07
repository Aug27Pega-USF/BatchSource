package coreJavaHomework;

public class Q3StringReverse {
	public static void StringReverse(String str){
		System.out.println(str);
		int len = str.length();
		for (int i = (len-1); i >= 0; --i) { 
			str += str.charAt(i);} //Adds characters in reverse order to the string
		str = str.substring(len); //cuts the new string to just the reversed half

	    System.out.println(str +"\n");
	}
}

