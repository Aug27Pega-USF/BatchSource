package com.example.model;

public class Pet {
	
	String Name, Type;
	
	public Pet() {
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Pet(String name, String type) {
		super();
		Name = name;
		Type = type;
	}

	@Override
	public String toString() {
		return "Pet [Name=" + Name + ", Type=" + Type + "]";
	}
	
	

}
