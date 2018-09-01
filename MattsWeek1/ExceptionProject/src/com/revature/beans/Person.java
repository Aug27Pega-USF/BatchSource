package com.revature.beans;

import com.revature.exception.IncreasedByNegativeNumberException;

public class Person {
	private String name;
	private int age;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public void increaseAgeBy(int x) throws
	IncreasedByNegativeNumberException{
		if(x<0) {
			throw new IncreasedByNegativeNumberException();
		}
		this.age+=x;
	}
	
}
