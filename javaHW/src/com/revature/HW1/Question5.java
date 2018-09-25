package com.revature.HW1;

public class Question5 {
	static String substring(String str, int idx) {
        if (idx > str.length()) {
            /*
             * if the end index is greater than the total length of the String,
             * returns the string unchanged
             */
              return str;
              }
        String sub = "";
        for (int i = 0; i < idx; i++) {
              /*
              * getting the character at i position, and appends to the output
              * String
              */
              sub += str.charAt(i);
        }
        return sub;
  }
  public static void main(String[] args) {
        /*
        * Demonstrating the working of the substring method
        */
        String string="This is a sentence";
        System.out.println("Original String: "+string);
        System.out.println("substring(string,4): "+substring(string, 4));
        System.out.println("substring(string,2): "+substring(string, 2));
        System.out.println("substring(string,50): "+substring(string, 50));
        System.out.println("substring(string,8): "+substring(string, 8));
  }
}
