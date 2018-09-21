package com.driver.questions;

import question.twenty.IO;


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



