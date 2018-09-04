package com.reaveture.beans;

import com.revature.abstractz.Animal;
import com.revature.interfacez.Hunt;

public class Shark extends Animal implements Hunt{

	@Override
	public void findPrey() {
		System.out.println("I eat fishes!");
		
	}

	@Override
	public void breathe() {
		System.out.println("I breathe underwater!");
	}

}
