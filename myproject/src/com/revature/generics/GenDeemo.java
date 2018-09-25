package com.revature.generics;

public class GenDeemo {

	public static void main(String[] args) {
		//create a Gen reference for Integers
		Gen<Integer> i;
		
		//create Gen<Integer> object and assign it to reference i
		i = new Gen<Integer>(88);
		
		//show  type of i
		i.showType();
		
		//get the value of i
		int v = i.getOb();
		System.out.println("Value: "+ v);
		
		Gen<String> s = new Gen<String>("Generics Test");
		
		s.showType();
		String str = s.getOb();
		System.out.println("value: " + str);
	}

}
