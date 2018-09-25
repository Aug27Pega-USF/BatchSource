/*
 * Find the minimum of two numbers using the ternary operator
 * last == x ? do something : do something else
 */
package com.revature.ternary;

import java.util.Scanner;

public class Minimum {

	public static void main(String[] args) {
		int minVal;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number?");
		int x = sc.nextInt();
		System.out.println("enter a second number?");
		int y = sc.nextInt();
		minVal = (x < y) ? x : y;
		System.out.println("the minimum value is: " +minVal);
		

	}

}
