package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a Gen reference for integers
		Gen<Integer> iOb;
		// Create a Gen<Integer> object, and assign it 
		// reference to iOb.
		iOb = new Gen<Integer>(88);
		// show the type of iOb
		iOb.showType();
		
		// Get th e value in iOb;
		int v = iOb.getob();
		System.out.println("Value of v is " + v);
		
		Gen<String> strOb;
		strOb = new Gen<String>("Throb");
		strOb.showType();
		String str = strOb.getob();
		System.out.println("Value of str is " + str);
	}

}
