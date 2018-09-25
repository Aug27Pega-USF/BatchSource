package com.revature.beans;

import com.revature.exception.IncreaseByNegativeNumberException;

public class Person {
	private static String homePlanet = "earth";
	private String name;
	private int age;
	private int weight;
	
	public Person() {
		super();
		//also known as a default constructor. If we do not have this thing than it will automatically add
	}
	
	public Person(String name, int age, int weight) {
		//homePlanet is already defined so we are not including here
		this.name= name;
		this.age = age;
		this.weight = weight;
		//this is a pointer and its going to create a variable
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
	
	public void increaseAgeBy(int x)  throws 
	IncreaseByNegativeNumberException{
		if(x<=o) {
			throw new IncreaseByNegativeNumberException();
		}
		this.age += x;
	}
	
	
}




