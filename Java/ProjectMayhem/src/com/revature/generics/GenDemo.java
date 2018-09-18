package com.revature.generics;

public class GenDemo {

	public static void main(String[] args) {
		//Create a Gen reference for Integers
		Gen<Integer> i;
		//Create Gen<Integer> object and assign it to reference i
		i=new Gen<Integer>(88);
		//show the type of i
		i.showType();
		//get the value of i
		int v=i.getOb();
		System.out.println("Value: "+v);
		
		Gen<String> s = new Gen<String>("Generics Test");
		s.showType();
		String str =  s.getOb();
		System.out.println("value: "+str);

	}

}
