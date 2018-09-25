package com.revature.HW1;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // scanner declaration
        System.out.println("Enter principle amount :");
        
        float principle = scanner.nextFloat(); // accept the amount
        System.out.println("Enter time in years : ");
        
        float time = scanner.nextFloat(); // accept time
        System.out.println("Enter rate annually : ");
        
        float rate = scanner.nextFloat(); // accept time
        float interest = (principle*rate*time)/100; // calculate interest
        System.out.println("Simple interest of the amount is : " + interest); // print the interest

	}

}
