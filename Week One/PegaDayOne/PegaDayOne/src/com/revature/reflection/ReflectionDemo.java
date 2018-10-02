package com.revature.reflection;

import java.lang.reflect.*;

/*
 * Reflection - a way for Java to inspect itself @ runtime
 * 
 * Breaks encapsulation
 * Contains methods for runtime inspection of objects
 *  - this includes private members
 *  	- Class of Object
 *  	- Fields
 *  	- Methods
 *  	- Constructors
 *  
 *  Can also modify or instantiate things 
 */
public class ReflectionDemo {
	public static void main(String[] args) {
		
		try {
			Class<?> c = Class.forName("java.awt.Dimension");// utilize class w/o imports
			System.out.println("Constructors: ");
			Constructor<?> constructors[] = c.getConstructors();
			for(int i =0; i<constructors.length;i++) {
				System.out.println(" " + constructors[i]);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
