package com.revature;

public class overloading {
	public static void add(int a, int b) {
		System.out.println("exact");
		System.out.println(a+b);	
	}
	public static void add(Integer a, Integer b) {
		System.out.println("boxing");
		System.out.println(a+b);
	}

	public static void add(double a, double b) {
		System.out.println("conversion");
		System.out.println(a+b);
	}
	public static void add(float a, float b) {
		System.out.println("conversion");
		System.out.println(a+b);	
	}
	public static void add(int ... a ) {
		System.out.println("varargs");
		int sum=0;
		for(int i : a) {
			sum+=i;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		add(1,2);
	}
}
