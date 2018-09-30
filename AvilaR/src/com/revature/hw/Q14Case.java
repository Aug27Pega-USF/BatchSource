package com.revature.hw;

import java.util.Date;

public class Q14Case {

	public void caseProb(int a) {
		double number = 10;
		switch (a) {
		case 1:

			number = Math.sqrt(number);
			System.out.println("Sqare Root: " + number);
			break;
		case 2:
			Date date = new Date();
			System.out.println("Todays Date: " + date);
			break;
		case 3:
			String s = "I am learning Core Java";
			String sArray[] = s.split(" ");
			for (String token : sArray) {
				System.out.println("String Array Value: " + token);
			}
			break;
		default:
			break;
		}
	}
}
