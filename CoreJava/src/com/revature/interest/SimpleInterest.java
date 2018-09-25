/*
 * write a program that calculate the simple interest on the principal, rate of interest
 * and number of years provided by the user. enter principal,
 *  rate and time thru the console using Scanner class
 *  interest = Principal * rate * time;
 */
package com.revature.interest;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the amount of the principal");
		double principal = sc.nextDouble();
		System.out.println("enter the rate");
		double rate = sc.nextDouble();
		System.out.println("enter the time");
		double years = sc.nextInt();
		
		double interest = principal * rate * years;
		
		System.out.println(" your interest will be: " +interest);
		

	}

}
