package com.revature.homework;

public class Q6 {
	void isEven(int num) {
		System.out.println("Q6: Checking if a number is even.");
		
		int evenOrNot = num / 2;
		evenOrNot *= 2;
		
		if(evenOrNot == num) {
			System.out.println("The number " + num + " is even!");
		}
		else {
			System.out.println("Nope, " + num + " is not even.");
		}
		System.out.println();
	}
}
