package com.revature.driver;

import com.revature.beans.Person;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("Tim", 3);
		p.increaseByAge(25);
		System.out.println(p.getAge());
	}

}
