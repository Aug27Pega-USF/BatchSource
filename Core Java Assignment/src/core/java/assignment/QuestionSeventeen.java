package core.java.assignment;

public class QuestionSeventeen {
	private double principal;
	private double rate;
	private int years;
	
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate / 100;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	
	public double findInterest() {
		return principal * rate * (double) years;
	}
}
