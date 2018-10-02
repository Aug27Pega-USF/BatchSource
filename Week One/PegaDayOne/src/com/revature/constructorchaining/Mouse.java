package com.revature.constructorchaining;
//Constructor chaining example
public class Mouse {

	private int weight, numTeeth, numWhiskers;
	
	public static void main(String[] args) {
		Mouse m = new Mouse(15);
		System.out.println(m.toString());
		Mouse m2 = new Mouse(400, 8);
		System.out.println(m2);
	}
	
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
