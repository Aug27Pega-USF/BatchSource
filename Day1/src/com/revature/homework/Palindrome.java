package com.revature.homework;

import java.util.ArrayList;
import java.util.Collection;

public class Palindrome {
    public Collection<String> isPalindrome(ArrayList<String> strings){
        ArrayList<String> palindromeList = new ArrayList<String>();
        for (String s : strings){

            int length = s.length();
            String reverse = "";
            for ( int i = length - 1; i >= 0; i-- ){
               reverse = reverse + s.charAt(i);
           }
           if (s.equalsIgnoreCase(reverse)){
               palindromeList.add(s);
           }
        }
        return palindromeList;
    }
}