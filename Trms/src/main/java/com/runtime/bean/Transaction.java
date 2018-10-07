package com.runtime.bean;

public class Transaction {
	private int userId;
	private int transId;
	private double amountReim;
	private double remainingReim;
	private String date;
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public double getAmountReim() {
		return amountReim;
	}
	public void setAmountReim(double amountReim) {
		this.amountReim = amountReim;
	}
	public double getRemainingReim() {
		return remainingReim;
	}
	public void setRemainingReim(double remainingReim) {
		this.remainingReim = remainingReim;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Transaction(int userId, int transId, double amountReim, double remainingReim, String date) {
		super();
		this.userId = userId;
		this.transId = transId;
		this.amountReim = amountReim;
		this.remainingReim = remainingReim;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [userId=" + userId + ", transId=" + transId + ", amountReim=" + amountReim
				+ ", remainingReim=" + remainingReim + ", date=" + date + "]";
	}
	
	

}
