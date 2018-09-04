package com.revature.design;
/*
 * Singleton design pattern
 * ensures a class has only one instance and provides a global point of access to it
 * 
 */
public class Singleton {
	//static private property of the self class 
	private static Singleton instance;
	//private constructor
	private Singleton() {
		//logic here
		
	}
	//static method to get a unique instance, where it creates the instance 
	public static synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
			return instance;
			
		}
		return instance;
	}
	public void doSomething() {
		//What the obj should do
	}
}

