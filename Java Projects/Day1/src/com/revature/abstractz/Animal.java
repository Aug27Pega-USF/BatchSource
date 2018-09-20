package com.revature.abstractz;

/*
 * Special class that can't be instantiated
 * They contain at least one abstract method
 * Can contain concrete methods
 * "Contract based" - any method declared MUST be defined by child class
 * Abstract methods MUST be overriden in subclass
 * 
 * How are interfaces and abstract classes different?
 * You can't inherit more than one abstract class, but you can inherit more than one interface
 * Abstract classes - used as a skeleton of a class
 * Interfaces - more for specified functionality
 * 
 */



abstract public class Animal {

	public abstract void breath();
	
	
}
