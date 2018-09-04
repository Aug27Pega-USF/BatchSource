package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		//Create a Gen reference for Integers 
		Gen<Integer> iOb;
		//Create Gen<Integer> object and assign it 
		//reference to iOb.
		iOb = new Gen <Integer>(88);
		// show the type of iOb
		iOb.showType();
		
		//Get the value in iOb
		int v= iOb.getOb();
		
		System.out.println("value: "+v);
		
		Gen<String> strOb= new Gen<String>("Generics Test");
		
		strOb.showType();
		String str= strOb.getOb();
		System.out.println("value: "+str);
		
	}

}
