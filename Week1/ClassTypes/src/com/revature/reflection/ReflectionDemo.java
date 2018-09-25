package com.revature.reflection;

import java.lang.reflect.*;

/* 
	 * Reflection- a way for Java to inspect itself 
	 * breaks encapsulation
	 * Contains methods for runtime inspection of Objects
	 * 		-this is going to include private members
	 * 		-Class of an object 
	 * 		-Fields 
	 * 		-Methods 
	 * 		-Constructors
	 * Can also modify or instantiate things, invoke methods
	 * java.lang.reflect
	 * 
	 */

public class ReflectionDemo {
	
	
	public static void main(String[] args) 
	{
		try {
			Class<?> c= Class.forName("java.awt.Dimension");
			System.out.println("Constructors");
			Constructor<?> constructor[]= c.getConstructors();
			for(int i=0; i<constructor.length;i++)
			{
				System.out.println(" " + constructor[i]);
			}
			
			System.out.println("Fields: ");
			Field f[]= c.getFields();
			for(int i=0; i<f.length;i++)
			{
				System.out.println(" " + f[i]);
			}
			
		System.out.println("Methods:");
		Method m[]= c.getMethods();
		for(int i=0; i<m.length;i++)
		{
			System.out.println(" " + m[i]);
		}
		
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		
	}
	
	
}
