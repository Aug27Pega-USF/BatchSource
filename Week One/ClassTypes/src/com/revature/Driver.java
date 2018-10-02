package com.revature;

import com.revature.beans.Shark;
import com.revature.generics.GenericTest;

public class Driver {

	public static void main(String[] args) {
		Shark shark = new Shark();
		shark.breathe();
		shark.findPrey();
		
		//Create a generic test object reference for Integers
		GenericTest<Integer> iOb;
		
		//Create GenericTest object and assign it
		//Reference to iOb
		iOb = new GenericTest<Integer>(88);
		iOb.showType();
		
		int v = iOb.getOb();
		System.out.println("value: "+ v);
		
		GenericTest<String> strOb = new GenericTest<String>("Generic Test");
		
		strOb.showType();
		String str = strOb.getOb();
		System.out.println("value: " + str);
		

	}

}
