package com.revature.beans;

public class Person {
	{
		//instance code block
		//execute before the constructor is called
		System.out.println("I'm in the instance code block!");
	}
	static {
		//static code blocks execute once when the class
		//is loaded in the JVM
		System.out.println("static code block LOLz");
	}
	
	//encapsulation
	private static String homePlanet ="earth";
	private String name;
	private int age;
	private int weight;
	
	
	//default constructor
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}	
	public Person(String name, int age, int weight) {
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
	public static void testPrint() {
		System.out.println("test print");
	}
	
}
