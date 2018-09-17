package com.revature.chaining;

public class Mouse {
//constructor chaining- overloading constructors to call each other
	
	
	
	private int numTeeth;
	private int numWhiskers;
	private int weight;
	
	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}

	
	public Mouse(int numTeeth, int numWhiskers) {
		this(numTeeth,numWhiskers,6);
	}
	public Mouse (int numTeeth) {
		this(numTeeth, 10);
	}
	public Mouse(int numTeeth, int numWhiskers, int weight) {
		super();
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}
	public static void main(String[] args) {
		Mouse m= new Mouse(20);
		System.out.println(m.toString());
		Mouse m2 = new Mouse(2,94);
		System.out.println(m2.toString());
	
	}
	

}
