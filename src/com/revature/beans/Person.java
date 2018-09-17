package com.revature.beans;

public class Person {
	{
	//instance code block
	// execute before constructor is called.
		System.out.println("Static Code Block");
	
	}
	
	
	//encapsulation
	static String homePlanet="earth";
	private String name;
	private int age;
	private int weight;
	public String getHomePlanet() {
		return homePlanet;
	}
	//default
	public Person() {
		super();
		};
		
	public Person(String name, int age, int weight) {
		super();
		this.name=name;
		this.age=age;
		this.weight=weight;
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
		return "Person" + name + "[homePlanet=" + homePlanet + "age=" + age + ", weight=" + weight + "]";
	}
	
	public static void testPrint() {
		System.out.println("Person test");
	}
}
