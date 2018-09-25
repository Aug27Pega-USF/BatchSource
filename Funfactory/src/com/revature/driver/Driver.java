package com.revature.driver;

import com.revature.beans.Car;
import com.revature.factory.HondaFactory;

public class Driver {
	private static HondaFactory hf= new HondaFactory();
	

	public static void main(String[] args) {
		Car c1 = hf.getCar("crv", "ruler");
		Car c2 = hf.getCar("Civic", "Grey");
		Car c3 = hf.getCar("bhbs", "balck");
		Car c4 = hf.getCar("hot dog", "red");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);


		

	}

}
