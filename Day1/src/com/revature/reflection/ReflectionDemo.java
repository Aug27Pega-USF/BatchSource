package com.revature.reflection;

import java.lang.reflect.*;

/*
 * Reflection - A way for java to inspect itself
 * breaks encapsulation
 * Contains methods for runtime inspection of objects
 *  -this includes private members 
 *  	-Class of an object
 * 		-Fields
 * 		-Methods
 * 		-Constructors
 * Can also modify or instantiate things and invoke methods
 */

public class ReflectionDemo {
	public static void main(String[] args) {
	try {
		Class<?> c = Class.forName("java.awt.Dimension");
		System.out.println("Constructors: ");
		Constructor<?> constructor[] = c.getConstructors();
		for(int i=0; i<constructor.length; i++) {
			System.out.println(" " + constructor[i]);
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}
	
	
}
