package com.revature.beans;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	{	// instance code block
		// execute before the constructor is called 
		System.out.println("I'm in the instance code block!");
		
	}
	static {
		//static code blocks execute once when the class
		//is loaded in the JVM
		System.out.println("Static code block");
	}
	
	
// encapsulation (hiding details) - we can do this by making details 'private'
	private static String homePlanet = "earth";	// we put static there because we don't know ppl from other planets
	private String name;
	private int age;
	private int weight;
	
	
	// default constructor - constructor that takes no parameters
	public Person() {
		super();
	}
	public Person( String name, int age, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}


// Order of things should be...
// private members
// default constructor
// constructors with parameters
// getters setters
	
	
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
	
	

	
	
	
}
