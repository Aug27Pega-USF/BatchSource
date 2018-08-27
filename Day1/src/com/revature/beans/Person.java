package com.revature.beans;

public class Person {
	private static String homePlanet = "Earth";
	private String name;
	private int age;
	private int weight;
	//default constructor
	
	public Person(String name, int age, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	public Person() {
		super();
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
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
}
