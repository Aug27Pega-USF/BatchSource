package com.revature;

import com.revature.beans.Person;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Roll Tide");
		Person jimbo = new Person();
		jimbo.setName("Jimbo");
		System.out.println(jimbo.getName()+" is from "+ jimbo.getHomePlanet());
	}

}
