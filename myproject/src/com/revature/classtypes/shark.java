package com.revature.classtypes;

public class shark extends Animal implements Hunt{

	@Override
	public void breathe() {
		System.out.println("I breath under water");
	}

	@Override
	public void findPrey() {
		System.out.println("I ate fishes");
	}

}
