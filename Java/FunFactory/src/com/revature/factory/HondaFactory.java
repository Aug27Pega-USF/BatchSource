package com.revature.factory;

import com.revature.beans.Car;

//Factories create an object  w/o exposing logic to client 
public class HondaFactory {
	/* use a "factory" method to return a Car Model based on what String has
	 * has been given 
	 * 
	 */
	public Car getCar(String whatCar, String color) {
		if("civic".equalsIgnoreCase(whatCar)) {
			return new Car("Honda",2018, "Civic", color);
		}else if ("crv".equals(whatCar)) {
			return new Car("Honda",2018,"CRV", color);
		}
		return null;
	}
}
