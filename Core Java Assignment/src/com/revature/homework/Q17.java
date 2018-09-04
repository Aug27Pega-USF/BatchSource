package com.revature.homework;

import java.util.Scanner;

public class Q17 {
	void calculateInterest() {
		System.out.println("\nQ17: Calculating interest based on scanned input values.");
		
		double interest, principal, rate, time;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your principal amount: ");
		principal = scan.nextDouble();
		System.out.println("Enter the rate: ");
		rate = scan.nextDouble();
		System.out.println("Enter the amount of time: ");
		time = scan.nextDouble();
		interest = principal * rate * time;
		
		System.out.println("Your principal is " + principal + ".");
		System.out.println("The rate is " + rate + ".");
		System.out.println("The amount of time is " + time +".");
		System.out.println("Your interest is calculated to be: " + interest + ".");
		
		scan.close();
	}
}