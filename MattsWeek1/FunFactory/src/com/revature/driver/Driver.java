package com.revature.driver;

import com.revature.beans.Car;
import com.revature.factory.HondaFactory;

public class Driver {
	 private static HondaFactory hf = new HondaFactory();
	public static void main(String[] args) {

		 	Car carOne = hf.getCar("crv", "Grey");
	        Car carTwo = hf.getCar("civic", "White");
	        System.out.println(carOne);
	        System.out.println(carTwo);
	}

}
