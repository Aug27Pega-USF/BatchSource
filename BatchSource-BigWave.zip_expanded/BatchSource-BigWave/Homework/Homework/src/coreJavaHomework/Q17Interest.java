package coreJavaHomework;

import java.util.Scanner;

public class Q17Interest {
	public static void interestCalc() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principal: ");
		int principal = sc.nextInt();
		System.out.println("Enter the rate of interest: ");
		float rate = sc.nextFloat();
		System.out.println("Enter the number of years: ");
		float years = sc.nextFloat();
		
		System.out.println("The simple interest is $"+(principal*rate*years));
	}
}
