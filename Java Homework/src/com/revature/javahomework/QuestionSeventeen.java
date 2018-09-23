package com.revature.javahomework;

public class QuestionSeventeen {
	private double principal;
	private double rate;
	private int years;
	
	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public void setRate(double rate) {
		this.rate = rate / 100;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
	public double findInterest() {
		return principal * rate * (double) years;
	}

}
