package com.revature.beans;

public class Powers {
	private int powersID;
	private String powersNames;
	public Powers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Powers(int powersID, String powersNames) {
		super();
		this.powersID = powersID;
		this.powersNames = powersNames;
	}
	public int getPowersID() {
		return powersID;
	}
	public void setPowersID(int powersID) {
		this.powersID = powersID;
	}
	public String getPowersNames() {
		return powersNames;
	}
	public void setPowersNames(String powersNames) {
		this.powersNames = powersNames;
	}
	@Override
	public String toString() {
		return "Powers [powersID=" + powersID + ", powersNames=" + powersNames + "]";
	}
	 
}
