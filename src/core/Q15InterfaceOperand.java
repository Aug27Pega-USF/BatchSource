package core;

public interface Q15InterfaceOperand {
	public abstract double add(double a, double b);
	public abstract double minus(double a, double b);
	public abstract double multiply(double a, double b);
	public abstract double divide(double a, double b);
}

class Q15Class implements Q15InterfaceOperand{

	@Override
	public double add(double a, double b) {
		return a+b;
	}

	@Override
	public double minus(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double multiply(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double divide(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
	
}