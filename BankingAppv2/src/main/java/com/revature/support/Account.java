package com.revature.support;

public class Account {
	private int aid;
	private int uid;
	private double bal;
	public Account(int aid, int uid, double bal) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.bal = bal;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", uid=" + uid + ", bal=" + bal + "]";
	}
	
}
