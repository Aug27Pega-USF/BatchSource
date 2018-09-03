package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Question 20:");
		try {
			File file = new File("Names.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String l = scan.nextLine();
				String[] info = l.split(":");
				System.out.println("Name: " + info[0] + " " + info[1]);
				System.out.println("Age: " + info[2] +" years");
				System.out.println("State " + info[3]);
				System.out.println("\n");
			}
			scan.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
