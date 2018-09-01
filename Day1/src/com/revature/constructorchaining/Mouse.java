package com.revature.constructorchaining;

public class Mouse {

	private int weight;
	private int numTeeth;
	private int numWhiskers;
	
	public Mouse() {
		super();
	}
	public Mouse(int weight) {
		this(weight, 16, 6);//call constructor w/ two parameters
	}
	public Mouse(int weight, int numTeeth) {
		this(weight, numTeeth, 6);//call constructor w/ three parameters
	}
	public Mouse(int numWhiskers, int numTeeth, int weight) {
		super();
		this.numWhiskers = numWhiskers;
		this.numTeeth = numTeeth;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Mouse [weight=" + weight + ", numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + "]";
	}
	public static void main(String[] args) {
		Mouse m = new Mouse(15);
		Mouse m2 = new Mouse(400,7);
		System.out.println(m.toString());
		System.out.println(m2.toString());
	}
}
