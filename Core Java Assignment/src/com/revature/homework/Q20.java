package com.revature.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20 {
	void readTxtFile() throws FileNotFoundException {
		String line = "";
		String[] sentence = new String[4];
		System.out.println("\nQ20: Reading and printing from a txt file.\n");
		String[] filelist = new String[5];
		int count = 0;
		File file = new File("C:\\Git\\Revature\\Homework and Projects\\BatchSource\\Core Java Assignment\\Data.txt");
		Scanner scan = new Scanner(file);
		
		//Reading each line from the text file
		System.out.println("Original text from Data.txt file:");
		while(scan.hasNext()) {
			filelist[count] = (scan.nextLine());
			System.out.println(filelist[count]);
			count++;
		}
		count = 0;
		System.out.println("\nTranslated into specified format:");
		//Saving each line into separate sentences
		for(int i = 0; i < filelist.length-1; i++) {
			line = filelist[i];
			for(String word: line.split(":")) {
				sentence[count] = word;
				count++;
			}
			count = 0;
			System.out.println("Name: "+sentence[0]+" "+sentence[1]+ "\nAge: "+sentence[2]+" years\nState: "+sentence[3]+ " State\n");
			for(int j = 0; j < sentence.length; j++) {
				sentence[j] = "";
			}
		}
		scan.close();
	}
}
