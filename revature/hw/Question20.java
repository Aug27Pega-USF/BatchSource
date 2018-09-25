package com.revature.hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question20 {
	public static void main(String[] args) throws Exception {
		try {
			File file = new file("Data.txt");
			Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) { //so long as there is another line in data.txt
              String line = sc.nextLine(); //the value line with contain the upcoming line
            String[] details = line.split(":"); //line will have the values split at the semicolon and
                                                //stored within the string array details
            String Firstname = details[0]; //First name is declared as the first value
            String Lastname = details[1]; //Last name is declared as the second value
            String age = details[2]; //age is declared as the third value
            String state = details[3]; //state is declared as the last value
            System.out.println("Name: " + Firstname + " " + Lastname); //prints first and last name
            System.out.println("Age: "+ " " + age); //prints age
            System.out.println("State: " + state); //prints last name
            System.out.println();// prints new line if there is another line in the data file
            }
            
        } catch (FileNotFoundException e) { // if no file is found, throw no file exception
            e.printStackTrace();
        }

    }