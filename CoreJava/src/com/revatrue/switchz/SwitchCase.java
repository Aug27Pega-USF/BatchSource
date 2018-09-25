package com.revatrue.switchz;

import java.util.Date;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		//int selection = sc.nextInt();
		int selection = choice();
		switch(selection) {
		case 1: 
			System.out.println("enter  a number to get its square root");
			double num = sc.nextDouble();
			squareRoot(num);
		break;
		case 2: 
			todaysDate();
		break;
		case 3: 
			System.out.println("enter  a string to get its splitted");
			String string = sc.nextLine();
			splitAString(string);
		break;
		default:
			System.out.println("Not a valid operation number");
		
		}
	}
	
	public static double  squareRoot(double number) {
		double sq = Math.sqrt(number);
		return sq;
	}
	
	public static Date todaysDate() {
		Date date = new Date();
		return date;
	}
	public static String[] splitAString(String str) {
		String [] val = str.split("");
		return val;
	}
	public static int choice() {
		Scanner scan = new Scanner(System.in);
		System.out.println("choose the operation");
		System.out.println("1- find the square root of a number");
		System.out.println("2- display today's date");
		System.out.println("3- split the string I am learning Core Java");
		System.out.println("choose an operation");
		int selection = scan.nextInt();
		
		return selection;	
	}

}
