package com.revature.hw;

import java.util.ArrayList;

public class Q8 {
	static ArrayList<String> toPalindrome = new ArrayList<String>();
	
	
	
	public static void populateList() {
	    
	    toPalindrome.add("madam");
	    toPalindrome.add("tom");
	    toPalindrome.add("civic");
	    toPalindrome.add("radar");
	    toPalindrome.add("karan");
	    toPalindrome.add("jimmy");
	    toPalindrome.add("kayak");
	    toPalindrome.add("john");
	    toPalindrome.add("refer");
	    toPalindrome.add("billy");
	    toPalindrome.add("did");
	  }
	
	//Q8 call function to populate arrayList with palindromes
	public static ArrayList<String> getPalindromes() { 
	    ArrayList<String> goodPalindromes = new ArrayList<>();
	    for(String word : toPalindrome) {
	      if(isPalindrome(word)) {
	        goodPalindromes.add(word);
	      }		
	    }
	    return goodPalindromes;	
	  }
	
	 //Q8 check if palindrome
	  public static boolean isPalindrome(String word) {
	    boolean result = false;
	    int front = 0; int back = word.length() -1;
	    while(front < back) {
	      if (word.charAt(front++) != word.charAt(back--)) {
	        return false;
	      } else {
	        return true;
	      }
	    }
	    return result;
	  }
	  
	  

}
