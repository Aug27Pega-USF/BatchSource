package com.revature.beans;

public class SuperHero {
	private int hearoID;
	private String heroName;
	public SuperHero() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SuperHero [hearoID=" + hearoID + ", heroName=" + heroName + "]";
	}
	public SuperHero(int hearoID, String heroName) {
		super();
		this.hearoID = hearoID;
		this.heroName = heroName;
	}
	public int getHearoID() {
		return hearoID;
	}
	public void setHearoID(int hearoID) {
		this.hearoID = hearoID;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	
}
