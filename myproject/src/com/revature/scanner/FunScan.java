package com.revature.scanner;

import java.util.Scanner;

public class FunScan {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String contents;
		System.out.println("What would you like to print?");
		contents = sc.nextLine();
		System.out.println(contents);
		
		
		System.out.println("What would you like to print?");
		contents = sc.nextLine();
		System.out.println(contents);
		
	}

}
