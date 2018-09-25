package com.revature.beans;

public class Car {
	private String make;
	private int year;
	private String model;
	private String color;
	
	@Override
	public String toString() {
		return "Car [make=" + make + ", year=" + year + ", model=" + model + ", color=" + color + "]";
	}
	public Car(String make, int year, String model, String color) {
		super();
		this.make = make;
		this.year = year;
		this.model = model;
		this.color = color;
	}
	public String getMake() {
		return make;
	}
	public int getYear() {
		return year;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
