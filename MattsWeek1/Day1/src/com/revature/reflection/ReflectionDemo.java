package com.revature.reflection;

import java.lang.reflect.*;

/*
 * Reflection- a way for Java to inspect itself 
 * breaks encapsulation
 * Contains methods for runtime inspection of objects
 * 	-this includes private members
 * 		-Class of an object
 * 		-Fields
 * 		-Methods
 * 		-Constructors
 * Can also modify or instantiate things, invoke methods
 * 
 */
public class ReflectionDemo {
	public static void main(String[] args) {
	 try {
		Class<?> c= Class.forName("java.awt.Dimension");
		 System.out.println("COnstructors:");
		 Constructor<?> constructor[]= c.getConstructors();
		 for(int i=0;i<constructor.length; i++) {
			 System.out.println(" " + constructor[i]);
		 }
		 System.out.println("Fields:");
			Field fields[]=c.getFields();
			for(int i=0;i<fields.length;i++) {
				System.out.println(" " + fields[i]);
			}
			System.out.println("Methods:");
			Method methods[] = c.getMethods();
			for(int i=0;i<methods.length;i++) {
				System.out.println(" " + methods[i]);
	 
			}
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
	} 
}
