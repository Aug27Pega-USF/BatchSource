package com.revature.inheritenceTest;

public class Raptor extends Bird {

	//static block
	static {
		System.out.println("r1");
	}
	
	public Raptor() {
		System.out.println("r2");
	}
	
	//instance block
	{
		System.out.println("r3");
	}
	
	//static block
	static {
		System.out.println("r4");
	}
}
