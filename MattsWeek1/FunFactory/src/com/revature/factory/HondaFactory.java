package com.revature.factory;

import com.revature.beans.Car;
//Factories create an object w/o exposing creation logic to client
public class HondaFactory {
	
	/*
	 * use a "factory" method to return a Car Model based on what String is given
	 * if the method is given a parameter of something besides 
	 * crv or civic, it will return null
	 */
	
	 public Car getCar(String whatCar, String color) {
		    if ("civic".equals(whatCar)) {
		      return new Car("Honda", 2018, "Civic", color);
		    } else if ("crv".equals(whatCar)) {
		      return new Car("Honda", 2018, "CRV", color);
		    }

		    return null;
		  }
}
