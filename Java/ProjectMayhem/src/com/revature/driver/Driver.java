package com.revature.driver;

import com.revature.beans.Person;

// Packages- namespaces that organize related class and interfaces
public class Driver {
	//this is a single comment
	
	/*
	 * this
	 * is
	 * a
	 * multi line
	 * comment
	 */
	
	/*
	 * Naming Conventions
	 * Classes and Projects: Pascal case- capitalize each ex.ProjectMayhem
	 * methods and variables: camelCase- ex. firstSecondThird 
	 * Package name: all lowercase, separated by periods
	 * constants: ALL_CAPS_LOLZ
	 */
	
	//main method is the entry point
	public static void main(String[] args) {
		/*
		 * static: we dont need an instance/belongs to class
		 * void: doesn't return anything
		 * String[] args- arg to be utilized in a method
		 */
		//System.out.println("I did a thing!");
		
		Person p =new Person();
		p.setName("Paul");
		System.out.println(p.getName() + " is from "+ p.getHomePlanet());
		
		Person p2 = new Person("Fatty",32, 74898);
		System.out.println(p2.toString());
		
	}

}
