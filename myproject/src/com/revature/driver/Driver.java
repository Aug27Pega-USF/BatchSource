package com.revature.driver;

/*	Members of class:
 * 		Instance variable: property of one specific object
 * 		Static variable: property of class/shared by all instances of this class
 * 		Instance method: behavior relative to specific object
 * 		Static method: behavior relative to the entire class
 * 		Constructor: instantiates the class using key word "new"
 */

/*
 * 	Code Blocker: A block of code
 * 		Instance Code Block: execute before constructor when an object is instantiated. {......}
 * 		Static Code Block: exeute once when class is loaded in JVM
 * 		
 * 		Instance Code Block: 
 * 		{System.out.println("I am in the instance block");}
 * 
 * 		Static Code Block:
 * 		static{System.out.println("I am in static code block");}
 * 		
 */

import com.revature.beans.Person; //ctrl shift o to add this automatically in order to remove red lines

//Packages - namespaces that organize related class and interfaces
public class Driver {
	
	//This is a single line comment
	
	/*
	 * Naming Conventions
	 * Classes and Projects: Pascal case- capitalize each name ex.ProjectJava
	 * methods and variables: camelCase- ex. firstSecondThird
	 * Package name: all lowercase, separated by periods
	 * constants: ALL_CAPS_LOLZ
	 */
	
	
	//main method is the entry point
	public static void main(String[] args) {
		/*
		 * static: we do not need an instance/belongs to class
		 * void: does not return anything
		 * String[] args- arg to be utilized in a method
		 */
		
		System.out.println("I did a thing!");
		Person p = new Person(); //p is identifier
		p.setName("Paul");
		System.out.println(p.getName() + " is from " + p.getHomePlanet());
		
		Person p2 = new Person("Fatty", 32, 7848);
		System.out.println(p2.toString());
	}
}
