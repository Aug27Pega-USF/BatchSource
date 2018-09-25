package com.revature.design;

public class Singleton {
	/*
	 * Singleton Design Pattern
	 * Ensure a class has only one instance and provides a global access to it
	 */
	
	//static private property of the self class
	private static Singleton instance;
	
	//We need private constructor
	private Singleton() {
		//logic here
	}
	
	//static method to get the unique instance, where it creates the instance if it is not already created
	public static synchronized Singleton getInstance() {
		//we want one for entire application
		if (instance == null) {
			instance = new Singleton();
			//return instance;
		}
		return instance;
	}
	
	public void doSomething() {
		//what the object should do
	}

}
