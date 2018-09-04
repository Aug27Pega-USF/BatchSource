package com.revature;

import com.revature.beans.Person;

public class Driver {
	public static void main (String[] args) {
		//JVM looks for a method with this signature
		System.out.println("Roll Tide");
		Person jimbo= new Person();
		jimbo.setName("Jimbo");
		System.out.println(jimbo.getName() + " is from " + jimbo.getHomePlanet());
		
		Person p= new Person("Thom",34,215);
		System.out.println(p.toString());
		}
}
