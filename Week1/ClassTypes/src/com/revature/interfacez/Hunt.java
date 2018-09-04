package com.revature.interfacez;

public interface Hunt {
/*
 * Specify what a class must do but not how it does it.(abstraction!)
 * 
 * Special type of class that cannot be instantiated 
 * Lack instance variables 
 * can mimic multiple inheritance w/ interfaces
 * Methods are declared with out a body
 * classes can implement interfaces 0+
 * interfaces can extend other interfaces 0+
 * All variables are implicitly static, public, and final (java 8)
 * 
 * 
 */
	public abstract void findPrey();
}
