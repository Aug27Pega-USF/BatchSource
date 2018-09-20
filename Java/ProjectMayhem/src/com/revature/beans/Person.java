package com.revature.beans;

import java.io.Serializable;

import com.revature.exceptions.IncreasedByNegativeNumberException;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Members of a class
	 * Instance variables-property of one specific object
	 * Static variables- property of class/shared by all instances of this class
	 * Instance methods-behavior relative to a specific object
	 * Static methods-behavior relative to the entire class
	 * Constructors- instantiates the class using the keyword "new"
	 */
	/*Code Blocks-a block of code...
	 * 
	 *instance code block- execute before constructor when an object is 
	 *instantiated.
	 *{....}
	 *Static code- execute once, when class is loaded in JVM
	 */
	
	//Instance code block
	{System.out.println("I'm in the instance code block");}
	static {System.out.println("I'm in a static code block");}
	
	private static String homePlanet = "earth";
	private String name;
	private int age;
	private int weight;
	
	public Person(){
		super();
	}
	public Person(String name, int age, int weight) {
		this.name= name;
		this.age = age;
		this.weight = weight;
	}
	public static String getHomePlanet() {
		return homePlanet;
	}
	public static void setHomePlanet(String homePlanet) {
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	public void increaseAgeBy(int x) throws
	IncreasedByNegativeNumberException {
		if(x<=0) {
			throw new IncreasedByNegativeNumberException();
		}
		this.age+=x;
	}
	
}
