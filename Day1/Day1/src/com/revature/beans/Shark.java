package com.revature.beans;

import com.revature.abstractz.Animal;
import com.revature.interfacez.Hunt;

public class Shark extends Animal implements Hunt{
	
	@Override
	public void findPrey(){
	
		System.out.println("I ate fishes");
	}

	@Override
	public void breath() {
		
		System.out.println("I breathe under water");
	}
}
