package coreJavaHomework;

import java.util.ArrayList;

public class Q8PalindromeSort {
	
	public static ArrayList<String> arrayLoad(){
		ArrayList <String> words = new ArrayList <>(); //Create list of words to test
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		return words;
	}
	public static boolean palindromeCheck(char[] word) {
		int i = 0;
		int j = word.length -1;
		while (j>i) {
			if(word[i] != word[j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	public static void PalindromeSort() {
		ArrayList <String> words = arrayLoad();
		ArrayList <String> palindromes = new ArrayList <>(); //Create list of words to test
		for(int k=0;k<(words.size());k++) {
			if(palindromeCheck(words.get(k).toCharArray()))
				palindromes.add(words.get(k));
		}
		for(int i=0;i<palindromes.size();i++) {
			System.out.println(palindromes.get(i));}
		System.out.println();
	}
}
