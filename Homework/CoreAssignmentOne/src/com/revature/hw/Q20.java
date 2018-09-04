package com.revature.hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20 {
	static Scanner scan = new Scanner(System.in);
	public static void readAndFormat() {
	    String firstName="";
	    String lastName="";
	    String age="";
	    String state="";
	    try {
	      Scanner scanner = new Scanner(new File("Data.txt"));
	      while(scanner.hasNext()) {
	        firstName = scanner.next();
	        lastName = scanner.next();
	        age = scanner.next();
	        state = scanner.next();
	        System.out.println("Name: "+firstName+" "+lastName+ "\nAge: "+age+" years\nState: "+ state+ "State\n");
	      }
	      scan.close();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }
	    
	  }
}
