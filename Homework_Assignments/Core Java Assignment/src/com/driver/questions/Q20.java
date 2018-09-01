package com.driver.questions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Q20 {
	/*
	 * Q20: Create a notepad file called Data.txt and enter the following:
	 * Mickey:Mouse:35:Arizona
	 * Hulk:Hogan:50:Virginia
	 * Roger:Rabbit:22:California
	 * Wonder:Woman:18:Montana
	 * 
	 * Write a program that would read from the file and print it out to the screen in the following format:
	 * Name: Mickey Mouse
	 * Age: 35 years
	 * State: Arizona State
	 */
	public static void question() {
		//new instance of IO
		//class created below
		IO io = new IO();
		
		//set string to contents parsed from files
		String s = io.readFile();
		
		//split the file line by line into an array
		String[] sArrayLines = s.split("\r\n|\r|\n");

		//breaking each entry down into it's parts for display
		for(int i = 0; i < sArrayLines.length; i++) {
			String[] sArrayParts = sArrayLines[i].split(":");
			//print it out
			System.out.println("Name: " + sArrayParts[0] + " " + sArrayParts[1]);
			System.out.println("Age: " + sArrayParts[2] + " years");
			System.out.println("State: " + sArrayParts[3] + " State");
			System.out.println("*********************");
		}
	}
}

//question 20
//class for opening the iostream and getting external file data
class IO {
	//reference to the file we're getting
	private static final String inString = "Data.txt";
	
	//function to get the data from the file
	public String readFile(){
		//reference to our stream for getting data 
		InputStream is = null;
		//reference object for the file
		File file = new File(inString);
		//reference object for manipulating the string data itself
		StringBuilder s = new StringBuilder();
		
		//generating a try-catch in case the file's not found
		try {
			//pass in a stream to our file
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//temp variable to make sure file's been read
		int b = 0;
		
		try {
			//goes through the file until it reaches the end
			while ( (b=is.read()) != -1) {
				char c = (char) b;
				//adds each character to the string
				s.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//if our stream is still open, close it
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//give us the string
		return s.toString();
	}
}

