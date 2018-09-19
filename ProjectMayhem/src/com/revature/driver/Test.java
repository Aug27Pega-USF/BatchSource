package com.revature.driver;


public class Test {

	public static void chag(int x, int y) {
		System.out.println("int x, int y, Exact match");
		
	}


	public static void chag(double x, double y) {
		System.out.println("double x, double y, conversion");

	}
	
	
	public static void chag(Integer x, Integer y) {
		System.out.println("Integer x, y, Boxing");
	}
	
	public static void chag(int...chags) {
		System.out.println("int..... var args");
		
	}
	
	public static void main(String [] args) {
		
		chag(5,4);
		chag(3.00,2.00);
		chag(5, 3);
		chag( 3,2,1);
		
	}
}
