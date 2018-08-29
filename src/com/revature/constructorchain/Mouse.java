package com.revature.constructorchain;

import com.revature.beans.Person;

public class Mouse {
	private int weight;
	private int numTeeth;
	private int numWhiskers;

	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}

	public Mouse() {
		super();
	}
	
	public Mouse (int weight) {
		this(weight,16); //numTeeth default
	}

	public Mouse(int weight, int numTeeth) {
		this(weight, numTeeth, 6); //numWhiskers default
	}
	
	public Mouse(int weight, int numTeeth, int numWhiskers) {
		super();
		this.weight = weight;
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
	}
	
	public static void main(String[] args) {
		Mouse m = new Mouse(15);
		System.out.println(m.toString());
		Mouse m2 = new Mouse(400,7);
		System.out.println(m2.toString());	
	}

	
	
}
