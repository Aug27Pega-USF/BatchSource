package com.revature;

import com.revature.beans.Person;

public class Driver {
	//JVM looks for a method with this signature as an entrance point to the program
	public static void main (String[] args) {
		System.out.println("Roll Tide");
		Person jimbo =new Person();
		jimbo.setName("Jimbo");
		System.out.println(jimbo.getName() + " is from " + jimbo.getHomePlanet());
		}
}
