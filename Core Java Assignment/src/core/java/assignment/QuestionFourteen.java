package core.java.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class QuestionFourteen {
	public void switching(int option) throws IOException{
		switch(option) {
		case 1:
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a number to find the square root: ");
			System.out.println(Math.sqrt(Integer.parseInt(reader.readLine())));
			break;
		case 2:
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			System.out.println(format.format(new Date()));
			break;
		case 3:
			System.out.println("I am learning Core Java");
			String[] str = "I am learning Core Java".split(" ");
			System.out.println(new ArrayList<String>(Arrays.asList(str)));
			break;
		default:
			System.out.println("Goodbye!");
			break;
		}
	}
}
