package com.reaveture.beans;

import java.util.Comparator;

public class Bean implements Comparable<Bean>{
	private int id;
	private String name;
	private String make;
	
	
	
	public Bean(int id, String name, String make) {
		super();
		this.id = id;
		this.name = name;
		this.make = make;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	@Override
	public int compareTo(Bean o) {
		return this.getId()- o.getId();
	}
	@Override
	public String toString() {
		return "Bean [id=" + id + ", name=" + name + ", make=" + make + "]";
	}
	
}

class BeanNameCompare implements Comparator<Bean>{
	public int compare(Bean a, Bean b) {
		return a.getName().compareTo(b.getName());
	}
}
