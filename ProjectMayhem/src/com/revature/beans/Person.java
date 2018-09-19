package com.revature.beans;

public class Person {
	/*
	 * Members of a class
	 * Instance variables - property of one specific object
	 * Static variables - property of one class/shared by all instances of this class
	 * Instance methods - behavior relative to a specific object
	 * Static methods - behavior relative to the entire class
	 * Constructors - instantiates the class using keyword "new"
	 */
	/*
	 * Code Blocks - {Blocks of Code..}
	 * Instance code block - execute before the constructor when an object is 
	 * instantiated
	 * 
	 * Static code - execute once, when class is loaded in JVM
	 */
	
	private String homePlanet = "earth";
	private String name;
	private int age;
	private int weight;
	
	public Person(String string, int i, int j)
	{
		super();
	}

	public Person(String homePlanet, String name, int age, int weight) {
		super();
		this.homePlanet = homePlanet;
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public String getHomePlanet() {
		return homePlanet;
	}

	public void setHomePlanet(String homePlanet) {
		this.homePlanet = homePlanet;
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
	
}
