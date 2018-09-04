package com.revature.driver;

import com.revature.beans.Person;

public class Driver {

	public static void main(String[] args) {
		Person p = new Person ("Tim", 3);
		p.increaseAgeBy(20);
		System.out.println(p.getAge());
		p.increaseAgeBy(-13);
		System.out.println(p.getAge());

	}

}
