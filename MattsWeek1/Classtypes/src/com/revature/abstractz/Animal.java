package com.revature.abstractz;
/*
 * special class that can't be instantiated
 * they contain at least 1 abstract methods
 * can contain concrete methods
 * "Contract based"- abstract methods MUST be overriden in subclass 
 */
public abstract class Animal {
	public abstract void breathe();
}
