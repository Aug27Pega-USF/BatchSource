package com.revature.exceptions;

import com.revature.beans.Person;

public class Driver {

	public static void main(String[] args) {
		Person p = new Person("Pete", 50, 645);
		p.increaseAgeBy(3);
		System.out.println("Pete's age is: "+ p.getAge());
		p.increaseAgeBy(-44);
		System.out.println("Pete's age is: "+ p.getAge());

	}

}
