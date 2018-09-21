package com.revature.design;

public class Singleton {
/*
 * Singleton Design Pattern
 * ensure a class has only one instance and provides
 * a global access to it
 */
	
	// private static property of the self class
	private static Singleton instance;
	
	//private constructor
	private Singleton() {
		//logic here
	}
	
	//Static Method to get the unique instance, where it creates
	// the instance if it is not already created
	public static synchronized Singleton getInstance() {
		if(instance ==null) {
			instance=new Singleton();
			//return instance;
		}
		return instance;
	}
	public void doSomething() {
		//what the object should do
	}
}
