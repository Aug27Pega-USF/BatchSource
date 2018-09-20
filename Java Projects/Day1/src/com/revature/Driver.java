package com.revature;

import com.revature.beans.Person;
import com.revature.beans.Shark;

public class Driver {

	// JVM looks for a method with this signature as an entrance point to the program
	public static void main(String[] args) {	// main method
		
		System.out.println("Roll Tide");
		
		Person jimbo = new Person();
		jimbo.setName("Jimbbo");
		System.out.println(jimbo.getName() + " is from " + jimbo.getHomePlanet());
		
		Person p = new Person("Thom",34, 215);
		System.out.println(p.toString());
		
		Shark shark = new Shark();
		shark.breath();
		shark.findPrey();
		
		
		
	}
}


// NOTES


//void - no return type
// public - makes it accessible throughout
// static - means that the variable or function is shared between  
// all instances of that class as it belongs to the type, not the actual objects themselves. 


// static variables - referenced by/ belongs to class instead of object, members of class can access it // species name
// instance variable - belongs to object // dog name

// static methods - belong to class
// instance methods - belong to specific object