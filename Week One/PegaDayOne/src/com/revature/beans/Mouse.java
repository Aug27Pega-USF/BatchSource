package com.revature.beans;
//Constructor chaining example
public class Mouse {

	private int weight, numTeeth, numWhiskers;
	
	//default constructor 
	public Mouse() {
		super();
	}
	
	public Mouse(int weight) {
		this(weight, 20);
	}
	
	public Mouse(int weight, int numTeeth ) {
		this(weight, numTeeth, 6); //calls constructor w/ 3 params
	}
	
	//constructor with fields
		public Mouse(int weight, int numTeeth, int numWhiskers) {
			super();
			this.numTeeth = numTeeth;
			this.numWhiskers = numWhiskers;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Mouse [weight=" + weight + ", numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + "]";
		}

}
