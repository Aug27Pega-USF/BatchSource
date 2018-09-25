package com.revature.factory;

import com.revature.beans.Car;

//Factories create and object without exposing logic to the client
public class HondaFactory {
	/*
	 * Used a "factory" method to return a Car Model based on waht String has been given
	 * 
	 */
	
	public Car getCar(String whatCar, String color) {
		if("civic".equalsIgnoreCase(whatCar)) {
			return new Car("Honda", 2018, "Civic", color);
		}else if ("crv".equals(whatCar)) {
			return new Car("Honda", 2018, "CRV", color);
		}
		return null;
	}

}
