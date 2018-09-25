/*
 * Write a program to determine if an integer 
 * is even without using the modulus operator (%)
 * if n mod 2 == 0 not that 
 * if n ==  2y ---> n/y = 2;

 */
package com.revature.even;

import java.util.Scanner;

public class EvenNoMod {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a numerator!");
		int n = sc.nextInt();
		System.out.println("Enter a denominator!");
		int y = sc.nextInt();
		System.out.println(n/y);
		//n & 0x01 
		if( n == 2 * y) {
			System.out.println(" n is even");
		}else {
			System.out.println("n is odd ");
		}

	}

}
