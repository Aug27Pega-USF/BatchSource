package com.revature.beans;

public class Driver {

	private static HondaFactory hf= new HondaFactory();
	public static void main(String [] args)
	{
		Car c1 = hf.getCar("crv","rlue");
		Car c2 = hf.getCar("Civic","clear");
		Car c3= hf.getCar("hotdog", "RED?");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
