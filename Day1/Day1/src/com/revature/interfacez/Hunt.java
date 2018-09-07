package com.revature.interfacez;

public interface Hunt {

	/*
	 * An interface specifies what a class must do, but not how it does it (ABSTRACTION!)
	 * Special type of class that cannot be instantiated
	 * Lack instance variables
	 * We can mimic multiple inheritance with interfaces
	 * Methods are declared without body
	 * Classes can implement interfaces using keyword "implement"
	 * Interfaces can extend other interfaces
	 * Kind of like c++ where you declare the class and it's member functions, but define it way later
	 * Classes can implement 0+ interfaces
	 * Interfaces can extend other 0+ interfaces
	 * All variables are implicitly static, public, and final (Java 8)
	 * Marker Interface - aka tag
	 * 
	 * 
	 */
	
	public abstract void findPrey();
	
	
	
}
