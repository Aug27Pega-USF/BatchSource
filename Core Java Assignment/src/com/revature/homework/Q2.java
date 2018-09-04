package com.revature.homework;

public class Q2 {
	//Printing out the first 25 numbers of the the Fibonacci sequence (being passed as count = 25)
	void fibonacci(int count) {
		System.out.println("Q2: First 25 Fibonacci numbers.");
		int num1 = 0, num2 = 1, num3;
		System.out.print(num1 + " " + num2); // print the first two numbers of the sequence
		
		for(int i = 2; i < count; ++i) { //starting from index 2 since 0 and 1 are already printed
			num3 = num1 + num2;
			System.out.print(" " + num3); //print out the rest of the sequence
			num1 = num2;
			num2 = num3;
		}
		System.out.println();
        System.out.println();
	}
}
