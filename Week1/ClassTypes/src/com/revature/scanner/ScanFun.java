package com.revature.scanner;

import java.util.Scanner;

public class ScanFun {

	public static Scanner sc= new Scanner(System.in);
	public static void main(String[] args)
	{
		String contents;
		System.out.println("What would you like to print?");
		contents= sc.next();
		System.out.println(contents);
		//sc.close();
		System.out.println("What would you like to print?");
		contents= sc.next();
		System.out.println(contents);
	}
}
