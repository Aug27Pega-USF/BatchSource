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


	public Mouse(int numTeeth, int numWhiskers, int weight) { // alt shitf s "generate constructor using field", all selected and generate
		super();
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}
	
	public Mouse(int numTeeth, int numWhiskers) {
		// we are calling public mouse constructor in this constructor
		//taking two parameters
		this(numTeeth, numWhiskers, 6);	
	}
	
	public Mouse (int numTeeth) {
		//taking one parameters
		this(numTeeth, 10);
	}
	
	public static void main(String[] args) {
		Mouse m = new Mouse(20);
		System.out.println(m.toString());
		
		Mouse m2 = new Mouse(2,94);
		System.out.println(m2.toString());  // sysout ctrl shift for shortcut
		
		Mouse m3 = new Mouse(3,20,3);
		System.out.println(m3.toString());
		
	}
	
	
	
}
