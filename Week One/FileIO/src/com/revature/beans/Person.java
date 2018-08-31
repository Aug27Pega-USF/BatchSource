package com.revature.beans;

import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;
	{
		//executes before constructor is called (each time)
		System.out.println("Instance code block");
	}
	
	static {
		//exectute block once when class is loaded in JVM
		System.out.println("Static Code Block");
	}
	
	static String homePlanet = "Earth";
	private String name = "";
	private int age = 0;
	private double weight = 0;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	//overrides default constructor if implemented
	public Person(String name, int age, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	
	public String getHomePlanet() {
		return homePlanet;
	}
	
	public void setHomePlanet(String homePlanet) {
		Person.homePlanet = homePlanet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public static void testPrint() {
		System.out.println("Static method");
	}
	
}
