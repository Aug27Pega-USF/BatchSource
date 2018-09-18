package com.revature.classtypes;

public class Shark extends Animal implements Hunt{

	@Override
	public void findPrey() {
		System.out.println(" I ate fishes!");
		
	}

	@Override
	public void breathe() {
		System.out.println("I breathe underwater");
		
	}

}
