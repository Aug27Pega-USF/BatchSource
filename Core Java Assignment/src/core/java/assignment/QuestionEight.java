package core.java.assignment;

import java.util.ArrayList;

public class QuestionEight {
	ArrayList<String> wordList = new ArrayList<String>();
	
	public QuestionEight(String ...strings){
		for(String s : strings) {
			wordList.add(s);
		}
	}
	
	public ArrayList<String> findPalindromes(){
		ArrayList<String> palindromeList = new ArrayList<String>();
		
		for(String word : wordList) {
			int wordLength = word.length();
			int halfLength = wordLength / 2;
			boolean palindrome = false;
			
			for(int i = 0; i <= halfLength; i++) {
				if(i == halfLength) {
					palindrome = true;
				} else if(word.charAt(i) == word.charAt(wordLength - i - 1)) {
					continue;
				} else
					break;
			}
			if(palindrome) {
				palindromeList.add(word);
			}
		}
		return palindromeList;
	}
}
