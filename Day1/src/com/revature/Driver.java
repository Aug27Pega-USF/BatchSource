package com.revature;

import com.revature.beans.Person;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Stop being stupid!");
		Person jim = new Person();
		jim.setName("Jim Belushi");
		System.out.println(jim.getName() + " is from " + jim.getHomePlanet());
	}
}
