package com.revature.beans;

import com.revature.abstracts.Animal;

public class Shark extends Animal {

	@Override
	public void breathe() {
		System.out.println("Im a shark and I breathe underwater");
		
	}

	@Override
	public void findPrey() {
		System.out.println("Im a shark and I hunt fish");
		
	}

	
}
