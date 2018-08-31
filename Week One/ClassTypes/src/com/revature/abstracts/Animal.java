/**
 * @author Kevin Medara
 * 
 * Special class that can't be instantiated
 * they contain at least 1 abstract method
 * can contain concrete methods
 * "Contract based" - abstract methods MUST be overridden in subclass
 */
package com.revature.abstracts;

import com.revature.interfaces.Hunt;

public abstract class Animal implements Hunt {
	
	 public void breathe() {
		System.out.println("I breathe Somehow");
	}
	
	 public void findPrey () {
		System.out.println("I hunt something");
	}
	
}
