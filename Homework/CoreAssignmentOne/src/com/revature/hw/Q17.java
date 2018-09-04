package com.revature.hw;

import java.util.Scanner;

public class Q17 {
		Scanner scan = new Scanner(System.in);
	 //Q17 calculate Interest from user input 
	  public static double simpleInterest(){
	    double principle, rate,years;
	    principle = rate = years = 0;
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Enter The Principle Amount:");
	    principle = scan.nextDouble();
	    System.out.println("Enter The Interest Rate:");
	    rate=scan.nextDouble();
	    rate = (rate/100);
	    System.out.println("Enter The Number Of Years:");
	    years = scan.nextInt();
	    return (principle *rate*years);
	    
	  }
}
