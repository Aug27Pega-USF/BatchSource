package com.revature.constuctorchaining;

public class Mouse {
	private int numTeeth;
	private int numWhiskers;
	private int weight;
	
	
	public Mouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mouse(int weight) {
		this(weight,16); //call the constructor w/ 2 parameters
	}

	public Mouse(int weight,int numTeeth) {
		this(weight, numTeeth,6); //call constructor w/ 3 parameters
	}

	public Mouse(int weight, int numTeeth, int numWhiskers) {
		super();
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mouse m =new Mouse(15);
		System.out.println(m.toString());
		Mouse m2 =new Mouse(400,7);
		System.out.println(m2.toString());
	}

}
