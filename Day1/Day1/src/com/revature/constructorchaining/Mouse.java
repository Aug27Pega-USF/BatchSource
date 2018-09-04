package com.revature.constructorchaining;

public class Mouse {

	private int numTeeth;
	private int numWhiskers;
	private int weight;
	
	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}

	public Mouse() {
		//super();
		
	}
	
	public Mouse(int weight) {
		this(weight,16);	// Call the constructor w/ 2 paramters
	}
	public Mouse(int weight, int numTeeth) {
		this(weight, numTeeth, 6); // call constructor w 3 parameters
	}
	
	public Mouse(int numWhiskers, int weight, int numTeeth) {
		super();
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mouse m = new Mouse(15);
		System.out.println(m.toString());
		Mouse m2 = new Mouse(400,7);
		System.out.println(m2.toString());
		

	}
	

}
